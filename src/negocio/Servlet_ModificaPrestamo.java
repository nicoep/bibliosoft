package negocio;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Prestamo_BD;

public class Servlet_ModificaPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet_ModificaPrestamo() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("action");
		int idPrestamo = Integer.valueOf(request.getParameter("idPrestamo"));
		if (accion.contains("Cancelar")) {
			Prestamo_BD.cancelaPrestamo(idPrestamo);
		} else if (accion.contains("Retirar")) {
			Prestamo_BD.registraPrestamo(idPrestamo);
		} else if (accion.contains("Finalizar")) {
			Prestamo_BD.finalizaPrestamo(idPrestamo);
		}
		response.sendRedirect("/bibliosoft/Listado_Prestamos.jsp");
	}

}
