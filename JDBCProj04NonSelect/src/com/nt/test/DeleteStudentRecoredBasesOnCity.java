package com.nt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteStudentRecoredBasesOnCity {

	public static void main(String[] args) {
		Scanner sc=null;
		String city=null;
		Connection con=null;
		Statement st=null;
		String query="";
		int noOfRowsThatAreEffected=0;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter Student city name ::");
				city=sc.nextLine();
				//convert sql formate
				city="'"+city+"'";
			}
			if(sc!=null && city!=null) {
				//load and register jdbc driver
				//Class.forName("oracle.jdbc.driver.OracleDriver");
				//established the connection 
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","Arvind");
			}
			query="delete from student where city="+city;
			//create statement object
			if(con!=null)
				st=con.createStatement();
			//execute sql query to database
			noOfRowsThatAreEffected=st.executeUpdate(query);
			if(noOfRowsThatAreEffected!=0)
				System.out.println("No of recored are deleted "+noOfRowsThatAreEffected);
			else
				System.out.println("No Rows are deleted..");
			
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
