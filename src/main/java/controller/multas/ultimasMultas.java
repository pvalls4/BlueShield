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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DTO.AgenteDTO;
import model.DTO.MultaDTO;

@WebServlet(name = "ultimasMultas", urlPatterns = {"/ultimasMultas"})
public class ultimasMultas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
            HttpSession session = request.getSession(false);
            if (session != null && session.getAttribute("username") != null) {
                AgenteDTO agente = (AgenteDTO) session.getAttribute("username");
                int idPlaca = agente.getPlaca();
                MultaDAO dao = new MultaDAO();
                List<MultaDTO> ultimasMultas = dao.selectPlaca(idPlaca);
                request.setAttribute("ultimasMultas", ultimasMultas);
                RequestDispatcher rd = request.getRequestDispatcher("./view/multas/ultimasMultas.jsp");
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
            Logger.getLogger(ultimasMultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        response.sendRedirect("multaInfo?id=" + id);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
