/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mariana
 */
public class CarreraDAO {
 private static final String SQL_INSERT = "insert into carrera (nombreCarrera,duracion) values(?,?)"; 
 private static final String SQL_Update = "update carrera set nombreCarrera=?,duracion=? where idCarrera=?"; 
 private static final String SQL_DELETE = "delete from carera where idcarrera=?";
 private static final String SQL_SELECT ="select * from carrera where idcarrera=?";
 private static final String SQL_SELECT_ALL ="select * from carrera";
 private String url = "jdbc:mysql://localhost:3306/mydb";
	private String driver = "com.mysql.jdbc.Driver";
	private String usuario = "root";
	private String password = "root";
	private Connection conexionDB = null;

	public CarreraDAO() {
		this.conexionDB = conectar(this.url, this.driver, this.usuario,
				this.password);
                
                System.out.println("conexion establecida");
	}

	public Connection conectar(String url, String driver, String usuario,
			String password) {
		try {

			Class.forName(driver);

			java.sql.Connection con = DriverManager.getConnection(url, usuario,
					password);

			// System.out.println("Conexion establecida");

			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
    
    //private Connection con = null;
    public void create(Carrera carrera)throws SQLException{
        PreparedStatement ps = null;
        
        try{
            ps= conexionDB.prepareStatement(SQL_INSERT);
            ps.setString(1,carrera.getNombre());
            ps.setInt(2,carrera.getDuración());
            
            //ps.setInt(8,1);
            ps.executeUpdate();
            
        }
        finally{
            if(ps != null) ps.close();
            //if(conexionDB != null) conexionDB.close();           
        }
        
        
    }
    
  
    public void update(Carrera carrera)throws SQLException{
        PreparedStatement ps = null;
        
        try{
            ps= conexionDB.prepareStatement(SQL_Update);
             
            ps.setString(1, carrera.getNombre());
            ps.setInt(2, carrera.getDuración());
            ps.setInt(3, carrera.getIdCarrera());
            ps.executeUpdate();
            
        }
        finally{
            if(ps != null) ps.close();
            //if(conexionDB != null) conexionDB.close();           
        }
        
        
    }
    public void delet(Carrera carrera)throws SQLException{
        PreparedStatement ps = null;
        
        try{
            ps= conexionDB.prepareStatement(SQL_DELETE);
            ps.setInt(1, carrera.getIdCarrera());
            //ps.setString(7, usuario.getTipoUsuario());
            
            ps.executeUpdate();
            
        }
        finally{
            if(ps != null) ps.close();
            //if(conexionDB != null) conexionDB.close();           
        }
        
        
    }
    
   
    
    public Carrera load(Carrera carrera)throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps= conexionDB.prepareStatement(SQL_SELECT);
            ps.setInt(1, carrera.getIdCarrera());
            rs = ps.executeQuery();
            //ps.setString(7, usuario.getTipoUsuario());
            List resultados = obtenerResultados(rs);
            if(resultados.size() > 0)
            {
                return (Carrera)resultados.get(0);
            }
            else {
                return null;
            }
            //ps.executeUpdate();
            
        }
        finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            //if(conexionDB != null) conexionDB.close();           
        }
        
        
    }

    public List obtenerResultados(ResultSet rs)throws SQLException{
        
       List res = new LinkedList();
       while(rs.next()){
           Alumno user = new Alumno();
           user.setMatricula(rs.getInt("Matricula"));
           user.setNombre(rs.getString("nombre"));
           user.setPaternoAlumno(rs.getString("paternoAlumno"));
           user.setMaternoAlumno(rs.getString("maternoAlumno"));
           user.setFechaNacimiento(rs.getString("fechaNacimiento"));
           user.setCalle(rs.getString("calle"));
           user.setColonia(rs.getString("colonia"));
           user.setNumero(rs.getInt("numero"));
           user.setCodigoPostal(rs.getString("codigoPostal"));
           user.setSexo(rs.getString("sexo"));
           user.setEmail(rs.getString("email"));
           res.add(user);
           
       }
        
        return res;
    }
    
    
     public List loadAll()throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps= conexionDB.prepareStatement(SQL_SELECT_ALL);
 
            rs = ps.executeQuery();
            //ps.setString(7, usuario.getTipoUsuario());
            List resultados = obtenerResultados(rs);
            if(resultados.size() > 0)
            {
                //System.out.println("los resultados son"+resultados.size());
                return resultados;//resultados
            }
            else {
                return null;
            }
            //ps.executeUpdate();
            
        }
        finally{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
           // if(conexionDB != null) conexionDB.close();           
        }
        
        
    }
} 
