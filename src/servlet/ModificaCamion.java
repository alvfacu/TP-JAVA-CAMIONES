package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import capaEntidades.Camion;
import capaNegocio.ControladorCamion;

/**
 * Servlet implementation class ModificaCamion
 */
@WebServlet("/ModificaCamion")
public class ModificaCamion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaCamion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String patente = request.getParameter("patente");
		if(new ControladorCamion().existePatente(request.getParameter("patente")))
		{
		//elimino primero para poder modificar
		
		new ControladorCamion().eliminarCamion(patente);
		
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String descripcion = request.getParameter("descripcion");
		double kmi = CambiarComaPorPunto(request.getParameter("kmRecorridosEnViaje"));	
		Camion.Estado est = new Camion().dameNombreEstado(request.getParameter("estado"));
		Camion ca = new Camion(patente, marca, modelo, descripcion, kmi,0,est);
		new ControladorCamion().agregarCamion(ca);	
		response.sendRedirect("exito.html");
		}
	}
		private double CambiarComaPorPunto(String km) {
			if(km.contains(","))
			{
				km = km.replace(",",".");
			}
			return Double.valueOf(km);
		}
}
