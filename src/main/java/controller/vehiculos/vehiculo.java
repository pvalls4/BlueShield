package controller.vehiculos;

import DAO.VehiculoDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

            String bastidor = request.getParameter("id");

            VehiculoDAO dao = new VehiculoDAO();
            VehiculoDTO vehiculo = dao.select(bastidor);

            request.setAttribute("vehiculo", vehiculo);
            request.getRequestDispatcher("/view/vehiculos/vehiculo.jsp").forward(request, response);

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
