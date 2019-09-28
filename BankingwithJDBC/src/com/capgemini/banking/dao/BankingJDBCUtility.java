package com.capgemini.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankingJDBCUtility {

	final static String url = "jdbc:oracle:thin:@10.138.151.23:1521:xe";
	final static String username = "INVENTORY3";
	final static String password = "INVENTORY3";
	static Connection connection = null;

	public static Connection getConnection() throws SQLException {
		if (connection != null){
			return connection;
		}
		
		else {
			try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection(url, username, password);
				connection.setAutoCommit(false);
				System.out.println("Database connection established");
			} catch (ClassNotFoundException e) {
				System.err.println(e.getMessage());
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
			return connection;
		}
	}

}
