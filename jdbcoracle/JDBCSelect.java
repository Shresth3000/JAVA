import java.sql.*;
public class JDBCSelect {

public static void main(String[] args) throws Exception{
  Class.forName("oracle.jdbc.driver.OracleDriver");
   
   //Create the Connecton to connect the Database
   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shresth","shresth"); //both "system" for user name & pswd to connect Oracle
   System.out.println("Connected to Oracle Database");
try{

    String QUERY = "SELECT roll, name, age FROM student_CSE_43";

   
      
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);
      		      
         while(rs.next()){
            //Display values
            System.out.print("Roll: " + rs.getInt("ROLL"));
           
            System.out.print(", Name: " + rs.getString("NAME"));
 System.out.print(", Age: " + rs.getInt("age"));
           
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}