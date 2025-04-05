package practise;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		try {

			Connection c=ConnectionProvide.getConnection();
			
			String q="insert into Images (pic) values(?)";
			
			PreparedStatement pstmt=c.prepareStatement(q);
			
			JFileChooser jfc=new JFileChooser();
			jfc.showOpenDialog(null);
			File file=jfc.getSelectedFile();
			FileInputStream fis=new FileInputStream(file);
			pstmt.setBinaryStream(1, fis, fis.available());
			pstmt.executeUpdate();
			System.out.println("Image Inserted");
			c.close();
			//JOptionPane.showMessageDialog(null, "Success..");
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	}
}
