package project.factory;
import project.bean.*;
public class StudentObject {

	private static Student obj;
	static 
	{
		obj=new Student();
	}
	
	public static Student getObject()
	{
		return obj;
	}
	
}
