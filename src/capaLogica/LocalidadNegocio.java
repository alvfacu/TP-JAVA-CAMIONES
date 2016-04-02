package capaLogica;

import java.util.ArrayList;

import capaDatos.LocalidadAdaptador;
import capaEntidades.Localidad;

public class LocalidadNegocio {
	
	private LocalidadAdaptador localidadDatos;
	
	public LocalidadNegocio()
	{
		this.localidadDatos = new LocalidadAdaptador();
	}

	public LocalidadAdaptador getLocalidadDatos() {
		return localidadDatos;
	}

	public void setLocalidadDatos(LocalidadAdaptador localidadDatos) {
		this.localidadDatos = localidadDatos;
	}
	
	public ArrayList<Localidad> dameTodo()
	{
		return localidadDatos.dameTodo();
	}

}
