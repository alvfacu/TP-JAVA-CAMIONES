package capaNegocio;

import capaEntidades.Personal;
import capaEntidades.Personal.Tipo;

public class Ejecuta {
	
	// MESA DE PRUEBA

	public static void main(String[] args) {
		
		// Controlador.cargaCamion();
		// Controlador.cargaCiudad();
	//	 Controlador.cargaPersonal();
			//Controlador.modificaDemora();
		 String dni="37999000";
		 String nombre="mariano";
		 String apellido="roberto";
		 int telefono=42123;
		 String direccion="Bernardo";	
		 String usuario="martial";
		 String password="123";
		 boolean disponibilidad=true;
		 Tipo tipo= Tipo.Administrador;
		Personal p = new Personal(dni,nombre,apellido,telefono,direccion,usuario,password, disponibilidad,tipo);
		ControladorPersonal cp = new ControladorPersonal();
		cp.agregarPersonal(p);
	}

}
