package dao.impl;

import com.example.fly.hiber.HibernateUtil;
import dao.AgentDao;
import entity.Clients;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AgentDaoImpl implements AgentDao {
    public boolean saveClient(Clients client) {
        boolean result = false;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(client);
            // commit transaction
            transaction.commit();
            result = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }
}
