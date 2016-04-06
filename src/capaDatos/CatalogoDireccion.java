package capaDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import capaEntidades.Direccion;
import capaEntidades.Localidad;
import capaEntidades.Provincia;

public class CatalogoDireccion extends Catalogo{
	
	public ArrayList<Direccion> dameTodoXLocalidad(int idLoc)
	{
		ArrayList<Direccion> direcciones = null;
		
		String sql = "SELECT * FROM direcciones dir INNER JOIN localidades loc ON loc.idLocalidad = dir.idLocalidad INNER JOIN provincias prov ON loc.idProvincia = prov.idProvincia WHERE dir.idLocalidad = ?";
		ResultSet rs = null;
		
		try
		{
			AbrirConexion(sql);
			sentencia.setInt(1, idLoc);
			rs = sentencia.executeQuery();
			direcciones = new ArrayList<Direccion>();
			
			while(rs.next())
			{
				Direccion dir = new Direccion();
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
				if((boolean)val.equals(""))
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
				
				direcciones.add(dir);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CerrarConexion();
		}
		
		return direcciones;
	}

	public ArrayList<Direccion> dameTodo()
	{
		ArrayList<Direccion> direcciones = null;
		
		String sql = "SELECT * FROM direcciones dir INNER JOIN localidades loc ON loc.idLocalidad = dir.idLocalidad INNER JOIN provincias prov ON loc.idProvincia = prov.idProvincia";
		ResultSet rs = null;
		
		try
		{
			AbrirConexion(sql);
			rs = sentencia.executeQuery();
			direcciones = new ArrayList<Direccion>();
			
			while(rs.next())
			{
				Direccion dir = new Direccion();
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
				
				direcciones.add(dir);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CerrarConexion();
		}
		
		return direcciones;
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
