package controller.multas;

import DAO.MultaDAO;
import jakarta.servlet.RequestDispatcher;
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
import model.DTO.MultaDTO;

@WebServlet(name = "listaMultas", urlPatterns = {"/listaMultas"})
public class listaMultas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        MultaDAO dao = new MultaDAO();
        List<MultaDTO> listaMultas = dao.selectAll();
        request.setAttribute("listaMultas", listaMultas);
        RequestDispatcher rd = request.getRequestDispatcher("./view/multas/listaMultas.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(listaMultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String identifier = request.getParameter("id");
        int id = Integer.parseInt(identifier);
        response.sendRedirect("multaInfo?id=" + id);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
