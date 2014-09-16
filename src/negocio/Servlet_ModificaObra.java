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
		int idObra = Integer.parseInt(request.getParameter("idObra"));
		String accion = request.getParameter("action");
		if (accion.contains("Eliminar")) {
			this.eliminarObra(idObra);
		} else {
			String cdu = request.getParameter("cdu");
			int stock = Integer.parseInt(request.getParameter("stock"));
			this.modificarObra(idObra, cdu, stock);
		}
		response.sendRedirect("/bibliosoft/");
			}

	private void eliminarObra(int idObra) {
		Obra_BD obra_bd = new Obra_BD();
		obra_bd.baja_obra(idObra);
	}

	private void modificarObra(int idObra, String cdu, int stock) {
		Obra_BD obra_db = new Obra_BD();
		obra_db.modificaObra(idObra, cdu, stock);
	}

}
