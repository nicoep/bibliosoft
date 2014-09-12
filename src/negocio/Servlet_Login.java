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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("usuario");
		String pass = request.getParameter("contraseña");
		try {
			this.getUsuario(user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/bibliosoft/Listado_Obras.jsp");
	}

	private void getUsuario(String user, String pass) throws SQLException {
		Socio_BD socio_bd = new Socio_BD();
		socio_bd.getUsuario(user, pass);
	}

}