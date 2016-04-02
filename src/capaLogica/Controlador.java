package capaLogica;

import capaEntidades.Personal;
import capaDatos.PersonalAdaptador;

public class Controlador {
	
	
/*public static void cargaCamion(){
	
	Camion  ca = new Camion("IHI",123,"FIAT","UNO","LINDO CAMION");
	CamionAdaptador.agregarCamion(ca);
}

public static void cargaCiudad(){
	Ciudad ciu = new Ciudad("San Pedro","Buenos Aires",2900);
	CiudadAdaptador.agregarCiudad(ciu);
}
*/
	/*public static void cargaPersonal() {
	Personal pe = new Personal("Martin","Guereta",37953038);
	PersonalAdaptador.agregarPersonal(pe);
	*/
	/*
public static void modificaDemora() {
	Demora demo = new Demora(Time.valueOf("06:00:00"));
	DemoraAdaptador.modificaDemora(demo);
}
	*/


public Personal validarUsuario(String us, String pass) {
	Personal pe = new Personal();
	PersonalAdaptador pa = new PersonalAdaptador();
	pe = pa.validarUsuario(us,pass);
	return pe;
}
}