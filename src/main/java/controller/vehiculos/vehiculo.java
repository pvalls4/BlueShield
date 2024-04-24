package controller.vehiculos;

import DAO.VehiculoDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import model.DTO.VehiculoDTO;

@WebServlet(name = "vehiculo", urlPatterns = {"/vehiculo"})
public class vehiculo extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("./view/vehiculos/vehiculo.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession(false);

            if (session != null && session.getAttribute("username") != null) {
                request.setAttribute("username", session.getAttribute("username"));
                String bastidor = request.getParameter("id");

                VehiculoDAO dao = new VehiculoDAO();
                VehiculoDTO vehiculo = dao.select(bastidor);

                request.setAttribute("vehiculo", vehiculo);
                request.getRequestDispatcher("/view/vehiculos/vehiculo.jsp").forward(request, response);
            } else {
                response.sendRedirect("login");
            } 
        } catch (SQLException ex) {
            ex.printStackTrace(); 
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
