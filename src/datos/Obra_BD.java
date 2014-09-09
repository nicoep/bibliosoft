package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Obra;

public class Obra_BD {
	private Connection connection;

	public void alta_obra(String titulo, String autor, String editorial, String cdu, String isbn, int stock, int idTipo) throws SQLException {
		Conexion_BD con = new Conexion_BD();
		connection = con.openConnection();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO obra (idObra, titulo, autor, editorial, cdu, isbn, imagen, descriptores, stock, idTipo) VALUES (null, ?, ?, ?, ?, ?, null, null, ?, ?)");
		statement.setString(1, titulo);
		statement.setString(2, autor);
		statement.setString(3, editorial);
		statement.setString(4, cdu);
		statement.setString(5,isbn);
		statement.setInt(6, stock);
		statement.setInt(7, idTipo);
		int resultado = statement.executeUpdate();
		System.out.println(resultado);
	}
	
	public ArrayList<Obra> getObras() throws SQLException {
		Conexion_BD con = new Conexion_BD();
		connection = con.openConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM obra");
		ResultSet resultado = statement.executeQuery();
		if (resultado.next()) {
			System.out.println(resultado);
		}
		return null;
	}

}
