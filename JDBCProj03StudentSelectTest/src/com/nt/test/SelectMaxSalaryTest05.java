package com.nt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectMaxSalaryTest05 {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		String query="";
		ResultSet rs=null;
		
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//create jdbc connection
			
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","Arvind");
			//create statement object
			if(con!=null)	
				st=con.createStatement();
			//prepare sql query 
			query="select empno ,ename, job, sal from emp where sal=(select max(sal) from emp)";
		System.out.println(query);
			//execute sql query to database
			
			if(st!=null)
				rs=st.executeQuery(query);
			if(rs!=null)
				while (rs.next()) 
					System.out.println(rs.getInt(1)+"\t: "+rs.getString(2)+"\t:"+rs.getString(3)+"\t:"+rs.getFloat(4));
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
