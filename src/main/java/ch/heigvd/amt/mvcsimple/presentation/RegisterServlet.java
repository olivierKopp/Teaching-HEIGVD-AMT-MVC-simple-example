package ch.heigvd.amt.mvcsimple.presentation;

import ch.heigvd.amt.mvcsimple.business.InfoChecker;
import ch.heigvd.amt.mvcsimple.model.Profile;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RegisterServlet extends javax.servlet.http.HttpServlet {

    private InfoChecker service; // we will see later how to replace this with dependency injection
    private HashMap<String, String> erreurs = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        service = new InfoChecker();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        /* Affichage de la page d'inscription */

        request.getRequestDispatcher("/WEB-INF/pages/view2.jsp").forward(request, response);

    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Profile p = new Profile(request.getParameter("username"), request.getParameter("password"), request.getParameter("mail"));
        //reset error
        for (int i = 0; i < erreurs.size(); i++){
            erreurs.clear();
        }
        String resultat = "Login failure";
        if (!service.checkNotEmpty(p.getUsername())){
            erreurs.put("username", "username can't be empty");
        }
        else if(!service.checkNotEmpty(p.getPassword())){
            erreurs.put("password", "password can't be empty");
        }
        else if(!service.checkNotEmpty(p.getMail())){
            erreurs.put("mailEmpty", "mail can't be empty");
        }
        else if(!service.checkMail(p.getMail())){
            erreurs.put("mailIncorrect", "invalid mail");
        }
        else{
            resultat = "Login success";
        }
        erreurs.put("status", resultat);
        request.setAttribute("erreurs", erreurs);
        request.getRequestDispatcher("/WEB-INF/pages/view2.jsp").forward(request, response);
    }

}
