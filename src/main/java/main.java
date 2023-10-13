import com.example.fly.database.Database;
import com.example.fly.hiber.HibernateUtil;
import entity.Clients;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Connection;

public class main {

    public static void main(String[] args) {

        Connection con = Database.getInstance();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        // Create a new Client entity
        Clients client = new Clients();
        client.setNom("John");
        client.setPrenom("Doe");
        client.setEmail("john.doe@example.com");
        client.setPassword("secret");
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

