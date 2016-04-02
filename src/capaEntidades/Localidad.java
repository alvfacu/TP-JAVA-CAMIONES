package capaEntidades;

import java.util.ArrayList;

public class Localidad {
	
	private int idLocalidad;
	private String nombreLocalidad;
	private int codigoPostal;
	private Provincia prov;
	private ArrayList<Direccion> direcciones;
		
	public int getIdLocalidad() {
		return idLocalidad;
	}
	
	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	
	public String getNombreLocalidad() {
		return nombreLocalidad;
	}
	
	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}
	
	public Provincia getProv() {
		return prov;
	}
	
	public void setProv(Provincia prov) {
		this.prov = prov;
	}

	public ArrayList<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(ArrayList<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Localidad(int idLocalidad, int cp, String nombreLocalidad, Provincia prov) {
		super();
		this.idLocalidad = idLocalidad;
		this.codigoPostal = cp;
		this.nombreLocalidad = nombreLocalidad;
		this.prov = prov;		
	}

	public Localidad() {
		// TODO Auto-generated constructor stub
	}
	
}
