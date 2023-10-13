package dao;

import entity.Admins;

public interface AdministateurDao {
    public boolean regester(Admins admins);
    public boolean authentifier(Admins admins);
    }
