package capaDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import capaEntidades.Provincia;

public class CatalogoProvincia extends Catalogo {
	
	//Devuelve una Provincia sin sus localidades 
	public Provincia dameUno(int id)
	{
		Provincia prov = null;
		
		String sql = "SELECT * FROM provincias WHERE idProvincia = ?";
		ResultSet rs = null;
		
		try
		{
			AbrirConexion(sql);
			sentencia.setInt(1, id);
			rs = sentencia.executeQuery();
			
			if(rs.next())
			{
				prov = new Provincia();
				prov.setIdProvincia(rs.getInt("idProvincia"));
				prov.setNombreProvincia(rs.getString("nombreProvincia"));
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CerrarConexion();
		}	
		
		return prov;
	}
	
	public ArrayList<Provincia> dameTodo()
	{
		ArrayList<Provincia> provincias = null;
		String sql = "SELECT * FROM provincias";
		ResultSet rs = null;
		
		try
		{
			AbrirConexion(sql);
			rs = sentencia.executeQuery();
			provincias = new ArrayList<Provincia>();
			
			while(rs.next())
			{				
				Provincia prov = new Provincia(rs.getInt("idProvincia"), rs.getString("nombreProvincia"));
				provincias.add(prov);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CerrarConexion();
		}
		return provincias;
				
	}
}
