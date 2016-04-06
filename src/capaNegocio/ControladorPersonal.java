package capaNegocio;

import java.util.ArrayList;

import capaDatos.CatalogoPersonal;
import capaEntidades.Personal;

public class ControladorPersonal {
	
	CatalogoPersonal datosPersonal;

	public ControladorPersonal() {
		
		this.datosPersonal = new CatalogoPersonal();
	}
	
	public void agregarPersonal(Personal pe){
		datosPersonal.agregarPersonal(pe);
	}
	
	public void modificarPersonal(Personal pe){
		datosPersonal.modificarPersonal(pe);
	}
	
	public void eliminarPersonal(Personal pe){
		datosPersonal.eliminarPersonal(pe);
	}
	
	public ArrayList<Personal> dameTodo()
	{
		return datosPersonal.dameTodo();
	}
	
	public Personal dameUno(String patente)
	{
		return datosPersonal.dameUno(patente);
	}
	
}
