package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import capaEntidades.Demora;
import capaNegocio.ControladorDemora;

/**
 * Servlet implementation class ModificarDemora
 */
@WebServlet("/ModificarDemora")
public class ModificarDemora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarDemora() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorDemora cd = new ControladorDemora();	
		cd.eliminarDemora();
		Demora demoraNueva = new Demora();
		demoraNueva.setHoras(Integer.parseInt(request.getParameter("horas")));
		demoraNueva.setMinutos(Integer.parseInt(request.getParameter("minutos")));
		cd.agregarDemora(demoraNueva);
		response.sendRedirect("modificarDemora.jsp");
			
	}

}
