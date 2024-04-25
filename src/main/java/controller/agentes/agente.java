package controller.agentes;

import DAO.AgenteDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import model.DTO.AgenteDTO;

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

                if (session != null && session.getAttribute("username") != null) {
                    request.setAttribute("username", session.getAttribute("username"));
                    try {
                        int placa = Integer.parseInt(request.getParameter("placa"));

                        AgenteDAO agentedao = new AgenteDAO();
                        AgenteDTO agente = agentedao.select(placa);
                        // Sanciones o concecoraciones: List<VehiculoDTO> listaVehiculos = new VehiculoDAO().selectDNI(dni);

                        request.setAttribute("ciudadano", agente);
                        // Sanciones o condecoracionesrequest.setAttribute("listaVehiculos", listaVehiculos);
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
