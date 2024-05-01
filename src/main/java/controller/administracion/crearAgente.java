package controller.administracion;

import DAO.AgenteDAO;
import DAO.CiudadanoDAO;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.DTO.AgenteDTO;
import model.DTO.CiudadanoDTO;
import static utilidad.PasswordManager.hashPassword;

@WebServlet(name = "crearAgente", urlPatterns = {"/crearAgente"})
public class crearAgente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null && (Boolean) session.getAttribute("isAdmin") == true) {
            try {
                request.setAttribute("username", session.getAttribute("username"));
                request.setAttribute("isAdmin", session.getAttribute("isAdmin"));
                response.setContentType("text/html;charset=UTF-8");
                AgenteDAO aDao = new AgenteDAO();
                List<AgenteDTO> listaAgentes = aDao.selectAll();
                CiudadanoDAO cDao = new CiudadanoDAO();
                List<CiudadanoDTO> listaCiudadanos = cDao.selectAll();

                List<CiudadanoDTO> listaCiudadanosFiltrada = listaCiudadanos.stream()
                        .filter(ciudadano -> listaAgentes.stream()
                        .noneMatch(agente -> ciudadano.getDni().equals(agente.getCiudadano().getDni())))
                        .collect(Collectors.toList());

                request.setAttribute("listaCiudadanosFiltrada", listaCiudadanosFiltrada);

                request.setAttribute("listaCiudadanos", listaCiudadanos);
                RequestDispatcher rd = request.getRequestDispatcher("/view/administracion/crearAgente.jsp");
                rd.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(crearAgente.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            String dni = request.getParameter("dni");
            CiudadanoDAO ciudadanoDAO = new CiudadanoDAO();
            CiudadanoDTO ciudadano;
            AgenteDAO agenteDAO = new AgenteDAO();
            try {
                ciudadano = ciudadanoDAO.select(dni);
                if (ciudadano == null || agenteDAO.select(dni) == 1) {
                    request.setAttribute("dniInvalid", true);
                    request.setAttribute("dni", dni);
                    rd = request.getRequestDispatcher("/view/administracion/agenteSubido.jsp");
                    rd.forward(request, response);
                    return;
                }
            } catch (SQLException e) {
                e.getStackTrace();
            }

            String rango = request.getParameter("rangos");
            String adminCheckboxValue = request.getParameter("adminCheckbox");
            boolean isAdmin = adminCheckboxValue != null && adminCheckboxValue.equals("on");

            String imagen = request.getParameter("imagen");
            String halfPass = dni.substring(dni.length() - 3);
            int placa = 0;
            try {
                List<AgenteDTO> listaAgentes = agenteDAO.selectAll();
                AgenteDTO miAgente = listaAgentes.get(listaAgentes.size() - 1);
                placa = miAgente.getPlaca() + 1;
            } catch (SQLException ex) {
                ex.getStackTrace();
            }
            request.setAttribute("placa", placa);
            String contrasena = request.getParameter("dni");
            request.setAttribute("rango", rango);
            
            int idPlaca=0;
            
            try {
                ciudadano = ciudadanoDAO.select(dni);
                AgenteDTO nuevoAgente = new AgenteDTO(ciudadano, hashPassword(contrasena), imagen, rango, isAdmin);
                idPlaca=agenteDAO.insert(nuevoAgente);
            } catch (SQLException e) {
                e.getStackTrace();
            }
            request.setAttribute("idAgente",idPlaca);
            request.setAttribute("dni", dni);
            request.setAttribute("dniInvalid", false);
            request.setAttribute("dni", dni);
            rd = request.getRequestDispatcher("/view/administracion/agenteSubido.jsp");
            rd.forward(request, response);
        } else {
            throw new WebApplicationException("Access is forbidden to this resource", Response.Status.FORBIDDEN);
        }

    }
}
