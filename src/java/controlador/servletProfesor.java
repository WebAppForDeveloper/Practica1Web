/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Mail;
import modelo.Profesor;
import modelo.UsuarioProfesorDAO;

/**
 *
 * @author Jorge
 */
@WebServlet(name = "regProfesor", urlPatterns = {"/regProfesor"})
public class servletProfesor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, MessagingException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            Profesor u =new Profesor();
            u.setMatriculaProfesor(Long.valueOf(request.getParameter("matriculaProfesor")));
            u.setNombre(request.getParameter("nombre"));
            u.setPaterno(request.getParameter("paterno"));
            u.setMaterno(request.getParameter("materno"));
            u.setEmail(request.getParameter("correro"));
            u.setFechaNacimineto(request.getParameter("fechaNacimiento"));
            u.setCalle(request.getParameter("calle"));
            u.setColonia(request.getParameter("colonia"));
            u.setSexo(request.getParameter("tipo"));
            
            
            UsuarioProfesorDAO udao= new UsuarioProfesorDAO();
            udao.create(u);
             Mail mail = new Mail();
            String asunto="Bienvenido al sistema";
                String texto="Hola";
                texto+=u.getNombre();
                texto+=u.getPaterno();
                texto+="tu contraseña es:";
                texto+=u.getNombre();
                mail.enviarMail(u.getEmail(),asunto, texto);
            
                
                 response.setContentType("text/plain");
       response.setCharacterEncoding("UTF-8");
       response.getWriter().write("echo");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(servletProfesor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(servletProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(servletProfesor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(servletProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
