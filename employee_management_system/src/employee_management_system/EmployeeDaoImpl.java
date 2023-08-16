package employee_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class EmployeeDaoImpl implements EmployeeDaoIntrf  {
	
	Connection con;
	@Override
	public void createEmployee(Employee emp) {
		con=DBConnection.createDBConnection();
		String query="insert into employee values(?,?,?,?)";
		try {
			PreparedStatement pstm=con.prepareStatement(query);
			pstm.setInt(1, emp.getId());
			pstm.setString(2, emp.getName());
			pstm.setDouble(3, emp.getSalary());
			pstm.setInt(4, emp.getAge());
			int cnt=pstm.executeUpdate();
			if(cnt!=0) {
				System.out.println("Employee Inserted Successfully");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void showAllEmployee() {
		con=DBConnection.createDBConnection();
		String query="select * from employee";
		System.out.println("Employee Details :");
		
		System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Salary","age");	
		System.out.println("------------------------------------------------------");
		try {
			Statement stmt=con.createStatement();
			ResultSet resultSet=stmt.executeQuery(query);
			while(resultSet.next()) {
				System.out.format("%d\t%s\t%f\t%d\n",resultSet.getInt(1),resultSet.getString(2),
						resultSet.getDouble(3),resultSet.getInt(4));
				System.out.println("------------------------------------------------------");
				
			}
			
		} catch ( Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showEmployeeBasedOnId(int id) {
		con=DBConnection.createDBConnection();
		String query="select * from employee where id="+id;
		try {
			Statement stmt=con.createStatement();
			ResultSet resultSet=stmt.executeQuery(query);
			
			System.out.format("%s\t%s\t%s\t%n","ID","Name","Salary","age");	
			System.out.println("------------------------------------------------------");
			while(resultSet.next()) {
				System.out.format("%d\t%s\t%f\t%d\n",resultSet.getInt(1),resultSet.getString(2),
						resultSet.getDouble(3),resultSet.getInt(4));
			}
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployee(int id, String name) {
		con=DBConnection.createDBConnection();
		String query="update employee set name=? where id=?";
		try {
			PreparedStatement pstm=con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setInt(2, id);
			int cnt=pstm.executeUpdate();
			if(cnt!=0) {
				System.out.println("Employee details updated successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteEmployee(int id) {
		con=DBConnection.createDBConnection();
		String query="delete from employee where id=?";
		try {
			PreparedStatement pstm=con.prepareStatement(query);
			pstm.setInt(1, id);
			
			int cnt=pstm.executeUpdate();
			if(cnt!=0) {
				System.out.println("Employee delted successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
