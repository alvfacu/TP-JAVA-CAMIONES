package capaNegocio;

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
}
