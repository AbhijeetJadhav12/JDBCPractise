package com.org;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FirstJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
			
		}catch (Exception e) {
			System.out.println("Error" +e);
		}
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Practise", "root", "2002");
		if (con != null) {
			System.out.println("Connected..");
		}
		
		java.sql.Statement st=con.createStatement();
			String q="create table student (id int primary key auto_increment, name varchar(20))";
		st.executeUpdate(q);
		System.out.println("table Created");
		con.close();
	}
}
