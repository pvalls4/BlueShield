package controller.administracion;

import DAO.AdminDAO;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DTO.AdminDTO;
import model.DTO.AgenteDTO;
import utilidad.PasswordManager;
import static utilidad.PasswordManager.hashPassword;
import static utilidad.PasswordManager.verifyPassword;

/**
 *
 * @author Mati
 */
@WebServlet(name = "loginAdmin", urlPatterns = {"/loginAdmin"})
public class loginAdmin extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/administracion/loginAdmin.jsp");
            dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String pwd = request.getParameter("pwd");

        // Perform authentication (e.g., check against a database)
        AdminDTO admin = authenticate(correo, pwd);
        if (admin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
            session.setAttribute("isAdmin", true);
            request.setAttribute("admin", admin);
            request.setAttribute("isAdmin", true);
            //request.getRequestDispatcher("/view/dashboard.jsp").forward(request, response);
            System.out.println(hashPassword("admin"));
            response.sendRedirect("dashboard");
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.setAttribute("invalidUser", true);
            request.getRequestDispatcher("/view/administracion/loginAdmin.jsp").forward(request, response);
                }
            
    }
    private AdminDTO authenticate(String correo, String pwd) 
        throws ServletException, IOException {
            AdminDAO adminDao = new AdminDAO();
            try {
                AdminDTO admin = adminDao.select(correo);
                if(admin == null){
                    return null;
                } else if (admin.getEmail().equals(correo) && verifyPassword(pwd,admin.getPassword())) {
                    return admin;
                }
            } catch (SQLException ex) {
                Logger.getLogger(loginAdmin.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
            return null;    
        }
 
}
    
