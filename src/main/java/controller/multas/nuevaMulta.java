package controller.multas;

import DAO.CiudadanoDAO;
import DAO.InfraccionDAO;
import DAO.MultaDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DTO.AgenteDTO;
import model.DTO.CiudadanoDTO;
import model.DTO.InfraccionDTO;
import model.DTO.MultaDTO;

@WebServlet(name = "nuevaMulta", urlPatterns = {"/nuevaMulta"})
public class nuevaMulta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            request.setAttribute("username", session.getAttribute("username"));
            AgenteDTO agente = (AgenteDTO) session.getAttribute("username");
            CiudadanoDAO daoc = new CiudadanoDAO();
            InfraccionDAO daoi = new InfraccionDAO();
            List<CiudadanoDTO> listaCiudadanos = daoc.selectAll();
            request.setAttribute("listaCiudadanos", listaCiudadanos);
            List<InfraccionDTO> listaInfracciones = daoi.selectAll();
            request.setAttribute("listaInfracciones", listaInfracciones);
            RequestDispatcher rd = request.getRequestDispatcher("/view/multas/nuevaMulta.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("login");
        }
    }

    private double importeTotal(List<InfraccionDTO> listaInfracciones) {
        double result = 0;
        for (InfraccionDTO infraccion : listaInfracciones) {
            result += infraccion.getImporte();
        }
        return result;
    }

    private Date fechaLimite(Date fechaEmision) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaEmision);
        calendar.add(Calendar.MONTH, 1);
        return new Date(calendar.getTime().getTime());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(nuevaMulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] articulosSeleccionadosStr = request.getParameterValues("articuloSeleccionado");

        if (articulosSeleccionadosStr != null) {
            // Convertir los valores de cadena a enteros
            List<Integer> articulosSeleccionados = new ArrayList<>();
            for (String str : articulosSeleccionadosStr) {
                try {
                    int articuloId = Integer.parseInt(str);
                    articulosSeleccionados.add(articuloId);
                } catch (NumberFormatException e) {
                    // Manejar cualquier error de conversión aquí
                    e.printStackTrace();
                }
            }

            List<InfraccionDTO> infracciones = null;

//        for(0 -> idsArticulosSeleccionado.size){
//            infracciones.i=new InfraccionDAO().select(idsArticulosSeleccionados.i)
//        }
//        double importeTotal=importeTotal(infracciones);
//        Date fecha_final=fechaLimite(request.getParameter(fecha_emision));
        }

        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
