package controller.administracion;

import DAO.CondecoracionDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import java.sql.SQLException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import model.DTO.CondecoracionDTO;

@WebServlet(name = "crearCondecoracion", urlPatterns = {"/crearCondecoracion"})
public class crearCondecoracion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null && (Boolean) session.getAttribute("isAdmin") == true) {
            request.setAttribute("username", session.getAttribute("username"));
            request.setAttribute("isAdmin", session.getAttribute("isAdmin"));
            response.setContentType("text/html;charset=UTF-8");
            RequestDispatcher rd = request.getRequestDispatcher("/view/administracion/crearCondecoracion.jsp");
            rd.forward(request, response);
        } else {
            throw new WebApplicationException("Access is forbidden to this resource", Response.Status.FORBIDDEN);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null && (Boolean) session.getAttribute("isAdmin") == true) {
            request.setAttribute("username", session.getAttribute("username"));
            request.setAttribute("isAdmin", session.getAttribute("isAdmin"));
            response.setContentType("text/html;charset=UTF-8");
            RequestDispatcher rd;
            String titulo = request.getParameter("titulo");
            String imagen = request.getParameter("imagen");
            String descripcion = request.getParameter("descripcion");
            CondecoracionDAO condecoracionDAO = new CondecoracionDAO();
            try {
                CondecoracionDTO nuevaCondecoracion = new CondecoracionDTO(titulo, descripcion, imagen);
                condecoracionDAO.insert(nuevaCondecoracion);

            } catch (SQLException e) {
                e.getStackTrace();
            }
            request.setAttribute("titulo", titulo);
            rd = request.getRequestDispatcher("/view/administracion/condecoracionSubida.jsp");
            rd.forward(request, response);
        } else {
            throw new WebApplicationException("Access is forbidden to this resource", Response.Status.FORBIDDEN);
        }

    }
}
