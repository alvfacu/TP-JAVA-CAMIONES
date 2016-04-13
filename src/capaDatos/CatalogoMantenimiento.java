package capaDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import capaEntidades.Camion;
import capaEntidades.Mantenimiento;

public class CatalogoMantenimiento extends Catalogo {

	// Agrega un nuevo mantenimiento
	public void agregarMantenimiento(Mantenimiento man) {
	
		String sql = "INSERT INTO mantenimientos(fechaHoraIngreso,fechaHoraMantenimiento,fechaHoraEgreso,tipo,kmIngreso,kmEgreso,patente) values (?,?,?,?,?,?,?)";
		
		try 
		{				
			AbrirConexion(sql);
				
			sentencia.setString(1,TransformaFecha(man.getFechaHoraIngreso()));
			sentencia.setString(2,TransformaFecha(man.getFechaHoraMantenimiento()));
			sentencia.setString(3,TransformaFecha(man.getFechaHoraEgreso()));
			sentencia.setString(4, man.getTipo().toString());
			sentencia.setDouble(5, man.getKmIngreso());
			sentencia.setDouble(6, man.getKmEgreso());
			sentencia.setString(7, man.getCamion().getPatente());
			sentencia.execute(); 
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			CerrarConexion();			
		}	
		
	}
	
	// Devuelvo el conjunto de mantenimientos x patente de un camion
	public ArrayList<Mantenimiento> dameTodoXCamion(String patente)
	{
		ArrayList<Mantenimiento> mantenimientos = null;
		
		String sql = "SELECT cam.patente as pat, cam.marca as mar, cam.modelo as model, "+
		"cam.descripcion as descr, cam.kmRecorridosDesdeMantenimiento as kmman, cam.kmRecorridosEnViaje as kmviaje, "
				+"cam.estado as est, man.fechaHoraIngreso as ing, man.fechaHoraMantenimiento as mant, man.fechaHoraEgreso as egr, "
				+ "man.tipo as tip, man.kmIngreso as kming, man.kmEgreso as kmegr FROM mantenimientos man INNER JOIN camiones cam ON man.patente = cam.patente WHERE cam.patente like ?";
		ResultSet rs = null;
		
		try
		{
			AbrirConexion(sql);
			sentencia.setString(1, patente);
			rs = sentencia.executeQuery();
			mantenimientos = new ArrayList<Mantenimiento>();			
			
			while(rs.next())
			{
				Mantenimiento man = new Mantenimiento();
				Camion ca = new Camion(rs.getString("pat"),rs.getString("mar"),rs.getString("model"),rs.getString("descr"),rs.getDouble("kmman"),rs.getDouble("kmviaje"),new Camion().dameNombreEstado(rs.getString("est")));
				man.setCamion(ca);
				
				// Creo instancia Calendar
				Calendar cal = Calendar.getInstance();
				// Devuelvo la fecha de un tipo DATETIME
				Date dat = (Date)rs.getTimestamp("ing");
				// Seteo en la instancia Calendar
				cal.setTime(dat);
				man.setFechaHoraIngreso(cal);			
				
				dat = new Date();
				cal = Calendar.getInstance();
				dat = (Date)rs.getTimestamp("egr");
				cal.setTime(dat);
				man.setFechaHoraEgreso(cal);
				
				dat = new Date();
				cal = Calendar.getInstance();
				dat = (Date)rs.getTimestamp("mant");
				cal.setTime(dat);
				man.setFechaHoraMantenimiento(cal);
								
				man.setTipo(rs.getString("tip"));
				man.setKmIngreso(rs.getDouble("kming"));
				man.setKmEgreso(rs.getDouble("kmegr"));
				
				mantenimientos.add(man);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CerrarConexion();
		}	
		
		return mantenimientos;
	}
	
	// Devuelve todos los mantenimientos ordenados alfabeticamente de modo ascendente por patente y tipo
 	public ArrayList<Mantenimiento> dameTodo()
	{
		ArrayList<Mantenimiento> mantenimientos = null;
		
		String sql = "SELECT cam.patente as pat, cam.marca as mar, cam.modelo as model, cam.descripcion as descr, "
				+ "cam.kmRecorridosDesdeMantenimiento as kmman, cam.kmRecorridosEnViaje as kmviaje, cam.estado as est, "
				+ "man.fechaHoraIngreso as ing, man.fechaHoraMantenimiento as mant, man.fechaHoraEgreso as egr, man.tipo as tip, "
				+ "man.kmIngreso as kming, man.kmEgreso as kmegr FROM mantenimientos man INNER JOIN camiones cam ON man.patente = cam.patente"
				+ " GROUP BY cam.patente ASC, man.tipo ASC";
		ResultSet rs = null;
		
		try
		{
			AbrirConexion(sql);
			rs = sentencia.executeQuery();
			mantenimientos = new ArrayList<Mantenimiento>();			
			
			while(rs.next())
			{
				Mantenimiento man = new Mantenimiento();
				Camion ca = new Camion(rs.getString("pat"),rs.getString("mar"),rs.getString("model"),rs.getString("descr"),rs.getDouble("kmman"),rs.getDouble("kmviaje"),new Camion().dameNombreEstado(rs.getString("est")));
				man.setCamion(ca);
				
				// Creo instancia Calendar
				Calendar cal = Calendar.getInstance();
				// Devuelvo la fecha de un tipo DATETIME
				Date dat = (Date)rs.getTimestamp("ing");
				// Seteo en la instancia Calendar
				cal.setTime(dat);
				man.setFechaHoraIngreso(cal);			
				
				dat = new Date();
				cal = Calendar.getInstance();
				dat = (Date)rs.getTimestamp("egr");
				cal.setTime(dat);
				man.setFechaHoraEgreso(cal);
				
				dat = new Date();
				cal = Calendar.getInstance();
				dat = (Date)rs.getTimestamp("mant");
				cal.setTime(dat);
				man.setFechaHoraMantenimiento(cal);
								
				man.setTipo(rs.getString("tip"));
				man.setKmIngreso(rs.getDouble("kming"));
				man.setKmEgreso(rs.getDouble("kmegr"));
				
				mantenimientos.add(man);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CerrarConexion();
		}	
		
		return mantenimientos;
	}
}
