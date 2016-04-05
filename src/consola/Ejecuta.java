package consola;

import capaDatos.CatalogoCamion;
import capaEntidades.Camion;

public class Ejecuta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Camion camion = new CatalogoCamion().dameUno("HIV800");
		
		camion.setDescripcion("MUY BUENO");
		
		new CatalogoCamion().modificarCamion(camion);
		
		System.out.println(camion.getDescripcion());
		
	}

}
