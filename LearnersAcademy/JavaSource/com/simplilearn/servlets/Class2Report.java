package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.models.Students;
import com.simplilearn.models.Subjects;
import com.simplilearn.models.Teachers;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class Class2Report
 */
public class Class2Report extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Class2Report() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			HttpSession session1 = request.getSession();
			System.out.println(session1.getAttribute("username"));
			
			if(session1.getAttribute("username")==null) {
				response.sendRedirect("invalid.jsp");
			}
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			List<Students> StudentList = session.createQuery("select _sub from Students _sub where _sub.class_id=2" , Students.class).getResultList();
			PrintWriter out = response.getWriter();
			out.println("List of Students from Class-2:-");
			String sub = "<br><br><table><tr><th>Student-ID</th><th>Student-Name</th><th>Class-ID</th></tr>";
			
			for (Students list: StudentList) {
				
				sub= sub + "<tr><td>" + list.getStudent_id() +"</td><td>"+list.getName() +"</td><td>"+list.getClass_id() +"</td></tr>";
			}
			
			sub+="</table>";
			out.println(sub);
			
			List<Subjects> subjectsList = session.createQuery("select _sub from Subjects _sub where _sub.class_id=2" , Subjects.class).getResultList();
			out.println("<br><br>List of Subjects for Class-2:-");
			
			 sub = "<br><br><table><tr><th>Subject-ID</th><th>Subject-Name</th></tr>";
			
			for (Subjects sublist: subjectsList) {
				
				sub= sub + "<tr><td>" + sublist.getSubject_id() +"</td><td>"+sublist.getName() +"</td></tr>";
			}
			
			sub+="</table>";
			out.println(sub);
			
			List<Teachers> TeacherList = session.createQuery("select _sub from Teachers _sub join Subjects _sub1 on _sub.teacher_id=_sub1.teacher_id where _sub1.class_id=2" ,Teachers.class).getResultList();
			out.println("<br><br>List of Teachers for Class-2:-");
			
			sub = "<br><br><table><tr><th>Teacher-ID</th><th>Teacher-Name</th></tr>";
			
			for (Teachers list: TeacherList) {
				
				sub= sub + "<tr><td>" + list.getTeacher_id() +"</td><td>"+list.getName() +"</td></tr>";
			}
			
			sub+="</table>";
			out.println(sub);
			
			
			out.println("<br><br><a href='dashboard.jsp'>Back to dashboard page</a>");
			session.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
