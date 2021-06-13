package com.nt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class PsDateRetriveTestOracle {
	private static final String RETRIVE_DATES_QUERY="SELECT PID,PNAME,DOB,DOJ,DOM FROM PERSON_INFO_DATES";
	
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		
		try {
			//Established the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","Arvind");
			//create preparestatement 
			if(con!=null)
				pst=con.prepareStatement(RETRIVE_DATES_QUERY);
			//execute query
			if(pst!=null)
				rs=pst.executeQuery();
			//process the result set
			while (rs.next()) {
				int pid=rs.getInt(1);
				String pname=rs.getString(2);
				java.util.Date sqdob= rs.getDate(3);
				java.util.Date sqdom= rs.getDate(4);
				java.util.Date sqdoj= rs.getDate(5);
				
				//convert sql date to String date formate
				SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyy");
					System.out.println(pid+"\t"+pname+"\t"+"\t"+sdf.format(sqdob)+"\t"+sdf.format(sqdoj)+"\t"+sdf.format(sqdom));
				}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
