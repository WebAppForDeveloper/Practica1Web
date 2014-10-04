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
import modelo.UsuarioAdminDAO;
import modelo.UsuarioAlumnoDAO;

/**
 *
 * @author javs
 */
public class VerAlumnosS extends HttpServlet {

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
       UsuarioAdminDAO u = new UsuarioAdminDAO();
        UsuarioAlumnoDAO c = new UsuarioAlumnoDAO();
        List lista;
        
         long matricula;
         String nombre;
         String paternoAlumno;
         String maternoAlumno;
         String fechaNacimiento;
         String calle;
         String colonia;
         int numero;
         String codigoPostal;
         String sexo;
         String email;
         String enlace;
         
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
            
            pagina +=" <link href=\"CSS/bootstrap/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\">";   
            pagina +=" <script src=\"js/jquery/jquery-2.1.1.js\"></script>"; 
            pagina +=" <script src=\"CSS/bootstrap/bootstrap.js\"></script>"; 
            
            pagina +="<title>userlist</title>";  
            pagina +="</head>";
            pagina +="<body>";
            
            pagina +=" <div class=\"navbar navbar-inverse \" role=\"navigation\">\n" +
"      \n" +
"          \n" +
"        <div class=\"navbar-header \">\n" +
"            <a class=\"navbar-brand  \" href=\"vistas/ReAdmin.html\">Administrador</a>\n" +
"        </div>\n" +
"        <div class=\"collapse navbar-collapse\">\n" +
"            <ul class=\"nav navbar-nav\">\n" +
"              \n" +
"              <li><a href=\"vistas/ReAdmin.html\">Perfil</a></li>\n" +
"              \n" +
"             <li class=\"dropdown active\">\n" +
"			<a class=\"dropdown-toggle\"data-toggle=\"dropdown\"href=\"#\">\n" +
"			Alumnos\n" +
"			<b class=\"caret\"></b>\n" +
"			</a>\n" +
"			<ul class=\"dropdown-menu\">\n" +
"				<li><a href=\"vistas/registroAlumno.html\">Registrar Alumno</a></li>\n" +
"				<li><a href=\"VerAlumnosS\">Ver Alumnos</a></li>\n" +
"				\n" +
"			</ul>\n" +
"		</li>\n" +
"                \n" +
"                <li class=\"dropdown\">\n" +
"			<a class=\"dropdown-toggle\"data-toggle=\"dropdown\"href=\"#\">\n" +
"			Profesores\n" +
"			<b class=\"caret\"></b>\n" +
"			</a>\n" +
"			<ul class=\"dropdown-menu\">\n" +
"				<li><a href=\"vistas/registroProfesor.html\">Registrar Profesor</a></li>\n" +
"				<li><a href=\"VerProfesorS\">Ver Profesores</a></li>\n" +
"				\n" +
"			</ul>\n" +
"		</li>\n" +
"                \n" +
"                 <li class=\"dropdown\">\n" +
"			<a class=\"dropdown-toggle\" data-toggle=\"dropdown\"href=\"#\">\n" +
"			Carreras\n" +
"			<b class=\"caret\"></b>\n" +
"			</a>\n" +
"			<ul class=\"dropdown-menu\">\n" +
"				<li><a href=\"vistas/Crearcarrera.html\">Crear Carrera</a></li>\n" +
"				\n" +
"				\n" +
"			</ul>\n" +
"		</li>\n" +
"                         \n" +
"       </ul>\n" +
"            <form class=\"navbar-form navbar-right\" role=\"form\" id=\"formulario\" action=\"\" method=\"post\">\n" +
"            <input type=\"submit\" class=\"btn btn-info btn-primary\" id=\"nombre\">\n" +
"          </form>\n" +
"        </div>\n" +
"        </div>\n" +
"        ";
//          Tablas            
            
            pagina +="<h1>Lista de Alumnos </h1>";
            pagina += "<div class='table-responsive'>";
            pagina +="<table class ='table table-striped'>";
            pagina +="<thead> <tr> <th>Matricula</th> <th>Nombre</th> <th>Apellido Paterno</th> <th>Apellido Materno</th> <th>Fecha de nacimiento</th> <th>Calle</th> <th>Colonia</th> <th>Numero</th> <th>Codigo Postal</th> <th>Sexo</th> <th>E-mail</th>  </tr> </thead>";
            pagina += "<tbody>";
            ls = c.loadAll();
            for(int i = 0; i<ls.size();i++){
                Alumno lu= (Alumno)(ls.get(i));
                
                matricula = lu.getMatricula();
                //System.out.println(id+" "+ls.size());
                nombre = lu.getNombre();
                paternoAlumno =lu.getPaternoAlumno();
                maternoAlumno = lu.getMaternoAlumno();
                fechaNacimiento = lu.getFechaNacimiento();
                calle = lu.getCalle();
                colonia = lu.getColonia();
                numero = lu.getNumero();
                codigoPostal = lu.getCodigoPostal();
                sexo = lu.getSexo();
                email = lu.getEmail();
                
                pagina += "<tr>";
                pagina += "<td>" +matricula+"</td>";
                pagina += "<td>" +nombre+"</td>";
                pagina += "<td>" +paternoAlumno+"</td>";
                pagina += "<td>" +maternoAlumno+"</td>";
                pagina += "<td>" +fechaNacimiento+"</td>";
                pagina += "<td>" +calle+"</td>";
                pagina += "<td>" +colonia+"</td>";
                pagina += "<td>" +numero+"</td>";
                pagina += "<td>" +codigoPostal+"</td>";
                pagina += "<td>" +sexo+"</td>";
                pagina += "<td>" +email+"</td>";
                enlace = "<td><a href='servletActualizarAlumno?id="+matricula+"'>"+"Actualizar"+"</a></td>";
                pagina += enlace;
                pagina += "</tr>";
                
            }
            pagina += "</tbody>";
            pagina +="</div>";
            //enlaceG = "<a href='/Practica1/vistas/ReAlumno.html'>"+"<input type ='button' value='Regresar'"+"</a>";
            pagina +="<table>";
            //pagina += enlaceG;
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
            Logger.getLogger(VerAlumnosS.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(VerAlumnosS.class.getName()).log(Level.SEVERE, null, ex);
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
