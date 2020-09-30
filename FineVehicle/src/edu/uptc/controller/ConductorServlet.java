package edu.uptc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.model.dao.ConductorManager;

/**
 * Servlet implementation class ConductorServlet
 */
@WebServlet("/ConductorServlet")
public class ConductorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String MENU = "control";
	private static final String CREATE = "Crear conductor";
	private static final String SHOW = "Listado de conductores";
	private static final String REMOVE = "Eliminar conductor";
	private static final String UPDATE = "Modificar conductor";
	private static final String ADD_CONDUCTOR_JSP = "/addConductor.jsp";
	private static final String ATTRIBUTE_LIST = "listConductor";
	private static final String FIND_ALL_CONDUCTORS_JSP = "/findAllConductors.jsp";
	private static final String REMOVE_CONDUCTOR_JSP = "/removeConductor.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConductorServlet() {
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
		case REMOVE:
			remove(request, response);
			break;
		case UPDATE:
			
			break;
		}
	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(REMOVE_CONDUCTOR_JSP);
        dispatcher.forward(request, response);
	}

	private void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConductorManager conductorManager = new ConductorManager();
		request.getSession().setAttribute(ATTRIBUTE_LIST, conductorManager.findAllConductors());
		RequestDispatcher dispatcher = request.getRequestDispatcher(FIND_ALL_CONDUCTORS_JSP);
        dispatcher.forward(request, response);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(ADD_CONDUCTOR_JSP);
        dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
