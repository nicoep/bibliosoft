package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Prestamo;

public class Prestamo_BD {
	
	public static ArrayList<Prestamo> buscarPrestamos(Integer estado) throws SQLException {
		Conexion_BD con = new Conexion_BD();
		try {
			PreparedStatement statement = null;
			switch (estado) {
			case 1:
				statement = con.connection.prepareStatement("SELECT * FROM prestamo");	
				break;
			case 2:
				statement = con.connection.prepareStatement("SELECT * FROM prestamo WHERE fechaRetiro is null AND fechaDevolucion is null");
				break;
			case 3:
				statement = con.connection.prepareStatement("SELECT * FROM prestamo WHERE fechaRetiro is not null AND fechaDevolucion is null");
				break;
			case 4:
				statement = con.connection.prepareStatement("SELECT * FROM prestamo WHERE fechaRetiro is not null AND fechaDevolucion is not null");
				break;
			}
			ResultSet resultado = statement.executeQuery();
			ArrayList<Prestamo> prestamos = new ArrayList<>();
			while (resultado.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setIdPrestamo(resultado.getInt("idPrestamo"));
				prestamo.setIdSocio(resultado.getInt("idSOcio"));
				prestamo.setIdObra(resultado.getInt("idObra"));
				prestamo.setFechaRetiro(resultado.getDate("fechaRetiro"));
				prestamo.setFechaDevolucion(resultado.getDate("fechaDevolucion"));
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

	public static void nuevoPrestamo(int idObra, int idSocio, int stockObra) {
		Conexion_BD con = new Conexion_BD();
		try {
			PreparedStatement statement1;
			PreparedStatement statement2;
			statement1 = con.connection.prepareStatement("INSERT INTO prestamo (idPrestamo, idSocio, idObra, fechaRetiro, fechaDevolucion) VALUES (null, ?, ?, null, null)");
			statement1.setInt(1, idSocio);
			statement1.setInt(2, idObra);
			if (statement1.executeUpdate() == 0) {
				throw new RuntimeException("Error dando de alta prestamo");
			} else {
				int stockNuevo = stockObra - 1;
				statement2 = con.connection.prepareStatement("UPDATE obra SET stock=? WHERE idObra=?");
				statement2.setInt(1, stockNuevo);
				statement2.setInt(2, idObra);
				if (statement2.executeUpdate() == 0) {
					throw new RuntimeException("Error actualizando stock");
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
	}

	public static void registraPrestamo(int idPrestamo) {
		Conexion_BD con = new Conexion_BD();
		try {
			PreparedStatement statement = con.connection.prepareStatement("UPDATE prestamo SET fechaRetiro=CURDATE() WHERE idPrestamo=?");
			statement.setInt(1, idPrestamo);
			statement.executeUpdate();
			if (statement.executeUpdate() == 0) {
				throw new RuntimeException("Error registrando prestamo");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
	}

	public static void finalizaPrestamo(int idPrestamo, int idObra, int stock) {
		Conexion_BD con = new Conexion_BD();
		try {
			PreparedStatement statement1;
			PreparedStatement statement2;
			statement1 = con.connection.prepareStatement("UPDATE prestamo SET fechaDevolucion=CURDATE() WHERE idPrestamo=?");
			statement1.setInt(1, idPrestamo);
			if (statement1.executeUpdate() == 0) {
				throw new RuntimeException("Error finalizando prestamo");
			} else {
				statement2 = con.connection.prepareStatement("UPDATE obra SET stock=? WHERE idObra=?");
				statement2.setInt(2, idObra);
				int stockNuevo = stock + 1;
				statement2.setInt(1, stockNuevo);
				if (statement2.executeUpdate() == 0) {
					throw new RuntimeException("Error actualizando stock");
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}

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
	
	public static void cancelaPrestamo(int idPrestamo) {
		Conexion_BD con = new Conexion_BD();
		try {
			PreparedStatement statement = con.connection.prepareStatement("DELETE FROM prestamo WHERE idPrestamo=?");
			statement.setInt(1, idPrestamo);
			if (statement.executeUpdate() == 0) {
				throw new RuntimeException("Error cancelando prestamo");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
	}

}
