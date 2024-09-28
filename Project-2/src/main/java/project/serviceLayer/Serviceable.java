package project.serviceLayer;
import project.bean.*;
import java.util.List;
public interface Serviceable {

	public String add(Student std);
	public String updatestatus(Student std);
	public String editform(Student std);
	public String delete(Student std);
	public List<Student> search(Student std);
}
