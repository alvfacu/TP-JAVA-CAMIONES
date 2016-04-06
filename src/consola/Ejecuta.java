package consola;

import java.util.ArrayList;
import capaEntidades.Direccion;
import capaNegocio.ControladorDireccion;

public class Ejecuta {

	public static void main(String[] args) {		
				
		ArrayList<Direccion> direcciones = new ControladorDireccion().dameTodo();
		for(Direccion d : direcciones)
		{
			System.out.print(d.getCalle()+" "+d.getNro());
			if(!(d.getPiso()== 0))
			{
				System.out.print(" "+d.getPiso());
			}
			if(!(d.getDepto()=='0'))
			{
				System.out.print(" "+d.getDepto());
			}
			System.out.print(", "+d.getLoc().getNombreLocalidad()+", "+d.getLoc().getProv().getNombreProvincia()+"\n");
		}		
		
	}

}

