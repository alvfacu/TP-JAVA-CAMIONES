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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}	
	
	public Personal() {
		// TODO Auto-generated constructor stub
	}

	public Personal(String dni, String nombre, String apellido, int telefono, String direccion, String usuario,
			String password, boolean disponibilidad, Tipo tipo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.usuario = usuario;
		this.password = password;
		this.disponibilidad = disponibilidad;
		this.tipo = tipo;
	}
	
}
