package consola;

import capaDatos.CamionAdaptador;
import capaEntidades.Camion;

public class Ejecuta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Camion camion = new CamionAdaptador().dameUno("HIV800");
		
		camion.setDescripcion("MUY BUENO");
		
		new CamionAdaptador().modificarCamion(camion);
		
		System.out.println(camion.getDescripcion());
		
	}

}
