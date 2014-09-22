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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Profesor;
import modelo.UsuarioProfesorDAO;

/**
 *
 * @author Mariana
 */
public class servletactualizarprof extends HttpServlet {

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
       HttpSession session = request.getSession(true);
       String usuario = (String)session.getAttribute("usuario");
       String nombre = (String)session.getAttribute("nombre");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Profesor p=new Profesor();
            System.out.println("El numero"+usuario);
            p.setMatriculaProfesor(Long.parseLong(usuario));
            UsuarioProfesorDAO prof =new UsuarioProfesorDAO();
            p=prof.load(p);
            String pagina = null;
            pagina +="<html>";
            pagina +="<head>";
            pagina +="<title>actualizar</title>";            
            pagina +="</head>";
            pagina +="<body>";
            pagina+="<form action=\"hacerupdateProf\" method=\"get\" >" + " <fieldset>"; 
            pagina+="<legend>Datos de"+nombre+"</legend>";
            pagina+="matricula</br>"+p.getMatriculaProfesor()+" <input type=\"hidden\" name=\"matricula\""+"value=\""+p.getMatriculaProfesor()+"\""+">";
            pagina+="<br/>";
            pagina+="Nombre <br/>";
            pagina+= " <input type=\"text\" name=\"nombre\""+"value=\""+p.getNombre()+"\""+"/>" +"<br/>";
            pagina+="Apallido Paterno <br/>\n" + "<input type=\"text\" name=\"paterno\""+"value=\""+p.getPaterno()+"\""+"/>" + "<br/>";
            pagina+="Apellido Materno <br/>\n" +"<input type=\"text\" name=\"materno\""+"value=\""+p.getMaterno()+"\""+"/>" + "<br/>";
            pagina+="Fecha de Nacimiento <br/>\n" +"<input type=\"date\" name=\"fechaNacimiento\""+"value=\""+p.getFechaNacimineto()+"\""+"/>" + "<br/>";
            pagina+="Tipo de usuario<br/>";
            if("F".equals(p.getSexo())){
            pagina+="<input type=\"radio\" name=\"tipo\" value=\"F\"checked>F<br>";
            pagina+="<input type=\"radio\" name=\"tipo\" value=\"M\">M<br>\n";
            }
            else{
            pagina+="<input type=\"radio\" name=\"tipo\" value=\"F\">F<br>\n";
            pagina+="<input type=\"radio\" name=\"tipo\" value=\"M\" checked>M<br>\n";
            }
            pagina+="Calle <br/>\n" +"<input type=\"text\" name=\"calle\""+"value=\""+p.getCalle()+"\""+"/>" + "<br/>\n";
            pagina+="Colonia <br/>\n" +"<input type=\"text\" name=\"colonia\""+"value=\""+p.getColonia()+"\""+"/>" + "<br/>\n";
            pagina+="Correo Electronico <br/>\n" +"<input type=\"text\" name=\"email\""+"value=\""+p.getEmail()+"\""+"/>" + "<br/>\n";
            pagina+=
                    "</fieldset>\n" +
                    "<input type=\"submit\" value=\"Actualizar\">\n" +
                    "</form>";
            pagina +="<a href='/Practica1/vistas/ReProfesor.html'><input type ='button' value='Regresar'></a>";
            pagina +="<a href='/Practica1/vistas/index.html'><input type ='button' value='Cerrar sesion'></a>";
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
            Logger.getLogger(servletactualizarprof.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servletactualizarprof.class.getName()).log(Level.SEVERE, null, ex);
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
