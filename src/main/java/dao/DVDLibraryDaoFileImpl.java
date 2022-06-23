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
    public DVD removeDVD(String dvdId) {
        return dvds.remove(dvdId);
    }
}
