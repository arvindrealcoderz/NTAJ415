package com.nt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDetailsTest {
	public static void main(String[] args) {
		// read input from end user
		Scanner sc = null;
		String desg1 = null, desg2 = null, desg3 = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			sc = new Scanner(System.in);
			if (sc != null) {
				System.out.println("enter desg1..");
				desg1 = sc.next().toUpperCase();
				System.out.println("enter desg1..");
				desg2 = sc.next().toUpperCase();
				System.out.println("enter desg1..");
				desg3 = sc.next().toUpperCase();

			}

			// convert input value as required sql query
			desg1 = "'" + desg1 + "'";
			desg2 = "'" + desg2 + "'";
			desg3 = "'" + desg3 + "'";

			// established
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "Arvind");

			// create statement object
			if (con != null)
				st = con.createStatement();

			// prepare sql query to database
			String query = "select sno,sname,SADDR, avg from student where SADDR in (" + desg1 + "," + desg2 + "," + desg3
					+ ")";
			System.out.println(query);

			// send and execute query
			if (st != null)
				rs = st.executeQuery(query);

			if (rs != null) {
				System.out.println("The Employee Details are :: ");

				while (rs.next() != false) {
					System.out.println(rs.getInt(1) + " \t: " + rs.getString(2) + "\t:" + rs.getString(3) + "\t: "
							+ rs.getFloat(4));
				} // while
			} // if

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			// close jdbc stream

			if (st != null && rs != null && con != null && sc != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}
		}

	}

}
