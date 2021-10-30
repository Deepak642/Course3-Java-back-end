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

import com.simplilearn.models.Classes;

import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ClasssList
 */
public class ClasssList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ClasssList() {
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

			List<Classes> classList = session.createQuery("select _sub from Classes _sub" , Classes.class).getResultList();
			PrintWriter out = response.getWriter();
			
			String sub = "<table><tr><th>Class-ID</th><th>Class-Name</th></tr>";
			
			for (Classes list: classList) {
				
				sub= sub + "<tr><td>" + list.getClass_id() +"</td><td>"+list.getClass_name() +"</td></tr>";
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
