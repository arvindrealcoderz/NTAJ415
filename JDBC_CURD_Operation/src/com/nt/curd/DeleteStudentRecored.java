package com.nt.curd;

import java.sql.Connection;
import java.sql.Statement;

import com.nt.bd.DataBaseConnection;

public class DeleteStudentRecored {

	public static String delete(int sno) {
		Connection con=null;
		Statement st=null;
		String query=null;
		int count=0;

		//8127473060--sala

		try {
			//create connetion object
			con=DataBaseConnection.getConnection();
			//create statement object
			if(con!=null)
				st=con.createStatement();
			//prepare sql query
			if(st!=null)
				query="delete from student where sno="+sno;
			//System.out.println(query);
			if(st!=null && query!=null)
				count=st.executeUpdate(query);
			if(count!=0)
				return "Student recored are deleted successfully";
			else
				return "Student recored are not deleted successfully";
		}catch (Exception e) {
			return "Student recored are not deleted successfully";
		}

		finally {
			DataBaseConnection.closeStatement(st);
			DataBaseConnection.closeConnection();
		}
	}

}
