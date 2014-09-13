package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Socio_BD {
	private Connection connection;

	public void altaSocio(String nombre, String apellido, String dni,
			String direccion, String telefono, String email, String legajo,
			String usuario, String contraseña) throws SQLException {
		Conexion_BD con = new Conexion_BD();
		connection = con.openConnection();
		try {
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO socio (idSocio, nombre, apellido, dni, direccion, email, legajo, telefono, fechaAlta, usuario, clave) VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
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
			statement.setString(9, usuario);
			statement.setString(10, contraseña);
			if (statement.executeUpdate() == 0) {
				throw new RuntimeException("Error modificando obra");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
	}

	public void bajaSocio(int idSocio) throws SQLException {
		Conexion_BD con = new Conexion_BD();
		connection = con.openConnection();
		PreparedStatement statement = connection
				.prepareStatement("DELETE * FROM socio WHERE idSocio=?");
		statement.setInt(1, idSocio);
		int resultado = statement.executeUpdate();
		System.out.println(resultado);

	}

	public void getUsuario(String user, String pass) throws SQLException {
		Conexion_BD con = new Conexion_BD();
		connection = con.openConnection();
		PreparedStatement statement = connection
				.prepareStatement("SELECT * FROM socio WHERE usuario=? AND contrase��a=?");
		statement.setString(1, user);
		statement.setString(2, pass);
		ResultSet resultado = statement.executeQuery();
		if (resultado != null) {
			System.out.println("login ok");
		} else {
			System.out.println("usuario y/o clave incorrecta");
		}

	}
}
