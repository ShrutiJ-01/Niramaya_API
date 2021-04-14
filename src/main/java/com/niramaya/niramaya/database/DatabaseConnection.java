package com.niramaya.niramaya.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private Connection connection;
	
	public Connection getDbConnection() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","sdkFlutt3r");
			
			return connection;

			}
		catch(Exception e){
			System.out.println(e);
			return null;
			}
		
				
	}
	
	void closeDbConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
}
