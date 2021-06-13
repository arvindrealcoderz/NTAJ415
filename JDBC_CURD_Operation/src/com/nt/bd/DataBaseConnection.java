package com.nt.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBaseConnection {
	public static Connection con=null;
	public static Connection getConnection() {
		
		try {
			//load and register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//established the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","Arvind");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return  con;
		
	}
	
	
	//close the connection
	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//close the scanner
	public static void closeScanner(Scanner sc) {
		try {
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//close the scanner
	public static void closeStatement(Statement st) {
		try {
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
