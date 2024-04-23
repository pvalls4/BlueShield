package controller;

import DAO.CiudadanoDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DTO.CiudadanoDTO;

@WebServlet(name = "ciudadano", urlPatterns = {"/ciudadano"})
public class ciudadano extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("./view/ciudadano.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String dni = request.getParameter("id");

            CiudadanoDAO ciudadanoDAO = new CiudadanoDAO();
            CiudadanoDTO ciudadano = ciudadanoDAO.select(dni);

            request.setAttribute("ciudadano", ciudadano);
            request.getRequestDispatcher("/view/ciudadano.jsp").forward(request, response);

        } catch (SQLException ex) {
            ex.printStackTrace(); 
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
