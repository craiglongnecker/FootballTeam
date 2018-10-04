package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Craig Longnecker
/**
 * Servlet implementation class viewAllItemsServlet
 */
@WebServlet("/viewAllItemsServlet")
public class viewAllItemsServlet extends HttpServlet { // Begin class.
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllItemsServlet() { // Begin constructor.
        super();
        // TODO Auto-generated constructor stub
    } // Close constructor.

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // Begin doGet method.
		// TODO Auto-generated method stub
		ListItemHelper dao = new ListItemHelper();
		
		request.setAttribute("allItems", dao.showAllItems());
		
		if(dao.showAllItems().isEmpty()) { // Begin if statement.
			request.setAttribute("allItems", " ");
		} // Close if statement.
			getServletContext().getRequestDispatcher("/footballteam.jsp").forward(request, response);
	} // Close doGet method.

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // Begin doPost method.
		// TODO Auto-generated method stub
		doGet(request, response);
	} // Close doPost method.
} // Close class.
