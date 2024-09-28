package project.database_layer;
import java.util.List;

import project.bean.*;
public interface Taskable {
	public String addStudent(Student std);
public String checkUpdate(Student std);
public String editform(Student std);
public String delete(Student std );
public List<Student> search(Student std);
}
