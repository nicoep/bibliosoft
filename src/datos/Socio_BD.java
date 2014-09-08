package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Socio_BD {
	private Connection connection;

	public void altaSocio(String nombre, String apellido, String dni,
			String direccion, String telefono, String email, String legajo)
			throws SQLException {
		Conexion_BD con = new Conexion_BD();
		connection = con.openConnection();

		PreparedStatement statement = connection
				.prepareStatement("INSERT INTO socio (idSocio, nombre, apellido, dni, direccion, email, legajo, telefono, fechaAlta, estado) VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
		statement.setString(1, nombre);
		statement.setString(2, apellido);
		statement.setString(3, dni);
		statement.setString(4, direccion);
		statement.setString(5, email);
		statement.setString(6, legajo);
		statement.setString(7, telefono);
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date fecha_hoy = new java.sql.Date(utilDate.getTime());
		statement.setDate(8, fecha_hoy);
		statement.setString(9, "1");

		int resultado = statement.executeUpdate();

		System.out.println(resultado);
	}
}
