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
public class UsuarioDAO {
    
    private static final String SQL_INSERT = "insert into usuarioo(nombre,aPaterno,aMaterno,email,nombreUsuario,claveUsuario,tipoUsuario) values(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "update usuarioo set nombre=?,aPeterno=?,aMaterno=?,email=?,nombreUsuario=?,tipoUsuario=? where idUsuario=?";
    private static final String SQL_DELETE = "delete from usuarioo where idUsuario=?";
    private static final String SQL_SELECT ="select * from alumno";
    private static final String SQL_SELECT_ALL ="select * from usuarioo";
    private static final String SQL_GRAFICAR ="{call spDatosGrafica()}";
    private static final String SQL_CONTRASEÑA="select * from alumno where Matricula=?";
    
    
    private String url = "jdbc:mysql://localhost:3306/mydb";
	private String driver = "com.mysql.jdbc.Driver";
	private String usuario = "root";
	private String password = "root";
	private Connection conexionDB = null;

	public UsuarioDAO() {
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
    public void create(Alumno alumno)throws SQLException{
        PreparedStatement ps = null;
        
        try{
            ps= conexionDB.prepareStatement(SQL_INSERT);
            ps.setLong(1, alumno.getMatricula());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getPaternoAlumno());
            ps.setString(4, alumno.getMaternoAlumno());
            ps.setDate(5, (Date) alumno.getFechaNacimineto());
            ps.setString(6, alumno.getCalle());
            ps.setString(7, alumno.getColonia());
            ps.setInt(8, alumno.getNumero());
            ps.setString(9, alumno.getCodigoPostal());
            ps.setString(10, alumno.getSexo());
            ps.setString(11, alumno.getEmail());
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
            ps.setDate(5, (Date) alumno.getFechaNacimineto());
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

    public List obtenerResultados(ResultSet rs)throws SQLException{
        
       List res = new LinkedList();
       while(rs.next()){
           Alumno user = new Alumno();
           user.setMatricula(rs.getInt("Matricula"));
           user.setNombre(rs.getString("nombre"));
           
           //System.out.println(rs.getString("nombre"));
           
           user.setPaternoAlumno(rs.getString("paternoAlumno"));
           user.setMaternoAlumno(rs.getString("maternoAlumno"));
           user.setEmail(rs.getString("email"));
           //user.setUsuario(rs.getString("nombreUsuario"));
           //user.setClave(rs.getString("claveUsuario"));
          // user.setEmail(rs.getString("tipoUsuario"));
           
           res.add(user);
           
       }
        
        return res;
    }
    
    public Alumno recuperar (long numero) throws SQLException{
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=conexionDB.prepareStatement(SQL_CONTRASEÑA);
            ps.setLong(1,numero);
            Alumno a = new Alumno();
            //ps=conexionDB.prepareStatement(SQL_SELECT);
            rs=ps.executeQuery();
            List resultados=obtenerResultados(rs);
            if(resultados.size()>0){
            return(Alumno) (resultados.get(0));
            }
            else{
            return null;
            }
          
        } finally{
            if(ps!=null)ps.close();
            if(conexionDB!=null)conexionDB.close();
        }
    }
}