import java.sql.*;
import java.util.Scanner;

public class JDBCCombined {
    public static void main(String[] args) throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:xe",
            "shresth",
            "shresth"
        );

        Scanner sc = new Scanner(System.in);

        // 👉 User input
        System.out.print("Enter Roll: ");
        int r = sc.nextInt();

        System.out.print("Enter Name: ");
        String n = sc.next();

        System.out.print("Enter Age: ");
        int a = sc.nextInt();

        // 👉 Insert
        PreparedStatement ps = con.prepareStatement(
            "insert into student_CSE_43 values(?,?,?)"
        );
        ps.setInt(1, r);
        ps.setString(2, n);
        ps.setInt(3, a);
        ps.execute();

        System.out.println("Inserted!");

        // 👉 Display
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from student_CSE_43");

        while (rs.next()) {
            System.out.println(
                rs.getInt(1) + " " +
                rs.getString(2) + " " +
                rs.getInt(3)
            );
        }

        con.close();
        sc.close();
    }
}