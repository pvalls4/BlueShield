package controller.ciudadanos;

import DAO.CiudadanoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "existeDNI", urlPatterns = {"/existeDNI"})
public class existeDNI extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String dni = request.getParameter("id");
            List<String> dnis = new CiudadanoDAO().selectALL_dni();
            boolean dniExiste = dnis.contains(dni);
            // Configurar la respuesta del servlet
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.print(dniExiste ? "1" : "0"); // Devolver "1" si el DNI existe, "0" si no existe
            out.flush();

        } catch (SQLException ex) {
            Logger.getLogger(existeDNI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
