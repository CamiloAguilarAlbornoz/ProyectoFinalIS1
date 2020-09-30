package edu.uptc.controller;

import java.io.IOException;

import javax.persistence.EntityNotFoundException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.model.dao.PersonManager;
import edu.uptc.model.dao.STATE_CONDUCTOR;
import edu.uptc.model.entity.Person;

/**
 * Servlet implementation class RemoveConductorServlet
 */
@WebServlet("/RemoveConductorServlet")
public class RemoveConductorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String DOCUMENT_PERSON = "documento";
	private static final String GREAT_ADD_CONDUCTOR_JSP = "/great.jsp";
	private static final String ERROR_ADD_CONDUCTOR_JSP = "/error.jsp";
	private static final String MESSAGE = "message";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveConductorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int document = Integer.parseInt(request.getParameter(DOCUMENT_PERSON));
			PersonManager personManager = new PersonManager();
			Person person = personManager.findPerson(document);
			person.setState(STATE_CONDUCTOR.INNACTIVE.toString());
			personManager.updatePerson(person);
			change(request, response, GREAT_ADD_CONDUCTOR_JSP);
		} catch (EntityNotFoundException e) {
			request.getSession().setAttribute(MESSAGE, e.getMessage());
			change(request, response, ERROR_ADD_CONDUCTOR_JSP);
		}
	}
	
	private void change(HttpServletRequest request, HttpServletResponse response, String page) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
	}
}
