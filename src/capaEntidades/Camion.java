package capaEntidades;

public class Camion {

	public enum Estado{
		Disponible,
		Mantenimiento,
		Viajando,
		NoDisponible,
	}
	
	private String patente;
	private String marca;
	private String modelo;
	private String descripcion;
	private double kmRecorridosDesdeMantenimiento;
	private double kmRecorridosEnViaje;
	private Estado estado;
	
	public String getPatente() {
		return patente;
	}
	
	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public double getKmRecorridosDesdeMantenimiento() {
		return kmRecorridosDesdeMantenimiento;
	}
	
	public void setKmRecorridosDesdeMantenimiento(double kmRecorridosDesdeMantenimiento) {
		this.kmRecorridosDesdeMantenimiento = kmRecorridosDesdeMantenimiento;
	}
	
	public double getKmRecorridosEnViaje() {
		return kmRecorridosEnViaje;
	}
	
	public void setKmRecorridosEnViaje(double kmRecorridosEnViaje) {
		this.kmRecorridosEnViaje = kmRecorridosEnViaje;
	}
	
	public Estado getEstado() {
		return estado;
	}
		
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Camion(String patente, String marca, String modelo, String descripcion,
			double kmRecorridosDesdeMantenimiento, double kmRecorridosEnViaje, Estado estado) {
		super();
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.descripcion = descripcion;
		this.kmRecorridosDesdeMantenimiento = kmRecorridosDesdeMantenimiento;
		this.kmRecorridosEnViaje = kmRecorridosEnViaje;
		this.estado = estado;
	}

	public Camion() {
		// TODO Auto-generated constructor stub
	}
	
	//Devuelve el tipo de Estado en base al estado con el que se encuentra registrado en la BD (pasamos string a enum Estado)
	public Estado dameNombreEstado(String estado)
	{		
		if(Estado.Disponible.toString().compareToIgnoreCase(estado) == 0)
		{
			return Estado.Disponible;
		}
		else if(Estado.NoDisponible.toString().compareToIgnoreCase(estado) == 0)
		{
			return Estado.NoDisponible;
		}
		else if(Estado.Viajando.toString().compareToIgnoreCase(estado) == 0)
		{
			return Estado.Viajando;
		}
		else if(Estado.Mantenimiento.toString().compareToIgnoreCase(estado) == 0)
		{
			return Estado.Mantenimiento;
		}
		else
		{
			return null;
		}
	}
	
}
