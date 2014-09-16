package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_BD {

	private final static String driver = "com.mysql.jdbc.Driver";

	String db = "jdbc:mysql://localhost/biblioteca?useServerPrepStmts=true";
	private final static String user = "root";
	private final static String pass = "";

	public final Connection connection;
	
	public Conexion_BD() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(db, user, pass);
		} catch (ClassNotFoundException e1) {
			throw new RuntimeException("ERROR: No se encuentra el driver de la BD: " + e1.getMessage());
		} catch (SQLException e2) {
			throw new RuntimeException("ERROR: Falla en SQL: " + e2.getMessage());
		}
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e3) {
			System.out.println("ERROR: Fallo al desconectar de la BD: " + e3.getMessage());
		}
	}
}
