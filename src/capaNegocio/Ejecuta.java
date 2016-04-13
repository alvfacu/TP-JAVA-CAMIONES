package capaNegocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import capaDatos.CatalogoDireccion;
import capaDatos.CatalogoMantenimiento;
import capaDatos.CatalogoRuta;
import capaEntidades.Camion;
import capaEntidades.Direccion;
import capaEntidades.Mantenimiento;
import capaEntidades.Mantenimiento.Tipo;
import capaEntidades.Ruta;


public class Ejecuta {

	// MESA DE PRUEBA

	public static void main(String[] args) {
		
		// Controlador.cargaCamion();
		// Controlador.cargaCiudad();
	//	 Controlador.cargaPersonal();
			//Controlador.modificaDemora();
	/*	 String dni="37999000";
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
		cp.eliminarPersonal(p);
*/	
		
	/* Calendar calendario = Calendar.getInstance();
	calendario.set(2015, 02, 24, 03, 02, 24);
	System.out.print(calendario.get(2));*/ 
		
		/*ControladorCamion cc = new ControladorCamion();
		Camion ca = new Camion();
		ca = cc.dameUno("HIV800");
		
		ControladorMantenimiento cm = new ControladorMantenimiento();
		Calendar fechaHM = Calendar.getInstance();
		fechaHM.set(2016,02,01,21,02,21);
		Calendar fechaHE = Calendar.getInstance();
		fechaHE.set(2016,02,01,19,02,21);		
		Calendar fechaHI = Calendar.getInstance();
		fechaHI.set(2016,02,01,18,02,21);
		Tipo tipo = Mantenimiento.Tipo.Arreglo_General;
		Double kmIn = 900.00;
		Double kmE = 1000.00;

		
		Mantenimiento man = new Mantenimiento(fechaHM,fechaHI,fechaHE,tipo,kmIn,kmE,ca);
		cm.agregarMantenimiento(man);*/
		
		ArrayList<Ruta> mas = new CatalogoRuta().dameTodoXOrigen(21);
		
		for(int i=0;i<mas.size();i++)
		{
			System.out.println(mas.get(i).getDistancia()+" | "+mas.get(i).getDirOrigen().getLoc().getNombreLocalidad()+" | "+mas.get(i).getDirDestino().getLoc().getNombreLocalidad());
		}
	
	
	}

}
