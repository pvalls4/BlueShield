package controller.multas;

import DAO.MultaDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DTO.MultaDTO;

@WebServlet(name = "multaInfo", urlPatterns = {"/multaInfo"})
public class multaInfo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
                HttpSession session = request.getSession(false);

                if (session != null && session.getAttribute("username") != null) {
                    request.setAttribute("username", session.getAttribute("username"));
                    String identifier = request.getParameter("id");
                    int id = Integer.parseInt(identifier);

                    MultaDAO dao = new MultaDAO();
                    MultaDTO multaInfo = dao.select(id);

                    request.setAttribute("multaInfo", multaInfo);
                    RequestDispatcher rd = request.getRequestDispatcher("./view/multas/multaInfo.jsp");

                    rd.forward(request, response);
                } else {
                    response.sendRedirect("login");
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
