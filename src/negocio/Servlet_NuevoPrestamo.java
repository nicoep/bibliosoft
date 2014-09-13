package negocio;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Prestamo_BD;

public class Servlet_NuevoPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet_NuevoPrestamo() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("idObra"));
		int idObra = Integer.parseInt(request.getParameter("idObra"));
		int idSocio = 1;
		try {
			this.nuevoPrestamo(idSocio, idObra);
			response.sendRedirect("/bibliosoft/");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void nuevoPrestamo(int idSocio, int idObra) throws SQLException {
		Prestamo_BD prestamos_bd = new Prestamo_BD();
		prestamos_bd.nuevoPrestamo(idObra, idSocio);
	}

}
