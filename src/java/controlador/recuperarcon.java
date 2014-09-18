package controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import modelo.Alumno;
import modelo.Mail;
import modelo.UsuarioDAO;

/**
 *
 * @author Mariana
 */
@WebServlet(urlPatterns = {"/recuperarcon"})
public class recuperarcon extends HttpServlet {

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
            
            String email;
            Alumno a =new Alumno();
            UsuarioDAO udao=new UsuarioDAO();
            //udao.recuperar(12);
            a=udao.recuperar(Long.valueOf(request.getParameter("boleta")));
            if(a!=null){
            System.out.println(a);
                Mail enviarmail =new Mail();
                String asunto="Recuperación de Contraseña";
                String texto="Hola";
                texto+=a.getNombre();
                texto+=a.getPaternoAlumno();
                texto+=a.getPaternoAlumno();
                texto+="tu contraseña es:";
                texto+=a.getNombre();
                enviarmail.enviarMail(a.getEmail(),asunto, texto);
            }
            else{
            System.out.println("null");
            
            Mail enviarmail =new Mail();
                String asunto="Recuperación de Contraseña";
                String texto="Hola";
                texto+=a.getNombre();
                texto+=a.getPaternoAlumno();
                texto+=a.getPaternoAlumno();
                texto+="tu contraseña es:";
                texto+=a.getNombre();
                enviarmail.enviarMail(a.getEmail(),asunto, texto);
            }
            
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
            Logger.getLogger(recuperarcon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(recuperarcon.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(recuperarcon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(recuperarcon.class.getName()).log(Level.SEVERE, null, ex);
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
