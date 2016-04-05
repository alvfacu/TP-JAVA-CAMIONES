package capaDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConexionBD;
import capaEntidades.Personal;

public class PersonalAdaptador {

	public static void agregarPersonal(Personal pe) {
		
		String sql = "INSERT INTO personal(dni,nombre,apellido,usuario,password) values (?,?,?,?,?)";
		PreparedStatement sentencia = null;
		Connection conn = ConexionBD.getInstancia().getConn();
		
		try 
		{
			sentencia = conn.prepareStatement(sql);
			
			sentencia.execute(); 

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				ConexionBD.getInstancia().CloseConn();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}			
		}		

		
	}

	public  Personal validarUsuario(String us, String pass) {
		
		
		String sql = "SELECT * FROM personal where usuario = ? and password = ?";
		PreparedStatement sentencia = null;
		Connection conn = ConexionBD.getInstancia().getConn();
		ResultSet rs= null ;
		Personal pe = new Personal();
		try 
		{
		
			sentencia = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			sentencia.setString(1, us);
			sentencia.setString(2, pass);
			rs = sentencia.executeQuery();

			if (rs.next())
			{ 			
				pe.setNombre(rs.getString("nombre"));
				pe.setApellido(rs.getString("apellido"));
				pe.setUsuario(rs.getString("usuario"));
				pe.setPassword(rs.getString("password"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				ConexionBD.getInstancia().CloseConn();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}			
		}
		
				
			return pe;
			
		
	}

}
