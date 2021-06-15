package com.nt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AgeCalculator {
	private static final String AgeCalculator="SELECT ROUND((SYSDATE-DOB)/365.25,2) as age FROM PERSON_INFO_DATES WHERE PID=?";
	
	public static void main(String[] args) {
		try (
			
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","Arvind");
				PreparedStatement pst=con.prepareStatement(AgeCalculator);
				
			){
			if(pst!=null)
				pst.setInt(1, 2);
			ResultSet rs= pst.executeQuery();
			
			if(rs.next())
				System.out.println(rs.getDouble(1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
