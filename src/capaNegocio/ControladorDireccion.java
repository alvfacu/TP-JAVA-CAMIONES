package capaNegocio;

import java.util.ArrayList;

import capaDatos.CatalogoDireccion;
import capaEntidades.Direccion;

public class ControladorDireccion {
	
	CatalogoDireccion direccionDatos;
	
	public ControladorDireccion()
	{
		this.direccionDatos = new CatalogoDireccion();
	}
		
	public ArrayList<Direccion> dameTodo()
	{
		return direccionDatos.dameTodo();
	}
	
	public ArrayList<Direccion> dameTodoXLocalidad(int id)
	{
		return direccionDatos.dameTodoPorLocalidad(id);
	}
		
	public Direccion dameUno(int id)
	{
		return direccionDatos.dameUno(id);
	}

	public void agregarDireccion(Direccion dir)
	{
		direccionDatos.agregarDireccion(dir);
	}
	
	public void modificarDireccion(Direccion dir)
	{
		direccionDatos.modificarDireccion(dir);
	}
	
	public void eliminarDireccion(int id)
	{
		direccionDatos.eliminarDireccion(id);
	}
	
}
