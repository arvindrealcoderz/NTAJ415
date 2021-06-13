package com.nt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

public class ConnectionTest {

	public static void main(String[] args) {
		
		try {
			System.out.println("class loading start. ");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///3306");
			
			
		} catch (Exception e) {
			System.out.println("===============================");
			e.printStackTrace();
		}
		
	}//main
}//class
