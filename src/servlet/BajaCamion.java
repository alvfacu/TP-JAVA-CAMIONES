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
 * Servlet implementation class BajaCamion
 */
@WebServlet("/BajaCamion")
public class BajaCamion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaCamion() {
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
		if((new ControladorCamion().existePatente(request.getParameter("patente"))))
		{
		
			new ControladorCamion().eliminarCamion(patente);	
			response.sendRedirect("bajaCamiones.jsp");
		}
		else
		{
			response.sendRedirect("error.html");
		}
	}

}
