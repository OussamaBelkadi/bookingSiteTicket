package dao;

import entity.Voyages;

import java.util.List;

public interface VoyageDao {
      public Voyages getVoyage(int id);
      public boolean upVoyage(Voyages voyages);
      public List<Voyages> rechercheVoy(Voyages voyages);
}
