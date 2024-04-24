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
        VehiculoDAO dao = new VehiculoDAO();
        List<VehiculoDTO> listaVehiculos = dao.selectAll();
        request.setAttribute("listaVehiculos", listaVehiculos);
        RequestDispatcher rd = request.getRequestDispatcher("./view/vehiculos/vehiculos_dashboard.jsp");
        rd.forward(request, response);
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ciudadanos_dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bastidor = request.getParameter("bastidor");
        response.sendRedirect("vehiculo?id=" + bastidor);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
