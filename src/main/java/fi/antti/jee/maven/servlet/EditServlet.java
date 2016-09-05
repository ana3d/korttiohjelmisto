package fi.antti.jee.maven.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.antti.jee.maven.bean.Kortti;
import fi.antti.jee.maven.dao.Dao;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/Edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("EditServlet.doPost()");
		String jsp = "/edit.jsp";

		String id = request.getParameter("id");
		String edit = "";
		edit += request.getParameter("muokkaus");


		
		Dao db = new Dao();

		Kortti kortti = new Kortti();

		if (edit.equals("edit")) {
			String etunimi = request.getParameter("etunimi");
			String sukunimi = request.getParameter("sukunimi");
			String osoite = request.getParameter("osoite");
			String zip = request.getParameter("zip");
			String postitoimipaikka = request.getParameter("postitoimipaikka");
			jsp = "/kortit.jsp";
			try {
				
				kortti.setId(Integer.parseInt(id));
				kortti.setEtunimi(etunimi);
				kortti.setSukunimi(sukunimi);
				kortti.setPostitoimipaikka(postitoimipaikka);
				kortti.setZip(zip);
				kortti.setOsoite(osoite);
				
				db.editOsoite(kortti);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
		} else {
			
			try {

				kortti = db.haeRivi(Integer.parseInt(id));
				request.setAttribute("kortti", kortti);

			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}



		

		

		RequestDispatcher dp = getServletContext().getRequestDispatcher(jsp);
		dp.forward(request, response);

	}

}
