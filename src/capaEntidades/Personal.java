package capaEntidades;



public class Personal {

	public enum Tipo{
		Administrador,
		Camionero,
		Operador,
	}
		
	private String dni;
	private String nombre;
	private String apellido;
	private int telefono;
	private String direccion;	
	private String usuario;
	private String password;
	private boolean disponibilidad;
	private Tipo tipo;	
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
		
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public boolean getDisponibilidad(){
		return disponibilidad;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}	
	
	public Tipo dameNombreTipo(String tipo) {
		if(Tipo.Administrador.toString().compareToIgnoreCase(tipo) == 0)
		{
			return Tipo.Administrador;
		}
		else if(Tipo.Camionero.toString().compareToIgnoreCase(tipo) == 0)
		{
			return Tipo.Camionero;
		}
		else if(Tipo.Operador.toString().compareToIgnoreCase(tipo) == 0)
		{
			return Tipo.Camionero;
		}
		else
		{
			return null;
		}	
	}
	
	public Personal() {
		// TODO Auto-generated constructor stub
	}

	
	public Personal(String nombre, String apellido, String direccion, String dni, int tel, String usuario,
			String password, Tipo tipo, boolean disponible) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = tel;
		this.direccion = direccion;
		this.usuario = usuario;
		this.password = password;
		this.disponibilidad = disponible;
		this.tipo = tipo;
	}

	
	
}
