package controller.condecoraciones;

import DAO.CiudadanoDAO;
import DAO.CondecoracionAgenteDAO;
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
import model.DTO.CondecoracionAgenteDTO;
import model.DTO.CondecoracionDTO;

@WebServlet(name = "condecoracionDetalles", urlPatterns = {"/condecoracion"})
public class condecoracionDetalles extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
            HttpSession session = request.getSession(false);

            if (session != null && (session.getAttribute("username") != null || session.getAttribute("admin") != null)) {
                request.setAttribute("username", session.getAttribute("username"));
                int idCondecoracion = Integer.parseInt(request.getParameter("id"));
                response.setContentType("text/html;charset=UTF-8");
                CondecoracionDAO cdao = new CondecoracionDAO();
                CondecoracionDTO condecoracion = cdao.select(idCondecoracion);
                CondecoracionAgenteDAO dao = new CondecoracionAgenteDAO();
                List<CondecoracionAgenteDTO> agentesCondecoracion = dao.selectByCond(idCondecoracion);
                request.setAttribute("condecoracion", condecoracion);
                request.setAttribute("agentesCondecoracion", agentesCondecoracion);
                RequestDispatcher rd = request.getRequestDispatcher("./view/condecoraciones/condecoracionDetalles.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect("login");
            } 
            
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);

            if (session != null && session.getAttribute("username") != null) {
                request.setAttribute("username", session.getAttribute("username"));
                int idCondecoracion = Integer.parseInt(request.getParameter("id"));
                response.setContentType("text/html;charset=UTF-8");
                CondecoracionDAO cdao = new CondecoracionDAO();
                CondecoracionDTO condecoracion = cdao.select(idCondecoracion);
                CondecoracionAgenteDAO dao = new CondecoracionAgenteDAO();
                List<CondecoracionAgenteDTO> agentesCondecoracion = dao.selectByCond(idCondecoracion);
                request.setAttribute("condecoracion", condecoracion);
                request.setAttribute("agentesCondecoracion", agentesCondecoracion);
                RequestDispatcher rd = request.getRequestDispatcher("./view/condecoraciones/condecoracionDetalles.jsp");
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
