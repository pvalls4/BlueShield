/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.multas;

import DAO.CiudadanoDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DTO.CiudadanoDTO;

/**
 *
 * @author Mati
 */
@WebServlet(name = "multas", urlPatterns = {"/multas"})
public class multas extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
                HttpSession session = request.getSession(false); // No crea una nueva sesión si no hay una existente

                if (session != null && session.getAttribute("username") != null) {
                    // Hay una sesión activa y el usuario está autenticado
                    // Realiza la lógica correspondiente, como mostrar una página de inicio o redirigir a otra URL
                    request.setAttribute("username", session.getAttribute("username"));
                    System.out.println("####1" + session.getAttribute("username"));
                    System.out.println("####2" + request.getAttribute("username"));
                    request.getRequestDispatcher("/view/multas/multas.jsp").forward(request, response);
                } else {
                    // No hay una sesión activa o el usuario no está autenticado
                    // Realiza la lógica correspondiente, como mostrar un formulario de inicio de sesión
                    response.sendRedirect("view/login.jsp");
                } 
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
                try {
                    processRequest(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(multas.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
                    processRequest(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(multas.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

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
