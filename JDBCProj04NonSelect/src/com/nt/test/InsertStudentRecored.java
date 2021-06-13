package com.nt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertStudentRecored {

	public static void main(String[] args) {
		Scanner sc=null;
		String sname=null;
		String saddr=null;
		String city=null;
		float avg=0.0f;
		int sno=0;
		Connection con=null;
		Statement st=null;
		String query="";
		
		int noOfRowsThatAreEffected=0;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter Student Number ::");
				sno=sc.nextInt();sc.nextLine();
				
				System.out.println("Enter Student name ::");
				sname=sc.nextLine();
				System.out.println("Enter Student Address ::");
				saddr=sc.nextLine();
				System.out.println("Enter Student avg  ::");
				avg=sc.nextFloat();sc.nextLine();
				System.out.println("Enter Student City ::");
				city=sc.nextLine();
				//convert sql formate
				sname="'"+sname+"'";
				saddr="'"+saddr+"'";
				city="'"+city+"'";
				
			}
			if(sc!=null && sname!=null && saddr!=null && avg!=0.0f && sno!=0) {
				//load and register jdbc driver
				//Class.forName("oracle.jdbc.driver.OracleDriver");
				//established the connection 
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","Arvind");
			}
			//insert into student (sno , sname , saddr ,avg ,city) values (101,'AAA','BBB',58,'CCC')
			query="insert into student (sno , sname , saddr ,avg ,city) values ("+sno+" ,"+sname+" , "+saddr+" ,"+avg+" ,"+city+")";
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
