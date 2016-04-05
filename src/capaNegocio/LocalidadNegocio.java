package capaNegocio;

import java.util.ArrayList;

import capaDatos.CatalogoLocalidad;
import capaEntidades.Localidad;

public class LocalidadNegocio {
	
	private CatalogoLocalidad localidadDatos;
	
	public LocalidadNegocio()
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

}
