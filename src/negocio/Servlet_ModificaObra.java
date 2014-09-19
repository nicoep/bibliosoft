package negocio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Obra_BD;

public class Servlet_ModificaObra extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet_ModificaObra() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idObra = Integer.parseInt(request.getParameter("id"));
		String accion = request.getParameter("action");
		if (accion.contains("Eliminar")) {
			this.eliminarObra(idObra);
		} else {
			String titulo = request.getParameter("titulo");
			String autor = request.getParameter("autor");
			String editorial = request.getParameter("editorial");
			String cdu = request.getParameter("cdu");
			String isbn = request.getParameter("isbn");
			String imagen = request.getParameter("imagen");
			int stock = Integer.parseInt(request.getParameter("stock"));
			int tipoObra = Integer.valueOf(request.getParameter("tipoObra"));
			this.modificarObra(idObra, titulo, autor, editorial, cdu, isbn, imagen, stock, tipoObra);
		}
		response.sendRedirect("Home.jsp");
	}

	private void modificarObra(int idObra, String titulo, String autor, String editorial, String cdu, String isbn, String imagen, int stock, int tipoObra) {
		Obra_BD.modificaObra(idObra, titulo, autor, editorial, cdu, isbn, imagen, stock, tipoObra);
	}

	private void eliminarObra(int idObra) {
		Obra_BD.baja_obra(idObra);
	}
}
