package capaDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import capaEntidades.Camion;

public class CatalogoCamion extends Catalogo {
	
	// Devuelve el conjunto de todos los camiones
	public ArrayList<Camion> dameTodo()
	{
		ArrayList<Camion> camiones = null;
				
		String sql = "SELECT * FROM camiones";
		ResultSet rs = null;
		
		try
		{				
			AbrirConexion(sql);
			rs = sentencia.executeQuery();
			
			camiones = new ArrayList<Camion>();
			
			while(rs.next())
			{
				Camion camion = new Camion();
				camion.setPatente(rs.getString("patente"));
				camion.setMarca(rs.getString("marca"));
				camion.setModelo(rs.getString("modelo"));
				camion.setDescripcion(rs.getString("descripcion"));
				camion.setKmRecorridosDesdeMantenimiento(rs.getDouble("kmRecorridosDesdeMantenimiento"));
				camion.setKmRecorridosEnViaje(rs.getDouble("kmRecorridosEnViaje"));
				String est = rs.getString("estado");
				camion.setEstado(new Camion().dameNombreEstado(est));			
				camiones.add(camion);
			}					
		} 
		catch (SQLException e) 
		{		
			e.printStackTrace();
		}	
		finally
		{
			CerrarConexion();			
		}	
		
		return camiones;
	}
	
	// Devuelve el camión que coincida con la patente (en caso de no encontrarlo, devuelve un objeto null)
	public Camion dameUno(String patente)
	{
		Camion camion = null;
		String sql = "SELECT * FROM camiones WHERE patente like ?";
		ResultSet rs = null;
		
		try
		{			
			AbrirConexion(sql);
			sentencia.setString(1, patente);
			rs = sentencia.executeQuery();
			
			if(rs.next())
			{
				camion = new Camion();
				camion.setPatente(rs.getString("patente"));
				camion.setMarca(rs.getString("marca"));
				camion.setModelo(rs.getString("modelo"));
				camion.setDescripcion(rs.getString("descripcion"));
				camion.setKmRecorridosDesdeMantenimiento(rs.getDouble("kmRecorridosDesdeMantenimiento"));
				camion.setKmRecorridosEnViaje(rs.getDouble("kmRecorridosEnViaje"));
				camion.setEstado(new Camion().dameNombreEstado(rs.getString("estado")));			
			}					
		} 
		catch (SQLException e) 
		{		
			e.printStackTrace();
		}	
		finally
		{
			CerrarConexion();			
		}	
		
		return camion;
	}
	
	// Agrega un nuevo camion
	public void agregarCamion(Camion camion)
	{		
		String sql = "INSERT INTO camiones(patente,marca,modelo,descripcion,kmRecorridosDesdeMantenimiento,kmRecorridosEnViaje,estado) values (?,?,?,?,?,?,?)";
			
		try 
		{				
			AbrirConexion(sql);
				
			sentencia.setString(1, camion.getPatente());
			sentencia.setString(2, camion.getMarca());
			sentencia.setString(3, camion.getModelo());
			sentencia.setString(4, camion.getDescripcion());
			sentencia.setDouble(5, camion.getKmRecorridosDesdeMantenimiento());
			sentencia.setDouble(6, camion.getKmRecorridosEnViaje());
			sentencia.setString(7, camion.getEstado().toString());
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
	
	// Modifica un camion	
	public void modificarCamion(Camion camion)
	{
		String sql = "UPDATE camiones SET marca=?, modelo=?, descripcion=?, kmRecorridosDesdeMantenimiento=? , kmRecorridosEnViaje=?, estado=? WHERE patente=?";
		
		try
		{			
			AbrirConexion(sql);
			sentencia.setString(1, camion.getMarca());
			sentencia.setString(2, camion.getModelo());
			sentencia.setString(3, camion.getDescripcion());
			sentencia.setDouble(4, camion.getKmRecorridosDesdeMantenimiento());
			sentencia.setDouble(5, camion.getKmRecorridosEnViaje());
			sentencia.setString(6, camion.getEstado().toString());
			
			sentencia.setString(7, camion.getPatente());
			sentencia.executeUpdate();			
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
	
	// Elimina un camion (baja fisica, se elimina definitivamente de los registros)
	public void eliminarCamion(String patente)
	{
		String sql = "DELETE FROM camiones WHERE patente like ?";
		
		try
		{			
			AbrirConexion(sql);
			sentencia.setString(1, patente);
			sentencia.executeUpdate();								
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

	// Verifica existencia del camion: devuelve true si existe algun camion con la patente ingresada. Caso contrario, devuelve false.
	// Cuenta la cantidad de registros que coinciden con la patente (teoricamente debería existir 1 solo registro)
	public boolean existePatente(String patente) {
		
		String sql = "SELECT COUNT(*) as cant FROM camiones WHERE patente like ?";
		ResultSet rs = null;
		boolean est = false;
		
		try
		{
			AbrirConexion(sql);
			sentencia.setString(1, patente);
			rs = sentencia.executeQuery();
			
			if(rs.next())
			{
				if(rs.getInt("cant")>0)
				{
					est = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CerrarConexion();
		}
		
		return est;
	}
			
}
