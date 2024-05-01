package controller.multas;

import DAO.CiudadanoDAO;
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

@WebServlet(name = "BuscarCiudadano", urlPatterns = {"/BuscarCiudadano"})
public class BuscarCiudadano extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String dni = request.getParameter("id");
            CiudadanoDTO ciudadano = new CiudadanoDAO().select(dni);

            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            if (ciudadano != null) {
                String nombreCompleto = ciudadano.getNombre() + " " + ciudadano.getApellidos();
                out.println(nombreCompleto);
            } else {
                out.println("");
            }
            out.close();

        } catch (SQLException ex) {
            Logger.getLogger(BuscarCiudadano.class.getName()).log(Level.SEVERE, null, ex);
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
