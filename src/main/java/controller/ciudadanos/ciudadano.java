package controller.ciudadanos;

import DAO.CiudadanoDAO;
import DAO.VehiculoDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import model.DTO.CiudadanoDTO;
import model.DTO.VehiculoDTO;

@WebServlet(name = "ciudadano", urlPatterns = {"/ciudadano"})
public class ciudadano extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("./view/ciudadanos/ciudadano.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String dni = request.getParameter("id");

            CiudadanoDAO ciudadanoDAO = new CiudadanoDAO();
            CiudadanoDTO ciudadano = ciudadanoDAO.select(dni);
            List<VehiculoDTO> listaVehiculos = new  VehiculoDAO().selectDNI(dni);

            
            request.setAttribute("ciudadano", ciudadano);
            request.setAttribute("listaVehiculos", listaVehiculos);
            request.getRequestDispatcher("/view/ciudadanos/ciudadano.jsp").forward(request, response);

        } catch (SQLException ex) {
            ex.printStackTrace(); 
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
