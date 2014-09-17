package negocio;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Socio_BD;

@SuppressWarnings("serial")
public class Servlet_NuevoSocio extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String dni = request.getParameter("dni");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String legajo = request.getParameter("legajo");
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		try {
			this.altaSocio(nombre, apellido, dni, direccion, telefono, email, legajo, usuario, clave);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/bibliosoft/");

	}

	private void altaSocio(String nombre, String apellido, String dni,
			String direccion, String telefono, String email, String legajo,
			String usuario, String clave) throws SQLException {
		Socio_BD.altaSocio(nombre, apellido, dni, direccion, telefono, email, legajo, usuario, clave);
	}
}
