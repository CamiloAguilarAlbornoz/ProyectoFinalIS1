package edu.uptc.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.model.dao.PersonManager;
import edu.uptc.model.entity.Conductor;
import edu.uptc.model.entity.Vehicle;

/**
 * Servlet implementation class UpdateConductorServlet
 */
@WebServlet("/UpdateConductorServlet")
public class UpdateConductorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String DOCUMENT_CONDUCTOR = "document";
	private static final String NAME_CONDUCTOR = "name";
	private static final String LAST_NAME_CONDUCTOR = "lastName";
	private static final String DIRECTION_CONDUCTOR = "direction";
	private static final String DATE_EXPEDITION_CONDUCTOR = "dateExpedition";
	private static final String DATE_EXPIRATION_CONDUCTOR = "dateExpiration";
	private static final String TRADEMARK_VEHICLE = "trademark";
	private static final String YEAR_VEHICLE = "year";
	private static final String MESSAGE = "message";
	private static final String GREAT_UPDATE_CONDUCTOR_JSP = "/great.jsp";
	private static final String ERROR_UPDATE_CONDUCTOR_JSP = "/error.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateConductorServlet() {
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
			Date dateExpedition = Date.valueOf(request.getParameter(DATE_EXPEDITION_CONDUCTOR));
			Date dateExpiration = Date.valueOf(request.getParameter(DATE_EXPIRATION_CONDUCTOR));
			// ------------------ Datos del vehiculo ----------------------------------------------
			String trademark = request.getParameter(TRADEMARK_VEHICLE);
			int year = Integer.valueOf(request.getParameter(YEAR_VEHICLE));
			// --------------------- Crear y agregar vehiculo --------------------------------------
			try {
				PersonManager personManager = new PersonManager();
				Conductor conductor = personManager.findConductor(document);
				conductor.setName(name);
				conductor.setLastName(lastName);
				conductor.setDateExpedition(dateExpedition);
				conductor.setDateExpiration(dateExpiration);
				conductor.setDirection(direction);
				Vehicle vehicle = conductor.getVehicle();
				vehicle.setTrademark(trademark);
				vehicle.setYear(year);
				personManager.updatePerson(conductor);
				RequestDispatcher dispatcher = request.getRequestDispatcher(GREAT_UPDATE_CONDUCTOR_JSP);
		        dispatcher.forward(request, response);
			} catch (Exception e) {
				request.getSession().setAttribute(MESSAGE, e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher(ERROR_UPDATE_CONDUCTOR_JSP);
		        dispatcher.forward(request, response);
			}
		} catch (IndexOutOfBoundsException e) {
			request.getSession().setAttribute(MESSAGE, e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher(ERROR_UPDATE_CONDUCTOR_JSP);
	        dispatcher.forward(request, response);
		}
	}

}
