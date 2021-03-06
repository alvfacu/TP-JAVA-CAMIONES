package capaNegocio;

import java.io.IOException;
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
	
	public Personal dameUno(String patente) throws IOException
	{
		return datosPersonal.dameUno(patente);
	}

	public boolean existeDNI(String dni) {
		return datosPersonal.existeDNI(dni);
	}
	
}
