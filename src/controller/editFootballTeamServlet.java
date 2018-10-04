package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;
// Craig Longnecker
/**
 * Servlet implementation class editFootballTeamServlet
 */
@WebServlet("/editFootballTeamServlet")
public class editFootballTeamServlet extends HttpServlet { // Begin class.
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editFootballTeamServlet() { // Begin constructor
        super();
        // TODO Auto-generated constructor stub
    } // Close constructor.

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // Begin doGet method.
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	} // Close doGet method.

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // Begin doPost method.
		// TODO Auto-generated method stub
		ListItemHelper dao = new ListItemHelper();
		String act = request.getParameter("doThisToTeam");
		
		if (act == null) { // Begin if statement.
			getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
			
		} else if (act.equals("Delete Selected Team")) { // Close if statement, begin else if statement.
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ListItem teamToDelete = dao.searchForItemById(tempId);
			dao.deleteItem(teamToDelete);
			
			getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
			
		} else if (act.equals("Edit Selected Team")) { // Begin and close else if statements.
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ListItem teamToEdit  = dao.searchForItemById(tempId);
			request.setAttribute("teamToEdit", teamToEdit);
			getServletContext().getRequestDispatcher("/edit-team.jsp").forward(request, response);
			
		} else if (act.equals("Add New Team")) { // Begin and close else if statements.
			getServletContext().getRequestDispatcher("/addItem.html").forward(request, response);
		} // Close else if statement.
	} // Close doPost method.
} // Close class.
