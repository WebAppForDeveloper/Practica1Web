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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.UsuarioAdminDAO;
import modelo.UsuarioAlumnoDAO;

/**
 *
 * @author Mariana
 */
@WebServlet(name = "servletActualizarAlumno", urlPatterns = {"/servletActualizarAlumno"})
public class servletActualizarAlumno extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Alumno a=new Alumno();
            a.setMatricula(Long.valueOf(request.getParameter("matricula")));
            UsuarioAlumnoDAO adao=new UsuarioAlumnoDAO();
            a=adao.load(a);
            System.out.println(a);
            String pagina = null;
            pagina +="<html>";
            pagina +="<head>";
            pagina +="<title>actualizar</title>";            
            pagina +="</head>";
            pagina +="<body>";
            pagina+="<form action=\"serhaceupdateusuario\" method=\"get\" >" + " <fieldset>"; 
            pagina+="<legend>Datos Usuario</legend>";
            pagina+="matricula</br>"+a.getMatricula()+" <input type=\"hidden\" name=\"matricula\""+"value=\""+a.getMatricula()+"\""+">";
            pagina+="<br/>";
            pagina+="Nombre <br/>";
            
            pagina+= " <input type=\"text\" name=\"nombre\""+"value=\""+a.getNombre()+"\""+"/>" +"<br/>";
            pagina+="Apallido Paterno <br/>\n" + "<input type=\"text\" name=\"paterno\""+"value=\""+a.getPaternoAlumno()+"\""+"/>" + "<br/>";
            pagina+="Apellido Materno <br/>\n" +"<input type=\"text\" name=\"materno\""+"value=\""+a.getMaternoAlumno()+"\""+"/>" + "<br/>";
            pagina+="Fecha de Nacimiento <br/>\n" +"<input type=\"date\" name=\"fechaNacimiento\""+"value=\""+a.getFechaNacimiento()+"\""+"/>" + "<br/>";
            pagina+="Tipo de usuario<br/>";
            if("F".equals(a.getSexo())){
            pagina+="<input type=\"radio\" name=\"tipo\" value=\"F\"checked>F<br>";
            pagina+="<input type=\"radio\" name=\"tipo\" value=\"M\">M<br>\n";
            }
            else{
            pagina+="<input type=\"radio\" name=\"tipo\" value=\"F\">F<br>\n";
            pagina+="<input type=\"radio\" name=\"tipo\" value=\"M\" checked>M<br>\n";
            }
            pagina+="Calle <br/>\n" +"<input type=\"text\" name=\"calle\""+"value=\""+a.getCalle()+"\""+"/>" + "<br/>\n";
            pagina+="Colonia <br/>\n" +"<input type=\"text\" name=\"colonia\""+"value=\""+a.getColonia()+"\""+"/>" + "<br/>\n";
            pagina+="Numero  <br/>\n" +"<input type=\"text\" name=\"numero\""+"value=\""+a.getNumero()+"\""+"/>" + "<br/>\n";
            pagina+="Codigo Postal   <br/>\n" +"<input type=\"text\" name=\"cp\""+"value=\""+a.getCodigoPostal()+"\""+"/>" + "<br/>\n";
            pagina+="Correo Electronico <br/>\n" +"<input type=\"text\" name=\"email\""+"value=\""+a.getEmail()+"\""+"/>" + "<br/>\n";
            pagina+=
                    "</fieldset>\n" +
                    "<input type=\"submit\" value=\"Actualizar\">\n" +
                    "</form>";
            
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
            Logger.getLogger(servletActualizarAlumno.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servletActualizarAlumno.class.getName()).log(Level.SEVERE, null, ex);
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
