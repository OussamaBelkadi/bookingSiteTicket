package dao.impl;

import com.example.fly.hiber.HibernateUtil;
import dao.VoyageDao;
import entity.Voyages;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class VoyageDaoImp implements VoyageDao {
    private SessionFactory sessionFactory;
    public VoyageDaoImp(){
         this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    @Override
    public Voyages getVoyage(int id) {
        Transaction transaction = null;
        Voyages voyage = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
             voyage = session.get(Voyages.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return voyage;
    }

    @Override
    public boolean upVoyage(Voyages voyages) {
        boolean result = false;
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

                session.merge(voyages);
                transaction.commit();
                result = true;

        }
        return result;
    }

    @Override
    public List<Voyages> rechercheVoy(Voyages voyages) {
        List<Voyages> voyage = new ArrayList<>();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
             transaction = session.beginTransaction();
             String query = "From Voyages  Where villedepart=:villedepart and villearriver=:villearriver";
             Query<Voyages> queryRcherche = session.createQuery(query, Voyages.class);
             queryRcherche.setParameter("villedepart", voyages.getVilledepart());
             queryRcherche.setParameter("villearriver", voyages.getVillearriver());
             voyage = queryRcherche.list();
        }
        return voyage;
    }

}
