package edu.uptc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.model.dao.AgentManager;
import edu.uptc.model.dao.PersonManager;
import edu.uptc.model.dao.STATE_CONDUCTOR;

/**
 * Servlet implementation class AddAgenteServlet
 */
@WebServlet("/AddAgenteServlet")
public class AddAgenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DOCUMENT_AGENT = "document";
	private static final String NAME_AGENT = "name";
	private static final String LAST_NAME_AGENT = "lastName";
	private static final String DIRECTION_AGENT = "direction";
	private static final String GREAT_ADD_AGENT_JSP = "/great.jsp";
	private static final String ERROR_ADD_AGENT_JSP = "/error.jsp";
	private static final String MESSAGE = "message";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAgenteServlet() {
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
			int document = Integer.parseInt(request.getParameter(DOCUMENT_AGENT));
			String name = request.getParameter(NAME_AGENT);
			String lastName = request.getParameter(LAST_NAME_AGENT);
			String direction = request.getParameter(DIRECTION_AGENT);
			try {
				PersonManager personManager = new PersonManager();
				personManager.addPerson(AgentManager.createAgent(STATE_CONDUCTOR.ACTIVE.toString(), 
						document, name, lastName, direction));
				RequestDispatcher dispatcher = request.getRequestDispatcher(GREAT_ADD_AGENT_JSP);
		        dispatcher.forward(request, response);
			} catch (Exception e) {
				request.getSession().setAttribute(MESSAGE, e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher(ERROR_ADD_AGENT_JSP);
		        dispatcher.forward(request, response);
			}
		} catch (IndexOutOfBoundsException e) {
			request.getSession().setAttribute(MESSAGE, e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher(ERROR_ADD_AGENT_JSP);
	        dispatcher.forward(request, response);
		}
	}

}
