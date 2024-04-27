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
import static utilidad.PasswordManager.hashPassword;

@WebServlet(name = "crearModelo", urlPatterns = {"/crearModelo"})
public class crearModelo extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
                response.setContentType("text/html;charset=UTF-8");
                HttpSession session = request.getSession(false);

                if (session != null && session.getAttribute("username") != null) {
                        request.setAttribute("username", session.getAttribute("username"));
                        response.setContentType("text/html;charset=UTF-8");
                        RequestDispatcher rd = request.getRequestDispatcher("/view/administracion/crearModelo.jsp");
                        rd.forward(request, response);
                } else {
                    response.sendRedirect("login");
                } 
            }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException{
//                response.setContentType("text/html;charset=UTF-8");
//                HttpSession session = request.getSession(false);
//                if (session != null && session.getAttribute("username") != null) {
//                    request.setAttribute("username", session.getAttribute("username"));
//                    response.setContentType("text/html;charset=UTF-8");
//                    RequestDispatcher rd;                 
//                    String marca = request.getParameter("marca");
//                    String modelo = request.getParameter("modelo");
//                    String imagen = request.getParameter("imagen");
//                                        
//                    try{
//                        ciudadano = ciudadanoDAO.select(dni);
//                        AgenteDTO nuevoAgente = new AgenteDTO(ciudadano, hashPassword(contrasena), imagen, rango);
//                        agenteDAO.insert(nuevoAgente);
//                        
//                    }catch(SQLException e){
//                        e.getStackTrace();
//                    }
//                    rd = request.getRequestDispatcher("/view/administracion/agenteSubido.jsp");
//                    rd.forward(request, response);
//                } else {
//                    response.sendRedirect("login");
//                } 
//                
//    }
}