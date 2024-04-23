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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DTO.CiudadanoDTO;

@WebServlet(name = "ciudadanos", urlPatterns = {"/ciudadanos"})
public class ciudadanos_dashboard extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        CiudadanoDAO dao = new CiudadanoDAO();
        List<CiudadanoDTO> listaCiudadanos = dao.selectAll();
        RequestDispatcher rd = request.getRequestDispatcher("./view/ciudadanos_dashboard.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ciudadanos_dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dni = request.getParameter("dni");
        response.sendRedirect("ciudadano?id=" + dni);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
