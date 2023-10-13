package GUI;


import core.Print;
import java.util.Scanner;

public class MainAdministeurGUI implements DisplayGUI{
    //need AgentService which is all agent function stored




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

            case 2:

            case 0:

            default:

        }


        return 0;
    }



}
