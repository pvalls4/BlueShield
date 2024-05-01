package controller.administracion;

import DAO.AgenteDAO;
import DAO.CiudadanoDAO;
import DAO.ModeloDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DTO.AgenteDTO;
import model.DTO.CiudadanoDTO;
import model.DTO.ModeloDTO;
import static utilidad.PasswordManager.hashPassword;

@WebServlet(name = "crearModelo", urlPatterns = {"/crearModelo"})
public class crearModelo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null && (Boolean) session.getAttribute("isAdmin") == true) {
            request.setAttribute("username", session.getAttribute("username"));
            request.setAttribute("isAdmin", session.getAttribute("isAdmin"));
            response.setContentType("text/html;charset=UTF-8");
            RequestDispatcher rd = request.getRequestDispatcher("/view/administracion/crearModelo.jsp");
            rd.forward(request, response);
        } else {
            throw new WebApplicationException("Access is forbidden to this resource", Response.Status.FORBIDDEN);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null && (Boolean) session.getAttribute("isAdmin") == true) {
            request.setAttribute("username", session.getAttribute("username"));
            request.setAttribute("isAdmin", session.getAttribute("isAdmin"));
            response.setContentType("text/html;charset=UTF-8");
            RequestDispatcher rd;
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            String imagen = request.getParameter("imagen");
            ModeloDAO modeloDao = new ModeloDAO();
            try {
                ModeloDTO nuevoModelo = new ModeloDTO(marca, modelo, imagen);
                modeloDao.insert(nuevoModelo);

            } catch (SQLException e) {
                e.getStackTrace();
            }
            request.setAttribute("marca", marca);
            request.setAttribute("modelo", modelo);
            rd = request.getRequestDispatcher("/view/administracion/modeloSubido.jsp");
            rd.forward(request, response);
        } else {
            throw new WebApplicationException("Access is forbidden to this resource", Response.Status.FORBIDDEN);
        }

    }
}
