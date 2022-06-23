package dao;

import dto.DVD;

import java.util.List;

public interface DVDLibraryDao {

    DVD addDVD(DVD dvdId, DVD dvd);

    List<DVD> getAllDVDs();

    DVD getDVD(String dvdId);

    DVD removeDVD(String dvdId);

}
