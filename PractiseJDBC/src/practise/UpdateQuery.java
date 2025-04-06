package practise;

import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class UpdateQuery {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc=new Scanner(System.in);
		Connection c=null;
		
		try{
			
			c=ConnectionProvide.getConnection();
		String q="update student set name=?,phoneNumber=? where id=?";
		
		PreparedStatement pstmt=c.prepareStatement(q);
		
		
		System.out.println("ENter name , phoneNumber and id");
		String name=sc.nextLine();
		String phoneNumber=sc.nextLine();
		int id=sc.nextInt();
		
		pstmt.setString(1, name);
		pstmt.setString(2, phoneNumber);
		pstmt.setInt(3, id);
		pstmt.executeUpdate();
		
		System.out.println("Success...");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			c.close();
		}
		
	}
}
