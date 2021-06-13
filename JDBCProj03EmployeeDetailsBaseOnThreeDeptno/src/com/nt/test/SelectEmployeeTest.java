package com.nt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectEmployeeTest {
	
	public static void main(String[] args) {
		Scanner sc=null;
		int dno1=0,dno2=0,dno3=0;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter first deptno ::");
				dno1=sc.nextInt();
			
				System.out.println("Enter secound deptno ::");
				dno2=sc.nextInt();
				
				System.out.println("Enter thired deptno ::");
				dno3=sc.nextInt();
			
			}
				
			if(dno1!=0 && dno2!=0 && dno3!=0) {
				//established the connection
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","Arvind");
				
				
				//create statemn object
				if(con!=null)
					st=con.createStatement();
				
				//prepare sql query
				String query="select empno , ename , job , sal from emp where deptno in ("+dno1+","+dno2+","+dno3+")";
				
				//execute sql query
				if(st!=null && query!=null) {
					rs=st.executeQuery(query);
				}
				
				
				
				if(rs!=null) {
					System.out.println("student details");
					while (rs.next()!=false) {
						System.out.println(rs.getInt(1)+"\t:"+rs.getString(2)+"\t:"+rs.getString(3)+"\t:"+rs.getFloat(4));
					}	
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (st != null && rs != null && con != null && sc != null) {
				
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sc.close();
			
			
			
			
			
		}
		
		
		}
	}

}
