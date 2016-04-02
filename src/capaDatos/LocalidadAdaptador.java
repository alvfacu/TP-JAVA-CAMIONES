package capaDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import capaEntidades.Localidad;
import capaEntidades.Provincia;

public class LocalidadAdaptador extends Adaptador {

	public ArrayList<Localidad> dameTodo()
	{
		ArrayList<Localidad> localidades = null;
		
		String sql = "SELECT * FROM localidades loc INNER JOIN provincias prov WHERE loc.idProvincia = prov.idProvincia";
		ResultSet rs = null;
						
		try
		{
			AbrirConexion(sql);
			rs = sentencia.executeQuery();
			
			localidades = new ArrayList<Localidad>();
			
			while(rs.next())
			{
				Localidad loc = new Localidad();
				loc.setIdLocalidad(rs.getInt("idLocalidad"));
				loc.setCodigoPostal(rs.getInt("cp"));
				loc.setNombreLocalidad(rs.getString("nombreLocalidad"));
				Provincia prov = new Provincia(rs.getInt("idProvincia"),rs.getString("nombreProvincia"));
				loc.setProv(prov);
				
				localidades.add(loc);				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CerrarConexion();
		}
		
		return localidades;
	}
}
