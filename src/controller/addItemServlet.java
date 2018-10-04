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
 * Servlet implementation class addItemServlet
 */
@WebServlet("/addItemServlet")
public class addItemServlet extends HttpServlet { // Begin class.
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addItemServlet() { // Begin constructor.
        super();
        // TODO Auto-generated constructor stub
    } // Close constructor.

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // Begin doPost method.
		// TODO Auto-generated method stub
		String teamName = request.getParameter("teamName");
		String teamNickname = request.getParameter("teamNickname");
		ListItem li = new ListItem(teamName, teamNickname);
		ListItemHelper dao = new ListItemHelper();
		dao.insertItem(li);
		
		getServletContext().getRequestDispatcher("/addItem.html").forward(request, response);
	} // Close doPost method.
} // Close class.
