package dao;

import dto.DVD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public DVD addDVD(String dvdId, DVD dvd) {
        return dvds.put(dvdId, dvd);
    }

    @Override
    public List<DVD> getAllDVDs() {
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String dvdId) {
        return dvds.get(dvdId);
    }

    @Override
    public List<DVD> findDVD(String title) {
        List<DVD> filteredDVDs = new ArrayList<>();
        for (DVD dvd : dvds.values()) {
            filteredDVDs.add(dvd);
        }
        return filteredDVDs;
    }

    @Override
    public DVD removeDVD(String dvdId) {
        return dvds.remove(dvdId);
    }

    @Override
    public DVD editDVDTitle(String dvdId, String title) {
        DVD newDVD = getDVD(dvdId);
        newDVD.setTitle(title);
        dvds.put(dvdId, newDVD);
        return newDVD;
    }

    @Override
    public DVD editDVDReleaseDate(String dvdId, String releaseDate) {
        DVD newDVD = getDVD(dvdId);
        newDVD.setTitle(releaseDate);
        dvds.put(dvdId, newDVD);
        return newDVD;
    }

    @Override
    public DVD editDVDMpaaRating(String dvdId, String mpaaRating) {
        DVD newDVD = getDVD(dvdId);
        newDVD.setTitle(mpaaRating);
        dvds.put(dvdId, newDVD);
        return newDVD;
    }

    @Override
    public DVD editDVDDirectorName(String dvdId, String directorName) {
        DVD newDVD = getDVD(dvdId);
        newDVD.setTitle(directorName);
        dvds.put(dvdId, newDVD);
        return newDVD;
    }

    @Override
    public DVD editDVDStudio(String dvdId, String studio) {
        DVD newDVD = getDVD(dvdId);
        newDVD.setTitle(studio);
        dvds.put(dvdId, newDVD);
        return newDVD;
    }

    @Override
    public DVD editDVDUserRating(String dvdId, String userRating) {
        DVD newDVD = getDVD(dvdId);
        newDVD.setTitle(userRating);
        dvds.put(dvdId, newDVD);
        return newDVD;
    }

}
