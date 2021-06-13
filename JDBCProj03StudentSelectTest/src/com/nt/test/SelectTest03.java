package com.nt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest03 {
	
	public static void main(String[] args) {
		//read  inpt from  end user.
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter deptno no:: ");
		int deptno=sc.nextInt();
		//load and register driver
		System.out.println(deptno);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//established the connection 
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","Arvind");
			//create statement object
			Statement st=con.createStatement();
			//pre[are sql query
			String query="select empno , ename , job , sal from emp where deptno="+deptno;
			//execute query
			ResultSet rs=st.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getInt(1)+"\t:"+rs.getString(2)+"\t:"+rs.getString(3)+"\t:"+rs.getFloat(4));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
