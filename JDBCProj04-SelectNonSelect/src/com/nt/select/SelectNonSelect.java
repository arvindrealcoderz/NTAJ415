package com.nt.select;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.nt.bd.DataBaseConnection;

public class SelectNonSelect {
	
	public static void fetchStudentRecored(int sno) {
		Connection con=null;
		Statement st=null;
		String query=null;
		int count=0;
		ResultSet rs=null;
		try {
			//create connection object
			con=DataBaseConnection.getConnection();
			//create statement object
			if(con!=null)
				st=con.createStatement();
			//prepare sql query
			if(st!=null)
				query="select sno ,sname ,saddr , avg from student where sno "+sno;
				//System.out.println(query);
			if(st!=null && query!=null)
				rs=st.executeQuery(query);
			if(rs!=null)
				if(rs.next())
					System.out.println("\t: "+rs.getInt(1)+"\t:: "+rs.getString(2)+"\t::"+rs.getString(3)+"\t:: "+rs.getDouble(4));
			System.out.println("no student recored found ");	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			DataBaseConnection.closeStatement(st);
			DataBaseConnection.closeConnection();
		}
	}

}
