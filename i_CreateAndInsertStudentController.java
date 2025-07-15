package jdbc_statement_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class i_CreateAndInsertStudentController {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		
		Connection conn=null;
		try {
			//Step-1 Load/Register JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step-2 Create Connection
			String url="jdbc:mysql://localhost:3306/jdbc-a7";
			String user="root";
			String pass="Shakya";
			
			conn=DriverManager.getConnection(url,user,pass);
			System.out.println(conn);
			System.out.println("----------------------------------------------------------");
			
			//Step-3 Create Statement
			Statement stm=conn.createStatement();
			
			//Step-4 Execute Query
			
			String insertStudentDetails="INSERT INTO Student(id,name,email,dob,phone) VALUES(1234,'Xyz','Xyz123@gmail.com','2008-05-17',8988740676)";
			
			int a=stm.executeUpdate(insertStudentDetails);
			
			if (a!=0) {
				
				System.out.println("==Data Enetred Successfully in Student Table.==");
			} else {
				System.out.println("!! Something Went Wrong !!");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				conn.close();
				System.out.println("<==Also, Connection Closed Succsefully==>");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
