package br.com.carv.app.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public static Connection getConnection() {
		
		final String driver = "org.mariadb.jdbc.Driver"; 
		final String url = "jdbc:mariadb://localhost:3306/app_jsp?useTimezone=true&serverTimezone=UTC";
		final String user = "adm"; 
		final String password = "123456789";
		
		Connection connection = null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
