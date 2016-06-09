package capaDatos;


import java.sql.ResultSet;
import java.sql.SQLException;


import capaEntidades.Demora;


public class CatalogoDemora extends Catalogo {

	// Demora dem = new Demora();
	
	public Demora dameDemoraActual() {
		Demora demora = null;
		String sql = "SELECT horas,minutos FROM demoras";
		ResultSet rs = null;

		try
		{			
			AbrirConexion(sql);
			rs = sentencia.executeQuery();

			if(rs.next())
			{
				demora = new Demora();
				demora.setHoras(rs.getInt("horas"));
				demora.setMinutos(rs.getInt("minutos"));
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

		return demora;
	}

	public void agregarDemora(Demora demora) {
		
		String sql = "INSERT INTO demoras (idDemora,horas,minutos) VALUES (?,?,?)";
		
		try 
		{				
			AbrirConexion(sql);

			sentencia.setInt(1, 1);
			sentencia.setInt(2, demora.getHoras());
			sentencia.setInt(3, demora.getMinutos());
			
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
	
	public void eliminarDemora(){
		String sql = "DELETE FROM demoras WHERE idDemora = 1";

		try
		{			
			AbrirConexion(sql);
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


	
}

