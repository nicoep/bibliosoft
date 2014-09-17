package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Obra;

public class Obra_BD {
	
	public static int getStock(int idObra) {
		Conexion_BD con = new Conexion_BD();
		Integer stock = null;
		try {
			PreparedStatement statement;
			statement = con.connection.prepareStatement("SELECT stock FROM obra WHERE idObra=?");
			statement.setInt(1, idObra);
			ResultSet resultado = statement.executeQuery();
			if (resultado.next()) {
				stock = Integer.valueOf(resultado.getString("stock")); 
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
		return stock;
	}
	
	public static void alta_obra(String titulo, String autor, String editorial, String cdu, String isbn, int stock, int idTipo, String imagen) {
		Conexion_BD con = new Conexion_BD();
		try {
			PreparedStatement statement;
			statement = con.connection.prepareStatement("INSERT INTO obra (idObra, titulo, autor, editorial, cdu, isbn, imagen, stock, idTipo, state) VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, 1)");
			statement.setString(1, titulo);
			statement.setString(2, autor);
			statement.setString(3, editorial);
			statement.setString(4, cdu);
			statement.setString(5, isbn);
			statement.setString(6, imagen);
			statement.setInt(7, stock);
			statement.setInt(8, idTipo);
			if (statement.executeUpdate() == 0) {
				throw new RuntimeException("Error creando obra");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
	}

	
	public static void baja_obra(int idObra) {
		Conexion_BD con = new Conexion_BD();
		try {
			PreparedStatement statement = con.connection.prepareStatement("UPDATE obra SET state=? WHERE idObra=?");
			statement.setInt(1, 0);
			statement.setInt(2, idObra);
			if (statement.executeUpdate() == 0) {
				throw new RuntimeException("Error eliminando la obra");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
	}

	
	public static Obra get_obra(int idObra) {
		Conexion_BD con = new Conexion_BD();
		PreparedStatement statement;
		try {
			statement = con.connection.prepareStatement("SELECT * FROM obra WHERE idObra=?");
			statement.setInt(1, idObra);
			ResultSet resultado = statement.executeQuery();
			if (resultado.next()) {
				return extractObra(resultado);
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
	}

	
	public static ArrayList<Obra> buscarObras(String busqueda, int tipo) throws SQLException {
		Conexion_BD con = new Conexion_BD();
		PreparedStatement statement;
		if (busqueda != null && !busqueda.isEmpty()) {
			statement = con.connection.prepareStatement("SELECT * FROM obra WHERE LOWER(titulo) LIKE ? AND idTipo = ? AND state=?");
			statement.setString(1, "%" + busqueda.toLowerCase() + "%");
			statement.setInt(2, tipo);
			statement.setInt(3, 1);
		} else {
			statement = con.connection.prepareStatement("SELECT * FROM obra WHERE state=?");
			statement.setInt(1, 1);
		}
		ResultSet resultado = statement.executeQuery();
		ArrayList<Obra> obras = new ArrayList<>();
		while (resultado.next()) {
			obras.add(extractObra(resultado));
		}
		resultado.close();
		con.closeConnection();
		return obras;
	}

	
	private static Obra extractObra(ResultSet resultado) throws SQLException {
		Obra obra = new Obra();
		obra.setIdObra(resultado.getInt("idObra"));
		obra.setTitulo(resultado.getString("titulo"));
		obra.setAutor(resultado.getString("autor"));
		obra.setEditorial(resultado.getString("editorial"));
		obra.setCdu(resultado.getString("cdu"));
		obra.setIsbn(resultado.getString("isbn"));
		obra.setStock(resultado.getInt("stock"));
		obra.setImagen(resultado.getString("imagen"));
		obra.setIdTipo(resultado.getInt("idTipo"));
		return obra;
	}

	
	public static void modificaObra(int idObra, String cdu, int stock) {
		Conexion_BD con = new Conexion_BD();
		try {
			PreparedStatement statement;
			statement = con.connection.prepareStatement("UPDATE obra SET cdu=?, stock=? WHERE idObra=?");
			statement.setString(1, cdu);
			statement.setInt(2, stock);
			statement.setInt(3, idObra);
			if (statement.executeUpdate() == 0) {
				throw new RuntimeException("Error modificando obra");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
	}
	
	
	public static String traerTitulo(int idObra) {
		Conexion_BD con = new Conexion_BD();
		try {
			PreparedStatement statement;
			statement = con.connection.prepareStatement("SELECT titulo FROM obra WHERE idObra=?");
			statement.setInt(1, idObra);
			ResultSet resultado = statement.executeQuery();
			if (resultado.next()) {
				String titulo = resultado.getString("titulo");
				return titulo;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.closeConnection();
		}
		return null;
	}

	
}
