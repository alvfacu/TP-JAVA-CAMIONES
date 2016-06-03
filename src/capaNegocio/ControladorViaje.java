package capaNegocio;

import java.util.ArrayList;

import capaDatos.CatalogoViaje;
import capaEntidades.Viaje;

public class ControladorViaje{
	
	CatalogoViaje viajeDatos;
	
	public ControladorViaje() {
		
		this.viajeDatos = new CatalogoViaje();
	}
	
	public ArrayList<Viaje> dameTodo()
	{
		return viajeDatos.dameTodo();
	}
	
	public void agregarRuta(int viaje, int ruta)
	{
		viajeDatos.agregarRuta(viaje, ruta);
	}
	
}
