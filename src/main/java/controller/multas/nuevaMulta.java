package controller.multas;

import DAO.CiudadanoDAO;
import DAO.InfraccionDAO;
import DAO.MultaDAO;
import DAO.VehiculoDAO;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DTO.AgenteDTO;
import model.DTO.CiudadanoDTO;
import model.DTO.InfraccionDTO;
import model.DTO.MultaDTO;
import model.DTO.VehiculoDTO;

@WebServlet(name = "nuevaMulta", urlPatterns = {"/nuevaMulta"})
public class nuevaMulta extends HttpServlet {

    private AgenteDTO agente;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);

        if (session != null && (session.getAttribute("username") != null || session.getAttribute("admin") != null)) {
            agente = (AgenteDTO) session.getAttribute("username");
            request.setAttribute("username", session.getAttribute("username"));
            request.setAttribute("title", "BlueShield - Emisión de Denuncia");
            CiudadanoDAO daoc = new CiudadanoDAO();
            VehiculoDAO daov = new VehiculoDAO();
            InfraccionDAO daoi = new InfraccionDAO();
            List<CiudadanoDTO> listaCiudadanos = daoc.selectAll();
            List<VehiculoDTO> listaVehiculos = daov.selectAll();
            request.setAttribute("listaCiudadanos", listaCiudadanos);
            request.setAttribute("listaVehiculos", listaVehiculos);
            List<InfraccionDTO> listaInfracciones = daoi.selectAll();
            Collections.sort(listaInfracciones, Comparator.comparing(InfraccionDTO::getId));
            request.setAttribute("listaInfracciones", listaInfracciones);
            RequestDispatcher rd = request.getRequestDispatcher("/view/multas/nuevaMulta.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("login");
        }
    }

    private float importeTotal(List<InfraccionDTO> listaInfracciones) {
        float result = 0;
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
        request.setCharacterEncoding("UTF-8");
        
        String dni = request.getParameter("dni");
        CiudadanoDTO ciudadano = null;
        CiudadanoDAO daoc = new CiudadanoDAO();

        try {
            if (daoc.select(dni) == null) {
                RequestDispatcher rd = request.getRequestDispatcher("/view/errores/errorCiudadano.jsp");
                rd.forward(request, response);
            } else {
                ciudadano = daoc.select(dni);
            }
        } catch (SQLException ex) {
            Logger.getLogger(nuevaMulta.class.getName()).log(Level.SEVERE, null, ex);
        }

        String matricula = request.getParameter("matricula");
        VehiculoDTO vehiculo = null;
        if (matricula != null && !matricula.isEmpty()) {
            VehiculoDAO daov = new VehiculoDAO();
            try {
                if (daov.selectMATRICULA(matricula) == null) {
                    RequestDispatcher rd = request.getRequestDispatcher("/view/errores/errorVehiculo.jsp");
                    rd.forward(request, response);
                } else {
                    vehiculo = daov.selectMATRICULA(matricula);
                }
            } catch (SQLException ex) {
                Logger.getLogger(nuevaMulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String ubicacion = request.getParameter("ubicacion");
        String observaciones = request.getParameter("observaciones");

        float importeTotal = 0.0f;
        String[] articulosSeleccionadosStr = request.getParameterValues("articuloSeleccionado");
        System.out.println(articulosSeleccionadosStr);

        List<Integer> articulosIds = new ArrayList<>();

        for (String str : articulosSeleccionadosStr) {
            // Buscamos la posición del valor "id"
            int idStartIndex = str.indexOf("\"id\":") + 5; // Sumamos 5 para saltar el texto "\"id\":"
            int idEndIndex = str.indexOf(",", idStartIndex); // La coma indica el final del valor
            if (idEndIndex == -1) { // Si no hay una coma, es el último elemento
                idEndIndex = str.indexOf("}", idStartIndex);
            }
            String idStr = str.substring(idStartIndex, idEndIndex).trim(); // Extraemos la cadena del valor "id"
            int id = Integer.parseInt(idStr); // Convertimos la cadena a entero
            articulosIds.add(id); // Agregamos el valor a la lista
        }

        List<InfraccionDTO> infracciones = new ArrayList<>();
        for (int articulo : articulosIds) {
            try {
                infracciones.add(new InfraccionDAO().select(articulo));
            } catch (SQLException ex) {
                Logger.getLogger(nuevaMulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        importeTotal = importeTotal(infracciones);

        String fechaEmisionStr = request.getParameter("fechaEmision");
        Date fechaEmision = null;
        try {
            fechaEmision = Date.valueOf(fechaEmisionStr);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        Date fecha_final = fechaLimite(fechaEmision);
        boolean isPagado = false;
        MultaDAO nuevaMultaDAO = new MultaDAO();

        MultaDTO nuevaMulta;
        if (vehiculo == null) {
            nuevaMulta = new MultaDTO(fechaEmision, fecha_final, importeTotal, observaciones, ubicacion, isPagado, agente, ciudadano, null);
        } else {
            nuevaMulta = new MultaDTO(fechaEmision, fecha_final, importeTotal, observaciones, ubicacion, isPagado, agente, ciudadano, vehiculo);
        }

        try {
            nuevaMultaDAO.insert(nuevaMulta, infracciones);
        } catch (SQLException ex) {
            Logger.getLogger(nuevaMulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("multas");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
