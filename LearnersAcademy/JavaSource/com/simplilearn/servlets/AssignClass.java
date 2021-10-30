package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.models.Subjects;
import com.simplilearn.util.HibernateUtil;

public class AssignClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AssignClass() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			HttpSession session1 = request.getSession();
			System.out.println(session1.getAttribute("username"));
			
			if(session1.getAttribute("username")==null) {
				response.sendRedirect("invalid.jsp");
			}
		
			
			int subj = Integer.parseInt( request.getParameter("sub"));
			
			int class1 = Integer.parseInt(request.getParameter("cls"));
			
			System.out.println(subj +" " + class1);
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction tx= session.beginTransaction();
			Subjects subj1 =session.load(Subjects.class, subj);
			subj1.setClass_id(class1);
			session.update(subj1);
			tx.commit();
			PrintWriter out = response.getWriter();
			out.println("<p>Updated provided details in database</p>");
			
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
