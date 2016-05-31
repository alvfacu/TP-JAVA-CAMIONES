package capaEntidades;

import java.util.ArrayList;
import java.util.Calendar;


public class Viaje {

	public enum Estado{
		Iniciado,
		Cancelado,
		NoIniciado,
		Finalizado,
	}
	
	private int nroViaje;
	private Calendar fechaHoraSalidaPactada;
	private Calendar fechaHoraSalidaReal;
	private Calendar fechaHoraLlegadaPactada;
	private Calendar fechaHoraLlegadaReal;
	private double kmTotales;
	private double kmReales;
	private Estado estado;
	private Personal camionero;
	private Camion camion;
	private ArrayList<Ruta> rutas;
	
	public Estado dameNombreEstado(String estado)
	{		
		if(Estado.Iniciado.toString().compareToIgnoreCase(estado) == 0)
		{
			return Estado.Iniciado;
		}
		else if(Estado.Cancelado.toString().compareToIgnoreCase(estado) == 0)
		{
			return Estado.Cancelado;
		}
		else if(Estado.NoIniciado.toString().compareToIgnoreCase(estado) == 0)
		{
			return Estado.NoIniciado;
		}
		else if(Estado.Finalizado.toString().compareToIgnoreCase(estado) == 0)
		{
			return Estado.Finalizado;
		}
		else
		{
			return null;
		}
	}
	
	
	public int getNroViaje() {
		return nroViaje;
	}
	
	public void setNroViaje(int nroViaje) {
		this.nroViaje = nroViaje;
	}
	
	public Calendar getFechaHoraSalidaPactada() {
		return fechaHoraSalidaPactada;
	}
	
	public void setFechaHoraSalidaPactada(Calendar cal) {
		this.fechaHoraSalidaPactada = cal;
	}
	
	public Calendar getFechaHoraSalidaReal() {
		return fechaHoraSalidaReal;
	}
	
	public void setFechaHoraSalidaReal(Calendar cal) {
		this.fechaHoraSalidaReal = cal;
	}
	
	public Calendar getFechaHoraLlegadaPactada() {
		return fechaHoraLlegadaPactada;
	}
	
	public void setFechaHoraLlegadaPactada(Calendar fechaHoraLlegadaPactada) {
		this.fechaHoraLlegadaPactada = fechaHoraLlegadaPactada;
	}
	
	public Calendar getFechaHoraLlegadaReal() {
		return fechaHoraLlegadaReal;
	}
	
	public void setFechaHoraLlegadaReal(Calendar fechaHoraLlegadaReal) {
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

	public Viaje(int nroViaje, Calendar fechaHoraSalidaPactada, Calendar fechaHoraSalidaReal, Calendar fechaHoraLlegadaPactada,
			Calendar fechaHoraLlegadaReal, double kmTotales, double kmReales, Estado estado, Personal camionero,
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

	public Viaje() {
		// TODO Auto-generated constructor stub
	}	
}
