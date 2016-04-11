package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import capaEntidades.Personal;
import capaNegocio.ControladorPersonal;

/**
 * Servlet implementation class AltaPersonal
 */
@WebServlet("/AltaPersonal")
public class AltaPersonal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaPersonal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dni = request.getParameter("dni");
		if(!(new ControladorPersonal().existeDNI(dni)))
		{
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String direccion = request.getParameter("direccion");
			int telefono = Integer.parseInt(request.getParameter("telefono"));
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");
			Personal.Tipo tipo = new Personal().dameNombreTipo(request.getParameter("tipo"));
			boolean disponible = Boolean.parseBoolean(request.getParameter("disponibilidad"));
			Personal per = new Personal(nombre,apellido,direccion,dni,telefono,usuario,password,tipo,disponible);
			new ControladorPersonal().agregarPersonal(per);
			response.sendRedirect("exito.html");
		}
		else
		{
			response.sendRedirect("error.html");
		}
			
		
		
		
		
	}

}
