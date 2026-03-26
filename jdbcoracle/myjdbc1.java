import java.sql.*;
class myjdbc1
{
 public static void main(String args[])throws Exception
  {
   //Load and Register the Driver class
   Class.forName("oracle.jdbc.driver.OracleDriver");
   
   //Create the Connecton to connect the Database
   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shresth","shresth"); //both "system" for user name & pswd to connect Oracle
   System.out.println("Connected to Oracle Database");
   
   //Create the Statement or Statement object to execute the Query related to Database
   Statement st=con.createStatement();

   //Execute the Query Statement (DDL,DML, DQL)
   st.execute("create table student_CSE_43(roll Number(6),name Varchar2(30),age Number(2))");
   System.out.println("Table Created");

   //ResultSet rs=st.executeQuery("select * from student_CSE_47");

  /* while (rs.next()) {	
	int rollno = rs.getInt("roll");
	String name = rs.getString("name");
	int age = rs.getInt("age");
        System.out.println(rollno);

}*/

   //Closing the Connection
   st.close();
   con.close();
  }
}