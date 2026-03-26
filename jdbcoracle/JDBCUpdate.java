import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class JDBCUpdate 
 {
   

   public static void main(String[] args) throws Exception{
    Class.forName("oracle.jdbc.driver.OracleDriver");
   
  
   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system"); //both "system" for user name & pswd to connect Oracle
   System.out.println("Connected to Oracle Database");
PreparedStatement p = null; 
	
        try { 
            String sql 
                = "update student_CSE_47 set age='18' where roll=75"; 
            p = con.prepareStatement(sql); 
            p.execute(); 
        } 
        catch (SQLException e) { 
            System.out.println(e); 
        } 
con.close();
   }
}