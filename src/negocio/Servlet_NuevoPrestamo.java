package negocio;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Obra_BD;
import datos.Prestamo_BD;

public class Servlet_NuevoPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet_NuevoPrestamo() {
		super();
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("/bibliosoft/InicioSesion.jsp");
		} else {
			int idObra = Integer.parseInt(request.getParameter("idObra"));
			int idSocio = (int) request.getSession().getAttribute("user");
			int stockObra = Obra_BD.getStock(idObra);
			Prestamo_BD.nuevoPrestamo(idObra, idSocio, stockObra);
			response.sendRedirect("/bibliosoft/Comprobante.jsp?id="+idObra);
		}
		
	}

}
