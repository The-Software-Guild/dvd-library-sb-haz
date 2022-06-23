package ui;

import dto.DVD;

import java.util.List;

public class DVDLibraryView {

    private UserIO io = new UserIOConsoleImpl();

    private final String BANNER_MESSAGE_PREFIX = "-===- ";
    private final String BANNER_MESSAGE_SUFFIX = " -===-";


    // Add DVD
    public DVD getNewDVDInfo() {
        String dvdId = io.readString("Please enter the DVD ID");
        String title = io.readString("Please enter the DVD ID");
        String releaseDate = io.readString("Please enter the DVD ID");
        String mpaaRating = io.readString("Please enter the DVD ID");
        String directorName = io.readString("Please enter the DVD ID");
        String studio = io.readString("Please enter the DVD ID");
        String userRating = io.readString("Please enter the DVD ID");

        DVD dvd = new DVD(dvdId, title, releaseDate, mpaaRating, directorName, studio, userRating);

        return dvd;
    }

    public void displayCreateDVDBanner() {
        displayBannerMessage("Create Student");
    }

    public void displayCreateDVDSuccessBanner() {
        io.readString("DVD successfully created. Please hit enter to continue.");
    }


    // View DVD
    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print("ID: " + dvd.getDvdId());
            io.print("Title: " + dvd.getTitle());
            io.print("MPAA Rating: " + dvd.getMpaaRating());
            io.print("Director: " + dvd.getDirectorName());
            io.print("Studio: " + dvd.getStudio());
            io.print("User Rating: " + dvd.getUserRating());
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue");
    }

    public void displayDVDBanner() {
        displayBannerMessage("Display DVD");
    }


    // View All DVDs
    public void displayAllDVDs(List<DVD> dvdList) {
        for (DVD dvd : dvdList) {
            String dvdInfo = String.format("[%s] Title: %s, MPAA Rating: %s, Director: %s, Studio: %s, User Rating: %s",
                    dvd.getDvdId(),
                    dvd.getTitle(),
                    dvd.getMpaaRating(),
                    dvd.getDirectorName(),
                    dvd.getStudio(),
                    dvd.getUserRating());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayAllDVDBanner() {
        displayBannerMessage("Display All DVDs");
    }


    // Remove DVD
    public void displayRemoveDVD(DVD dvd) {
        if (dvd != null) {
            io.print("DVD removed successfully.");
        } else {
            io.print("No such DVD exists.");
        }
        io.readString("Please hit enter to continue.");
    }


    // Edit DVD
    public void displayEditDVDField(String field) {
        io.print("Please enter the new DVD " + field + ".");
    }

    public String getNewDVDFieldValue(String field) {
        return io.readString("Please enter the new " + field);
    }

    public void displayEditDVDBanner() {
        displayBannerMessage("Edit DVD");
    }

    public void displayEditSuccess() {
        io.print("DVD successfully edited.");
    }

    public void displayNullDVDSelection() {
        io.print("No such DVD exists.");
    }


    // Show Menu Options
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Students");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Edit a Student");
        io.print("5. Remove a Student");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    // Show Edit Menu Options
    public int printEditMenuAndGetSelection() {
        io.print("Edit DVD Menu");
        io.print("1. Title");
        io.print("2. Release Date");
        io.print("3. MPAA Rating");
        io.print("4. Director Name");
        io.print("5. Studio");
        io.print("6. User Rating");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }


    // Get user DVD choice
    public String getDVDIdChoice() {
        return io.readString("Please enter the DVD ID.");
    }

    // Banner Template
    public void displayBannerMessage(String msg) {
        io.print(BANNER_MESSAGE_PREFIX + msg + BANNER_MESSAGE_SUFFIX);
    }

    // Exit Message
    public void displayExitBanner() {
        io.print("Exiting program...");
    }

    // Unknown Command
    public void displayUnknownCommandBanner() {
        io.print("Unknown command.");
    }
}
