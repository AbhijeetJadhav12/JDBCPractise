package practise;

import java.awt.Taskbar.State;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CRUDOperationWithJoinTable {
	public static void main(String[] args) {

		Connection c = null;
		Scanner sc = new Scanner(System.in);
		try {

			do {
				System.out.println();
				System.out.println("1 Insert Data in Department table");
				System.out.println("2 Insert Data in Employee Table");
				System.out.println("3 Show Data Employee");
				System.out.println("4 Show Employee Table");
				System.out.println("5 Update");
				System.out.println("6 Delet data");
				System.out.println("Enter you choice ");
				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					c = ConnectionProvide.getConnection();
					String q = "insert into department (dept_name) values (?)";
					PreparedStatement pst = c.prepareStatement(q);
					sc.nextLine();
					System.out.println("Enter name of department");
					String deptName = sc.nextLine();
					pst.setString(1, deptName);
					pst.executeUpdate();
					System.out.println("Department Added...!");
					break;
				case 2:
					c = ConnectionProvide.getConnection();
					q = "insert into employee (emp_name, dept_id) values (?,?)";
					pst = c.prepareStatement(q);
					sc.nextLine();
					System.out.println("Enter employee name and deptId");
					String name = sc.nextLine();
					int id = sc.nextInt();
					pst.setString(1, name);
					pst.setInt(2, id);
					pst.executeUpdate();
					System.out.println("Employee Addedd...!");
					break;
				case 3:
					c = ConnectionProvide.getConnection();
					q = "select * from department";
					java.sql.Statement s = c.createStatement();
					ResultSet res = s.executeQuery(q);

					while (res.next()) {
						int eId = res.getInt(1);
						String eName = res.getString(2);

						System.out.println(eId + "\t" + eName);
					}
					break;
				case 4:
					c = ConnectionProvide.getConnection();
					q = "select * from employee";
					s = c.createStatement();
					res = s.executeQuery(q);
					System.out.println("Id\tName\t\tDept_id");
					System.out.println("-------------------");
					while (res.next()) {
						int eId = res.getInt(1);
						String eName = res.getString(2);
						int dept_id = res.getInt(3);
						System.out.println(eId + "\t" + eName + "\t" + dept_id);
					}
					break;
				case 5:
					c = ConnectionProvide.getConnection();
					
					System.out.println("Enter 1 for Update department table and 2 for update Employee table");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						q = "update department set dept_name=? where dept_id=?";
						pst = c.prepareStatement(q);
						sc.nextLine();
						System.out.println("Enter name and id");
						name = sc.nextLine();
						id = sc.nextInt();

						pst.setString(1, name);
						pst.setInt(2, id);
						pst.executeUpdate();
						System.out.println("Updated..!");
						break;
					case 2:
						q = "update employee set emp_name=?,dept_id=? where emp_id=?";
						pst = c.prepareStatement(q);
						sc.nextLine();
						System.out.println("Enter name dept_id and id");
						name = sc.nextLine();
						int dept_id = sc.nextInt();
						id=sc.nextInt();
						pst.setString(1, name);
						pst.setInt(2, dept_id);
						pst.setInt(3, id);
						pst.executeUpdate();
						System.out.println("Updated..!");
						break;
						
					default:
						throw new IllegalArgumentException("Unexpected value: " + choice);
					}
					break;
				case 6:
					System.out.println("Enter 1 to delete from Employee and 2 for delete from Department");
					choice=sc.nextInt();
					c=ConnectionProvide.getConnection();
					switch (choice) {
					case 1: 
						q="delete from employee where emp_id=?";
						System.out.println("Enter id to delete ");
						pst=c.prepareStatement(q);
						id=sc.nextInt();
						pst.setInt(1, id);
						pst.executeUpdate();
						System.out.println("Deleted...!");
						break;
					case 2:
						q="delete from department where dept_id=?";
						System.out.println("Enter id to delete ");
						pst=c.prepareStatement(q);
						id=sc.nextInt();
						pst.setInt(1, id);
						pst.executeUpdate();
						System.out.println("Deleted...!");
					default:
					System.out.println("Invalid Choice");
					}
					break;
				case 7:
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
