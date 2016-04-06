package capaNegocio;

import java.util.ArrayList;

import capaDatos.CatalogoCamion;
import capaEntidades.Camion;

public class ControladorCamion {
	
	CatalogoCamion camionDatos;
	
	public ControladorCamion() {
		
		this.camionDatos = new CatalogoCamion();
	}
	
	public ArrayList<Camion> dameTodo()
	{
		return camionDatos.dameTodo();
	}
	
	public Camion dameUno(String patente)
	{
		return camionDatos.dameUno(patente);
	}
	
	public void agregarCamion(Camion c)
	{
		camionDatos.agregarCamion(c);
	}

//Faltan los metodos de eliminar y modificar
}
