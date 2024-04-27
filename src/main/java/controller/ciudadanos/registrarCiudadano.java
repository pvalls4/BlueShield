package controller.ciudadanos;

import DAO.CiudadanoDAO;
import DAO.DireccionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DTO.CiudadanoDTO;
import model.DTO.DireccionDTO;

@WebServlet(name = "registrarCiudadano", urlPatterns = {"/registrarCiudadano"})
public class registrarCiudadano extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            request.setAttribute("username", session.getAttribute("username"));
            request.getRequestDispatcher("./view/ciudadanos/registrarCiudadano.jsp").forward(request, response);
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
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String fecha = request.getParameter("fechaNacimiento");
        Date fechaNacimiento = null;
        fechaNacimiento = Date.valueOf(fecha);
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        String email = request.getParameter("email");
        String imagen = request.getParameter("imagen");

        String municipio = request.getParameter("municipio");
        String codigoPostal = request.getParameter("codigoPostal");
        String calle = request.getParameter("calle");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String piso = request.getParameter("piso");
        String puerta = request.getParameter("puerta");

        DireccionDTO dir = null;
        dir = new DireccionDTO(municipio, codigoPostal, calle, piso, puerta, numero);

        try {
            int idDireccion = new DireccionDAO().insert(dir);
            if (idDireccion != -1) {
                CiudadanoDTO ciudadano = null;
                DireccionDTO direccion = new DireccionDAO().select(idDireccion);
                ciudadano = new CiudadanoDTO(
                        dni,
                        nombre,
                        apellidos,
                        fechaNacimiento,
                        telefono,
                        email,
                        false,
                        direccion,
                        imagen
                );
                 int row = new CiudadanoDAO().insert(ciudadano);
                 if(row>0){
                     response.sendRedirect("ciudadanos");
                 } else {
                     System.out.println("Error añadiendo ciudadano");
                 }
            } else {
                System.out.println("Error añadiendo direccion.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(registrarCiudadano.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
