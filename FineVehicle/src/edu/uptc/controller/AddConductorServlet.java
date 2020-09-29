package edu.uptc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.model.dao.ConductorManager;

/**
 * Servlet implementation class AddConductorServlet
 */
@WebServlet("/AddConductorServlet")
public class AddConductorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String DOCUMENT_CONDUCTOR = "document";
	private static final String NAME_CONDUCTOR = "name";
	private static final String LAST_NAME_CONDUCTOR = "lastName";
	private static final String DIRECTION_CONDUCTOR = "direction";
	private static final String DATE_EXPEDITION_CONDUCTOR = "dateExpedition";
	private static final String DATE_EXPIRATION_CONDUCTOR = "dateExpiration";
	private static final String LICENSE_PLATE_VEHICLE = "licensePlate";
	private static final String TRADEMARK_VEHICLE = "trademark";
	private static final String YEAR_VEHICLE = "year";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddConductorServlet() {
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
		//------------------- Datos del Conductor -----------------------
		int document = Integer.parseInt(request.getParameter(DOCUMENT_CONDUCTOR));
		String name = request.getParameter(NAME_CONDUCTOR);
		String lastName = request.getParameter(LAST_NAME_CONDUCTOR);
		String direction = request.getParameter(DIRECTION_CONDUCTOR);
		Date dateExpedition = Date.valueOf(request.getParameter(DATE_EXPEDITION_CONDUCTOR));
		Date dateExpiration = Date.valueOf(request.getParameter(DATE_EXPIRATION_CONDUCTOR));
		// ------------------ Datos del vehiculo ----------------------------------------------
		String licensePlate = request.getParameter(LICENSE_PLATE_VEHICLE);
		String trademark = request.getParameter(TRADEMARK_VEHICLE);
		Date year = Date.valueOf(request.getParameter(YEAR_VEHICLE));
		// --------------------- Crear y agregar vehiculo --------------------------------------
		ConductorManager conductorManager = new ConductorManager();
		if (conductorManager.addConductor(ConductorManager.createConductor(document, name, lastName, direction, 
				dateExpedition, dateExpiration, licensePlate, trademark, year))) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<html>");
			out.println("<head><title>Agregar Conductor</title>");
			out.println("<title>Agregar Conductor</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>El conductor ha sido agregado exitosamente!</h1>");
			out.println("<h2><a href=\"index.jsp\"> Volver a la página inicial!</h2>");
			out.println("</body></html>");
		} else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<html>");
			out.println("<head><title>Agregar Conductor</title>");
			out.println("<title>Agregar Conductor</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Error en la adición del conductor!</h1>");
			out.println("<h2><a href=\"index.jsp\"> Volver a la página inicial!</h2>");
			out.println("</body></html>");
		}
	}
}
