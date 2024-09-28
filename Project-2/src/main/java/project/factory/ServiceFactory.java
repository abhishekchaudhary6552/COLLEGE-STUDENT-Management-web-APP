package project.factory;
import project.serviceLayer.*;
public class ServiceFactory {
	private static ServiceProvider obj;
	static
	{
		obj=new ServiceProvider();
	}
	 public static Serviceable getObject()
	 {
		 return obj;
	 }
}
