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
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DTO.MultaDTO;

@WebServlet(name = "ultimasMultas", urlPatterns = {"/ultimasMultas"})
public class ultimasMultas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
  
        HttpSession session = request.getSession(false); // No crea una nueva sesión si no hay una existente

        
        if (session != null && session.getAttribute("username") != null) {
            // Hay una sesión activa y el usuario está autenticado
            // Realiza la lógica correspondiente, como mostrar una página de inicio o redirigir a otra URL
            request.setAttribute("username", session.getAttribute("username"));
            System.out.println("####1" + session.getAttribute("username"));
            System.out.println("####2" + request.getAttribute("username"));
            int idPlaca = (Integer) request.getAttribute("username");
            MultaDAO dao = new MultaDAO();
            List<MultaDTO> ultimasMultas = dao.selectPlaca(idPlaca);
            request.setAttribute("ultimasMultas", ultimasMultas);
            RequestDispatcher rd = request.getRequestDispatcher("./view/multas/ultimasMultas.jsp");
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
