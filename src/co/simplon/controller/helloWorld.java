package co.simplon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.simplon.dao.DAOContext;
import co.simplon.dao.DAOPays;
import co.simplon.model.Pays;

/**
 * Servlet implementation class CountryServlet
 */
@WebServlet(urlPatterns="/country", loadOnStartup=1)
public class helloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	 @Override
	    public void init() throws ServletException {
	        DAOContext.init( this.getServletContext() );
	    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public helloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOContext daoContext = new DAOContext();
        DAOPays daopays = daoContext.getPaysDao();
        List<Pays> listePays = daopays.lister();
        request.setAttribute("liste",listePays);


		
		RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/vues/country.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		String nomPays = request.getParameter("nomPays");
		DAOContext daoContext = new DAOContext();
		DAOPays daopays = daoContext.getPaysDao();
		if(nomPays.isEmpty())
		{
			message = "le champ est vide...";
			request.setAttribute("message",message);
		}
		else
		{
			Pays pays = new Pays();
			pays.setNom(nomPays);
			daopays.ajouter(pays);
		}
		
		List<Pays> listePays = daopays.lister();
		request.setAttribute("liste",listePays);
		request.setAttribute("message",message);
		response.sendRedirect(request.getContextPath() + "/country");
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
