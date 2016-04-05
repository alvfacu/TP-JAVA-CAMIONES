package capaEntidades;

import java.util.ArrayList;

public class Provincia {

	private int idProvincia;
	private String nombreProvincia;
	private ArrayList<Localidad> localidades;
	
	public int getIdProvincia() {
		return idProvincia;
	}
	
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	
	public String getNombreProvincia() {
		return nombreProvincia;
	}
	
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}
	
	public ArrayList<Localidad> getLocalidades() {
		return localidades;
	}
	
	public void setLocalidades(ArrayList<Localidad> localidades) {
		this.localidades = localidades;
	}

	public Provincia(int idProvincia, String nombreProvincia) {
		super();
		this.idProvincia = idProvincia;
		this.nombreProvincia = nombreProvincia;
	}

	public Provincia() {
		// TODO Auto-generated constructor stub
	}	
	
}
