/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.UsuarioAdminDAO;
import modelo.UsuarioAlumnoDAO;
import modelo.UsuarioDAO;
import modelo.UsuarioProfesorDAO;

/**
 *
 * @author javs
 */
public class CloginS extends HttpServlet {

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
            throws ServletException, IOException {
        
        int  tipo;
        String master;
        tipo = Integer.parseInt(request.getParameter("Tipo"));
       
        
        response.setContentType("text/plain");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write("si me enlace");
       
        tipo = Integer.parseInt(request.getParameter("Tipo"));
        
        if( tipo == 1){
            master = "admin";
            UsuarioAdminDAO a = new UsuarioAdminDAO();
        }
        if( tipo == 2){
            master = "tech";
            UsuarioProfesorDAO p = new UsuarioProfesorDAO();
        }
        
        if( tipo == 3){
            master = "stud";
            UsuarioAlumnoDAO al = new UsuarioAlumnoDAO();
            
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
        processRequest(request, response);
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
        processRequest(request, response);
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
