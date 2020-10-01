package edu.uptc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.model.dao.AgentManager;

/**
 * Servlet implementation class AgentServlet
 */
@WebServlet("/AgentServlet")
public class AgentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String MENU = "control";
	private static final String CREATE = "Crear agente";
	private static final String SHOW = "Listado de agentes";
	private static final String REMOVE = "Eliminar agente";
	private static final String UPDATE = "Modificar agente";
	private static final String ADD_AGENT_JSP = "/addAgent.jsp";
	private static final String ATTRIBUTE_LIST = "listAgent";
	private static final String FIND_ALL_AGENTS_JSP = "/findAllAgents.jsp";
	private static final String REMOVE_AGENT_JSP = "/removeAgent.jsp";
	private static final String MODIFY_AGENT_JSP = "/modifyAgent.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getParameter(MENU)) {
		case CREATE:
			change(request, response, ADD_AGENT_JSP);
			break;
		case SHOW:
			read(request, response);
			break;
		case REMOVE:
			change(request, response, REMOVE_AGENT_JSP);
			break;
		case UPDATE:
			change(request, response, MODIFY_AGENT_JSP);
			break;
		}
	}
	
	private void change(HttpServletRequest request, HttpServletResponse response, String page) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
	}
	
	private void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AgentManager agentManager = new AgentManager();
		request.getSession().setAttribute(ATTRIBUTE_LIST, agentManager.findAllAgents());
		change(request, response, FIND_ALL_AGENTS_JSP);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

}
