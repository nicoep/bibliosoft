package negocio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Socio_BD;

public class Servlet_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet_Login() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String user = request.getParameter("usuario");
		String pass = request.getParameter("clave");
		Integer id = Socio_BD.getUsuario(user, pass);
		if (id != null) {
			sesion.setAttribute("user", id);
			response.sendRedirect("");
		} else {
			sesion.setAttribute("login", null);
			response.sendRedirect("InicioSesion.jsp");
		}
	
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sesion = req.getSession();
		sesion.invalidate();
		resp.sendRedirect("Home.jsp");
	}
}
