package com.nt.blogic;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.nt.connection.DBConnection;

public class CreateTable {
	
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		String queryForOracle=null;
		String queryForMysql=null;
		int count2=0;
		String queryForDrop=null;
		
		try {
			
			//get connection object
			 con=DBConnection.getConnectionForOracle();
			//Connection con=DBConnection.getConnectionForOracle();
			
			//create statement object
			if(con!=null)
			st=con.createStatement();
			
			//prepare sql query6 to database 
			queryForOracle="create table test(sno varchar2(10) , sname varchar2(10))";
			queryForMysql="create table test(sno varchar(10) , sname varchar(10))";
			
			///execute sql query to database
			
			if(st!=null)
				count2= st.executeUpdate(queryForOracle);
			
			if(count2!=0)
				System.out.println("Table created success");
			else
				System.out.println("Table is not created success");
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
