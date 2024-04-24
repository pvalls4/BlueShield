package controller.ciudadanos;

import DAO.CiudadanoDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DTO.CiudadanoDTO;
import model.DTO.DireccionDTO;

@WebServlet(name = "editarCiudadano", urlPatterns = {"/editarCiudadano"})
public class editarCiudadano extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("./view/ciudadanos/editarCiudadano.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String dni = request.getParameter("id");

            CiudadanoDAO ciudadanoDAO = new CiudadanoDAO();
            CiudadanoDTO ciudadano = ciudadanoDAO.select(dni);

            request.setAttribute("ciudadano", ciudadano);
            request.getRequestDispatcher("/view/ciudadanos/editarCiudadano.jsp").forward(request, response);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtener los datos del formulario
            String dni = request.getParameter("dni");
            CiudadanoDTO ciudadano= new CiudadanoDAO().select(dni);
            
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            String imagen = request.getParameter("imagen");
            String email = request.getParameter("email");
            
            ciudadano.setEmail(email);
            ciudadano.setEnlaceFotografico(imagen);
            ciudadano.setTelefono(telefono);
            
            String calle = request.getParameter("calle");
            int numero = Integer.parseInt(request.getParameter("numero"));
            String piso = request.getParameter("piso");
            String puerta = request.getParameter("puerta");
            String codigoPostal = request.getParameter("codigoPostal");
            String municipio = request.getParameter("municipio");
            
            ciudadano.getDireccion().setMunicipio(municipio);
            ciudadano.getDireccion().setCodigoPostal(codigoPostal);
            ciudadano.getDireccion().setCalle(calle);
            ciudadano.getDireccion().setNumero(numero);
            ciudadano.getDireccion().setPiso(piso);
            ciudadano.getDireccion().setPuerta(puerta);
            
            int resultado = new CiudadanoDAO().update(ciudadano);
            
            // Puedes manejar el resultado de la actualización aquí, por ejemplo, redireccionar a otra página
            if (resultado > 0) {
                response.sendRedirect("exito.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(editarCiudadano.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
