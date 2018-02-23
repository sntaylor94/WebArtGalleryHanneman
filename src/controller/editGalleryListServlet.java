package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GalleryPiece;

/**
 * Servlet implementation class editGalleryListServlet
 */
@WebServlet("/editGalleryListServlet")
public class editGalleryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editGalleryListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String act = request.getParameter("doThisItem");
		GalleryPieceHelper galleryHelper = new GalleryPieceHelper();
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);

		} else if (act.equals("Delete Selected Item")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			GalleryPiece itemToDelete = galleryHelper.searchForItemById(tempId);
			galleryHelper.deleteItem(itemToDelete);
			
			getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
			
		} else if (act.equals("Edit Selected Item")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			GalleryPiece itemToEdit = galleryHelper.searchForItemById(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			getServletContext().getRequestDispatcher("/edititem.jsp").forward(request, response);
		} else if (act.equals("Add New Item")) {
			getServletContext().getRequestDispatcher("/addItem.jsp").forward(request, response);
		}
		
	}

}
