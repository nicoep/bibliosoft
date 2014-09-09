package negocio;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Socio_BD;

@SuppressWarnings("serial")
public class Servlet_Registro extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("se llamo al metodo doPost de Servlet_Registro");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String dni = request.getParameter("dni");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String legajo = request.getParameter("legajo");
		try {
			this.altaSocio(nombre, apellido, dni, direccion, telefono, email,
					legajo);
			response.sendRedirect("/bibliosoft/Catalogo.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void altaSocio(String nombre, String apellido, String dni,
			String direccion, String telefono, String email, String legajo)
			throws SQLException {
		Socio_BD sociobd = new Socio_BD();
		sociobd.altaSocio(nombre, apellido, dni, direccion, telefono, email,
				legajo);
	}
}
