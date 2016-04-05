package capaDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import capaEntidades.Demora;
import connection.ConexionBD;

public class CatalogoDemora {
	
	//comentss
	
	
	
	public static void modificaDemora(Demora demo) {
		
		//Elimina la demora anterior
		
		String sql = "DELETE FROM demora WHERE id=?";
		
		PreparedStatement sentencia = null;
		ResultSet rs = null;
		
		try 
		{			
			sentencia = ConexionBD.getInstancia().getConn().prepareStatement(sql);
			sentencia.setInt(1, 1);
			sentencia.executeUpdate();					
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs!=null)
				{
					rs.close();
				}
				if (sentencia!=null && !sentencia.isClosed())
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
    
	
		
		
		// Agrega la nueva demora
		
		String sql1 = "INSERT INTO demora(demora,id) values (?,?)" ;
		PreparedStatement sentencia1 = null;
		Connection conn = ConexionBD.getInstancia().getConn();
		
		try 
		{
			sentencia1 = conn.prepareStatement(sql1);
			
			sentencia1.setTime(1, demo.getDemora());
			sentencia1.setInt(2, 1);
			
			sentencia1.execute(); 

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(sentencia1!=null && !sentencia1.isClosed())
				{
					sentencia1.close();
				}
				ConexionBD.getInstancia().CloseConn();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}			
		}		

	
	
	
	
		
	}



}
