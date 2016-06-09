package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/* Conexi�n a la Base de Datos */

public class ConexionBD {
	
	private static ConexionBD instancia;

	/* Creo una instancia de la clase ConexionBD */ 

	public static ConexionBD getInstancia(){ //M�todo para obtener la �nica instancia
		if(instancia==null){
			instancia=new ConexionBD();
		}
		return instancia;
	}
	
	private static String dbUrl="jdbc:mysql://localhost:3306/sistema_camiones";
	private static String dbUser="root";
	private static String dbPassword="root";
	
	private ConexionBD(){}
	
	private Connection conexion;
	
	//Abrir la conexi�n
	
	public Connection getConn(){
		try {
			if(conexion==null || !conexion.isValid(3)){
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conexion=DriverManager.getConnection(dbUrl,dbUser,dbPassword);	
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conexion;
	}
	
	// Cerrar la conexi�n
	
	public void CloseConn(){
		try {
			if(conexion!=null && !conexion.isClosed()){
				conexion.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}


	