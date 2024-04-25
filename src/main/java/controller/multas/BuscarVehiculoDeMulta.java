package controller.multas;

import DAO.CiudadanoDAO;
import DAO.VehiculoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DTO.CiudadanoDTO;
import model.DTO.VehiculoDTO;

@WebServlet(name = "BuscarVehiculoDeMulta", urlPatterns = {"/BuscarVehiculoDeMulta"})
public class BuscarVehiculoDeMulta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String matricula = request.getParameter("id");
            VehiculoDTO vehiculo = new VehiculoDAO().selectMATRICULA(matricula);

            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            if (vehiculo != null) {
                
                out.println(vehiculo.getCiudadano().getDni());
            } else {
                out.println("");
            }
            out.close();

        } catch (SQLException ex) {
            Logger.getLogger(BuscarCiudadanoDeMulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
