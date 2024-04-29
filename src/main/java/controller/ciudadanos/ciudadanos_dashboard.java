package controller.ciudadanos;

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

@WebServlet(name = "ciudadanos", urlPatterns = {"/ciudadanos"})
public class ciudadanos_dashboard extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
            
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);

            if (session != null && (session.getAttribute("username") != null || session.getAttribute("admin") != null)) {
                request.setAttribute("username", session.getAttribute("username"));
                request.setAttribute("title", "BlueShield - Ciudadanos");
                response.setContentType("text/html;charset=UTF-8");
                CiudadanoDAO dao = new CiudadanoDAO();
                List<CiudadanoDTO> listaCiudadanos = dao.selectAll();
                request.setAttribute("listaCiudadanos", listaCiudadanos);
                RequestDispatcher rd = request.getRequestDispatcher("./view/ciudadanos/ciudadanos_dashboard.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect("login");
            } 
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
