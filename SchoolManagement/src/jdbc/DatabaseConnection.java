package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
	public static Connection getConnection() throws Exception{
		Connection con;
		String driverName="com.mysql.jdbc.Driver"; 
		String url="jdbc:mysql://localhost:3306/";
		String databaseName="school_management";
		String username="root";
		String password="";
		Class.forName (driverName);
		con = DriverManager.getConnection(url+databaseName, username, password);
		return con;
	}
}
