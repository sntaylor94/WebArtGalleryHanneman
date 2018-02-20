package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GalleryPiece;

/**
 * Servlet implementation class editItemServlet
 */
@WebServlet("/editItemServlet")
public class editItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GalleryPieceHelper galleryHelper = new GalleryPieceHelper();
		
		String title = request.getParameter("title");
		String artist = request.getParameter("artist");
		String media = request.getParameter("media");
		String year = request.getParameter("year");
		String valueAsString = request.getParameter("value");
		double value = Double.parseDouble(valueAsString);
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		GalleryPiece pieceToUpdate = galleryHelper.searchForItemById(tempId);
		pieceToUpdate.setTitle(title);
		pieceToUpdate.setArtistName(artist);
		pieceToUpdate.setMedia(media);
		pieceToUpdate.setYear(year);
		pieceToUpdate.setValue(value);
		
		galleryHelper.updateItem(pieceToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
		
		
	}

}
