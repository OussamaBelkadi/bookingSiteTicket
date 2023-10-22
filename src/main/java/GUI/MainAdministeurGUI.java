package GUI;


import core.Print;
import dao.AdministateurDao;
import dao.impl.AdminstateurDaoImpl;
import entity.Admins;

import java.util.Scanner;

public class MainAdministeurGUI implements DisplayGUI{

    private AdministateurDao administateurDao;
    private Admins admins;
    public MainAdministeurGUI(){
        this.administateurDao = new AdminstateurDaoImpl();
        this.admins = new Admins();
    }
    @Override
    public int displayMainOptions(Scanner scanner)  {
        Print.log("Bienvenue dans l'application de gestion des patients");
        Print.log("=== OPERATION  ===");
        Print.log("1 - Authentification ");
        Print.log("2 - Go back to the main menu ");
        Print.log("0 - Exit ");

        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                Print.log("enter votre Email");
                scanner.nextLine();
                admins.setEmail(scanner.nextLine());
                Print.log("enter votre Password");
                admins.setPassword(scanner.nextLine());
//                boolean ter = this.administateurDao.authentifier(admins);
//                if(ter){
//                    System.out.println("ok");
//                }
            case 2:
                Admins admins = new Admins();
                admins.setEmail("er@gmail.com");
                admins.setNom("Os");
                admins.setPrenom("ter");
                admins.setPassword("reda23");
                boolean ser = this.administateurDao.regester(admins);
                if(ser){
                    System.out.println("ok");
                }else {
                    System.out.println("no");
                }
            case 0:

            default:

        }


        return 0;
    }



}
