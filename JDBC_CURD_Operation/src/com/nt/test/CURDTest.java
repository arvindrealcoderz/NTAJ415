package com.nt.test;

import java.util.Scanner;

import com.nt.curd.CreateInsert;
import com.nt.curd.DeleteStudentRecored;
import com.nt.curd.RetriveStudentRecored;
import com.nt.curd.updateStudentRecored;

public class CURDTest {

	public static void main(String[] args) {
		Scanner sc=null;
		int sno=0;
		String sname="";
		String saddr="";
		double avg=0.0;
		int choice=0;
		
		//create Scanner object
		sc=new Scanner(System.in);
		if(sc!=null) {
			System.out.println("Enter student number :: ");
			sno=sc.nextInt();sc.nextLine();
			System.out.println("Enter student name :: ");
			sname=sc.nextLine();
			System.out.println("Enter student address :: ");
			saddr=sc.nextLine();
			System.out.println("Enter student avg :: ");
			avg=sc.nextDouble();
			
			//convert string values sql formate
			sname="'"+sname+"'";
			saddr="'"+saddr+"'";
			
			System.out.println("Press 1 to insert student recored :: ");
			System.out.println("Press 2 to update student recored :: ");
			System.out.println("Press 3 to retrive student recored :: ");
			System.out.println("Press 4 to delete student recored :: \"");
			choice=sc.nextInt();
			System.out.println(choice);
		}
		//case : 1
		//insert recored
		if(choice==1)
			System.out.println(CreateInsert.insert(sno,sname,saddr,avg));
		else if(choice==2)
			System.out.println(updateStudentRecored.update(sno,sname,saddr,avg));
		else if(choice==3)
			RetriveStudentRecored.fetchStudentRecored(sno);
		else if(choice==4)
			System.out.println(DeleteStudentRecored.delete(sno));
		
		
	}
}
