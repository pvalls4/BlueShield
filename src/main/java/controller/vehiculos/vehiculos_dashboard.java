package controller.vehiculos;

import DAO.VehiculoDAO;
import controller.ciudadanos.ciudadanos_dashboard;
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
import model.DTO.VehiculoDTO;

@WebServlet(name = "vehiculos_dashboard", urlPatterns = {"/vehiculos"})
public class vehiculos_dashboard extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
                response.setContentType("text/html;charset=UTF-8");
                HttpSession session = request.getSession(false);

                if (session != null && (session.getAttribute("username") != null || session.getAttribute("admin") != null)) {
                    request.setAttribute("username", session.getAttribute("username"));
                    request.setAttribute("title", "BlueShield - Vehiculos");
                    response.setContentType("text/html;charset=UTF-8");
                    VehiculoDAO dao = new VehiculoDAO();
                    List<VehiculoDTO> listaVehiculos = dao.selectAll();
                    request.setAttribute("listaVehiculos", listaVehiculos);
                    RequestDispatcher rd = request.getRequestDispatcher("./view/vehiculos/vehiculos_dashboard.jsp");
                    rd.forward(request, response);
                } else {
                response.sendRedirect("login");
                } 
            }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(vehiculos_dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String matricula = request.getParameter("matricula");
        response.sendRedirect("vehiculo?id=" + matricula);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
