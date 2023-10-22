import GUI.DisplayGUI;
import GUI.MainGUI;
import com.example.fly.database.Database;
import com.example.fly.hiber.HibernateUtil;
import core.Print;
import entity.Clients;


import java.sql.Connection;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        //        Connection con = Database.getInstance();
        //        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //        // Create a new Client entity
        //        Clients client = new Clients();
        //        client.setNom("John");
        //        client.setPrenom("Doe");
        //        client.setEmail("john.doe@example.com");
        //        client.setPassword("secret");
        //        try(Session session = sessionFactory.openSession()){
        //            Transaction transaction = session.beginTransaction();
        //            session.save(client);
        //            transaction.commit();
        //        }catch (Exception e) {
        //            e.printStackTrace();
        //        }
        DisplayGUI displayGUI = new MainGUI();

        Scanner scanner = new Scanner(System.in);
        try {
            Print.log("MACNSS Application ");

            int choice = 0;
            do {
                choice  = displayGUI.displayMainOptions(scanner);
            }while (choice != 0);
        } catch(Exception e){
            Print.log(e.toString());
        }


    }
}

