package capaDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConexionBD;
import capaEntidades.Personal;

public class CatalogoPersonal extends Catalogo {

	public void agregarPersonal(Personal pe) {
		
		String sql = "INSERT INTO personal(dni,nombre,apellido,telefono,direccion,usuario,password,tipo,disponibilidad) values (?,?,?,?,?,?,?,?,?)";
		try 
		{			
				
			boolean rta = validarExistencia(pe);
			if (rta==false)
			{
				AbrirConexion(sql);
				sentencia.setString(1, pe.getDni());
				sentencia.setString(2, pe.getNombre());
				sentencia.setString(3, pe.getApellido());
				sentencia.setInt(4, pe.getTelefono());
				sentencia.setString(5, pe.getDireccion());
				sentencia.setString(6, pe.getUsuario());
				sentencia.setString(7, pe.getPassword());
				sentencia.setString(8,	pe.getTipo().toString());
				if(pe.isDisponibilidad())
				{
					sentencia.setBoolean(9, true);
					}
				else 
				{
					sentencia.setBoolean(9, false);
				}
				sentencia.execute(); 
			}} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			CerrarConexion();			
		}	
		
	}

	//Valida la existencia o no del Personal en la Base de Datos
	
	 private static boolean validarExistencia(Personal p) {
		boolean rta=false;	
		String sql = "SELECT nombre FROM PERSONAL WHERE dni IN (SELECT dni FROM PERSONAL where dni like ?)";
		ResultSet rs = null;
		try 
		{				
			AbrirConexion(sql);
			sentencia.setString(1,p.getDni());
			rs = sentencia.executeQuery(); 
			if (rs.next()){rta=true;} else {rta=false;}
			System.out.println(rta);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
		return rta;	
			
		
		
	}
	
	//Valida que las credenciales que ingreso en el Loggin sean correctas o no.

	public  Personal validarUsuario(String us, String pass) {
		
		
		String sql = "SELECT * FROM personal where usuario = ? and password = ?";
		PreparedStatement sentencia = null;
		Connection conn = ConexionBD.getInstancia().getConn();
		ResultSet rs= null ;
		Personal pe = new Personal();
		try 
		{
		
			sentencia = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			sentencia.setString(1, us);
			sentencia.setString(2, pass);
			rs = sentencia.executeQuery();

			if (rs.next())
			{ 			
				pe.setNombre(rs.getString("nombre"));
				pe.setApellido(rs.getString("apellido"));
				pe.setUsuario(rs.getString("usuario"));
				pe.setPassword(rs.getString("password"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				ConexionBD.getInstancia().CloseConn();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}			
		}
		
				
			return pe;
			
		
	}

	public ArrayList<Personal> dameTodos(){
		
		ArrayList<Personal> personales =null;
		
		String sql = "SELECT * FROM personal";
		ResultSet rs = null;
		
		
		try
		{				
			AbrirConexion(sql);
			rs = sentencia.executeQuery();
			
			personales = new ArrayList<Personal>();
			
			while(rs.next())
			{
				Personal pe = new Personal();
				pe.setDni(rs.getString("dni"));
				pe.setNombre(rs.getString("nombre"));
				pe.setApellido(rs.getString("apellido"));
				pe.setTelefono(rs.getInt("telefono"));
				pe.setDireccion(rs.getString("direccion"));
				pe.setUsuario(rs.getString("usuario"));
				pe.setPassword(rs.getString("password"));
				// pe.setDisponibilidad(rs.getDisponibilidad.("disponibilidad"));
				String tipo = rs.getString("tipo");
				pe.setTipo(new Personal().dameNombreTipo(tipo));				
				personales.add(pe);
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
		
		return null;
		
	
	}
	/*
	public  Personal dameUno(String dni){
		Personal p =null;
		String sql = "SELECT * FROM personal WHERE dni like ?";
		ResultSet rs = null;
	
	try
	{			
		AbrirConexion(sql);
		sentencia.setString(1, dni);
		rs = sentencia.executeQuery();
		
		if(rs.next())
		{
			p = new Personal();
			p.setDni(rs.getString("dni"));
			p.setNombre(rs.getString("nombre"));
			p.setApellido(rs.getString("apellido"));
			p.setTelefono(rs.getInt("telefono"));
			p.setDireccion(rs.getString("direccion"));
			p.setUsuario(rs.getString("usuario"));
			p.setPassword(rs.getString("password"));
			//p.setDisponibilidad()
			p.setTipo(new Personal().dameNombreTipo(rs.getString("tipo")));			
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
	}*/
	
}
	
