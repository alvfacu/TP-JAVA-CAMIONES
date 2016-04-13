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

	public boolean existePatente(String patente) {
		return camionDatos.existePatente(patente);
	}
	
	public void eliminarCamion(String patente)
	{
		camionDatos.eliminarCamion(patente);
	}
	
	public void modificarCamion(Camion cam)
	{
		camionDatos.modificarCamion(cam);
	}
}
