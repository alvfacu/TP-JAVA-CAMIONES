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

	// Agrega un nuevo personal
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

	// Valida la existencia o no del Personal en la Base de Datos
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
	
	// Valida que las credenciales que ingreso en el Loggin sean correctas o no.
	public Personal validarUsuario(String us, String pass) {
		
		
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

	// Trae todo el Personal registrado en la BD	
	public ArrayList<Personal> dameTodo(){
		
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
				pe.setDisponibilidad(rs.getBoolean("disponibilidad"));
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
	
	// Hay que ver como se maneja cuando no encuentra ninguno. 
	// Devuelve un objeto null si no encuentra ningún personal con el dni ingresado.
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
			p.setDisponibilidad(rs.getBoolean("Disponibilidad"));
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
	
	return p;
	}

	// Modifica un personal
	public void modificarPersonal(Personal p){
		
		String sql = "UPDATE Personal SET nombre=?, apellido=?, telefono=?,direccion=?,usuario=?,password=?,tipo=?,disponibilidad=? WHERE dni=?";
		
		try
		{	
			//Valido la existencia del Personal en la BD, si existe, lo modifico.
			
			boolean rta = validarExistencia(p);
			if (rta==true){
				AbrirConexion(sql);
				sentencia.setString(1, p.getDni());
				sentencia.setString(2, p.getNombre());
				sentencia.setString(3, p.getApellido());
				sentencia.setInt(4, p.getTelefono());
				sentencia.setString(5, p.getDireccion());
				sentencia.setString(6, p.getUsuario());
				sentencia.setString(7, p.getPassword());
				sentencia.setString(8,	p.getTipo().toString());
				if(p.isDisponibilidad())
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
		
	// Elimina un personal (baja física, se elimina definitivamente de la BD)
	public void eliminarPersonal(Personal p){
		
			String sql = "DELETE FROM personal WHERE dni like ?";
			
			try
			{	//Elimino si existe en la BD
				boolean rta = validarExistencia(p);
				if (rta==true){
				AbrirConexion(sql);
				sentencia.setString(1, p.getDni());
				sentencia.executeUpdate();								
			} }
			catch (SQLException e) 
			{		
				e.printStackTrace();
			}	
			finally
			{
				CerrarConexion();			
			}	
	}

	// Valida existencia del personal: devuelve true si existe algun personal con el dni ingresada. Caso contrario, devuelve false.
	// Cuenta la cantidad de registros que coinciden con el dni (teoricamente debería existir 1 solo registro)
	public boolean existeDNI(String dni) {
		
		String sql = "SELECT COUNT(*) as cant FROM personal WHERE dni like ?";
		ResultSet rs = null;
		boolean est = false;
		
		try
		{
			AbrirConexion(sql);
			sentencia.setString(1, dni);
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
