package capaDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import capaEntidades.Direccion;
import capaEntidades.Localidad;
import capaEntidades.Provincia;
import capaEntidades.Ruta;

public class CatalogoRuta extends Catalogo {
	
	public void agregarRuta(Ruta ruta)
	{
		String sql = "INSERT INTO rutas(idDireccionOrigen,idDireccionDestino,distancia) values (?,?,?)";
		
		try
		{
			AbrirConexion(sql);
			sentencia.setInt(1, ruta.getDirOrigen().getIdDireccion());
			sentencia.setInt(2, ruta.getDirDestino().getIdDireccion());
			sentencia.setDouble(3, ruta.getDistancia());
			sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CerrarConexion();			
		}
	}
	
	public ArrayList<Ruta> dameTodoXOrigen(int idOrigen)
	{
		ArrayList<Ruta> rutas = null;
		
		String sql = "SELECT rt.*, dirO.*, dirD.*, locO.*, locD.*, provO.*, provD.* FROM rutas rt INNER JOIN direcciones dirO "
				+ "ON rt.idDireccionOrigen = dirO.idDireccion INNER JOIN direcciones dirD ON rt.idDireccionDestino = dirD.idDireccion "
				+ "INNER JOIN localidades locO ON dirO.idLocalidad = locO.idLocalidad INNER JOIN localidades locD ON dirD.idLocalidad = locD.idLocalidad "
				+ "INNER JOIN provincias provO ON provO.idProvincia = locO.idProvincia INNER JOIN provincias provD ON provD.idProvincia = locD.idProvincia"
				+ " WHERE dirO.idDireccion = ?";
		ResultSet rs = null;
		
		try
		{
			AbrirConexion(sql);
			sentencia.setInt(1, idOrigen);
			rs = sentencia.executeQuery();
			rutas = new ArrayList<Ruta>();
			
			while(rs.next())
			{
				Ruta rt = new Ruta();
				rt.setIdRuta(rs.getInt("rt.idRuta"));
				rt.setDistancia(rs.getDouble("rt.distancia"));
				Provincia provO = new Provincia(rs.getInt("provO.idProvincia"),rs.getString("provO.nombreProvincia"));
				Provincia provD = new Provincia(rs.getInt("provD.idProvincia"),rs.getString("provD.nombreProvincia"));
				Localidad locO = new Localidad(rs.getInt("locO.idLocalidad"), rs.getInt("locO.cp"), rs.getString("locO.nombreLocalidad"), provO);
				Localidad locD = new Localidad(rs.getInt("locD.idLocalidad"), rs.getInt("locD.cp"), rs.getString("locD.nombreLocalidad"), provD);
				
				//Direccion Origen
				Direccion dirO = new Direccion();
				dirO.setIdDireccion(rs.getInt("dirO.idDireccion"));
				dirO.setCalle(rs.getString("dirO.calle"));
				dirO.setNro(rs.getInt("dirO.nro"));
				Object val = rs.getInt("dirO.piso");
				if((int)val==0)
				{
					dirO.setPiso(0);					
				}
				else
				{
					dirO.setPiso(rs.getInt("dirO.piso"));
				}
				val = rs.getString("dirO.letra");
				if(val==null || (boolean)val.equals(""))
				{
					dirO.setDepto('0');					
				}
				else
				{
					dirO.setDepto(rs.getString("dirO.letra").charAt(0));
				}				
				dirO.setLoc(locO);
				
				//Direccion Destino
				Direccion dirD = new Direccion();
				dirD.setIdDireccion(rs.getInt("dirD.idDireccion"));
				dirD.setCalle(rs.getString("dirD.calle"));
				dirD.setNro(rs.getInt("dirD.nro"));
				val = rs.getInt("dirD.piso");
				if((int)val==0)
				{
					dirD.setPiso(0);					
				}
				else
				{
					dirD.setPiso(rs.getInt("dirD.piso"));
				}
				val = rs.getString("dirD.letra");
				if(val==null || (boolean)val.equals(""))
				{
					dirD.setDepto('0');					
				}
				else
				{
					dirD.setDepto(rs.getString("dirD.letra").charAt(0));
				}				
				dirD.setLoc(locD);
				
				rt.setDirOrigen(dirO);
				rt.setDirDestino(dirD);
								
				rutas.add(rt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CerrarConexion();
		}
		
		return rutas;
	}

	public ArrayList<Ruta> dameTodoXViaje(int viaje) {
		
		String sql = "SELECT * "
				+ "FROM `viajes` via "
				+ "INNER JOIN `viajes_rutas` viarut "
				+ "ON via.`numeroViaje` = viarut.`numeroViaje` "
				+ "INNER JOIN rutas rut "
				+ "ON rut.`idRuta` = viarut.`idRuta` "
				+ "INNER JOIN direcciones dirO "
				+ "ON dirO.`idDireccion` = rut.`idDireccionOrigen` "
				+ "INNER JOIN direcciones dirD "
				+ "ON dirD.`idDireccion` = rut.`idDireccionDestino` "
				+ "WHERE via.`numeroViaje` = ?";
		ArrayList<Ruta> rutas = null;
		ResultSet rs = null;
		
		try
		{
			AbrirConexion(sql);
			sentencia.setInt(1, viaje);
			rs = sentencia.executeQuery();
			rutas = new ArrayList<Ruta>();
			
			while(rs.next())
			{
				Ruta rt = new Ruta();
				rt.setIdRuta(rs.getInt("rut.idRuta"));
				rt.setDistancia(rs.getDouble("rut.distancia"));
				//Provincia provO = new Provincia(rs.getInt("provO.idProvincia"),rs.getString("provO.nombreProvincia"));
				//Provincia provD = new Provincia(rs.getInt("provD.idProvincia"),rs.getString("provD.nombreProvincia"));
				//Localidad locO = new Localidad(rs.getInt("locO.idLocalidad"), rs.getInt("locO.cp"), rs.getString("locO.nombreLocalidad"), provO);
				//Localidad locD = new Localidad(rs.getInt("locD.idLocalidad"), rs.getInt("locD.cp"), rs.getString("locD.nombreLocalidad"), provD);
				
				//Direccion Origen
				Direccion dirO = new Direccion();
				dirO.setIdDireccion(rs.getInt("dirO.idDireccion"));
				dirO.setCalle(rs.getString("dirO.calle"));
				dirO.setNro(rs.getInt("dirO.nro"));
				Object val = rs.getInt("dirO.piso");
				if((int)val==0)
				{
					dirO.setPiso(0);					
				}
				else
				{
					dirO.setPiso(rs.getInt("dirO.piso"));
				}
				val = rs.getString("dirO.letra");
				if(val==null || (boolean)val.equals(""))
				{
					dirO.setDepto('0');					
				}
				else
				{
					dirO.setDepto(rs.getString("dirO.letra").charAt(0));
				}				
				//dirO.setLoc(locO);
				
				//Direccion Destino
				Direccion dirD = new Direccion();
				dirD.setIdDireccion(rs.getInt("dirD.idDireccion"));
				dirD.setCalle(rs.getString("dirD.calle"));
				dirD.setNro(rs.getInt("dirD.nro"));
				val = rs.getInt("dirD.piso");
				if((int)val==0)
				{
					dirD.setPiso(0);					
				}
				else
				{
					dirD.setPiso(rs.getInt("dirD.piso"));
				}
				val = rs.getString("dirD.letra");
				if(val==null || (boolean)val.equals(""))
				{
					dirD.setDepto('0');					
				}
				else
				{
					dirD.setDepto(rs.getString("dirD.letra").charAt(0));
				}				
				//dirD.setLoc(locD);
				
				rt.setDirOrigen(dirO);
				rt.setDirDestino(dirD);
								
				rutas.add(rt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CerrarConexion();
		}
		
		return rutas;
	}

}
