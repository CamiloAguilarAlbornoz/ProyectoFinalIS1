package edu.uptc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.model.dao.PersonManager;
import edu.uptc.model.entity.Agent;

/**
 * Servlet implementation class UpdateAgentServlet
 */
@WebServlet("/UpdateAgentServlet")
public class UpdateAgentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String DOCUMENT_CONDUCTOR = "document";
	private static final String NAME_CONDUCTOR = "name";
	private static final String LAST_NAME_CONDUCTOR = "lastName";
	private static final String DIRECTION_CONDUCTOR = "direction";
	private static final String MESSAGE = "message";
	private static final String GREAT_UPDATE_AGENT_JSP = "/great.jsp";
	private static final String ERROR_UPDATE_AGENT_JSP = "/error.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAgentServlet() {
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
			int document = Integer.parseInt(request.getParameter(DOCUMENT_CONDUCTOR));
			String name = request.getParameter(NAME_CONDUCTOR);
			String lastName = request.getParameter(LAST_NAME_CONDUCTOR);
			String direction = request.getParameter(DIRECTION_CONDUCTOR);
			// --------------------- Crear y agregar vehiculo --------------------------------------
			try {
				PersonManager personManager = new PersonManager();
				Agent agent = personManager.findAgent(document);
				agent.setName(name);
				agent.setLastName(lastName);
				agent.setDirection(direction);
				personManager.updatePerson(agent);
				RequestDispatcher dispatcher = request.getRequestDispatcher(GREAT_UPDATE_AGENT_JSP);
		        dispatcher.forward(request, response);
			} catch (Exception e) {
				request.getSession().setAttribute(MESSAGE, e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher(ERROR_UPDATE_AGENT_JSP);
		        dispatcher.forward(request, response);
			}
		} catch (IndexOutOfBoundsException e) {
			request.getSession().setAttribute(MESSAGE, e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher(ERROR_UPDATE_AGENT_JSP);
	        dispatcher.forward(request, response);
		}
	}

}
