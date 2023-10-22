package dao;

import entity.Admins;
import entity.Voyages;

import java.util.List;

public interface AdministateurDao {
    public boolean regester(Admins admins);
    public Admins listAdmin(Admins admins);
    public Admins authentifier(Admins admins);
    public Boolean ajouter(Voyages voyages);
    public Admins getAdmin(int id);
    public boolean supVoyage(int id);
    public List<Voyages> listVoyage();
}
