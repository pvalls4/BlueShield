package controller.administracion;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@WebServlet(name = "admin", urlPatterns = {"/admin"})
public class admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null && (Boolean) session.getAttribute("isAdmin") == true) {
            request.setAttribute("username", session.getAttribute("username"));
            request.setAttribute("isAdmin", session.getAttribute("isAdmin"));
            request.getRequestDispatcher("./view/administracion/admin.jsp").forward(request, response);
        } else {
            throw new WebApplicationException("Access is forbidden to this resource", Response.Status.FORBIDDEN);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
