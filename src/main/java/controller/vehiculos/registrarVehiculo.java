package controller.vehiculos;

import DAO.CiudadanoDAO;
import DAO.ModeloDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
import model.DTO.CiudadanoDTO;
import model.DTO.ModeloDTO;

@WebServlet(name = "registrarVehiculo", urlPatterns = {"/registrarVehiculo"})
public class registrarVehiculo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("title", "BlueShield - Registrar Ciudadano");
        HttpSession session = request.getSession(false);

        if (session != null && (session.getAttribute("username") != null || session.getAttribute("admin") != null)) {
            request.setAttribute("username", session.getAttribute("username"));
            try {
                List<ModeloDTO> listaModelos = new ModeloDAO().selectAll();
                List<CiudadanoDTO> listaCiudadanos = new CiudadanoDAO().selectAll();
                request.setAttribute("listaModelos", listaModelos);
                request.setAttribute("listaCiudadanos", listaCiudadanos);
            } catch (SQLException ex) {
                Logger.getLogger(registrarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("./view/vehiculos/registrarVehiculo.jsp").forward(request, response);
        } else {
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
