package dao.impl;

import com.example.fly.hiber.HibernateUtil;
import dao.AdministateurDao;
import entity.Admins;

import entity.Clients;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.JDBCType;


public class AdminstateurDaoImpl implements AdministateurDao {
    private Boolean AuthState = false;
    private SessionFactory sessionFactory;
    public AdminstateurDaoImpl(){
        this.sessionFactory = HibernateUtil.getSessionFactory();

    }
    @Override
    public boolean regester(Admins admins) {
        try {
            this.AuthState = false;
            String email = admins.getEmail();
            String password = BCrypt.hashpw(admins.getPassword(), BCrypt.gensalt());
            String nom = admins.getNom();
            String prenom = admins.getPrenom();
            try(Session session = sessionFactory.openSession()){
                Transaction transaction = session.beginTransaction();
                session.save(admins);
                transaction.commit();
            }catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    @Override
    public boolean authentifier(Admins admins) {
        boolean result = false;
        try {
            this.AuthState = false;
           int id = admins.getId();
           String password = admins.getPassword();
            try(Session session = sessionFactory.openSession()){
                Transaction transaction = session.beginTransaction();
                Admins admins1 =session.load(Admins.class, id);
                if (admins1 != null){
                    if(BCrypt.checkpw(password, admins1.getPassword())){
                        result = true;
                    }
                }
                transaction.commit();
            }catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
