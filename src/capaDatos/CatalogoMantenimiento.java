package capaDatos;

import java.sql.SQLException;

import capaEntidades.Mantenimiento;

public class CatalogoMantenimiento extends Catalogo {

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
		
}
