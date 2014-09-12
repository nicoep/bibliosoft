package negocio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Obra_BD;

public class Servlet_AltaObra extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet_AltaObra() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String editorial = request.getParameter("editorial");
		String cdu = request.getParameter("cdu");
		String isbn = request.getParameter("isbn");
		String imagen = request.getParameter("imagen");
		int stock = Integer.parseInt(request.getParameter("stock"));
		int idTipo = Integer.parseInt(request.getParameter("tipoObra"));
		this.altaObra(titulo, autor, editorial, cdu, isbn, stock, idTipo,
				imagen);
		response.sendRedirect("/bibliosoft/");

	}

	private void altaObra(String titulo, String autor, String editorial,
			String cdu, String isbn, int stock, int idTipo, String imagen) {
		Obra_BD obra_bd = new Obra_BD();
		obra_bd.alta_obra(titulo, autor, editorial, cdu, isbn, stock, idTipo,
				imagen);
	}

}
