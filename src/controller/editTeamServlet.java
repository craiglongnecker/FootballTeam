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
 * Servlet implementation class editTeamServlet
 */
@WebServlet("/editTeamServlet")
public class editTeamServlet extends HttpServlet { // Begin class.
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editTeamServlet() { // Begin constructor.
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
		
		String teamName = request.getParameter("teamName");
		String teamNickname = request.getParameter("teamNickname");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
	
		ListItem itemToUpdate = dao.searchForItemById(tempId);
		itemToUpdate.setTeamNickname(teamNickname);
		itemToUpdate.setTeamName(teamName);
		
		dao.updateItem(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
	} // Close doPost method.
} // Close class.
