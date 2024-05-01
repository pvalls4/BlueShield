package controller;

import DAO.AgenteDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DTO.AgenteDTO;
import static utilidad.PasswordManager.verifyPassword;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("title", "BlueShield - LogIn");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int placa = Integer.parseInt(request.getParameter("placa"));
        String pwd = request.getParameter("pwd");

        AgenteDTO agente = authenticate(placa, pwd);
        if (agente != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", agente);
            request.setAttribute("username", agente);
            if (agente.isAdmin() == true) {
                session.setAttribute("isAdmin", true);
                request.setAttribute("isAdmin", true);
            }
            response.sendRedirect("dashboard");
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.setAttribute("invalidUser", true);
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }
    }

    private AgenteDTO authenticate(int placa, String pwd)
            throws ServletException, IOException {
        AgenteDAO dao = new AgenteDAO();
        try {
            AgenteDTO agente = dao.select(placa);
            if (agente == null) {
                return null;
            } else if (agente.getPlaca() == placa && verifyPassword(pwd, agente.getPassword())) {
                return agente;
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
