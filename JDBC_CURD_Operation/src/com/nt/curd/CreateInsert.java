package com.nt.curd;

import java.sql.Connection;
import java.sql.Statement;

import com.nt.bd.DataBaseConnection;

public class CreateInsert {
	public static String insert(int sno, String sname, String saddr, double avg) {
		Connection con=null;
		Statement st=null;
		String query=null;
		int count=0;
		
		try {
			//create connetion object
			con=DataBaseConnection.getConnection();
			//create statement object
			if(con!=null)
				st=con.createStatement();
			//prepare sql query
			if(st!=null)
				query="insert into student 	values("+sno+","+sname+" , "+saddr+" ,"+avg+" )";
			if(st!=null && query!=null)
				count=st.executeUpdate(query);
			if(count!=0)
				return "Student recored inserted successfully";
			else
				return "Student recored not inserted successfully";
		}catch (Exception e) {
			return "Student recored inserted successfully";
		}
		
		finally {
			DataBaseConnection.closeStatement(st);
			DataBaseConnection.closeConnection();
		}
		
	}
}
