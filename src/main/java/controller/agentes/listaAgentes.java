package controller.agentes;

import DAO.AgenteDAO;
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

@WebServlet(name = "agentes", urlPatterns = {"/agentes"})
public class listaAgentes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession(false);
        request.setAttribute("title", "BlueShield - Agentes");

        if (session != null && (session.getAttribute("username") != null || session.getAttribute("admin") != null)) {
            request.setAttribute("username", session.getAttribute("username"));
            response.setContentType("text/html;charset=UTF-8");
            List<AgenteDTO> listaAgentes = new AgenteDAO().selectAll();
            request.setAttribute("listaAgentes", listaAgentes);
            RequestDispatcher rd = request.getRequestDispatcher("./view/agentes/listaAgentes.jsp");
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
            Logger.getLogger(listaAgentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String placa = request.getParameter("placa");
        response.sendRedirect("agente?placa=" + placa);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
