package dao;

import dto.DVD;

import java.util.List;

public interface DVDLibraryDao {

    DVD addDVD(String dvdId, DVD dvd);

    List<DVD> getAllDVDs();

    DVD getDVD(String dvdId);

    List<DVD> findDVD(String title);

    DVD removeDVD(String dvdId);

    DVD editDVDTitle(String dvdId, String title);

    DVD editDVDReleaseDate(String dvdId, String title);

    DVD editDVDMpaaRating(String dvdId, String title);

    DVD editDVDDirectorName(String dvdId, String title);

    DVD editDVDStudio(String dvdId, String title);

    DVD editDVDUserRating(String dvdId, String title);

}
