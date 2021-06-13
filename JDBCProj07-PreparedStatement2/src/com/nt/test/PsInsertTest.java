package com.nt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsInsertTest {
	private static final String CUSTOMER_INSERT_QUERY="INSERT INTO customer VALUES (?,?,?,?)";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement pst=null;
		
		
		try {
			
			//read input 
			sc=new  Scanner(System.in);
			int count=0;
			if(sc!=null) {
				System.out.println("enter customer count :: ");
				count=sc.nextInt();
			}
			//register jdbc driver
		//	Class.forName("com.mysql.cj.jdbc.Driver");
			
			//established the connection
			//con=DriverManager.getConnection("jdbc:mysql:///:ntaj415","root","root");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","Arvind");
			
			//create prepare statement object
			if(con!=null)	
				pst=con.prepareStatement(CUSTOMER_INSERT_QUERY);
			
			//read input values from end user and 
			//set them in query parameter values
			//execute the pre-compiled sql query.
			//sql quey for multiple time
			if(pst!=null && sc!=null) {
				for (int i = 0; i < count; i++) {
					//read each customer input values 
					System.out.println("enter "+i+" customer details ");
					System.out.print("enter customer number :: ");
					int no=sc.nextInt();
					System.out.print("enter  customer name :: ");sc.next();
					String name=sc.nextLine();
					System.out.print("enter  customer address :: ");
					String addr=sc.nextLine();
					System.out.print("enter  customer avg  :: ");
					float avg=sc.nextFloat();
					
					//set each customer details as pre compiled sql query
					pst.setInt(1, no);
					pst.setString(2, name);
					pst.setString(3, addr);
					pst.setFloat(4, avg);
					
					
					//execute pre compiled sql query each time
					int result= pst.executeUpdate();
					
					System.out.println(result!=0?"customer recored inserted ":"customer recored not inserted");
						
				}//for
				
			}//if
				
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}//catch
		finally {
			//close the prepare statement
			try {
				if(pst!=null)
					pst.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			//close the connection
			try {
				if(con!=null)
					con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(sc!=null)
					sc.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
