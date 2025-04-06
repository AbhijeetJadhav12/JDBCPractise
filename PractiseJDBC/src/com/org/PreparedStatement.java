package com.org;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatement {

	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Practise", "root", "2002");
			String q="insert into student (name, phoneNumber) values(?,?)";
			java.sql.PreparedStatement pst= con.prepareStatement(q);
		
			for(int i=0;i<3;i++) {
				System.out.println("Enter name and phoneNumber");
				String name=sc.nextLine();
				String phoneNumber=sc.nextLine();
				pst.setString(1,name);
				pst.setString(2, phoneNumber);
				pst.executeUpdate();
				System.out.println("Inserted...!");
			}
			
		} catch (Exception e) {
			System.out.println("Erooe: " + e);
		}
	}
}
