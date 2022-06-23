package controller;

import dao.DVDLibraryDao;
import dao.DVDLibraryDaoFileImpl;
import dto.DVD;
import ui.DVDLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

import java.util.List;

public class DVDLibraryController {

    private UserIO userInput = new UserIOConsoleImpl();
    private DVDLibraryDao data = new DVDLibraryDaoFileImpl();
    private DVDLibraryView view = new DVDLibraryView();

    public void run() {
        boolean keepGoing = true;
        int menuSelection;

        while (keepGoing) {
            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listDVDs();
                    break;
                case 2:
                    createDVD();
                    break;
                case 3:
                    getDVD();
                    break;
                case 4:
                    editDVD();
                    break;
                case 5:
                    removeDVD();
                    break;
                case 6:
                    exitMessage();
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDVD() {
        DVD dvd = view.getNewDVDInfo();
        data.addDVD(dvd.getDvdId(), dvd);
        view.displayCreateDVDBanner();
        view.displayCreateDVDSuccessBanner();
    }

    private void getDVD() {
        String dvdId = view.getDVDIdChoice();
        DVD dvd = data.getDVD(dvdId);
        view.displayDVDBanner();
        view.displayDVD(dvd);
    }

    private void listDVDs() {
        List<DVD> dvdList = data.getAllDVDs();
        view.displayAllDVDBanner();
        view.displayAllDVDs(dvdList);
    }

    private void removeDVD() {
        String dvdId = view.getDVDIdChoice();
        DVD dvd = data.removeDVD(dvdId);
        view.displayRemoveDVD(dvd);
    }

    private void editDVD() {
        view.displayEditDVDBanner();

        String dvdId = view.getDVDIdChoice();
        DVD dvd = data.getDVD(dvdId);

        if (dvd != null) {
            int editMenuSelection;
            boolean keepGoing = true;

            view.displayDVD(dvd);

            while (keepGoing) {
                editMenuSelection = view.printEditMenuAndGetSelection();

                switch (editMenuSelection) {
                    case 1:
                        editDVDTitle(dvdId);
                        break;
                    case 2:
                        editDVDReleaseDate(dvdId);
                        break;
                    case 3:
                        editDVDMpaaRating(dvdId);
                        break;
                    case 4:
                        editDVDDirectorName(dvdId);
                        break;
                    case 5:
                        editDVDStudio(dvdId);
                        break;
                    case 6:
                        editDVDUserRating(dvdId);
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
                if (keepGoing = false) {
                    break;
                }
            }

        } else {
            view.displayNullDVDSelection();
        }
    }

    public void editDVDTitle(String dvdId) {
        view.displayEditDVDField("Title");
        String newValue = view.getNewDVDFieldValue("Release Date");
        DVD editedDVD = data.editDVDTitle(dvdId, newValue);
        view.displayEditSuccess();
    }

    public void editDVDReleaseDate(String dvdId) {
        view.displayEditDVDField("Release Date");
        String newValue = view.getNewDVDFieldValue("Release Date");
        DVD editedDVD = data.editDVDReleaseDate(dvdId, newValue);
        view.displayEditSuccess();
    }

    public void editDVDMpaaRating(String dvdId) {
        view.displayEditDVDField("MPAA Rating");
        String newValue = view.getNewDVDFieldValue("Release Date");
        DVD editedDVD = data.editDVDMpaaRating(dvdId, newValue);
        view.displayEditSuccess();
    }

    public void editDVDDirectorName(String dvdId) {
        view.displayEditDVDField("Director Name");
        String newValue = view.getNewDVDFieldValue("Release Date");
        DVD editedDVD = data.editDVDDirectorName(dvdId, newValue);
        view.displayEditSuccess();
    }

    public void editDVDStudio(String dvdId) {
        view.displayEditDVDField("Studio");
        String newValue = view.getNewDVDFieldValue("Release Date");
        DVD editedDVD = data.editDVDStudio(dvdId, newValue);
        view.displayEditSuccess();
    }

    public void editDVDUserRating(String dvdId) {
        view.displayEditDVDField("User Rating");
        String newValue = view.getNewDVDFieldValue("Release Date");
        DVD editedDVD = data.editDVDUserRating(dvdId, newValue);
        view.displayEditSuccess();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
