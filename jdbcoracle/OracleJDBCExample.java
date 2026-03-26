import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class OracleJDBCExample {
    public static void main(String[] args) {
        try {
            // Step 1: Load Oracle Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Create Connection
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", // URL
                "shresth",  // username
                "shresth" // password
            );

            // Step 3: Create Statement
            Statement stmt = con.createStatement();

            // Step 4: Create Table
            

            // Step 5: Insert Data
            String insertData = "INSERT INTO st778 VALUES (1, 'Shresth')";
            stmt.executeUpdate(insertData);
            System.out.println("Data inserted successfully");

            // Step 6: Close Connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}