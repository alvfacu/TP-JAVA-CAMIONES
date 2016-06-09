package capaNegocio;

import capaDatos.CatalogoDemora;
import capaEntidades.Demora;

public class ControladorDemora {
	 CatalogoDemora cd = new CatalogoDemora();

	public Demora dameDemoraActual() {
		Demora demora = new Demora();
		demora = cd.dameDemoraActual();
	return demora;
	}

	public void agregarDemora(Demora dem) {

		cd.agregarDemora(dem);
		
	}
	
	public void eliminarDemora() {
		cd.eliminarDemora();
		
	}

}
