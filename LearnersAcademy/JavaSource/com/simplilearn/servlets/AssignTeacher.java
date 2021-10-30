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


public class AssignTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AssignTeacher() {
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
			
			int tch1 = Integer.parseInt(request.getParameter("tch"));
			
			
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction tx= session.beginTransaction();
			Subjects tch2 =session.load(Subjects.class, subj);
			tch2.setTeacher_id(tch1);
			session.update(tch2);
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
