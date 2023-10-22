package services;

import dao.VoyageDao;
import entity.Voyages;

import java.util.ArrayList;
import java.util.List;

public class VoyageService {

    private VoyageDao voyageDao;

    public VoyageService(VoyageDao voyageDao){
        this.voyageDao = voyageDao;
    }
    public Voyages getVoyage(int id){
        Voyages voyages = voyageDao.getVoyage(id);
        return voyages;
    }
    public boolean upVoyage(Voyages voyage){
        boolean result = false;
        result = voyageDao.upVoyage(voyage);
        return result;
    }
    public List<Voyages> rechercheVoy(Voyages voyages){
        List<Voyages> voyage = new ArrayList<>();
        voyage = voyageDao.rechercheVoy(voyages);
        return  voyage;
    }
}
