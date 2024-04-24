package controller.multas;

import DAO.MultaDAO;
import DAO.MultaInfraccionDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DTO.MultaDTO;
import model.DTO.MultaInfraccionDTO;

@WebServlet(name = "multaInfo", urlPatterns = {"/multaInfo"})
public class multaInfo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
                HttpSession session = request.getSession(false); // No crea una nueva sesión si no hay una existente


                if (session != null && session.getAttribute("username") != null) {
                    request.setAttribute("username", session.getAttribute("username"));
                    String identifier = request.getParameter("id");
                    int id = Integer.parseInt(identifier);

                    MultaDAO multaDao = new MultaDAO();
                    MultaDTO multaInfo = multaDao.select(id);

                    MultaInfraccionDAO multaInfraccionDao = new MultaInfraccionDAO();
                    List<MultaInfraccionDTO> infraccionesInfo =  multaInfraccionDao.selectIdMulta(id);

                    request.setAttribute("infraccionesInfo", infraccionesInfo);
                    request.setAttribute("multaInfo", multaInfo);
                    RequestDispatcher rd = request.getRequestDispatcher("./view/multas/multaInfo.jsp");

                    rd.forward(request, response);
                } else {
                    // No hay una sesión activa o el usuario no está autenticado
                    // Realiza la lógica correspondiente, como mostrar un formulario de inicio de sesión
                    response.sendRedirect("view/login.jsp");
                }
            }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(multaInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*String id = request.getParameter("id");
        response.sendRedirect("multaInfo?id=" + id);*/
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
