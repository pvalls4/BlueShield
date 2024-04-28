package controller;

import DAO.AdminDAO;
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
import utilidad.PasswordManager;

/**
 *
 * @author Mati
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             RequestDispatcher dispatcher = request.getRequestDispatcher("/view/login.jsp");
             dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int placa = Integer.parseInt(request.getParameter("placa"));
        String pwd = request.getParameter("pwd");

        // Perform authentication (e.g., check against a database)
        AgenteDTO agente = authenticate(placa, pwd);

        if (agente != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", agente);
            request.setAttribute("username", agente);
            request.getRequestDispatcher("/view/dashboard.jsp").forward(request, response);
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
                if(agente == null){
                    return null;
                } else if (agente.getPlaca() == placa && PasswordManager.verifyPassword(pwd,agente.getPassword())) {
                    return agente;
                }
            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
            return null;
        }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
    
