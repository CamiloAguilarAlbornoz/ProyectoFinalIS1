package edu.uptc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveConductorServlet
 */
@WebServlet("/RemoveConductorServlet")
public class RemoveConductorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DOCUMENT_PERSON = "documento";
       
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
		int document = Integer.parseInt(request.getParameter(DOCUMENT_PERSON));
		
	}
}
