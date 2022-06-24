package controller;

import dao.DVDLibraryDao;
import dao.DVDLibraryDaoException;
import dto.DVD;
import ui.DVDLibraryView;

import java.util.List;

public class DVDLibraryController {

    private DVDLibraryDao data;
    private DVDLibraryView view;

    public DVDLibraryController(DVDLibraryDao data, DVDLibraryView view) {
        this.data = data;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection;

        try {
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
                        searchDVD();
                        break;
                    case 5:
                        editDVD();
                        break;
                    case 6:
                        removeDVD();
                        break;
                    case 7:
                        exitMessage();
                        break;
                    default:
                        unknownCommand();
                        break;
                }
            }
            exitMessage();
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDVD() throws DVDLibraryDaoException {
        DVD dvd = view.getNewDVDInfo();
        data.addDVD(dvd.getDvdId(), dvd);
        view.displayCreateDVDBanner();
        view.displayCreateDVDSuccessBanner();
    }

    private void getDVD() throws DVDLibraryDaoException {
        String dvdId = view.getDVDIdChoice();
        DVD dvd = data.getDVD(dvdId);
        view.displayDVDBanner();
        view.displayDVD(dvd);
    }

    private void listDVDs() throws DVDLibraryDaoException {
        List<DVD> dvdList = data.getAllDVDs();
        view.displayAllDVDBanner();
        view.displayAllDVDs(dvdList);
    }

    private void searchDVD() throws DVDLibraryDaoException {
        String title = view.getDVDTitleChoice();
        view.displayFindDVDbyTitleBanner(title);
        List<DVD> filteredDVDs = data.findDVD(title);
        view.displayAllDVDs(filteredDVDs);
    }

    private void removeDVD() throws DVDLibraryDaoException {
        String dvdId = view.getDVDIdChoice();
        DVD dvd = data.removeDVD(dvdId);
        view.displayRemoveDVD(dvd);
    }

    private void editDVD() throws DVDLibraryDaoException {
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

    public void editDVDTitle(String dvdId) throws DVDLibraryDaoException {
        String newValue = view.getNewDVDFieldValue("Title");
        DVD editedDVD = data.editDVDTitle(dvdId, newValue);
        view.displayEditSuccess();
    }

    public void editDVDReleaseDate(String dvdId) throws DVDLibraryDaoException {
        String newValue = view.getNewDVDFieldValue("Release Date");
        DVD editedDVD = data.editDVDReleaseDate(dvdId, newValue);
        view.displayEditSuccess();
    }

    public void editDVDMpaaRating(String dvdId) throws DVDLibraryDaoException {
        String newValue = view.getNewDVDFieldValue("MPAA Rating");
        DVD editedDVD = data.editDVDMpaaRating(dvdId, newValue);
        view.displayEditSuccess();
    }

    public void editDVDDirectorName(String dvdId) throws DVDLibraryDaoException {
        String newValue = view.getNewDVDFieldValue("Directors Name");
        DVD editedDVD = data.editDVDDirectorName(dvdId, newValue);
        view.displayEditSuccess();
    }

    public void editDVDStudio(String dvdId) throws DVDLibraryDaoException {
        String newValue = view.getNewDVDFieldValue("Studio");
        DVD editedDVD = data.editDVDStudio(dvdId, newValue);
        view.displayEditSuccess();
    }

    public void editDVDUserRating(String dvdId) throws DVDLibraryDaoException {
        String newValue = view.getNewDVDFieldValue("User Rating");
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
