package capaNegocio;

import capaEntidades.Mantenimiento;
import capaDatos.CatalogoMantenimiento;

public class ControladorMantenimiento {
	
	CatalogoMantenimiento mantenimientoDatos;

	public ControladorMantenimiento(){
		
		this.mantenimientoDatos = new CatalogoMantenimiento();
		
	}
		
	public  void agregarMantenimiento(Mantenimiento man) {
		
	mantenimientoDatos.agregarMantenimiento(man);
	
	}

	
	
	
}
