package connectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectdb {
	private static final String URL = "jdbc:mysql://localhost:3306/db_tokobuku_azriel";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	private static Connection connection;
	
	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("Success Connect to db_tokobuku_azriel");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}return connection;
	} 
	
}
