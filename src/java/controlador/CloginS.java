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
import javax.servlet.http.HttpSession;
import modelo.UsuarioAdminDAO;
import modelo.UsuarioAlumnoDAO;
import modelo.UsuarioDAO;
import modelo.UsuarioProfesorDAO ;

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
        String matricula;
        String contraseña;
        tipo = Integer.parseInt(request.getParameter("Tipo"));
        matricula = request.getParameter("txtUser");
        contraseña = request.getParameter("txtPass");
//      Abrimos session        
        HttpSession session;
        session = request.getSession(true);
       
        
        if( tipo == 1){
            
            master = "1";
            UsuarioAdminDAO a = new UsuarioAdminDAO();
            
            
            if(a.verificarUsuario(matricula, contraseña)){
                
                session.setAttribute("usuario", matricula);
                session.setAttribute("nombre", contraseña);
                
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(master);
            }
            
            else{
                
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("Error");
            }
        }
        
        
        if( tipo == 2){
            
            master = "2";
            UsuarioProfesorDAO p = new UsuarioProfesorDAO();
            
            if(p.verificarUsuario(matricula, contraseña)){
                    
                    session.setAttribute("usuario", matricula);
                    session.setAttribute("nombre", contraseña);
                    
                    response.setContentType("text/plain");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(master);
            }   
            
            else{
                
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("Error");
            }
        }
        
        
        if( tipo == 3){
            
            master = "3";
            UsuarioAlumnoDAO al = new UsuarioAlumnoDAO();
            
            if(al.verificarUsuario(matricula, contraseña)){
//                  System.out.println(al.verificarUsuario(matricula, contraseña )+"VVVVVVVVVVVV");
//                    
                    session.setAttribute("usuario", matricula);
                    session.setAttribute("nombre", contraseña);
                    
                    response.setContentType("text/plain");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(master);
            }
            
            else{
                
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("Error");
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
