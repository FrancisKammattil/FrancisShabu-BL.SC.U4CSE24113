package project;
import java.sql.*;

public class Conn {
	Connection c;
	Statement s;
	
	
	
	public Conn() {
   try {
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   c=DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem","root","Vattan2005##");
       s=c.createStatement();
   } catch (Exception e) {
	   e.printStackTrace();
   }
}
}