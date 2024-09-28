package project.factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionProvider {
	
	static
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("CLASS CANNOT BE LOADED ");
		}
	}
	public  static Connection connect()
	
	{
		Connection connection =null;
		try
		{
	 connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","admin");
		}
		catch(SQLException e)
		{
			System.out.println("CANNOT ESTABLISH DATABASE Connection ");
		}
		return connection;
	}

}
