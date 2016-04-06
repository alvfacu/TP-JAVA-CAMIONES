package capaNegocio;

import java.util.ArrayList;

import capaDatos.CatalogoLocalidad;
import capaEntidades.Localidad;

public class ControladorLocalidad {
	
	private CatalogoLocalidad localidadDatos;
	
	public ControladorLocalidad()
	{
		this.localidadDatos = new CatalogoLocalidad();
	}

	public CatalogoLocalidad getLocalidadDatos() {
		return localidadDatos;
	}

	public void setLocalidadDatos(CatalogoLocalidad localidadDatos) {
		this.localidadDatos = localidadDatos;
	}
	
	public ArrayList<Localidad> dameTodo()
	{
		return localidadDatos.dameTodo();
	}
	
	public Localidad dameUno(int id)
	{
		return localidadDatos.dameUno(id);
	}

}
