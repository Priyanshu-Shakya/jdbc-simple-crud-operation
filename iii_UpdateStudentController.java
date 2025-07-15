package jdbc_statement_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class iii_UpdateStudentController {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        try {
            // Step-1: Load and register the JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step-2: Create Connection
            String url = "jdbc:mysql://localhost:3306/jdbc-a7";
            String user = "root";
            String pass = "Shakya";

            conn = DriverManager.getConnection(url, user, pass);
            System.out.println(conn);
            System.out.println("--------------------------------------------");

            // Step-3: Create Statement
            Statement stm = conn.createStatement();

            // Provide the id of the student to be updated
            int targetId = 223;  // Change this to the ID you want to update
            String newName = "Sameer";
            long newPhone = 4455667788L;

            // Step-4: Execute Update Query

//          UPDATE table_name
//          SET column1 = value1, column2 = value2, ...
//          		WHERE condition;
            String updateQuery = "UPDATE Student SET name='" + newName + "', phone=" + newPhone + " WHERE id=" + targetId;
            
            int rowsAffected = stm.executeUpdate(updateQuery);

            if (rowsAffected > 0) {
                System.out.println("Update successful. Rows affected: " + rowsAffected);
            } else {
                System.out.println("No student found with ID: " + targetId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                System.out.println(" >> Connection closed successfully <<");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}

