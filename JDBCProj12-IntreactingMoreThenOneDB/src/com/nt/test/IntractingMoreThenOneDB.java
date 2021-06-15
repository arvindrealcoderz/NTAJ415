package com.nt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class IntractingMoreThenOneDB {
	
	
	public static void main(String[] args) {
		int count=0;
		try( 
				Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","Arvind");
				Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/ntaj415","root","root");
				Statement st1=con1.createStatement();
				PreparedStatement pst=con2.prepareStatement("Insert into emp (empno , ename, job ,sal) values (?,?,?,?)");
				ResultSet rs1= st1.executeQuery("select empno ,ename , job ,sal from emp ");
				){
			
			while (rs1.next()) {
				pst.setInt(1, rs1.getInt(1));
				pst.setString(2, rs1.getString(2));
				pst.setString(3, rs1.getString(3));
				pst.setFloat(4, rs1.getFloat(4));
				count= pst.executeUpdate();
				
			}
			System.out.println(count!=0?"Employee Recored are inserted ":"Employee recored are not inserted ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
