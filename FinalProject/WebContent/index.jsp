<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Smart Museum Tour</h1>
		<form action="MuseumServlet" method="post">
   		 Enter your Latitude: <input type="text" name="latitude" size="20">
   		 Enter your Longitude: <input type="text" name="longitude" size="20">
   		 <input type="submit" value="Submit" />
		</form>
</body>
</html>