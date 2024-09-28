package project.serviceLayer;
import java.util.List;
import project.bean.Student;
import project.factory.DatabaseFactory;
import project.database_layer.*;

public class ServiceProvider implements Serviceable {

	@Override
	public String add(Student std) {
		Taskable add=DatabaseFactory.getObject();
		String status =add.addStudent(std);
return status;
	}
	public String updatestatus(Student std)
	{
		String status=null;
		Taskable add=DatabaseFactory.getObject();
		 status =add.checkUpdate(std);
		return status;
	}
	public String editform(Student std)
	{
		String status=null;
		Taskable add=DatabaseFactory.getObject();
		 status =add.editform(std);
		return status;
	}
public String delete (Student std)

{
String status=null;
Taskable add=DatabaseFactory.getObject();
status =add.delete(std);
return status;
}
public List<Student> search(Student std)
{
	
	Taskable add=DatabaseFactory.getObject();
	List<Student> li=add.search(std);
	return li;
}
}
