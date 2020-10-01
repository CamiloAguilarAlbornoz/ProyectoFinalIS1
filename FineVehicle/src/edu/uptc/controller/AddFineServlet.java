package edu.uptc.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.model.dao.FineManager;
import edu.uptc.model.dao.PersonManager;
import edu.uptc.model.dao.STATE_FINE;
import edu.uptc.model.entity.Agent;
import edu.uptc.model.entity.Conductor;
import edu.uptc.model.entity.PenaltyFee;

/**
 * Servlet implementation class AddFineServlet
 */
@WebServlet("/AddFineServlet")
public class AddFineServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "descripcion";
	private static final String CONDUCTORS_LIST = "conductorsList";
	private static final String AGENTS_LIST = "agentsList";
	private static final String VALUE_FINE = "value";
	private static final String GREAT_ADD_FINE_JSP = "/great.jsp";
	private static final String ERROR_ADD_FINE_JSP = "/error.jsp";
	private static final String MESSAGE = "message";
	private static final String ID_FINE = "id";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFineServlet() {
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
			int id = Integer.parseInt(request.getParameter(ID_FINE));
			String description = request.getParameter(DESCRIPTION);
			int conductorDocument = Integer.parseInt(request.getParameter(CONDUCTORS_LIST));
			int agentDocument = Integer.parseInt(request.getParameter(AGENTS_LIST));
			int value = Integer.parseInt(request.getParameter(VALUE_FINE));
			try {
				PersonManager personManager = new PersonManager();
				Conductor conductor = personManager.findConductor(conductorDocument);
				Agent agent = personManager.findAgent(agentDocument);
				PenaltyFee penaltyFee = FineManager.createPenaltyFree(id, Date.valueOf(LocalDate.now()), 
						description, STATE_FINE.NOTIFICADA.toString(), value, conductor, agent);
				agent.addFine(penaltyFee);
				conductor.addFine(penaltyFee);
				FineManager fineManager = new FineManager();
				fineManager.addFine(penaltyFee);
				RequestDispatcher dispatcher = request.getRequestDispatcher(GREAT_ADD_FINE_JSP);
		        dispatcher.forward(request, response);
			} catch (Exception e) {
				request.getSession().setAttribute(MESSAGE, e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher(ERROR_ADD_FINE_JSP);
		        dispatcher.forward(request, response);
			}
		} catch (IndexOutOfBoundsException e) {
			request.getSession().setAttribute(MESSAGE, e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher(ERROR_ADD_FINE_JSP);
	        dispatcher.forward(request, response);
		}
	}

}
