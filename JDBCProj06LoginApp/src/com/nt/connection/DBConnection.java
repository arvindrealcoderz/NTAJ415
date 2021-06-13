package com.nt.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection con=null;
	public static Connection getConnectionForOracle() {
		try {
			//established the connection in oracle
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","Arvind");
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	//mysql database cobnnection
	public static Connection getConnectionForMysql() {
		try {
			//established the connection in oracle
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ntaj415","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	//close jdbc connnection   
	
	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
