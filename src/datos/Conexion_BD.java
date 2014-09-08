package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_BD {

	private final static String driver = "com.mysql.jdbc.Driver";

	String db = "jdbc:mysql://localhost/biblioteca?useServerPrepStmts=true";
	private final static String user = "root";
	private final static String pass = "";

	private Connection connection;

	public Connection openConnection() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(db, user, pass);
		} catch (ClassNotFoundException e1) {
			System.out.println("ERROR: No se encuentra el driver de la BD: " + e1.getMessage());
		} catch (SQLException e2) {
			System.out.println("ERROR: Falla en SQL: " + e2.getMessage());
		}
		return connection;
	}
	
	public void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e3) {
			System.out.println("ERROR: Fallo al desconectar de la BD: " + e3.getMessage());
		}
	}
}
