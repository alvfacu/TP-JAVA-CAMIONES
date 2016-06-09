package consola;

import capaEntidades.Demora;
import capaNegocio.ControladorDemora;

public class Ejecuta {

	public static void main(String[] args) {
	
		// Demora demora = new Demora(6000);
		ControladorDemora cd = new ControladorDemora();
		Demora demora = new Demora();
		demora = cd.dameDemoraActual();
		System.out.println(demora.getHoras());
		System.out.println(demora.getMinutos());
	
	}
}
