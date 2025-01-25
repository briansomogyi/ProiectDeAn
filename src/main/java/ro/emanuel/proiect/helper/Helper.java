package ro.emanuel.proiect.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Helper {

	private static Connection connection;

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if (connection == null || connection.isClosed()) {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Properties properties = new Properties();
			properties.put("user", "root");
			properties.put("password", "");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop2024", properties);
		}
		return connection;
	}

	public static void closeConnection() throws SQLException {
		if (connection != null && !connection.isClosed())
			connection.close();
	}

}
