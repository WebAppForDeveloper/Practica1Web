/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author javs
 */
public class UsuarioAdminDAO {
    
    private static final String SQL_INSERT = "insert into usuarioo(nombre,aPaterno,aMaterno,email,nombreUsuario,claveUsuario,tipoUsuario) values(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "update usuarioo set nombre=?,aPeterno=?,aMaterno=?,email=?,nombreUsuario=?,tipoUsuario=? where idUsuario=?";
    private static final String SQL_DELETE = "delete from usuarioo where idUsuario=?";
    private static final String SQL_SELECT ="select * from usuarioo where idUsuario=?";
    private static final String SQL_SELECT_ALL ="select * from usuarioo";
    private static final String SQL_GRAFICAR ="{call spDatosGrafica()}";
    
    
    
    private String url = "jdbc:mysql://localhost:3306/mydb";
	private String driver = "com.mysql.jdbc.Driver";
	private String usuario = "root";
	private String password = "root";
	private Connection conexionDB = null;

	public UsuarioAdminDAO() {
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
    public void create(Admon admon)throws SQLException{
        PreparedStatement ps = null;
        
        try{
            ps= conexionDB.prepareStatement(SQL_INSERT);
            ps.setString(1, admon.getNombre());
            ps.setString(2, admon.getApellidoPaterno());
            ps.setString(3, admon.getApellidoMaterno());
            ps.setString(4, admon.getClave());
            //ps.setInt(8,1);
            
            ps.executeUpdate();
            
        }
        finally{
            if(ps != null) ps.close();
            //if(conexionDB != null) conexionDB.close();           
        }
        
        
    }
    
  
    public void update(Alumno alumno)throws SQLException{
        PreparedStatement ps = null;
        
        try{
            ps= conexionDB.prepareStatement(SQL_INSERT);
             ps.setLong(1, alumno.getMatricula());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getPaternoAlumno());
            ps.setString(4, alumno.getMaternoAlumno());
           // ps.setDate(5, (Date) alumno.getFechaNacimineto());
            ps.setString(6, alumno.getCalle());
            ps.setString(7, alumno.getColonia());
            ps.setInt(8, alumno.getNumero());
            ps.setString(9, alumno.getCodigoPostal());
            ps.setString(10, alumno.getSexo());
            ps.setString(11, alumno.getEmail());
            
            ps.executeUpdate();
            
        }
        finally{
            if(ps != null) ps.close();
            //if(conexionDB != null) conexionDB.close();           
        }
        
        
    }
    public void delet(Alumno alumno)throws SQLException{
        PreparedStatement ps = null;
        
        try{
            ps= conexionDB.prepareStatement(SQL_DELETE);
            ps.setLong(1, alumno.getMatricula());
            //ps.setString(7, usuario.getTipoUsuario());
            
            ps.executeUpdate();
            
        }
        finally{
            if(ps != null) ps.close();
            //if(conexionDB != null) conexionDB.close();           
        }
        
        
    }
    
    public boolean verificarUsuario(String user,String pass){
		try {
                    PreparedStatement ps= conexionDB.prepareStatement("Select * from administrador where administrador.nombre=? and administrador.clave=?");
                    ps.setString(1, user);
                    ps.setString(2, pass);
                    ResultSet r = ps.executeQuery();
            
			if(r.next()){
				//System.out.println(r.getObject(1));
                                //System.out.println(r.getObject(2));
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
    
    /*
    public Alumno load(Alumno alumno)throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps= conexionDB.prepareStatement(SQL_SELECT);
            ps.setLong(1, alumno.getMatricula());
            rs = ps.executeQuery();
            //ps.setString(7, usuario.getTipoUsuario());
            List resultados = obtenerResultados(rs);
            if(resultados.size() > 0)
            {
                return (Alumno)resultados.get(0);
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
/*
    public List obtenerResultados(ResultSet rs)throws SQLException{
        
       List res = new LinkedList();
       while(rs.next()){
           Alumno user = new Alumno();
           user.setId(rs.getInt("idUsuario"));
           user.setNombre(rs.getString("nombre"));
           
           //System.out.println(rs.getString("nombre"));
           
           user.setaPaterno(rs.getString("aPaterno"));
           user.setaMaterno(rs.getString("aMaterno"));
           user.setEmail(rs.getString("email"));
           user.setUsuario(rs.getString("nombreUsuario"));
           user.setClave(rs.getString("claveUsuario"));
           user.setTipoUsuario(rs.getString("tipoUsuario"));
           
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
     */
     
}
