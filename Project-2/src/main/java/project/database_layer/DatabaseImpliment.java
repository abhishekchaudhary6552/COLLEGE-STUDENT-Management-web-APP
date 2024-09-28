package project.database_layer;
import project.bean.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import project.factory.ConnectionProvider;
import java.util.List;
import java.util.ArrayList;



public class DatabaseImpliment implements Taskable{
	public String addStudent(Student student)
	{
		String status=null;
		Connection connection=   ConnectionProvider.connect();
		try
		{
		Statement statement=connection.createStatement();
		int updatecount=statement.executeUpdate("insert into studentmiet  value  ('"+student.getName()+"','"+student.getNumber()+"','"+student.getCourse()+"');");
		if(updatecount==1)
		{
			status="success";
		}
		else
		{
			status="failure";
		}
		}
		catch(Exception  e)
		{
			System.out.println("Problem while performing adding student details to database ");
		}
		return status;
	}
public String checkUpdate(Student student)
{
	String status=null;
	
	Connection connection=   ConnectionProvider.connect();
	try
	{
		Statement statement=connection.createStatement();	
		ResultSet resultset=statement.executeQuery("select * from studentmiet where name='"+student.getName()+"';");
	if(resultset.next())
	{
		status="yes";
	}
	else 
	{
		status="no";
	}
	}
	catch(Exception e)
	{
		System.out.println("Problem in checking update student ");
	}
	return status;
}
public String editform(Student student)
{
	String status=null;
	Connection connection=   ConnectionProvider.connect();
	try
	{
		Statement statement=connection.createStatement();	
		int updatecount =statement.executeUpdate("update  studentmiet\r\n"
				+ " set course='"+student.getCourse()+"' , number='"+student.getNumber()+"'\r\n"
				+ "where name='"+student.getName()+"';");
	if(updatecount>=1)
	{
		status="updated";
	}
	else 
	{
		status="notupdated";
	}
	}
	catch(Exception e)
	{
		System.out.println("Problem in editing student details ");
	}
	return status;
}
public String delete (Student student)
{
	String status=null;
	Connection connection=   ConnectionProvider.connect();
	try
	{
		Statement statement=connection.createStatement();	
		int updatecount =statement.executeUpdate("delete  from studentmiet where name='"+student.getName()+"';");
	if(updatecount>=1)
	{
		status="updated";
	}
	else 
	{
		status="notupdated";
	}
	}
	catch(Exception e)
	{
		System.out.println("Problem in editing student details ");
	}
	return  status;
}

public List<Student> search(Student student)
{
	List<Student> li = new ArrayList();
	
	Connection connection=   ConnectionProvider.connect();
	try
	{
			Statement statement=connection.createStatement();
	ResultSet rs=statement.executeQuery("select * from studentmiet where name='"+student.getName()+"';");
	while(rs.next())
	{
			
		Student s = new Student();
		s.setName(rs.getString(1));
		s.setNumber(rs.getString(2));
		s.setCourse(rs.getString(3));
		li.add(s);
		}
		
	
	
}
	catch(Exception e)
	{
		
		System.out.println("exception");
	}
	return li;
}
}
