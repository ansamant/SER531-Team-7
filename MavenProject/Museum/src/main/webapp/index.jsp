<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.semanticWeb.MuseumServlet"%>
<%@page import="java.semanticWeb.ArtworkDetails"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 
<html>
    <body>
        <div id="blackBar" class="w3-bar w3-white">
            <div class="w3-bar-item">
                <center><img src="PlaceholderImg.jpg" alt="" style="width:25%"></center>
            </div>
        </div>
        <div id="firstView">
            <h2>Museum Tour</h2>
            <h3>
                Welcome to the Museum of Modern Arts Tour Application site!! 
                Please enter your location below and find out information about the painting you <br>
                are viewing!
            </h3>
            <form id="form1" onsubmit="displayData()">
                Latitude:<br>
                <input type="text" id="latitude"><br>
                Longitude:<br>
                <input type="text" id="longitude"><br>
                <input type="submit" value="Submit">
                <input type= "reset" value="Clear">
            </form>     
        </div>
        <div id="the_body">
            <c:if test="sessionScope.details !=null">
                <% ArtworkDetails session = ${sessionScope.details} %>
                <center><h3>Painting Information</h3> <br>
                <h4><strong>Title: </strong></h4>
                </center>

            </c:if>
        </div>
    </body>
</html>
