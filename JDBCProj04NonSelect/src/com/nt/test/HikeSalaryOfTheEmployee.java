package com.nt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HikeSalaryOfTheEmployee {

	public static void main(String[] args) {
		Scanner sc=null;
		float per=0.0f;
		float startRange=0.0f;
		float endRange=0.0f;
		
		Connection con=null;
		Statement st=null;
		String query="";
		
		int noOfRowsThatAreEffected=0;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter employee hike percentage ::");
				per=sc.nextFloat();
				System.out.println("Enter employee start ranges ::");
				startRange=sc.nextFloat();
				System.out.println("Enter employee end range ::");
				endRange=sc.nextFloat();
				
			}
			if(sc!=null && per!=0.0 && startRange!=0.0 && endRange!=0.0f ) {
				//load and register jdbc driver
				//Class.forName("oracle.jdbc.driver.OracleDriver");
				//established the connection 
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","Arvind");
			}
			query="update emp set sal="+"sal+"+per/100 +" where sal>="+startRange+" and sal<="+endRange;
			//System.out.print(query);
			//create statement object
			if(con!=null)
				st=con.createStatement();
			//execute sql query to database
			noOfRowsThatAreEffected=st.executeUpdate(query);
			if(noOfRowsThatAreEffected!=0)
				System.out.println("recored are updated "+noOfRowsThatAreEffected);
			else
				System.out.println("No Rows are not updated..");
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}finally {
			//close the jdbc resources
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				sc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}

	}

}
