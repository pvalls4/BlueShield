package controller.multas;

import DAO.MultaDAO;
import controller.ciudadanos;
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
        MultaDAO dataObject = new MultaDAO();
        List<MultaDTO> listaMultas = dataObject.selectAll();
        request.setAttribute("listaMultas", listaMultas);
        System.out.println(listaMultas);
        RequestDispatcher rd = request.getRequestDispatcher("./view/multas/listaMultas.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ciudadanos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String identifier= request.getParameter("id");
            int id = Integer.parseInt(identifier);
            
            MultaDAO multaDAO = new MultaDAO(); 
            MultaDTO multa = multaDAO.select(id);
            
            if (multa == null) {
               
                response.sendRedirect("BlueShield/multaInfo.jsp?notFound=true");
            } else {
                
                request.setAttribute("multa", multa);
                request.getRequestDispatcher("/view/multas/multaInfo.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ciudadanos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
