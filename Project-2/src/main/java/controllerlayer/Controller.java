package controllerlayer;
import javax.servlet.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.io.PrintWriter;
import java.util.List;

import project.factory.ServiceFactory;
import project.factory.StudentObject;
import project.serviceLayer.*;
import project.bean.*;
/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller/*")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response_method(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response_method(request,response);
		
	}
	public void response_method(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=null;
		String check_uri=request.getRequestURI();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(check_uri.endsWith("addform"))
		{
			 rd= request.getRequestDispatcher("/addform.html");
			rd.forward(request, response);
		}
		if(check_uri.endsWith("addstudent"))
		{
			/*RequestDispatcher rd= request.getRequestDispatcher("/addform.html");
			rd.forward(request, response);*/
			String name =request.getParameter("name");
			String number =request.getParameter("number");
			String course =request.getParameter("course");
			Serviceable service=ServiceFactory.getObject();
			Student  student =StudentObject.getObject();
			student .setName(name);
			student.setNumber(number);
			student.setCourse(course);
			
		String status=service.add(student);
		if(status.equalsIgnoreCase("success"))
		{
			rd= request.getRequestDispatcher("/success.html");
			rd.forward(request, response);
		}
		else
		{
			rd= request.getRequestDispatcher("/failure.html");
			rd.forward(request, response);
		}
		
		}
		if(check_uri.endsWith("Index"))
		{
			rd= request.getRequestDispatcher("/Index.html");
			rd.forward(request, response);
		}
		if(check_uri.endsWith("updateform"))
		{
			rd= request.getRequestDispatcher("/updateform.html");
			rd.forward(request, response);
		}
		if(check_uri.endsWith("update"))
		{
			String name =request.getParameter("name");
			Serviceable service=ServiceFactory.getObject();
			Student  student =StudentObject.getObject();
			student.setName(name);
		String status=	service.updatestatus(student);
		if(status.equals("yes"))
		{
			out.println("<html><body>");
			out.println("<h1 align=\"center\"> EDIT FORM </h1>");
			out.println("<form method=\"post\" action=\"./controller/updatestatus\">");
			out.println("<table>");
			out.println("<tr>");
			out.println("<td>NAME </td> <td><input type =\"text\"  name =\"name\" value=\""+student.getName()+"\" readonly></td></tr>");
			out.println("<tr>");
			out.println("<td> COURSE </td><td><input  type=\"text\" name=\"course\"><td></tr> ");
			out.println("<tr><td> MOBILE </td><td><input  type=\"text\" name=\"mobile\"><td></tr> ");
			out.println("<tr><td><input  type=\"submit\" value=\"EDIT\"><td></tr> ");
			
		}
		else
		{
			rd= request.getRequestDispatcher("/failure.html");
			rd.forward(request, response);
		}
		
			
		}
		
		if(check_uri.endsWith("updatestatus"))
		{
			String name =request.getParameter("name");
			String number =request.getParameter("mobile");
			String course =request.getParameter("course");
			Serviceable service=ServiceFactory.getObject();
			Student  student =StudentObject.getObject();
			student .setName(name);
			student.setNumber(number);
			student.setCourse(course);
		String status=	service.editform(student);
		if(status.equalsIgnoreCase("updated"))
		{
			rd= request.getRequestDispatcher("/success.html");
			rd.forward(request, response);
		}
		else 
		{
			rd= request.getRequestDispatcher("/failure.html");
			rd.forward(request, response);
		}
		}
		if(check_uri.endsWith("deleteform"))
		{
			rd= request.getRequestDispatcher("/deleteform.html");
			rd.forward(request, response);
		}
	
		if(check_uri.endsWith("delete"))
		{
			String name =request.getParameter("name");
			Serviceable service=ServiceFactory.getObject();
			Student  student =StudentObject.getObject();
			student.setName(name);
			String status=	service.delete(student);
			if(status.equalsIgnoreCase("updated"))
			{
				rd= request.getRequestDispatcher("/success.html");
				rd.forward(request, response);
			}
			else 
			{
				rd= request.getRequestDispatcher("/failure.html");
				rd.forward(request, response);
			}
		}
		
		if(check_uri.endsWith("searchform"))
				{
			rd= request.getRequestDispatcher("/searchform.html");
			rd.forward(request, response);
				}
		
		
		if(check_uri.endsWith("search"))
		{
			String name =request.getParameter("name");
			Serviceable service=ServiceFactory.getObject();
			Student  student =StudentObject.getObject();
			student.setName(name);
			List<Student> l1  =	service.search(student);
			if(l1.isEmpty())
			{
				rd= request.getRequestDispatcher("/failure.html");
				rd.forward(request, response);
			}
			else {
			out.println("<html><body>");
			out.println("<table border=\"2\" bgcolor=\"orange\" align=\"center\"> ");
			out.println("<h1> YOUR RESULT IS BELOW ABOUT THE STUDENT</H1>");
			
			try
			{
			for(Student s: l1)
			{
			out.println("<tr><td> STUDENT NAME  </TD><td>"+s.getName()+"</td></tr>");
			out.println("<tr><td> STUDENT MOBILE  </TD><td>"+s.getNumber()+"</td></tr>");
			out.println("<tr><td> STUDENT EMAIL  </TD><td>"+s.getCourse()+"</td></tr>");
			
			out.println("<br><br>");
			}
			}
			catch(Exception e)
			{
				System.out.println("exception here  ");
			}
			out.println("</table>");
			out.println("</body></html>");
		}
		}
	}
			
		

}

