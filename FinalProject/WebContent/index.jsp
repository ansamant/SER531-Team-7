<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

div.form
{
    display: block;
    text-align: center;
}
form
{
    display: inline-block;
    margin-left: auto;
    margin-right: auto;
    text-align: left;
}
</style>
</head>
<body>
<center>	
	<h1>Smart Museum Tour</h1>	
	<div class="form">
		<form action="MuseumServlet" method="post">
		<fieldset style="width:200px">
   		 Enter Latitude: <br>
   		 <input type="text" name="latitude" value="40.77877209" size="20"><br>
   		 Enter Longitude: <br>
   		 <input type="text" name="longitude" value="-73.96449784" size="20"><br><br>
   		 <input type="submit" value="Submit" />
   		 <br>
   		 </fieldset>
		</form>	
		</div>
		</center>	
</body>
</html>
