package fi.antti.jee.maven.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.antti.jee.maven.bean.Kortti;
import fi.antti.jee.maven.dao.Dao;

/**
 * Servlet implementation class KorttiServlet
 */
@WebServlet("/KorttiServlet")
public class KorttiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public KorttiServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("KorttiServlet.doGet()");

		Dao db = new Dao();

		ArrayList<Kortti> kortit = null;

		try {
			kortit = db.haeKaikkiTiedot();

			// Jos resultset = tyhj‰, tehd‰‰n dummy olio joka n‰ytet‰‰n sivulla
			if (kortit.size() == 0) {
				Kortti kortti = new Kortti();
				
				kortti.setEtunimi("Tietokannassa ei yhteystietoja");
				
				kortit.add(kortti);
			}

			request.setAttribute("kortit_data", kortit);
			String jsp = "/kortit.jsp";

			RequestDispatcher dp = getServletContext()
					.getRequestDispatcher(jsp);
			dp.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
