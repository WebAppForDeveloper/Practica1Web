/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.Mail;
import modelo.UsuarioAlumnoDAO;

/**
 *
 * @author Jorge
 */
@WebServlet(name = "servletAlumno", urlPatterns = {"/servletAlumno"})
public class servletAlumno extends HttpServlet {

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
            
          
          
            Alumno alumno =new Alumno();
            alumno.setMatricula(Long.valueOf(request.getParameter("matricula")));
            alumno.setNombre(request.getParameter("nombre"));
            alumno.setPaternoAlumno(request.getParameter("paternoAlumno"));
            alumno.setMaternoAlumno(request.getParameter("maternoAlumno"));
            
            alumno.setFechaNacimiento(request.getParameter("fechaNacimiento"));
            //System.out.println(request.getParameter("fechaNacimiento"));
            alumno.setCalle(request.getParameter("calle"));
            alumno.setColonia(request.getParameter("colonia"));
            alumno.setNumero(Integer.parseInt(request.getParameter("numero")));
            alumno.setSexo(request.getParameter("tipo"));
            alumno.setCodigoPostal(request.getParameter("cp"));
            alumno.setEmail(request.getParameter("email"));
            alumno.setCarrera(Integer.parseInt(request.getParameter("carrera")));
            //alumno.setEmail(request.getParameter("email"));
            
            
            UsuarioAlumnoDAO udao= new UsuarioAlumnoDAO();
            udao.create(alumno);
            
            Mail mail = new Mail();
            String asunto="Bienvenido al sistema\n";
                String texto="Hola \n";
                texto+=alumno.getNombre();
                texto+=alumno.getPaternoAlumno();
                texto+="tu contraseña es:  \n";
                texto+=alumno.getNombre();
                mail.enviarMail(alumno.getEmail(),asunto, texto);
            //metodo ajax
                
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
            Logger.getLogger(servletAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(servletAlumno.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servletAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(servletAlumno.class.getName()).log(Level.SEVERE, null, ex);
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
