package capaDatos;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;

import connection.ConexionBD;

public class Catalogo {

	static PreparedStatement sentencia = null;
	
	public static PreparedStatement getSentencia() {
		return sentencia;
	}

	public static void setSentencia(PreparedStatement sentencia) {
		Catalogo.sentencia = sentencia;
	}
	
	public static String TransformaFecha(Calendar c) {
		String d = c.get(Calendar.YEAR) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.DATE) + " " + c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+
	c.get(Calendar.SECOND);
		return d;
	}
	
	public static void AbrirConexion(String sql)
	{
		Connection conn = ConexionBD.getInstancia().getConn();
				
		try 
		{
			sentencia = conn.prepareStatement(sql);			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void CerrarConexion()
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
