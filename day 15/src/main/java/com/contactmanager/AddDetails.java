package com.contactmanager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;

/**
 * Servlet implementation class AddDetails
 */
@WebServlet("/AddDetails")
public class AddDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	// why static and public 
	// private List - ensures encapsulation
	// public getContacts() - to make it accessable in ViewDetails servlet
	// static List & getContacts() - so that they are directly accessible without creating its obj.
	// servlet conatiner creates 1 obj at start after loading of servlet then doGet() doPost() are called form that obj.
	// if u created new obj , so your contact data will not be there for this new obj
	
	// using static public is not good practice, (ok for small projects)
	// good practice for servlet communication - use ServletContext
	
	private static List<ContactsModel> contacts = new ArrayList<>();
	
	public static List<ContactsModel> getContacts() {
		return contacts;
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		// i have created a arraylist for storing constact details (see abouve)
		
		//fetch
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		//store data in database or my collection
		ContactsModel obj = new ContactsModel(name, phone);
		contacts.add(obj);
		
		//now lets send response = html
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.println("<html><body>");
		pw.println("<p>Successfully Added the Contacts Information.</p>");
		pw.println("<a href='ViewDetails' >");       // i cant use " inside ", use ' inside "
		pw.println("<button>View Details</button>");
		pw.println("</a>"); 
		pw.println("</body></html>");
		
	}

}
