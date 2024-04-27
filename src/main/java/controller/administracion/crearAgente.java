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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DTO.AgenteDTO;
import model.DTO.CiudadanoDTO;

@WebServlet(name = "crearAgente", urlPatterns = {"/crearAgente"})
public class crearAgente extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
                response.setContentType("text/html;charset=UTF-8");
                HttpSession session = request.getSession(false);

                if (session != null && session.getAttribute("username") != null) {
                    try {
                        request.setAttribute("username", session.getAttribute("username"));
                        response.setContentType("text/html;charset=UTF-8");
                        AgenteDAO aDao = new AgenteDAO();
                        List<AgenteDTO> listaAgentes = aDao.selectAll();
                        int idPlaca = listaAgentes.size() + 1;
                        request.setAttribute("idPlaca", idPlaca);
                        RequestDispatcher rd = request.getRequestDispatcher("/view/administracion/crearAgente.jsp");
                        rd.forward(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(crearAgente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    response.sendRedirect("login");
                } 
            }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
                response.setContentType("text/html;charset=UTF-8");
                HttpSession session = request.getSession(false);
                if (session != null && session.getAttribute("username") != null) {
                    request.setAttribute("username", session.getAttribute("username"));
                    response.setContentType("text/html;charset=UTF-8");
                    RequestDispatcher rd;
                    String dni = request.getParameter("dni");
                    CiudadanoDAO ciudadanoDAO = new CiudadanoDAO();
                    CiudadanoDTO ciudadano;
                    try{
                       ciudadano = ciudadanoDAO.select(dni);
                       if(ciudadano == null){
                           request.setAttribute("dniInvalid", true);
                           request.setAttribute("dni", dni);
                           rd = request.getRequestDispatcher("/view/administracion/agenteSubido.jsp");
                           rd.forward(request, response);
                           return;
                       }
                    }catch(SQLException e){
                        e.getStackTrace();
                    }
                    
                    String correo = request.getParameter("correo");
                    String imagen = request.getParameter("imagen");
                    String halfPass = dni.substring(dni.length() - 3);
                    int placa = Integer.parseInt(request.getParameter("placa"));
                    request.setAttribute("placa", placa);
                    String contrasena = placa + "-" + halfPass;
                    
                    AgenteDAO agenteDAO = new AgenteDAO();
                    
                    try{
                        ciudadano = ciudadanoDAO.select(dni);
                        AgenteDTO nuevoAgente = new AgenteDTO(placa, ciudadano, contrasena, imagen);
                        agenteDAO.insert(nuevoAgente);
                        
                    }catch(SQLException e){
                        e.getStackTrace();
                    }
                    
                    request.setAttribute("dni", dni);
                    request.setAttribute("dniInvalid", false);
                    request.setAttribute("dni", dni);
                    rd = request.getRequestDispatcher("/view/administracion/agenteSubido.jsp");
                    rd.forward(request, response);
                } else {
                    response.sendRedirect("login");
                } 
                
    }
}