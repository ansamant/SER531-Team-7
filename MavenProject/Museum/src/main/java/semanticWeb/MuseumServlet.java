package semanticWeb;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Museum Servlet to send http request through jsp to get artwork details
 * @author leharbhatt
 *
 */
public class MuseumServlet extends HttpServlet {

	   public void init() throws ServletException {
	   }
	   
	   /**
	    * Used by UI to get the artwork details
	    */
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      
	      HttpSession session = request.getSession();
	      String latitude = request.getAttribute("latitude").toString();
	      String longitude = request.getAttribute("longitude").toString();
	      MuseumHelper helper = new MuseumHelper();
	      ArtworkDetails details = helper.getDetails(latitude, longitude);
	      session.setAttribute("details", details);
		  
	      //out.println("<h1>" + session.getAttribute("details") + "</h1>");
	   }
	
}
