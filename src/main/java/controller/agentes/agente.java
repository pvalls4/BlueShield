package controller.agentes;

import DAO.AgenteDAO;
import DAO.CondecoracionAgenteDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import model.DTO.AgenteDTO;
import model.DTO.CondecoracionAgenteDTO;

@WebServlet(name = "agente", urlPatterns = {"/agente"})
public class agente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null && (session.getAttribute("username") != null || session.getAttribute("admin") != null)) {
            request.setAttribute("username", session.getAttribute("username"));
            try {
                int placa = Integer.parseInt(request.getParameter("placa"));
                request.setAttribute("title", "BlueShield - Agente " + placa);

                AgenteDTO agente = new AgenteDAO().select(placa);
                List<CondecoracionAgenteDTO> condecoracionesAgente = new CondecoracionAgenteDAO().selectByAgente(agente.getPlaca());

                request.setAttribute("agente", agente);
                request.setAttribute("listaCondecoracionesAgente", condecoracionesAgente);

                request.getRequestDispatcher("/view/agentes/agente.jsp").forward(request, response);

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
