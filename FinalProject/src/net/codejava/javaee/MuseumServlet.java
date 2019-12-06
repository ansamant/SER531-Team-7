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
	      if(details.getArtworkTitle() == null) {
	    	  String htmlResp = "<html>";
	    	  htmlResp += "<center>";
	    	  htmlResp += "<h3> Invalid Latitude or Longitude. Please try again! <h3>";
	    	  htmlResp += "<a href=\"index.jsp\">Back </a> ";
	    	  htmlResp += "</center>";
		      htmlResp += "</html>";
		      out.println(htmlResp);
		      return;
	      }
	      String htmlRespone = "<html>";
	      htmlRespone += "<center>";
	      htmlRespone += "<fieldset style=\"width:600px\">";
	      htmlRespone += "<h4> " + "Artwork Details" + "</h4>";
	      htmlRespone += "<p align=\"left\">Title: " + details.getArtworkTitle() + "</p>";
	      htmlRespone += "<p align=\"left\">Artist Id : " + details.getArtistId() + "</p>";
	      htmlRespone += "<p align=\"left\"> Acquisition Date: " + details.getAcquisitionDate() + "</p>";
	      htmlRespone += "<p align=\"left\"> Birth Year: " + details.getBirthYear() + "</p>";
	      htmlRespone += "<p align=\"left\"> Classification: " + details.getClassification() + "</p>";
	      htmlRespone += "<p align=\"left\"> Creation Date: " + details.getCreationDate() + "</p>";
	      htmlRespone += "<p align=\"left\"> Credit: " + details.getCredit() + "</p>";
	      htmlRespone += "<p align=\"left\"> Death Year: " + details.getDeathYear() + "</p>";
	      htmlRespone += "<p align=\"left\"> Department: " + details.getDepartment() + "</p>";
	      htmlRespone += "<p align=\"left\"> Dimension: " + details.getDimension() + "</p>";
	      htmlRespone += "<p align=\"left\"> Gender: " + details.getGender() + "</p>";
	      htmlRespone += "<p align=\"left\"> Height: " + details.getHeight() + "</p>";
	      htmlRespone += "<p align=\"left\"> Width: " + details.getWidth() + "</p>";
	      htmlRespone += "<p align=\"left\"> Artwork ID: " + details.getLocationArtworkID() + "</p>";
	      htmlRespone += "<p align=\"left\"> Artwork Medium: " + details.getMedium() + "</p>";
	      htmlRespone += "<p align=\"left\"> Artist Name: " + details.getName() + "</p>";
	      htmlRespone += "<p align=\"left\"> Artist Nationality: " + details.getNationality() + "</p>";
	      htmlRespone += "<p> </p> "; 
	      htmlRespone += "<a href=\"index.jsp\">Back </a> ";
	      htmlRespone += "</fieldset>";
	      htmlRespone += "</center>";
	      htmlRespone += "</html>";
	      out.println(htmlRespone);
	}

}
