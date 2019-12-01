package net.codejava.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MuseumServlet
 */
@WebServlet("/MuseumServlet")
public class MuseumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MuseumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*System.out.println("Coming here in post request");
		response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      
	      HttpSession session = request.getSession();
	      String latitude = request.getAttribute("latitude").toString();
	      String longitude = request.getAttribute("longitude").toString();
	      MuseumHelper helper = new MuseumHelper();
	      ArtworkDetails details = helper.getDetails(latitude, longitude);
	      session.setAttribute("details", details);

	      out.println("<h1>" + session.getAttribute("details") + "</h1>");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		  response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
		  String latitude = request.getParameter("latitude").toString();
	      String longitude = request.getParameter("longitude").toString();
	      //System.out.println("latitude "+latitude);
	      //System.out.println("longitude "+longitude);
	      MuseumHelper helper = new MuseumHelper();
	      ArtworkDetails details = helper.getDetails(latitude, longitude);
	      String htmlRespone = "<html>";
	      htmlRespone += "<h3> </h3> "; 
	      htmlRespone += "<h2> " + "Artwork Details" + "</h2>";
	      htmlRespone += "<h3>Title: " + details.getArtworkTitle() + "</h3>";
	      htmlRespone += "<h3>Artist Id : " + details.getArtistId() + "</h3>";
	      htmlRespone += "<h3> Acquisition Date: " + details.getAcquisitionDate() + "</h3>";
	      htmlRespone += "<h3> Birth Year: " + details.getBirthYear() + "</h3>";
	      htmlRespone += "<h3> Classification: " + details.getClassification() + "</h3>";
	      htmlRespone += "<h3> Creation Date: " + details.getCreationDate() + "</h3>";
	      htmlRespone += "<h3> Credit: " + details.getCredit() + "</h3>";
	      htmlRespone += "<h3> Death Year: " + details.getDeathYear() + "</h3>";
	      htmlRespone += "<h3> Department: " + details.getDepartment() + "</h3>";
	      htmlRespone += "<h3> Dimension: " + details.getDimension() + "</h3>";
	      htmlRespone += "<h3> Gender: " + details.getGender() + "</h3>";
	      htmlRespone += "<h3> Height: " + details.getHeight() + "</h3>";
	      htmlRespone += "<h3> Width: " + details.getWidth() + "</h3>";
	      htmlRespone += "<h3> Artwork ID: " + details.getLocationArtworkID() + "</h3>";
	      htmlRespone += "<h3> Artwork Medium: " + details.getMedium() + "</h3>";
	      htmlRespone += "<h3> Artist Name: " + details.getName() + "</h3>";
	      htmlRespone += "<h3> Artist Nationality: " + details.getNationality() + "</h3>";
	      htmlRespone += "<h3> </h3> "; 
	      htmlRespone += "<a href=\"index.jsp\">Back </a> ";
	      htmlRespone += "</html>";
	      out.println(htmlRespone);
	}

}
