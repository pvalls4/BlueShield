package controller.ciudadanos;

import DAO.CiudadanoDAO;

import DAO.VehiculoDAO;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import model.DTO.CiudadanoDTO;
import model.DTO.VehiculoDTO;

@WebServlet(name = "ciudadano", urlPatterns = {"/ciudadano"})
public class ciudadano extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null && (session.getAttribute("username") != null || session.getAttribute("admin") != null)) {
            request.setAttribute("username", session.getAttribute("username"));
            try {
                String dni = request.getParameter("id");

                CiudadanoDAO ciudadanoDAO = new CiudadanoDAO();
                CiudadanoDTO ciudadano = ciudadanoDAO.select(dni);
                List<VehiculoDTO> listaVehiculos = new VehiculoDAO().selectDNI(dni);

                request.setAttribute("ciudadano", ciudadano);
                request.setAttribute("listaVehiculos", listaVehiculos);
                request.getRequestDispatcher("/view/ciudadanos/ciudadano.jsp").forward(request, response);

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
