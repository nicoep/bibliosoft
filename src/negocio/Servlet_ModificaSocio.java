package negocio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Socio_BD;

public class Servlet_ModificaSocio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet_ModificaSocio() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idSocio = Integer.parseInt(request.getParameter("idSocio"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String dni = request.getParameter("dni");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String legajo = request.getParameter("legajo");
		this.modificarSocio(idSocio, nombre, apellido, dni, direccion, telefono, email, legajo);
		response.sendRedirect("Listado_Socios.jsp");
	}

	private void modificarSocio(int idSocio, String nombre, String apellido, String dni,
			String direccion, String telefono, String email, String legajo) {
		Socio_BD.modificaSocio(idSocio, nombre, apellido, dni, direccion, telefono, email, legajo);
		
	}

}
