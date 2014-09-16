package negocio;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Socio_BD;

public class Servlet_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet_Login() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("usuario");
		String pass = request.getParameter("clave");
		Integer id = Socio_BD.getUsuario(user, pass);
		request.getSession().setAttribute("user", id);
		response.sendRedirect(request.getParameter("origin"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
