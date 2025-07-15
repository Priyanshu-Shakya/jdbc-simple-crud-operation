package jdbc_statement_crud_operation.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class ii_ReadOrDisplayStudentController {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection conn=null;
		try {
			
			//step-1 Load and register the JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 Create Connection
			
			String url="jdbc:mysql://localhost:3306/jdbc-a7";
			String user="root";
			String pass="Shakya";
			
			conn=DriverManager.getConnection(url,user,pass);
			System.out.println(conn);
			System.out.println("--------------------------------------------");
			
			//Step-3 Create Statement
			Statement stm=conn.createStatement();
			
			//Step-4 Execute Query
			
			ResultSet set=stm.executeQuery("Select * From Student");
			
//			String displayStudentData="Select * From Student";
//			ResultSet set=stm.executeQuery(displayStudentData);
			
			while(set.next()) {
				
				int id=set.getInt("id");
				String name=set.getString("name");
				String email=set.getString("email");
				
				Date dob=set.getDate("dob");
				LocalDate ldob=dob.toLocalDate();
				
				Long phone=set.getLong("phone");
				
				System.out.println("For id : "+id);
				System.out.println("Name is : "+name);
				System.out.println("Email-id is : "+email);
				System.out.println("DOB year is : "+ldob.getDayOfYear());
				System.out.println("Phone No. is : "+phone);
				System.out.println("=======================================================");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				System.out.println(" >> Connection close Succsessfully <<");
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
