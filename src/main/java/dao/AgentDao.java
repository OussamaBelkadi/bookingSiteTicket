package dao;


import com.example.fly.hiber.HibernateUtil;
import entity.Clients;
import org.hibernate.Session;
import org.hibernate.Transaction;

public interface AgentDao {
    public boolean saveClient(Clients client);
}
