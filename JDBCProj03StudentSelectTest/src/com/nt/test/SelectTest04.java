package com.nt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest04 {
	public static void main(String[] args) {
		Scanner sc=null;
		String str=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String query="";
		sc=new Scanner(System.in);
		
		
			//read input 
			System.out.println("Enter employee character:: ");
			str=sc.nextLine().toUpperCase();
			str="'%"+str+"'";
	
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//create jdbc connection
			
			if(sc!=null && str!=null)
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","Arvind");
			//create statement object
			if(con!=null)	
				st=con.createStatement();
			//prepare sql query 
			query="select empno ,ename, job, sal from emp where ename like "+str;
		System.out.println(query);
			//execute sql query to database
			
			if(st!=null)
				rs=st.executeQuery(query);
			if(rs!=null)
				while (rs.next()) 
					System.out.println(rs.getInt(1)+"\t: "+rs.getString(2)+"\t:"+rs.getString(3)+"\t:"+rs.getFloat(4));
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

}
