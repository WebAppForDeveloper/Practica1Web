/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.Profesor;
import modelo.UsuarioAdminDAO;
import modelo.UsuarioAlumnoDAO;
import modelo.UsuarioProfesorDAO;

/**
 *
 * @author javs
 */
public class VerProfesorS extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
//      UsuarioAdminDAO u = new UsuarioAdminDAO();
        UsuarioProfesorDAO c = new UsuarioProfesorDAO();
        List lista;   
        
         long matriculaProfesor;
         String nombre;
         String paterno;
         String materno;
         String fechaNacimineto;
         String calle;
         String colonia;
         String sexo;
         String email;
        
        String enlaceG;
        int id;
        String pagina;
        List ls;
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            pagina="<!DOCTYPE html>";
            pagina +="<html>";
            pagina +="<head>";
            pagina +="<title>userlist</title>";            
            pagina +="</head>";
            pagina +="<body>";
            pagina +="<h1>Lista de Profesores </h1>";
            pagina +="<table>";
            ls = c.loadAll();
            for(int i = 0; i<ls.size();i++){
                Profesor lu= (Profesor)(ls.get(i));
                
                matriculaProfesor = lu.getMatriculaProfesor();
                //System.out.println(id+" "+ls.size());
                nombre = lu.getNombre();
                paterno =lu.getPaterno();
                materno = lu.getMaterno();
                fechaNacimineto = lu.getFechaNacimineto();
                calle = lu.getCalle();
                colonia = lu.getColonia();
                sexo = lu.getSexo();
                email = lu.getEmail();
                
                
                pagina += "<tr>";
                pagina += "<td>" +matriculaProfesor+"</td>";
                pagina += "<td>" +nombre+"</td>";
                pagina += "<td>" +paterno+"</td>";
                pagina += "<td>" +materno+"</td>";
                pagina += "<td>" +fechaNacimineto+"</td>";
                pagina += "<td>" +calle+"</td>";
                pagina += "<td>" +colonia+"</td>";
                pagina += "<td>" +sexo+"</td>";
                pagina += "<td>" +email+"</td>";
                pagina += "</tr>";
                
            }
            enlaceG = "<a href='/Practica1/vistas/ReProfesor.html'>"+"<input type='button' value ='Regresar'"+"</a>";
            pagina +="<table>";
            pagina += enlaceG;
            pagina +="</body>";
            pagina +="</html>";
            
            out.println(pagina);
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
            Logger.getLogger(VerProfesorS.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(VerProfesorS.class.getName()).log(Level.SEVERE, null, ex);
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
