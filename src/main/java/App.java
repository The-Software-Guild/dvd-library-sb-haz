import controller.DVDLibraryController;
import dao.DVDLibraryDao;
import dao.DVDLibraryDaoFileImpl;
import ui.DVDLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {

        UserIO io = new UserIOConsoleImpl();
        DVDLibraryView view = new DVDLibraryView(io);
        DVDLibraryDao data = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(data, view);

        controller.run();
    }

}
