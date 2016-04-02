package capaEntidades;

public class Ruta {

	private int idRuta;
	private Direccion dirOrigen;
	private Direccion dirDestino;
	private double distancia;

	public int getIdRuta() {
		return idRuta;
	}

	public void setIdRuta(int idRuta) {
		this.idRuta = idRuta;
	}
	
	public Direccion getDirOrigen() {
		return dirOrigen;
	}
	
	public void setDirOrigen(Direccion dirOrigen) {
		this.dirOrigen = dirOrigen;
	}
	
	public Direccion getDirDestino() {
		return dirDestino;
	}
	
	public void setDirDestino(Direccion dirDestino) {
		this.dirDestino = dirDestino;
	}
	
	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public Ruta(int idRuta, Direccion dirOrigen, Direccion dirDestino, double distancia) {
		super();
		this.idRuta = idRuta;
		this.dirOrigen = dirOrigen;
		this.dirDestino = dirDestino;
		this.distancia = distancia;
	}
	
}
