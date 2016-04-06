package capaEntidades;

public class Direccion {
	
	private int idDireccion;
	private String calle;
	private int nro;
	private int piso;
	private char letra;
	private Localidad localidad;
	
	public int getIdDireccion() {
		return idDireccion;
	}
	
	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}
	
	public String getCalle() {
		return calle;
	}
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public int getNro() {
		return nro;
	}
	
	public void setNro(int nro) {
		this.nro = nro;
	}
	
	public int getPiso() {
		return piso;
	}
	
	public void setPiso(int piso) {
		this.piso = piso;
	}
	
	public char getDepto() {
		return letra;
	}
	
	public void setDepto(char depto) {
		this.letra = depto;
	}
	
	public Localidad getLoc() {
		return localidad;
	}
	
	public void setLoc(Localidad loc) {
		this.localidad = loc;
	}

	public Direccion(int idDireccion, String calle, int nro, int piso, char depto, Localidad loc) {
		super();
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.nro = nro;
		this.piso = piso;
		this.letra = depto;
		this.localidad = loc;
	}

	public Direccion(String calle, int nro, Localidad loc) {
		this.calle = calle;
		this.nro = nro;
		this.localidad = loc;
	}
	
	public Direccion() {
		// TODO Auto-generated constructor stub
	}

	public Direccion(String calle, int nro, int piso, char depto, Localidad loc) {
		this.calle = calle;
		this.nro = nro;
		this.piso = piso;
		this.letra = depto;
		this.localidad = loc;
	}	

}
