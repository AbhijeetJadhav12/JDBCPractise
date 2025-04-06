package practise;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CRUDOperation {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection c=null;
		try {
			c=ConnectionProvide.getConnection();
			PreparedStatement pst=null;
			
			do {
				System.out.println();
				System.out.println("\n------ Student Management ------");
                System.out.println("1. Insert Student");
                System.out.println("2. Display All Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice=sc.nextInt();
                
                switch(choice) {
                case 1:
                	String q="insert into student (name,email,phoneNumber,city) values(?,?,?,?)";
                	pst=c.prepareStatement(q);
                	System.out.println("Enter name,email,phoneNumber,city");
                	sc.nextLine();
                	String name=sc.nextLine();
                	String email=sc.nextLine();
                	String phoneNumber=sc.nextLine();
                	String city=sc.nextLine();
                	
                	pst.setString(1, name);
                	pst.setString(2,email);
                	pst.setString(3, phoneNumber);
                	pst.setString(4, city);
                	
                	pst.executeUpdate();
                	System.out.println("Inserted..!");
                	break;
                case 2:
                	java.sql.Statement s=c.createStatement();
                	 q="select * from student";
                	ResultSet res= s.executeQuery(q);
                	 while(res.next()) {
                		 int id=res.getInt(1);
                		 String sName=res.getString(2);
                		 String sEmail=res.getString(3);
                		 phoneNumber=res.getString(4);
                		 city=res.getString(5);
                		 System.out.println(id+"\t"+sName+"\t"+sEmail+"\t"+phoneNumber+"\t"+city);
                	 }
                	break;
                case 3:
                	q="update student set name=?,email=?,phoneNumber=?,city=? where id=?";
                	pst=c.prepareStatement(q);
                	sc.nextLine();
                	System.out.println("Enter name, email,phoneNumber,city,id");
                	name=sc.nextLine();
                	email=sc.nextLine();
                	phoneNumber=sc.nextLine();
                	city=sc.nextLine();
                	int id=sc.nextInt();
                	
                	pst.setString(1, name);
                	pst.setString(2, email);
                	pst.setString(3, phoneNumber);
                	pst.setString(4, city);
                	pst.setInt(5, id);
                	
                	pst.executeUpdate();
                	System.out.println("Updated...!");
                		
                	break;
                case 4:
                	q="delete from student where id=?";
                	pst=c.prepareStatement(q);
                	System.out.println("Enter id to Delete");
                	id=sc.nextInt();
                	
                	pst.setInt(1, id);
                	
                	pst.executeUpdate();
                	System.out.println("deleted...!");
                	break;
                case 5:
                	System.exit(0);
                	break;
                	default:
                		System.out.println("Invalid Choice");
                
                }
                	
			} while (true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
