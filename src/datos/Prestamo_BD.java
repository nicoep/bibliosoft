package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

import entidades.Prestamo;

public class Prestamo_BD {
	public static ArrayList<Prestamo> buscarPrestamos() throws SQLException {
		Conexion_BD con = new Conexion_BD();
		try {
			PreparedStatement statement;
			statement = con.connection
					.prepareStatement("SELECT * FROM prestamo");
			ResultSet resultado = statement.executeQuery();
			ArrayList<Prestamo> prestamos = new ArrayList<>();
			while (resultado.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setIdPrestamo(resultado.getInt("idPrestamo"));
				prestamo.setIdSocio(resultado.getInt("idSOcio"));
				prestamo.setIdObra(resultado.getInt("idObra"));
				prestamo.setFechaRetiro(resultado.getDate("fechaRetiro"));
				prestamo.setFechaDevolucion(resultado
						.getDate("fechaDevolucion"));
				prestamos.add(prestamo);
			}
			resultado.close();
			return prestamos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
	}

	public static void nuevoPrestamo(int idObra, int idSocio) throws SQLException {
		Conexion_BD con = new Conexion_BD();
		try {
			PreparedStatement statement;
			statement = con.connection
					.prepareStatement("INSERT INTO prestamo (idPrestamo, idSocio, idObra, fechaRetiro, fechaDevolucion) VALUES (null, ?, ?, null, null)");
			statement.setInt(1, idSocio);
			statement.setInt(2, idObra);
			if (statement.executeUpdate() == 0) {
				throw new RuntimeException("Error dando de alta prestamo");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
	}

	public static void registraPrestamo(int idPrestamo) throws SQLException {
		Conexion_BD con = new Conexion_BD();
		try {
			java.util.Date hoy = new java.util.Date();
			PreparedStatement statement = con.connection
					.prepareStatement("UPDATE prestamo SET fechaRetiro=? WHERE idPrestamo=?");
			statement.setDate(1, (Date) hoy);
			statement.setInt(2, idPrestamo);
			statement.executeUpdate();
		} finally {
			con.closeConnection();
		}
	}

	public static void finalizaPrestamo(int idPrestamo) throws SQLException {
		Conexion_BD con = new Conexion_BD();
		PreparedStatement statement = con.connection
				.prepareStatement("UPDATE prestamo SET fechaDevolucion=? WHERE idPrestamo=?");
		statement.setInt(2, idPrestamo);
		java.util.Date hoy = new java.util.Date();
		statement.setDate(1, (Date) hoy);
	}

	public static Prestamo getPrestamo(int idPrestamo) {
		Conexion_BD con = new Conexion_BD();
		PreparedStatement statement;
		Prestamo p = null;
		try {
			statement = con.connection
					.prepareStatement("SELECT * FROM prestamo WHERE idPrestamo=?");
			statement.setInt(1, idPrestamo);
			ResultSet resultado = statement.executeQuery();
			if (resultado.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setIdPrestamo(resultado.getInt("idPrestamo"));
				prestamo.setIdSocio(resultado.getInt("idSOcio"));
				prestamo.setIdObra(resultado.getInt("idObra"));
				prestamo.setFechaRetiro(resultado.getDate("fechaRetiro"));
				prestamo.setFechaDevolucion(resultado
						.getDate("fechaDevolucion"));
				p = prestamo;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
		return p;
	}

}
