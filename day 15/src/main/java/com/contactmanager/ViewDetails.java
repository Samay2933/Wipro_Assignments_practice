package com.contactmanager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;


/**
 * Servlet implementation class ViewDetails
 */
@WebServlet("/ViewDetails")
public class ViewDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		// this is called after clicking <a> which is inside AddDetails
		
		// lets fetch contact details 
		List<ContactsModel> contacts = AddDetails.getContacts();
		
		// print contacts on screen;
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.println("<html> <body>");
		pw.println("<h1>Contact details: </h1>");
		pw.println("<table border='1' cellpadding='10' style='border-collapse:collapse; margin-bottom:20px'>");
		pw.println("<tr>");
		pw.println("<th>Name</th>");
		pw.println("<th>Phone Number</th>");
		pw.println("</tr>");
		for(ContactsModel contact : contacts) {
			String name = contact.getName();
			String phone = contact.getPhone();
			pw.println("<tr>");
			pw.println("<td>" + name + "</td>");
			pw.println("<td>" + phone + "</td>");
			pw.println("</tr>");
		}
		pw.println("</table>");
		
		pw.println("<a href='index.html' >");
		pw.println("<button>Add Contacts</button>");
		pw.println("</a>");
		pw.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
