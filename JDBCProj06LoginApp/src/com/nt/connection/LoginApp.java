package com.nt.connection;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class LoginApp {
	
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		Resultset rs=null;
		
		
		//read input data from
		try {
			String uname=null, pass=null;
			String query="";
			int count=0;
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter user Name ");
				uname=sc.nextLine();
				System.out.println("Enter user password ");
				pass=sc.nextLine();
				
				//convert input value as required as sql
				uname="'"+uname+"'";
				pass="'"+pass+"'";
				
			}//if
			//get connection
			con=DBConnection.getConnectionForOracle();
			
			//create statement object
			if(con!=null)
				st=con.createStatement();
			
			//prepare sql query to db
			query="select count(*) as count from irctc_tab where uname ="+uname+" and pwd="+pass;
			//execute sql query
			if(query!=null && st!=null)
				count= st.executeUpdate(query);
			System.out.println(count==0?"Invallid Credentials":"valid credentials");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			DBConnection.closeConnection(con);
			
		}
		
		
	}

}
