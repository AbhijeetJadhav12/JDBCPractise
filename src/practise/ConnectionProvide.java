package practise;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvide {

	static Connection con;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		try {
			if (con == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/Practise?useSSL=false";
				con=DriverManager.getConnection(url,"root","2002");
				}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return con;
	}
}
