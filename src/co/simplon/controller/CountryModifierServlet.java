package co.simplon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.dao.DAOContext;
import co.simplon.dao.DAOPays;
import co.simplon.model.Pays;

/**
 * Servlet implementation class CountryModifierServlet
 */
@WebServlet(urlPatterns="/countryModifier",loadOnStartup=1)
public class CountryModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public void init() throws ServletException {
        DAOContext.init( this.getServletContext() );
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryModifierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		DAOContext daoContext = new DAOContext();
		DAOPays daopays = daoContext.getPaysDao();
		Pays pays = daopays.find(id);
		request.setAttribute("pays", pays);
		System.out.println(pays.toString());
		RequestDispatcher rs = request.getRequestDispatcher("WEB-INF/vues/uneCountry.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		String action = request.getParameter("queFaire");
		
		System.out.println(action);
		DAOContext daoContext = new DAOContext();
		DAOPays daopays = daoContext.getPaysDao();
		
		Pays pays = daopays.find(id);
		System.out.println(pays.toString());
		
		if(action.equals("Supprimer"))
		{
			daopays.delete(pays);
		}else 
		{
			String nomModifier = request.getParameter("nom");
			Pays paysModifier = new Pays(id,nomModifier);
			daopays.update(paysModifier);
		}
		response.sendRedirect(request.getContextPath() + "/country");
		
		
		//doGet(request, response);
	}

}
