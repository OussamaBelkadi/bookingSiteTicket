
package dao.impl;

import com.example.fly.hiber.HibernateUtil;
import dao.AdministateurDao;
import entity.Admins;

import entity.Clients;
import entity.Voyages;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.JDBCType;
import java.util.ArrayList;
import java.util.List;


public class AdminstateurDaoImpl implements AdministateurDao {
    private Boolean AuthState = false;
    private SessionFactory sessionFactory;

    public AdminstateurDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Admins getAdmin(int id) {
        try(Session session = sessionFactory.openSession()){
            String hql = "FROM Admins WHERE id = :adminId";
            Query<Admins> query = session.createQuery(hql, Admins.class);
            query.setParameter("adminId", id);
            return query.uniqueResult();
        }catch (HibernateException e) {
            // Handle any exceptions that may occur during the database operation
            e.printStackTrace();
            return null; // Or throw an exception, log the error, etc.
        }
    }

    @Override
    public boolean supVoyage(int id) {
        boolean result = false;
        try (Session session = sessionFactory.openSession()){
            Voyages voyages = session.get(Voyages.class,id);
            if(voyages != null){
                session.beginTransaction();
                session.delete(voyages);
                session.getTransaction().commit();
                result = true;
            }
        }
        return result;
    }

    @Override
    public List<Voyages> listVoyage() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Voyages> criteriaQuery = criteriaBuilder.createQuery(Voyages.class);
            Root<Voyages> root = criteriaQuery.from(Voyages.class);
            criteriaQuery.select(root);

            Query<Voyages> query = session.createQuery(criteriaQuery);
            return query.getResultList();
        }

    }

    @Override
    public boolean regester(Admins admins) {
        boolean result = false;
        try {

            admins.setPassword(BCrypt.hashpw(admins.getPassword(), BCrypt.gensalt()));
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(admins);
                transaction.commit();
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Admins listAdmin(Admins admins) {
        return null;
    }

    @Override
    public Admins authentifier(Admins admins) {
        Admins result = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String password = admins.getPassword();
            Admins admins1 = (Admins) session.createQuery("FROM Admins WHERE email = :email ")
                    .setParameter("email", admins.getEmail())
                    .uniqueResult();
            transaction.commit();
            session.close();
            if (admins1.getEmail() != null) {
                if (BCrypt.checkpw(password, admins1.getPassword())) {
                    result = admins1;
                }
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public Boolean ajouter(Voyages voyages) {
        boolean result = false;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(voyages);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
        return result;
    }

//    @Override
//    public List<Voyages> listVoyage(Admins admins) {
//        List<Voyages> voyages = new ArrayList<>();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            List<Voyages> voyage =(List<Voyages>)) session.createQuery("FROM Voyages WHERE id_admin = :id ")
//                    .setParameter("id", admins.getId())
//                    .uniqueResult();
//            transaction.commit();
//            session.close();
//            return  voyage;
//
//
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }finally {
//            session.close();
//        }
//    }
}
