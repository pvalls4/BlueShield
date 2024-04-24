package controller.ciudadanos;

import DAO.CiudadanoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import model.DTO.CiudadanoDTO;

@WebServlet(name = "ciudadano", urlPatterns = {"/ciudadano"})
public class ciudadano extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                HttpSession session = request.getSession(false);

                if (session != null && session.getAttribute("username") != null) {
                    request.setAttribute("username", session.getAttribute("username"));
                    try {
                        String dni = request.getParameter("id");

                        CiudadanoDAO ciudadanoDAO = new CiudadanoDAO();
                        CiudadanoDTO ciudadano = ciudadanoDAO.select(dni);

                        request.setAttribute("ciudadano", ciudadano);
                        request.getRequestDispatcher("/view/ciudadanos/ciudadano.jsp").forward(request, response);

                    } catch (SQLException ex) {
                        ex.printStackTrace(); 
                    }
                    
                } else {
                    response.sendRedirect("login");
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
