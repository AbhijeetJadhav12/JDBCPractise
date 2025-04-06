package com.org;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;

public class AddImageTODB {
	public static void main(String[] args) {

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Practise","root","2002");
			String q="insert into images (pic) values(?)";
			java.sql.PreparedStatement pstmt=con.prepareStatement(q);	
			
			FileInputStream fis=new FileInputStream("D:\\Template\\Abhi2.JPG");
			pstmt.setBinaryStream(1, fis, fis.available());
			pstmt.executeUpdate();
			System.out.println("Image Added");
		}catch (Exception e) {
			System.out.println("Error: "+e);
			
		}
	}
}
