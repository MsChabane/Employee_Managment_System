package Frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public abstract class Tools {

	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "chabane");
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return con;
	}

	public static int save(String name, String address, String email, String phone) throws SQLException {
		int result = -1;
		Connection con = connect();
		if (con != null) {
		
				PreparedStatement st = con.prepareStatement(
						"insert into employee (Emp_name,emp_address,emp_email,emp_phone) values (?,?,?,?);");
				st.setString(1, name);
				st.setString(2, address);
				st.setString(3, email);
				st.setString(4, phone);
				result = st.executeUpdate();
				st.close();
				con.close();
			
		}
		return result;
	}

	public static ArrayList<Employee>getEmployees() throws SQLException {
		ArrayList<Employee> employees = null;
		Connection con = connect();
		if (con != null) {
			
				Statement stmnt = con.createStatement();
				ResultSet res = stmnt.executeQuery("select * from employee");
				Employee emp;
				employees=new ArrayList<>();
				while (res.next()) {
					emp = new Employee(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),
							res.getString(5));
					employees.add(emp);
				}
				stmnt.close();
				res.close();
				con.close();
			
		}
		return employees;
	}

	public static int edit(int id,String name, String address, String email, String phone) throws SQLException  {
		Connection con = connect();
		int done=-1;
		
		if(con!=null) {
		//	try {
				PreparedStatement st = con.prepareStatement(
						"update employee set Emp_name=?, emp_address=? ,emp_email=? ,emp_phone=? where emp_id=?");
				st.setString(1, name);
				st.setString(2, address);
				st.setString(3, email);
				st.setString(4, phone);
				st.setInt(5, id);
				done = st.executeUpdate();
				st.close();
				con.close();
			//}catch (Exception e){
				//JOptionPane.showMessageDialog(null, e.getMessage());
			//}
		}
		return done;
	}
	public static int deleteRow(int id) throws SQLException {
		Connection con = connect();
		int done=-1;
		if(con!=null) {
			
				PreparedStatement st = con.prepareStatement(
						"delete from employee where emp_id = ?");
				st.setInt(1, id);
				done = st.executeUpdate();
				st.close();
				con.close();
			
		}
		return done;
		
	}

	
	
	
	

}
