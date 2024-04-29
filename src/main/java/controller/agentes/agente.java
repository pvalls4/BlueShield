package controller.agentes;

import DAO.AgenteDAO;
import DAO.CondecoracionAgenteDAO;
import DAO.CondecoracionDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DTO.AgenteDTO;
import model.DTO.CondecoracionAgenteDTO;
import model.DTO.CondecoracionDTO;

/**
 *
 * @author Mati
 */
@WebServlet(name = "agente", urlPatterns = {"/agente"})
public class agente extends HttpServlet {
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
                HttpSession session = request.getSession(false);

                if (session != null && (session.getAttribute("username") != null || session.getAttribute("admin") != null)) {
                    request.setAttribute("username", session.getAttribute("username"));
                    try {
                        int placa = Integer.parseInt(request.getParameter("placa"));

                        AgenteDTO agente = new AgenteDAO().select(placa);
                        List<CondecoracionAgenteDTO> condecoracionesAgente = new CondecoracionAgenteDAO().selectByAgente(agente.getPlaca());
                        
                        request.setAttribute("agente", agente);
                        request.setAttribute("listaCondecoracionesAgente", condecoracionesAgente);
                        System.out.println(request.getAttribute("listaCondecoracionesAgente"));
                        
                        request.getRequestDispatcher("/view/agentes/agente.jsp").forward(request, response);

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                } else {
                    response.sendRedirect("login");
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
