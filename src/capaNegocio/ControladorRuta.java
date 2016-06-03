package capaNegocio;

import java.util.ArrayList;

import capaDatos.CatalogoRuta;
import capaEntidades.Ruta;

public class ControladorRuta {
	
	CatalogoRuta datosRuta;
	
	public ControladorRuta()
	{
		this.datosRuta = new CatalogoRuta();
	}
	
	public ArrayList<Ruta> dameTodoXOrigen(int dirO)
	{
		return datosRuta.dameTodoXOrigen(dirO);
	}
	
	public ArrayList<Ruta> dameTodoXViaje(int viaje)
	{
		return datosRuta.dameTodoXViaje(viaje);
	}

}
