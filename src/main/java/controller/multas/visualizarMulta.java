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

@WebServlet(name = "visualizarMulta", urlPatterns = {"/visualizarMulta"})
public class visualizarMulta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
                HttpSession session = request.getSession(false); // No crea una nueva sesión si no hay una existente


                if (session != null && (session.getAttribute("username") != null || session.getAttribute("admin") != null)) {
                    request.setAttribute("username", session.getAttribute("username"));
                    String identifier = request.getParameter("id");
                    request.setAttribute("title", "BlueShield - Multa REF. " + identifier);
                    int id = Integer.parseInt(identifier);

                    MultaDAO multaDao = new MultaDAO();
                    MultaDTO visualizarMulta = multaDao.select(id);

                    MultaInfraccionDAO multaInfraccionDao = new MultaInfraccionDAO();
                    List<MultaInfraccionDTO> infraccionesInfo =  multaInfraccionDao.selectIdMulta(id);

                    request.setAttribute("infraccionesInfo", infraccionesInfo);
                    request.setAttribute("visualizarMulta", visualizarMulta);
                    RequestDispatcher rd = request.getRequestDispatcher("./view/multas/visualizarMulta.jsp");

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
            Logger.getLogger(visualizarMulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*String id = request.getParameter("id");
        response.sendRedirect("visualizarMulta?id=" + id);*/
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
