package capaDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import capaEntidades.Localidad;
import capaEntidades.Provincia;

public class CatalogoLocalidad extends Catalogo {

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

	public Localidad dameUno(int id) {
		
		Localidad loc = null;
		String sql = "SELECT * FROM localidades loc INNER JOIN provincias prov ON loc.idProvincia = prov.idProvincia WHERE loc.idProvincia = ?";
		ResultSet rs = null;
				
		try
		{
			AbrirConexion(sql);
			sentencia.setInt(1, id);
			rs = sentencia.executeQuery();			
			
			if(rs.next())
			{
				Provincia prov = new Provincia(rs.getInt("idProvincia"),rs.getString("nombreProvincia"));
				loc = new Localidad(rs.getInt("idLocalidad"), rs.getInt(rs.getInt("cp")), rs.getString("nombreLocalidad"), prov);				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CerrarConexion();
		}
		
		// TODO Auto-generated method stub
		return loc;
	}
}
