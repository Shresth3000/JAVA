import java.sql.*;

public class JDBC_Ins {

	
	public static void main(String[] args) throws Exception

	{

   Class.forName("oracle.jdbc.driver.OracleDriver");
   
  
   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shresth","shresth"); //both "system" for user name & pswd to connect Oracle
   System.out.println("Connected to Oracle Database");

		
		PreparedStatement ps = null;

		

		
		try {

			
			String sql = "insert into student_CSE_43 values(15,'WYZ',10)";


			ps = con.prepareStatement(sql);


			ps.execute();
		}

		
		catch (Exception e) {


			System.out.println(e);
		}
   con.close();
	}
}