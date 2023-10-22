import com.example.fly.service.ClientService;
import dao.AgentDao;
import dao.VoyageDao;
import dao.impl.AgentDaoImpl;
import dao.impl.VoyageDaoImp;
import entity.Clients;
import entity.Voyages;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.VoyageService;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "AgnetServlet", value = {"/rechercheVoy","/reserve", "/reserver"})
public class AgentServlet extends HttpServlet {
    private Voyages voyage;
    private VoyageService voyageService;
    private VoyageDao voyageDao;
    private Clients client;
    private ClientService clientService;
    private AgentDao agentDao;

    public void init() throws ServletException {
        this.voyage = new Voyages();
        this.voyageDao = new VoyageDaoImp();
        this.voyageService = new VoyageService(voyageDao);
        this.client = new Clients();
        this.agentDao = new AgentDaoImpl();
        this.clientService = new ClientService(agentDao);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/reserve")) {
            String idS = (String) request.getParameter("id");
            int id = Integer.parseInt(idS);
            Voyages voyage = voyageService.getVoyage(id);
            request.setAttribute("voyage", voyage);
            request.getRequestDispatcher("reservation.jsp").forward(request, response);
        }else if (path.equals("/reserver")) {
            // =>   Donnee relative au client
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            client.setNom(nom);
            client.setEmail(email);
            client.setPrenom(prenom);

            boolean resultRegister = clientService.saveClient(client);

            // =>   Donnee relative au client
            if(resultRegister) {
                System.out.println("good");
                String villeDepart = request.getParameter("villeDepart");
                String villeArriver = request.getParameter("villeArriver");
                String dateDepart = request.getParameter("dateDepart");
                String dateArriver = request.getParameter("dateArriver");
                String heureDepart = request.getParameter("heureDepart");
                String heureArriver = request.getParameter("heureArriver");
                int place = Integer.parseInt(request.getParameter("place"));

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
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String path = request.getServletPath();
        if(path.equals("/rechercheVoy")){

            String villeDepart = (String) request.getParameter("villeDepart");
            String villeArriver = (String) request.getParameter("villeArriver");
            System.out.println(villeDepart + " " + villeArriver);
            voyage.setVilledepart(villeDepart);
            voyage.setVillearriver(villeArriver);
            List<Voyages> voyages = voyageService.rechercheVoy(voyage);
            for (Voyages voyage : voyages) {
                System.out.println("id: " + voyage.getId());
            }
            System.out.println(voyages);
            request.setAttribute("voyages", voyages);
            request.getRequestDispatcher("recherche.jsp").forward(request, response);
        }
    }
}
