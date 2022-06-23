package controller;

import dao.DVDLibraryDao;
import dao.DVDLibraryDaoFileImpl;
import dto.DVD;
import ui.DVDLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

public class DVDLibraryController {

    private UserIO userInput = new UserIOConsoleImpl();
    private DVDLibraryDao data = new DVDLibraryDaoFileImpl();
    private DVDLibraryView view = new DVDLibraryView();

    public void run(){
        boolean keepGoing = true;
        int menuSelection;

        while(keepGoing) {
            menuSelection = getMenuSelection();

            switch(menuSelection) {
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

    private void createDVD(){
        DVD dvd = view.getNewDVDInfo();
        view.displayCreateDVDBanner();
        data.addDVD(dvd.getDvdId(), dvd);
        view.displayCreateDVDSuccessBanner();
    }

    private void getDVD(){

    }

    private void listDVDs(){

    }

    private void editDVD(){

    }

    private void removeDVD(){

    }

    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }

    private void exitMessage(){
        view.displayExitBanner();
    }

}
