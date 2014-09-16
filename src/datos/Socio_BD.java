package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Socio;

public class Socio_BD {
	public static Socio getSocio(int idSocio) {
		Conexion_BD con = new Conexion_BD();
		PreparedStatement statement;
		Socio s = null;
		try {
			statement = con.connection
					.prepareStatement("SELECT * FROM socio WHERE idSocio=?");
			statement.setInt(1, idSocio);
			ResultSet resultado = statement.executeQuery();
			while (resultado.next()) {
				Socio socio = new Socio();
				socio.setApellido(resultado.getString("apellido"));
				socio.setClave(resultado.getString("clave"));
				socio.setDireccion(resultado.getString("direccion"));
				socio.setDni(resultado.getString("dni"));
				socio.setEmail(resultado.getString("email"));
				socio.setIdSocio(resultado.getInt("idSocio"));
				socio.setLegajo(resultado.getString("legajo"));
				socio.setNombre(resultado.getString("nombre"));
				socio.setTelefono(resultado.getString("telefono"));
				socio.setUsuario(resultado.getString("usuario"));
				s = socio;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
		return s;
	}

	public static void altaSocio(String nombre, String apellido, String dni,
			String direccion, String telefono, String email, String legajo,
			String usuario, String contraseña) throws SQLException {
		Conexion_BD con = new Conexion_BD();
		try {
			PreparedStatement statement = con.connection
					.prepareStatement("INSERT INTO socio (idSocio, nombre, apellido, dni, direccion, email, legajo, telefono, usuario, clave) VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			statement.setString(1, nombre);
			statement.setString(2, apellido);
			statement.setString(3, dni);
			statement.setString(4, direccion);
			statement.setString(5, email);
			statement.setString(6, legajo);
			statement.setString(7, telefono);
			statement.setString(8, usuario);
			statement.setString(9, contraseña);
			if (statement.executeUpdate() == 0) {
				throw new RuntimeException("Error modificando obra");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
	}

	// public void bajaSocio(int idSocio) throws SQLException {
	// Conexion_BD con = new Conexion_BD();
	// connection = con.openConnection();
	// PreparedStatement statement =
	// connection.prepareStatement("DELETE FROM socio WHERE idSocio=?");
	// statement.setInt(1, idSocio);
	// int resultado = statement.executeUpdate();
	// }

	public static Integer getUsuario(String user, String pass) {
		try {
			Conexion_BD con = new Conexion_BD();
			PreparedStatement statement = con.connection
					.prepareStatement("SELECT * FROM socio WHERE usuario=? AND clave=?");
			statement.setString(1, user);
			statement.setString(2, pass);
			ResultSet resultado = statement.executeQuery();
			if (resultado.next()) {
				return resultado.getInt("idSocio");
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static ArrayList<Socio> buscarSocios(String busqueda) {
		Conexion_BD con = new Conexion_BD();
		try {
			PreparedStatement statement;
			if (busqueda != null && !busqueda.isEmpty()) {
				statement = con.connection
						.prepareStatement("SELECT * FROM socio WHERE legajo=?");
				statement.setString(1, busqueda);
			} else {
				statement = con.connection
						.prepareStatement("SELECT * FROM socio");
			}
			ResultSet resultado = statement.executeQuery();
			ArrayList<Socio> socios = new ArrayList<>();
			while (resultado.next()) {
				Socio s = new Socio();
				s.setApellido(resultado.getString("apellido"));
				s.setClave(resultado.getString("clave"));
				s.setDireccion(resultado.getString("direccion"));
				s.setDni(resultado.getString("dni"));
				s.setEmail(resultado.getString("email"));
				s.setIdSocio(resultado.getInt("idSocio"));
				s.setLegajo(resultado.getString("legajo"));
				s.setNombre(resultado.getString("nombre"));
				s.setTelefono(resultado.getString("telefono"));
				s.setUsuario(resultado.getString("usuario"));
				socios.add(s);
			}
			resultado.close();
			return socios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
	}

	public static String traerLegajo(int idSocio) {
		Conexion_BD con = new Conexion_BD();
		try {
			PreparedStatement statement;
			statement = con.connection
					.prepareStatement("SELECT legajo FROM socio WHERE idSocio=?");
			statement.setInt(1, idSocio);
			ResultSet resultado = statement.executeQuery();

			if (resultado.next()) {
				String legajo = resultado.getString("legajo");
				return legajo;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
		return null;
	}

	public static void modificaSocio(int idSocio, String nombre,
			String apellido, String dni, String direccion, String telefono,
			String email, String legajo) {
		Conexion_BD con = new Conexion_BD();
		try {
			PreparedStatement statement;
			statement = con.connection
					.prepareStatement("UPDATE socio SET nombre=?, apellido=?, dni=?, direccion=?, telefono=?, email=?, legajo=? WHERE idSocio=?");
			statement.setString(1, nombre);
			statement.setString(2, apellido);
			statement.setString(3, dni);
			statement.setString(4, direccion);
			statement.setString(5, telefono);
			statement.setString(6, email);
			statement.setString(7, legajo);
			statement.setInt(8, idSocio);
			if (statement.executeUpdate() == 0) {
				throw new RuntimeException("Error modificando socio");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
	}
}
