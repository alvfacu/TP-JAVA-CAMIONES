package capaEntidades;


public class Demora {
	
	

	private int horas;
	private int minutos;

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public Demora(int hora,int minutos){
		this.horas = hora;
		this.minutos = minutos;
		
	}

	public Demora() {
	}
	

}
