package capaEntidades;

import java.util.ArrayList;
import java.util.Date;

public class Viaje {

	public enum Estado{
		Iniciado,
		Cancelado,
		NoIniciado,
		Finalizado,
	}
	
	private int nroViaje;
	private Date fechaHoraSalidaPactada;
	private Date fechaHoraSalidaReal;
	private Date fechaHoraLlegadaPactada;
	private Date fechaHoraLlegadaReal;
	private double kmTotales;
	private double kmReales;
	private Estado estado;
	private Personal camionero;
	private Camion camion;
	private ArrayList<Ruta> rutas;
	
	public int getNroViaje() {
		return nroViaje;
	}
	
	public void setNroViaje(int nroViaje) {
		this.nroViaje = nroViaje;
	}
	
	public Date getFechaHoraSalidaPactada() {
		return fechaHoraSalidaPactada;
	}
	
	public void setFechaHoraSalidaPactada(Date fechaHoraSalidaPactada) {
		this.fechaHoraSalidaPactada = fechaHoraSalidaPactada;
	}
	
	public Date getFechaHoraSalidaReal() {
		return fechaHoraSalidaReal;
	}
	
	public void setFechaHoraSalidaReal(Date fechaHoraSalidaReal) {
		this.fechaHoraSalidaReal = fechaHoraSalidaReal;
	}
	
	public Date getFechaHoraLlegadaPactada() {
		return fechaHoraLlegadaPactada;
	}
	
	public void setFechaHoraLlegadaPactada(Date fechaHoraLlegadaPactada) {
		this.fechaHoraLlegadaPactada = fechaHoraLlegadaPactada;
	}
	
	public Date getFechaHoraLlegadaReal() {
		return fechaHoraLlegadaReal;
	}
	
	public void setFechaHoraLlegadaReal(Date fechaHoraLlegadaReal) {
		this.fechaHoraLlegadaReal = fechaHoraLlegadaReal;
	}
	
	public double getKmTotales() {
		return kmTotales;
	}
	
	public void setKmTotales(double kmTotales) {
		this.kmTotales = kmTotales;
	}
	
	public double getKmReales() {
		return kmReales;
	}
	
	public void setKmReales(double kmReales) {
		this.kmReales = kmReales;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Personal getCamionero() {
		return camionero;
	}
	
	public void setCamionero(Personal camionero) {
		this.camionero = camionero;
	}
	
	public Camion getCamion() {
		return camion;
	}
	
	public void setCamion(Camion camion) {
		this.camion = camion;
	}
	
	public ArrayList<Ruta> getRutas() {
		return rutas;
	}
	
	public void setRutas(ArrayList<Ruta> rutas) {
		this.rutas = rutas;
	}

	public Viaje(int nroViaje, Date fechaHoraSalidaPactada, Date fechaHoraSalidaReal, Date fechaHoraLlegadaPactada,
			Date fechaHoraLlegadaReal, double kmTotales, double kmReales, Estado estado, Personal camionero,
			Camion camion, ArrayList<Ruta> rutas) {
		super();
		this.nroViaje = nroViaje;
		this.fechaHoraSalidaPactada = fechaHoraSalidaPactada;
		this.fechaHoraSalidaReal = fechaHoraSalidaReal;
		this.fechaHoraLlegadaPactada = fechaHoraLlegadaPactada;
		this.fechaHoraLlegadaReal = fechaHoraLlegadaReal;
		this.kmTotales = kmTotales;
		this.kmReales = kmReales;
		this.estado = estado;
		this.camionero = camionero;
		this.camion = camion;
		this.rutas = rutas;
	}	
}
