package capaDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import capaEntidades.Camion;
import capaEntidades.Personal;
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
	
	public void agregarRuta(int idViaje, int idRuta)
	{
		String sql = "INSERT INTO viajes_rutas(numeroViaje,idRuta) VALUES (?,?)";
		
		try
		{
			AbrirConexion(sql);
			sentencia.setInt(1, idViaje);
			sentencia.setInt(2, idRuta);
			sentencia.execute();
			
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
	}
	
	
}
