package controller.agentes;

import DAO.AgenteDAO;
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
import model.DTO.AgenteDTO;

/**
 *
 * @author Mati
 */
@WebServlet(name = "agentes", urlPatterns = {"/agentes"})
public class listaAgentes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
                HttpSession session = request.getSession(false);

                    if (session != null && session.getAttribute("username") != null) {
                        request.setAttribute("username", session.getAttribute("username"));
                        response.setContentType("text/html;charset=UTF-8");
                        List<AgenteDTO> listaAgentes = new AgenteDAO().selectAll();
                        request.setAttribute("listaAgentes", listaAgentes);
                        RequestDispatcher rd = request.getRequestDispatcher("./view/agentes/listaAgentes.jsp");
                        rd.forward(request, response);
                    } else {
                        response.sendRedirect("login");
                    } 

            }

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
                try {
                    processRequest(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(listaAgentes.class.getName()).log(Level.SEVERE, null, ex);
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
                String placa = request.getParameter("placa");
                response.sendRedirect("agente?placa=" + placa);
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
