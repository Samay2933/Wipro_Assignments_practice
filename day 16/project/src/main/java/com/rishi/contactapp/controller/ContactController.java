package com.rishi.contactapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.rishi.contactapp.dao.ContactsDAO;
import java.util.*;
import com.rishi.contactapp.model.Contact;

/**
 * Servlet implementation class ContactController
 */
@WebServlet("/ContactController")
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getParameter("action");
		List<Contact> contacts = ContactsDAO.getAllContactDetails();
		if(action.equals("view")) {
			request.setAttribute("contacts", contacts);
			request.getRequestDispatcher("view.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String action = request.getParameter("action");
		String msg = null;
		// add Contacts
		if(action.equals("add")) {
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			
			msg = ContactsDAO.addContacts(name, phone);
		}
		
		//modify
		if(action.equals("modify")) {
			String str_id = request.getParameter("id");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			
			msg = ContactsDAO.updateContacts(str_id, name, phone);
		}
		
		//delete
		if(action.equals("delete")) {
			String str_id = request.getParameter("id");
			
			msg = ContactsDAO.deleteContacts(str_id);
		}
		
		request.setAttribute("message", msg);
		request.getRequestDispatcher("output.jsp").forward(request, response);
		
	}

}
