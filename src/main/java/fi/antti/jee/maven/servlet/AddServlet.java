package fi.antti.jee.maven.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.antti.jee.maven.bean.Kortti;
import fi.antti.jee.maven.dao.Dao;


/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("AddServlet.doPost()");
		
		Dao db = new Dao();
		
		String etunimi = request.getParameter("etunimi");
		String sukunimi = request.getParameter("sukunimi");
		String osoite = request.getParameter("osoite");
		String zip = request.getParameter("zip");
		String postitoimipaikka = request.getParameter("postitoimipaikka");
		
		Kortti kortti = new Kortti();
		
		kortti.setEtunimi(etunimi);
		kortti.setSukunimi(sukunimi);
		kortti.setOsoite(osoite);
		kortti.setZip(zip);
		kortti.setPostitoimipaikka(postitoimipaikka);
		
		
		try {
			
			if (osoite.length() > 1 && zip.length() == 5 && postitoimipaikka.length() > 0 ){
				
				db.lisaaKortti(kortti);
			}
			
		} catch (Exception e) {
		}
		

		String jsp = "/kortit.jsp";
		RequestDispatcher dp = getServletContext().getRequestDispatcher(jsp);
		dp.forward(request, response);
		
		
	}

}
