package edu.uptc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.model.dao.AgentManager;
import edu.uptc.model.dao.ConductorManager;

/**
 * Servlet implementation class FineServlet
 */
@WebServlet("/FineServlet")
public class FineServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String MENU = "control";
	private static final String CREATE = "Crear multa";
	private static final String SHOW = "Listado de multas";
	private static final String UPDATE = "Cambiar estado de multa";
	private static final String ATTRIBUTE_LIST_CONDUCTOR = "listConductors";
	private static final String ATTRIBUTE_LIST_AGENT = "listAgents";
	private static final String MODIFY_FINE_JSP = "/modifyFine.jsp";
	private static final String ADD_FINE_JSP = "/addFine.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getParameter(MENU)) {
		case CREATE:
			create(request, response);
			break;
		case SHOW:
			read(request, response);
			break;
		case UPDATE:
			change(request, response, MODIFY_FINE_JSP);
			break;
		}
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConductorManager conductorManager = new ConductorManager();
		AgentManager agentManager = new AgentManager();
		request.getSession().setAttribute(ATTRIBUTE_LIST_CONDUCTOR, conductorManager.findAllConductors());
		request.getSession().setAttribute(ATTRIBUTE_LIST_AGENT, agentManager.findAllAgents());
		change(request, response, ADD_FINE_JSP);
	}

	private void change(HttpServletRequest request, HttpServletResponse response, String page) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
	}

	private void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ConductorManager conductorManager = new ConductorManager();
//		request.getSession().setAttribute(ATTRIBUTE_LIST, conductorManager.findAllConductors());
//		change(request, response, FIND_ALL_FINE_JSP);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

}
