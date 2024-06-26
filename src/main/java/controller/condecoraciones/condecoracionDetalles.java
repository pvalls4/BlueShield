package controller.condecoraciones;

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
import model.DTO.CondecoracionAgenteDTO;
import model.DTO.CondecoracionDTO;

@WebServlet(name = "condecoracionDetalles", urlPatterns = {"/condecoracionDetalles"})
public class condecoracionDetalles extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

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
                request.setAttribute("title", "BlueShield - Condecoracion " + condecoracion.getTitulo());
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
        String condecoracionAgenteValue = request.getParameter("condecoracionAgente");
        String[] condecoracionAgenteParts = condecoracionAgenteValue.split(" ");
        String idCondecoracionStr = condecoracionAgenteParts[0];
        String idAgenteStr = condecoracionAgenteParts[1];
        int idCondecoracion = Integer.parseInt(idCondecoracionStr);
        int idAgente = Integer.parseInt(idAgenteStr);

        CondecoracionAgenteDTO condecoracionAgente = null;
        CondecoracionAgenteDAO daoCA = new CondecoracionAgenteDAO();
        try {
            condecoracionAgente = daoCA.selectIdCondecoracionAgente(idCondecoracion, idAgente);
            daoCA.delete(condecoracionAgente);
        } catch (SQLException ex) {
            Logger.getLogger(condecoracionDetalles.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("condecoraciones");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
