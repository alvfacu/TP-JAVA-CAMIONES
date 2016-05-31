package capaDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import capaEntidades.Camion;
import capaEntidades.Direccion;
import capaEntidades.Localidad;
import capaEntidades.Personal;
import capaEntidades.Provincia;
import capaEntidades.Viaje;

public class CatalogoViaje extends Catalogo{
		
	public ArrayList<Viaje> dameTodo()
	{
		ArrayList<Viaje> viajes = null;
		
		String sql = "SELECT * FROM viajes via INNER JOIN personal per ON via.`dni` = per.`dni` INNER JOIN camiones cam ON via.`patente` = cam.`patente`";
		ResultSet rs = null;
		
		try
		{
			AbrirConexion(sql);
			rs = sentencia.executeQuery();
			viajes = new ArrayList<Viaje>();
			
			while(rs.next())
			{
				Camion ca = new Camion(rs.getString("patente"),rs.getString("marca"),rs.getString("modelo"),rs.getString("descripcion"),rs.getDouble("kmRecorridosDesdeMantenimiento"),rs.getDouble("kmRecorridosEnViaje"),new Camion().dameNombreEstado(rs.getString("estado")));
				Personal pe = new Personal(rs.getString("nombre"),rs.getString("apellido"),rs.getString("direccion"),rs.getString("dni"),rs.getInt("telefono"),rs.getString("usuario"),rs.getString("password"), new Personal().dameNombreTipo(rs.getString("tipo")),rs.getBoolean("disponibilidad"));
				
				Viaje via = new Viaje();
				
				via.setCamion(ca);
				via.setCamionero(pe);
				
				via.setNroViaje(rs.getInt("numeroViaje"));
				
				// Creo instancia Calendar
				Calendar cal = Calendar.getInstance();
				// Devuelvo la fecha de un tipo DATETIME				
				Date dat = (Date)rs.getTimestamp("fechaHoraSalidaPactada");
				// Seteo en la instancia Calendar
				cal.setTime(dat);
				via.setFechaHoraSalidaPactada(cal);			
				
				dat = new Date();
				cal = Calendar.getInstance();
				if(rs.getTimestamp("fechaHoraSalidaReal") != null)
				{
					dat = (Date)rs.getTimestamp("fechaHoraSalidaReal");
					cal.setTime(dat);
					via.setFechaHoraSalidaReal(cal);
				}
				else
				{
					via.setFechaHoraSalidaReal(null);
				}				
				
				dat = new Date();
				cal = Calendar.getInstance();
				dat = (Date)rs.getTimestamp("fechaHoraLlegadaPactada");
				cal.setTime(dat);
				via.setFechaHoraLlegadaPactada(cal);
				
				dat = new Date();
				cal = Calendar.getInstance();
				if(rs.getTimestamp("fechaHoraLlegadaReal") != null)
				{
					dat = (Date)rs.getTimestamp("fechaHoraLlegadaReal");
					cal.setTime(dat);
					via.setFechaHoraLlegadaReal(cal);
				}
				else
				{
					via.setFechaHoraLlegadaReal(null);
				}						
				
				via.setKmReales(rs.getDouble("kmReales"));
				
				via.setKmTotales(rs.getDouble("kmTotales"));
				
				via.setEstado(new Viaje().dameNombreEstado(rs.getString("estado")));
				
				viajes.add(via);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			CerrarConexion();
		}
		
		return viajes;
	}
	
	public void agregarDireccion(Direccion dir)
	{
		String sql = "INSERT INTO direcciones(calle,nro,piso,letra,idLocalidad) VALUES (?,?,?,?,?)";
		try
		{
			AbrirConexion(sql);
			sentencia.setString(1, dir.getCalle());
			sentencia.setInt(2, dir.getNro());
			if(!(dir.getPiso()==0))
			{
				sentencia.setInt(3, dir.getPiso());
			}
			else
			{
				sentencia.setInt(3,0);
			}
			if(!(dir.getDepto()=='\u0000'))
			{
				sentencia.setString(4, dir.getDepto()+"");
			}
			else
			{
				sentencia.setNull(4, java.sql.Types.CHAR);
			}
			sentencia.setInt(5, dir.getLoc().getIdLocalidad());
			sentencia.execute();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CerrarConexion();
		}
	}
	
	public void modificarDireccion(Direccion dir)
	{
		String sql = "UPDATE direcciones SET calle=?, nro=?, piso=?, letra=?, idLocalidad=? WHERE idDireccion=?";
		
		try
		{
			AbrirConexion(sql);
			sentencia.setString(1, dir.getCalle());
			sentencia.setInt(2, dir.getNro());
			if(!(dir.getPiso()== 0))
			{
				sentencia.setInt(3, dir.getPiso());
			}
			else
			{
				sentencia.setInt(3,0);
			}
			if(!(dir.getDepto()=='0'))
			{
				sentencia.setString(4, dir.getDepto()+"");
			}
			else
			{
				sentencia.setNull(4, java.sql.Types.CHAR);
			}
			sentencia.setInt(5, dir.getLoc().getIdLocalidad());
			sentencia.setInt(6, dir.getIdDireccion());
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

	public Direccion dameUno(int id) {
		
		Direccion dir = null;
		String sql = "SELECT * FROM direcciones dir INNER JOIN localidades loc ON loc.idLocalidad = dir.idLocalidad INNER JOIN provincias prov ON loc.idProvincia = prov.idProvincia WHERE dir.idDireccion = ?";
		ResultSet rs = null;
		
		try
		{
			AbrirConexion(sql);
			sentencia.setInt(1, id);
			rs = sentencia.executeQuery();
			
			if(rs.next())
			{
				dir = new Direccion();
				dir.setIdDireccion(rs.getInt("idDireccion"));
				dir.setCalle(rs.getString("calle"));
				dir.setNro(rs.getInt("nro"));
				Object val = rs.getInt("piso");
				if((int)val==0)
				{
					dir.setPiso(0);					
				}
				else
				{
					dir.setPiso(rs.getInt("piso"));
				}
				val = rs.getString("letra");
				if(val == null || (boolean)val.equals(""))
				{
					dir.setDepto('0');					
				}
				else
				{
					dir.setDepto(rs.getString("letra").charAt(0));
				}			
				Provincia prov = new Provincia(rs.getInt("idProvincia"), rs.getString("nombreProvincia"));				
				Localidad loc = new Localidad(rs.getInt("idLocalidad"), rs.getInt("cp"), rs.getString("nombreLocalidad"), prov);
				dir.setLoc(loc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CerrarConexion();
		}
				
		return dir;
	}

	public void eliminarDireccion(int id)
	{
		String sql = "DELETE FROM direcciones WHERE idDireccion = ?";
		
		try
		{
			AbrirConexion(sql);
			sentencia.setInt(1, id);
			sentencia.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		finally
		{
			CerrarConexion();
		}
	}
}
