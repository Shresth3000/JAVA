import java.sql.*;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "shresth",
                "shresth"
            );

            System.out.println("Connected successfully!");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}