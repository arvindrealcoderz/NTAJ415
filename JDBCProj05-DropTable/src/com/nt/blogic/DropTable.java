package com.nt.blogic;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.nt.connection.DBConnection;

public class DropTable {
	
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		String queryForOracle=null;
		String queryForMysql=null;
		int count=0;
		String queryForDropOracle=null;
		
		try {
			
			//get connection object
			 con=DBConnection.getConnectionForOracle();
			//Connection con=DBConnection.getConnectionForOracle();
			
			//create statement object
			if(con!=null)
			st=con.createStatement();
			
			//prepare sql query6 to database 
			queryForDropOracle="drop table test";
			///execute sql query to database
			
			if(st!=null)
				count= st.executeUpdate(queryForDropOracle);
			
			if(count!=0)
				System.out.println("Table is drop");
			else
				System.out.println("Table is not drpp success");
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
