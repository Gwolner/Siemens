package br.com.desafio.siemens.model.repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static final String URL = "jdbc:mysql://localhost:3306/siemens";
	private static final String USER = "gwolner";
	private static final String PASSWORD = "root";

	private static Connection conn = null;
	
	static Connection getCurrentConnection() throws SQLException {
		
		if(conn == null)
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		return conn;
		
	}
	
	static Connection getNewConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
   
}
