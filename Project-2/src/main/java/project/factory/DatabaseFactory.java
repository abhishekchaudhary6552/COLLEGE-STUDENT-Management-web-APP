package project.factory;
import project.database_layer.*;
public class DatabaseFactory {

private  static Taskable obj;
static 
{
	obj= new DatabaseImpliment();
}
public static Taskable getObject ()
{
	return  obj;
}
}
