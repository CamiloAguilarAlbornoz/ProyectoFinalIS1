package edu.uptc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getParameter(MENU)) {
		case CREATE:
			
			break;
		case SHOW:
			
			break;
		case REMOVE:
			
			break;
		case UPDATE:
			
			break;
		}
	}
}
