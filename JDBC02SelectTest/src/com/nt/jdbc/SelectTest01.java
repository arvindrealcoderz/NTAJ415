package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest01 {
	public static void main(String[] args) {
		//read input 
		Scanner sc=new Scanner(System.in);
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		System.out.println("enter start rangle of employee salary ::");
		float startSal=sc.nextFloat();
		System.out.println("enter end rangle of employee salary ::");
		float endSal=sc.nextFloat();
		
		//register jdbc driver s/w to load jdbc driver  class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//established the connection 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ntaj415","root","root");
			//prepare statement object
			st=con.createStatement();
			//prepare sql query 
			String query="select empno, ename,job,sal from emp where sal>"+startSal+" and "+"sal<"+endSal;
			//execute sql query
			rs=st.executeQuery(query);
			while (rs.next()) {
				System.out.println("employee no :"+rs.getInt(1)+" employee name :: "+rs.getString(2)+" employee job :: "+rs.getString(3)+" employee salary "+rs.getFloat(4));
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
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
			sc.close();
			
		}
		
	}

}
