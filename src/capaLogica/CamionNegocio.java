package capaLogica;

import java.util.ArrayList;

import capaDatos.CamionAdaptador;
import capaEntidades.Camion;

public class CamionNegocio {
	
	CamionAdaptador camionDatos;
	
	public CamionNegocio() {
		
		this.camionDatos = new CamionAdaptador();
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


}
