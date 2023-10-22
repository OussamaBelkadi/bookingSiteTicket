import dao.AdministateurDao;
import dao.impl.AdminstateurDaoImpl;
import entity.Admins;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "signUp" ,value = {"/sign-up"})
public class AdminServlet extends HttpServlet {
    private Admins admins;
    private AdministateurDao administateurDao;
    public void init(){
        this.administateurDao = new AdminstateurDaoImpl();
        this.admins = new Admins();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signUp.jsp").forward(req,resp);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        admins.setNom(nom);
        admins.setPrenom(prenom);
        admins.setEmail(email);
        admins.setPassword(password);
        boolean result = administateurDao.regester(admins);
        if (result){
            response.sendRedirect("login");
        }else{
//            String error = "Erreur provient lors de l'enregistriment";
//            request.setAttribute("error", error);
//            request.getRequestDispatcher("signup.jsp").forward(request, response);
            response.getWriter().write("Registration failed. Please try again.");
        }
    }
}
