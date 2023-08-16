package employee_management_system;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con;
	public static Connection createDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/employeeDB?useSSL=false";
			String username="root";
			String password="Root123";
			con=DriverManager.getConnection(url,username,password);
		}catch (Exception ex) {
			ex.printStackTrace();
			// TODO: handle exception
		}
		return con;
	}
}
