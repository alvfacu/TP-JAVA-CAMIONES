package capaDatos;

import java.sql.ResultSet;
import java.sql.SQLException;

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

}
