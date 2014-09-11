package negocio;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Prestamos_BD;

public class Servlet_NuevoPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet_NuevoPrestamo() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idSocio = 1;
		int idObra = 1;
		try {
			this.nuevoPrestamo(idSocio, idObra);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void nuevoPrestamo(int idSocio, int idObra) throws SQLException {
		Prestamos_BD prestamos_bd = new Prestamos_BD();
		prestamos_bd.nuevoPrestamo(idObra, idSocio);
	}

}
