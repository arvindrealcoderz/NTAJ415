package com.nt.date;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PSDateTestOracle {
	private static final String INSERT_QUERY_TEST=
			"INSERT INTO PERSON_INFO_DATES (PID,PNAME,DOB,DOJ,DOM) VALUES (PID_SEQ.NEXTVAL,?,?,?,?)";
	
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			//read input 
			sc=new Scanner(System.in);
			String pname=null,pdob=null,pdoj=null,pdom=null;
			
			if(sc!=null) {
				System.out.println("Person Name ");
				pname=sc.next();
				System.out.println("Person DOB(DD-MM-YYYY) ");
				pdob=sc.next();
				System.out.println("Person DOJ(YYYY-MM-DD) ");
				pdoj=sc.next();
				System.out.println("Person DOM(MM-dd-YYYY) ");
				pdom=sc.next();
			}			
			//convert string date values to sql date class object
			//for DOB
			//convert string date values object to utilDate class object
			SimpleDateFormat sdf1=new SimpleDateFormat("dd-mm-yyyy");
			java.util.Date udob=sdf1.parse(pdob);
			//convert java.util.Date class Objectto java.sql.Date class object
			long ms=udob.getTime();
			java.sql.Date sqdob=new java.sql.Date(ms);
			
			//for DOJ(YYYY-MM-DD)
			//convert string date values to java.sql.date class object
			//java.sql.Date sqdoj=java.sql.Date.valueOf(pdoj);
			
			//convert string date values object to utilDate class object
			SimpleDateFormat sdf3=new SimpleDateFormat("YYYY-MM-DD");
			java.util.Date udoj=sdf3.parse(pdoj);
			//convert java.util.Date class Objectto java.sql.Date class object
			long ms1=udob.getTime();
			java.sql.Date sqdoj=new java.sql.Date(ms1);
			
			//convert string date values to sql date class object
			//for DOM
			//convert string date values object to utilDate class object
			SimpleDateFormat sdf2=new SimpleDateFormat("MM-dd-YYYY");
			java.util.Date udom=sdf1.parse(pdom);
			//convert java.util.Date class Objectto java.sql.Date class object
			ms1=udom.getTime();
			java.sql.Date sqdom=new java.sql.Date(ms1);
			
			//load jdbc driver
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","Arvind");
			//create prepare statement object
			if(con!=null) {
				pst=con.prepareStatement(INSERT_QUERY_TEST);
			}
			//set value to query parameter
			
			if(pst!=null) {
				pst.setString(1, pname);
				pst.setDate(2, sqdob);
				pst.setDate(3, sqdoj);
				pst.setDate(4, sqdom);
			}
			//execute query
			int count=0;
			if(pst!=null)
				count=pst.executeUpdate();
			
			System.out.println(count!=0?"Recored inserted successfully ":"Recored not inserted..");
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("internal problem occured ");
		}
		
		
	}

}
