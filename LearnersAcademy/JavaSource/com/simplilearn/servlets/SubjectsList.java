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

import com.simplilearn.models.Subjects;
import com.simplilearn.util.HibernateUtil;


public class SubjectsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SubjectsList() {
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

			List<Subjects> subjectsList = session.createQuery("select _sub from Subjects _sub" , Subjects.class).getResultList();
			PrintWriter out = response.getWriter();
			
			String sub = "<table><tr><th>Subject-ID</th><th>Subject-Name</th><th>Class-ID</th><th>Teacher-ID</th></tr>";
			
			for (Subjects sublist: subjectsList) {
				
				sub= sub + "<tr><td>" + sublist.getSubject_id() +"</td><td>"+sublist.getName() +
						"</td><td>"+ sublist.getClass_id() + "</td><td>"+ sublist.getTeacher_id()+"</td></tr>";
			}
			
			sub+="</table>";
			out.println(sub);
			
			
			out.println("<br><br><a href='dashboard.jsp'>Back to dashboard page</a>");
			session.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
