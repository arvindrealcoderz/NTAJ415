package com.nt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.nt.exception.NoResultFoundException;

public class EmpDetailsBaseInitial {

	public static void main(String[] args)  throws NoResultFoundException{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter initial char");
		String pattern=sc.next();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String query="";
		pattern="'"+pattern+"'";
		System.out.println(pattern);
		try {
			//load  and register driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:151:orcl","scott","Arvind");
			System.out.println("EmpDetailsBaseInitial.main()"+con);
			//create statement object	
			if(con!=null)
				st=con.createStatement();
			System.out.println("EmpDetailsBaseInitial.main()");
			
			//prepare query
			query="select empno , ename ,job ,sal from emp where ename like  %"+pattern;
			//execute sql query
			if(query!=null && st!=null)
				rs=st.executeQuery(query);
			if(rs!=null) {
				System.out.println("Employee details are ");
				while (rs.next()) {
					System.out.println(rs.getInt(1)+"\t:"+rs.getString(2)+"\t:"+rs.getString(3)+"\t:"+rs.getFloat(4));
				}//while 

			}//rs
		} catch (SQLException e) {
			//e.printStackTrace();
			new NoResultFoundException("Database connection failure ");
		}catch (Exception e) {
			e.printStackTrace();
		}
		//close all jdbc resources 
		finally {
			try {
				rs.close();
				st.close();
				con.close();
				sc.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}


	}


}
