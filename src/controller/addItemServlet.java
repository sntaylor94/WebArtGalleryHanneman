package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GalleryPiece;

/**
 * Servlet implementation class addItemServlet
 */
@WebServlet("/addItemServlet")
public class addItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public addItemServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String artist = request.getParameter("artistName");
		GalleryPieceHelper galleryHelp = new GalleryPieceHelper();
		String media = request.getParameter("media");
		String year = request.getParameter("year");
		String valueAsString = request.getParameter("value");
		double value = Double.parseDouble(valueAsString);
		GalleryPiece gp = new GalleryPiece(title, artist, media, year, value);
		galleryHelp.insertArt(gp);
		getServletContext().getRequestDispatcher("/addItem.jsp").forward(request, response);
	}

}
