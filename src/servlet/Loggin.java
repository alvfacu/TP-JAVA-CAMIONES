package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import capaEntidades.Personal;
import capaNegocio.Controlador;

/**
 * Servlet implementation class Loggin
 */
@WebServlet("/Loggin")
public class Loggin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Loggin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String usuario = request.getParameter("user");
		String password = request.getParameter("pass");
		Personal pe = new Personal();
		Controlador c = new Controlador();
		pe = c.validarUsuario(usuario,password);
		if(pe==null) {
			request.getRequestDispatcher("error.html").forward(request,response);}
		else {
			sesion.setAttribute("usuario", pe);
			request.getRequestDispatcher("exito.html").forward(request,response);};
	}

}
