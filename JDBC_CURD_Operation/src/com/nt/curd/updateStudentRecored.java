package com.nt.curd;

import java.sql.Connection;
import java.sql.Statement;

import com.nt.bd.DataBaseConnection;

public class updateStudentRecored {
	
	public static String update(int sno, String sname, String saddr, double avg) {
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
				query="update student set sname="+sname+" , saddr="+saddr+" , avg= "+avg+" where sno="+sno;
				//System.out.println(query);
			if(st!=null && query!=null)
				count=st.executeUpdate(query);
			if(count!=0)
				return "Student recored are update successfully";
			else
				return "Student recored are not update successfully";
		}catch (Exception e) {
			return "Student recored are not update successfully";
		}
		
		finally {
			DataBaseConnection.closeStatement(st);
			DataBaseConnection.closeConnection();
		}
	}

}
