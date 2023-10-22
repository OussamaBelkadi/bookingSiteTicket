package com.example.fly;

import java.io.*;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


import dao.AdministateurDao;
import dao.VoyageDao;
import dao.impl.AdminstateurDaoImpl;
import dao.impl.VoyageDaoImp;
import entity.Admins;
import entity.Voyages;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import services.VoyageService;

@WebServlet(name = "helloServlet", value = {"/login", "/createVoyage", "/supVoy", "/editVoy", "/editComplet"})
public class HelloServlet extends HttpServlet {
    private String message;
    private AdministateurDao administateurDao;
    private Admins admins;
    private Voyages voyages;
    private VoyageDao voyageDao;
    private VoyageService voyageService;
    Transaction transaction = null;

    public void init() {
        this.administateurDao = new AdminstateurDaoImpl();
        this.admins = new Admins();
        this.voyages = new Voyages();
        this.voyageDao = new VoyageDaoImp();
        this.voyageService = new VoyageService(voyageDao);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletPath();
        if (path.equals("/login")) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else if (path.equals("/createVoyage")) {
            request.getRequestDispatcher("createVoyage.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/login")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            admins.setEmail(email);
            admins.setPassword(password);

            Admins admin = administateurDao.authentifier(admins);
            if (admin != null) {
                HttpSession session = request.getSession();
                session.setAttribute("Admin", admin);
                List<Voyages> voyages = administateurDao.listVoyage();
                request.setAttribute("voyages", voyages);
                request.getRequestDispatcher("dashbordAdmin.jsp").forward(request, response);
            } else {
                String error = "Erreur provient lors de l'authentification";
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }else if (path.equals("/supVoy")){
            String idS = request.getParameter("id");
            int id = Integer.parseInt(idS);
            boolean result = administateurDao.supVoyage(id);
            if (result){
                List<Voyages> voyages = administateurDao.listVoyage();
                request.setAttribute("voyages", voyages);
                request.getRequestDispatcher("dashbordAdmin.jsp").forward(request, response);
            }else {
                request.setAttribute("id", id);
                request.getRequestDispatcher("desplay.jsp").forward(request, response);
            }
        }else if (path.equals("/createVoyage")) {
            HttpSession session = request.getSession();

            String villeDepart = request.getParameter("villeDepart");
            String villeArriver = request.getParameter("villeArriver");
            String dateDepart = request.getParameter("dateDepart");
            String dateArriver = request.getParameter("dateArriver");
            String heureDepart = request.getParameter("heureDepart");
            String heureArriver = request.getParameter("heureArriver");
            int place = Integer.parseInt(request.getParameter("place"));
            float prix = Float.parseFloat(request.getParameter("prix"));
            Date datedepart = Date.valueOf(dateDepart);
            Date datearriver = Date.valueOf(dateArriver);

            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            java.util.Date parsedTime1 = null;
            java.util.Date parsedTime2 = null;
            try {
                parsedTime1 = timeFormat.parse(heureDepart);
                parsedTime2 = timeFormat.parse(heureArriver);

                Time heuredepart = new Time(parsedTime1.getTime());
                Time heurearriver = new Time(parsedTime2.getTime());
                Admins admin1 =(Admins) session.getAttribute("Admin");
                Admins admin = administateurDao.getAdmin(admin1.getId());

                // Create a new instance of Voyages and set its properties
                voyages.setDatedepart(datedepart);
                voyages.setDatedarriver(datearriver);
                voyages.setHeuredepart(heuredepart);
                voyages.setHeuredarriver(heurearriver);
                voyages.setVilledepart(villeDepart);
                voyages.setVillearriver(villeArriver);
                voyages.setPlace(place);
                voyages.setAdmins(admin);
                voyages.setPrix(prix);
                Boolean result = administateurDao.ajouter(voyages);

                if (result) {
                    List<Voyages> voyages = administateurDao.listVoyage();
                    request.setAttribute("voyages", voyages);
                    request.getRequestDispatcher("dashbordAdmin.jsp").forward(request, response);
                } else {
                    request.setAttribute("model", voyages);
                    request.getRequestDispatcher("desplay.jsp").forward(request, response);

                }
            }catch (ParseException e) {
                    throw new RuntimeException(e);
                }

        } else if (path.equals("/editVoy")) {

            String idS = request.getParameter("id");
            int id = Integer.parseInt(idS);
            Voyages voyages1 = voyageService.getVoyage(id);
            request.setAttribute("voyage", voyages1);
            request.getRequestDispatcher("editVoyage.jsp").forward(request,response);
        } else if (path.equals("/editComplet")) {

                HttpSession session = request.getSession();
                String idS = request.getParameter("id");
                int id = Integer.parseInt(idS);
                String villeDepart = request.getParameter("villeDepart");
                String villeArriver = request.getParameter("villeArriver");
                String dateDepart = request.getParameter("dateDepart");
                String dateArriver = request.getParameter("dateArriver");
                String heureDepart = request.getParameter("heureDepart");
                String heureArriver = request.getParameter("heureArriver");
                int place = Integer.parseInt(request.getParameter("place"));
                Float prix = Float.parseFloat(request.getParameter("prix"));
                Date datedepart = Date.valueOf(dateDepart);
                Date datearriver = Date.valueOf(dateArriver);

                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                java.util.Date parsedTime1 = null;
                java.util.Date parsedTime2 = null;
                try {
                    parsedTime1 = timeFormat.parse(heureDepart);
                    parsedTime2 = timeFormat.parse(heureArriver);

                    Time heuredepart = new Time(parsedTime1.getTime());
                    Time heurearriver = new Time(parsedTime2.getTime());
                    Admins admin1 = (Admins) session.getAttribute("Admin");
                    Admins admin = administateurDao.getAdmin(admin1.getId());
                    System.out.println(admin1.getId());
                    voyages.setId(id);
                    voyages.setDatedepart(datedepart);
                    voyages.setDatedarriver(datearriver);
                    voyages.setHeuredepart(heuredepart);
                    voyages.setHeuredarriver(heurearriver);
                    voyages.setVilledepart(villeDepart);
                    voyages.setVillearriver(villeArriver);
                    voyages.setPlace(place);
                    voyages.setPrix(prix);
                    voyages.setAdmins(admin);
                    boolean resultUpdate = voyageService.upVoyage(voyages);
                    System.out.println(resultUpdate);
                    if (resultUpdate){
                        List<Voyages> voyages = administateurDao.listVoyage();
                        request.setAttribute("voyages", voyages);
                        request.getRequestDispatcher("dashbordAdmin.jsp").forward(request, response);
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

        }
    }

//    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        String path = request.getServletPath();
//        if (path.equals("/editVoy")){
//            HttpSession session = request.getSession();
//
//            String idS = request.getParameter("id");
//            int id = Integer.parseInt(idS);
//            String villeDepart = request.getParameter("villeDepart");
//            String villeArriver = request.getParameter("villeArriver");
//            String dateDepart = request.getParameter("dateDepart");
//            String dateArriver = request.getParameter("dateArriver");
//            String heureDepart = request.getParameter("heureDepart");
//            String heureArriver = request.getParameter("heureArriver");
//            int place = Integer.parseInt(request.getParameter("place"));
//
//            Date datedepart = Date.valueOf(dateDepart);
//            Date datearriver = Date.valueOf(dateArriver);
//
//            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
//            java.util.Date parsedTime1 = null;
//            java.util.Date parsedTime2 = null;
//            try {
//                parsedTime1 = timeFormat.parse(heureDepart);
//                parsedTime2 = timeFormat.parse(heureArriver);
//
//                Time heuredepart = new Time(parsedTime1.getTime());
//                Time heurearriver = new Time(parsedTime2.getTime());
//                Admins admin1 =(Admins) session.getAttribute("Admin");
//                Admins admin = administateurDao.getAdmin(admin1.getId());
//
//                voyages.setDatedepart(datedepart);
//                voyages.setDatedarriver(datearriver);
//                voyages.setHeuredepart(heuredepart);
//                voyages.setHeuredarriver(heurearriver);
//                voyages.setVilledepart(villeDepart);
//                voyages.setVillearriver(villeArriver);
//                voyages.setPlace(place);
//                voyages.setAdmins(admin);
//                voyageService.upVoyage(voyages);
//                List<Voyages> voyages = administateurDao.listVoyage();
//                request.setAttribute("voyages", voyages);
//                request.getRequestDispatcher("dashbordAdmin.jsp").forward(request, response);
//            }catch(Exception e){
//                throw new RuntimeException(e);
//            }
//        }

//    }
    public void destroy() {
    }
}