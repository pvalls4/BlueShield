package controller.vehiculos;

import DAO.CiudadanoDAO;
import DAO.VehiculoDAO;
import DAO.ModeloDAO;
import controller.ciudadanos.editarCiudadano;
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
import model.DTO.CiudadanoDTO;
import model.DTO.ModeloDTO;
import model.DTO.VehiculoDTO;

@WebServlet(name = "editarVehiculo", urlPatterns = {"/editarVehiculo"})
public class editarVehiculo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("./view/vehiculos/editarVehiculo.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession(false);

            if (session != null && (session.getAttribute("username") != null || session.getAttribute("admin") != null)) {
                request.setAttribute("username", session.getAttribute("username"));
                String bastidor = request.getParameter("id");
                request.setAttribute("title", "BlueShield - Editar vehículo " + bastidor);

                VehiculoDAO dao = new VehiculoDAO();
                VehiculoDTO vehiculo = dao.select(bastidor);

                List<ModeloDTO> listaModelos = new ModeloDAO().selectAll();
                List<CiudadanoDTO> listaCiudadanos = new CiudadanoDAO().selectAll();

                request.setAttribute("listaModelos", listaModelos);
                request.setAttribute("listaCiudadanos", listaCiudadanos);
                request.setAttribute("vehiculo", vehiculo);
                request.getRequestDispatcher("/view/vehiculos/editarVehiculo.jsp").forward(request, response);
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
        try {
            String bastidor = request.getParameter("bastidor");
            VehiculoDTO vehiculo = new VehiculoDAO().select(bastidor);

            int idModelo = Integer.parseInt(request.getParameter("idModelo"));
            ModeloDTO modeloDTO = new ModeloDAO().select(idModelo);
            vehiculo.setModelo(modeloDTO);
            int rows = new VehiculoDAO().update(vehiculo);
            if (rows > 0) {
                response.sendRedirect("vehiculo?id=" + vehiculo.getMatricula());
            } else {
                response.sendRedirect("vehiculo?id=-1");
            }

        } catch (SQLException ex) {
            Logger.getLogger(editarCiudadano.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
