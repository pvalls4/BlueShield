package controller.condecoraciones;

import DAO.CiudadanoDAO;
import DAO.CondecoracionDAO;
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
import model.DTO.CondecoracionDTO;

@WebServlet(name = "condecoraciones", urlPatterns = {"/condecoraciones"})
public class condecoraciones extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);

            if (session != null && (session.getAttribute("username") != null || session.getAttribute("admin") != null)) {
                request.setAttribute("username", session.getAttribute("username"));
                response.setContentType("text/html;charset=UTF-8");
                CondecoracionDAO dao = new CondecoracionDAO();
                List<CondecoracionDTO> listaCondecoraciones = dao.selectAll();
                request.setAttribute("listaCondecoraciones", listaCondecoraciones);
                RequestDispatcher rd = request.getRequestDispatcher("./view/condecoraciones/condecoraciones.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect("login");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(condecoraciones.class.getName()).log(Level.SEVERE, null, ex);
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
