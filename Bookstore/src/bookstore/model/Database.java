package bookstore.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton pattern
 * 
 * @author Xi Chen
 * 
 */
public class Database {
	private static Database instance = new Database();
	private Connection connection;

	private Database() {
		/*
		 * Loading drivers. Java 6 supports automatic driver discovery. So it is
		 * not necessary to load the driver explicitly. However, to be safe,
		 * load the driver explicitly.
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Loading MySQL error!");
			e.printStackTrace();
		}
	}

	public static Database getInstance() {
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void connect() {
		if (connection != null) {
			return;
		}		

		/*
		 * Establishing connection. It allows to run SQL against the database. Need
		 * provide MySQL Connector/J JAR file, which converts JDBC calls into a
		 * network protocol the MySQL database can understand
		 */
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bookstore_demo", "root", "");
		} catch (SQLException e) {
			System.err.println("Connecting to MySQL error!");
			e.printStackTrace();
		}
	}

	public void disconnect() {
		if (connection == null) {
			return;
		}
		try {
			connection.close(); // Close the connection to avoid overhead
			connection = null;
		} catch (SQLException e) {
			System.err.println("Closing connection to MySQL error");
			e.printStackTrace();
		}
	}
}
