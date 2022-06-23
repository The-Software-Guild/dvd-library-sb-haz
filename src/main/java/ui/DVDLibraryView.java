package ui;

import dto.DVD;

public class DVDLibraryView {

    private UserIO io = new UserIOConsoleImpl();

    private final String BANNER_MESSAGE_PREFIX = "-===- ";
    private final String BANNER_MESSAGE_SUFFIX = " -===-";

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

    // Get user DVD choice
    public String getDVDIdChoice() {
        return io.readString("Please enter the DVD ID.");
    }

    // Add DVD
    public DVD getNewDVDInfo(){
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

    public void displayCreateDVDBanner(){
        displayBannerMessage("Create Student");
    }

    public void displayCreateDVDSuccessBanner(){
        io.readString("DVD successfully created. Please hit enter to continue.");
    }

    // Banner template
    public void displayBannerMessage(String msg) {
        io.print(BANNER_MESSAGE_PREFIX + msg + BANNER_MESSAGE_SUFFIX);
    }

    // Exit message
    public void displayExitBanner() {
        io.print("Exiting program...");
    }

    // Unknown command message
    public void displayUnknownCommandBanner() {
        io.print("Unknown command.");
    }
}
