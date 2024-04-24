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
//        // Obtener los datos del formulario
//        String dni = request.getParameter("dni"); 
//        CiudadanoDTO ciudadano = null;
//        CiudadanoDAO dao = null;
//        ciudadano=dao.select(dni);
//         
//        String telefono = request.getParameter("telefono");
//        String imagen = request.getParameter("imagen");
//        String email = request.getParameter("email");
//        String calle = request.getParameter("calle");
//        int numero = Integer.getInteger(request.getParameter("numero"));
//        String piso = request.getParameter("piso"); 
//        String puerta = request.getParameter("puerta"); 
//        String codigoPostal = request.getParameter("codigoPostal");
//        String municipio = request.getParameter("municipio");
//        
//        ciudadano.setDireccion(ciudadano.getDireccion).setMunicipio();
//
//        // Llamar al método update para actualizar los datos en la base de datos
//        CiudadanoDAO dao = new CiudadanoDAO();
//        int resultado = dao.update(ciudadano);
//
//        // Puedes manejar el resultado de la actualización aquí, por ejemplo, redireccionar a otra página
//        if (resultado > 0) {
//            response.sendRedirect("exito.jsp");
//        } else {
//            response.sendRedirect("error.jsp");
//        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
