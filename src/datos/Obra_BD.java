package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Obra;

public class Obra_BD {
	private Connection connection;

	private Conexion_BD conectarBD() {
		Conexion_BD con = new Conexion_BD();
		connection = con.openConnection();
		return con;
	}

	public void alta_obra(String titulo, String autor, String editorial,
			String cdu, String isbn, int stock, int idTipo, String imagen) {
		Conexion_BD con = conectarBD();
		try {
			PreparedStatement statement;
			statement = connection
					.prepareStatement("INSERT INTO obra (idObra, titulo, autor, editorial, cdu, isbn, imagen, descriptores, stock, idTipo) VALUES (null, ?, ?, ?, ?, ?, ?, null, ?, ?)");
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

	public void baja_obra(int idObra) throws SQLException {
		Conexion_BD con = conectarBD();
		PreparedStatement statement = connection
				.prepareStatement("DELETE * FROM obra WHERE idObra=?");
		statement.setInt(1, idObra);
		int resultado = statement.executeUpdate();
		con.closeConnection();
		System.out.println(resultado);
	}

	public Obra get_obra(int idObra) {
		Conexion_BD con = conectarBD();
		PreparedStatement statement;
		try {
			statement = connection
					.prepareStatement("SELECT * FROM obra WHERE idObra=?");
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

	public ArrayList<Obra> buscarObras(String busqueda, int tipo)
			throws SQLException {
		Conexion_BD con = conectarBD();
		PreparedStatement statement;
		if (busqueda != null && !busqueda.isEmpty()) {
			statement = connection
					.prepareStatement("SELECT * FROM obra WHERE LOWER(titulo) LIKE ? AND idTipo = ?");
			statement.setString(1, "%" + busqueda.toLowerCase() + "%");
			statement.setInt(2, tipo);
		} else {
			statement = connection.prepareStatement("SELECT * FROM obra");
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

	private Obra extractObra(ResultSet resultado) throws SQLException {
		Obra obra = new Obra();
		obra.setIdObra(resultado.getInt("idObra"));
		obra.setTitulo(resultado.getString("titulo"));
		obra.setAutor(resultado.getString("autor"));
		obra.setEditorial(resultado.getString("editorial"));
		obra.setCdu(resultado.getString("cdu"));
		obra.setIsbn(resultado.getString("isbn"));
		obra.setStock(resultado.getInt("stock"));
		obra.setDescriptores(resultado.getString("descriptores"));
		obra.setImagen(resultado.getString("imagen"));
		obra.setIdTipo(resultado.getInt("idTipo"));
		return obra;
	}

}
