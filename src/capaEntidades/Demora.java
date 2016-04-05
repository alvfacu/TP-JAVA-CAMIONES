package capaEntidades;

import java.sql.Time;

public class Demora {
	
	private Time demora;

	public Time getDemora() {
		return demora;
	}

	public void setDemora(Time demora) {
		this.demora = demora;
	}

	public Demora(Time dem){
		this.demora = dem;
	}
	

}
