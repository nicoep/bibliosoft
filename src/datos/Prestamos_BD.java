package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class Prestamos_BD {
	private Connection connection;
	
	
	public void nuevoPrestamo(int idObra, int idSocio) throws SQLException {
		Conexion_BD conexion_bd = new Conexion_BD();
		connection = conexion_bd.openConnection();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO prestamo (idPrestamo, idSocio, idObra, fechaRetiro, fechaDevolucion) VALUES (null, ?, ?, null, null)");
		statement.setInt(1, idSocio);
		statement.setInt(2, idObra);
		int resultado = statement.executeUpdate();
		System.out.println(resultado);
		conexion_bd.closeConnection();
	}
	
	public void registraPrestamo(int idPrestamo) throws SQLException {
		Conexion_BD con = new Conexion_BD();
		connection = con.openConnection();
		java.util.Date hoy = new java.util.Date();
		PreparedStatement statement = connection.prepareStatement("UPDATE prestamo SET fechaRetiro=? WHERE idPrestamo=?");
		statement.setDate(1,(Date) hoy);
		statement.setInt(2, idPrestamo);
		int resultado = statement.executeUpdate();
		System.out.println(resultado);
		con.closeConnection();
	}
	
	public void finalizaPrestamo(int idPrestamo) throws SQLException {
		Conexion_BD con = new Conexion_BD();
		connection = con.openConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE prestamo SET fechaDevolucion=? WHERE idPrestamo=?");
		statement.setInt(2, idPrestamo);
		java.util.Date hoy = new java.util.Date();
		statement.setDate(1, (Date) hoy);
	}
	

}
