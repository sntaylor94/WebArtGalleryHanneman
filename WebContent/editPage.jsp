<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action = "editItemServlet" method = "post">
	Title: <input type = "text" name = "store" value = "${itemToEdit.title}">
	Artist: <input type="text" name="artistName" value = "${itemToEdit.artist}"><br />
	Media: <select name="media" value = "${itemToEdit.media}">
		<option value=null></option>
		<option value="pencil">Pencil</option>
		<option value="ink">Ink</option>
		<option value="pastels">Pastels</option>
		<option value="chalk">Chalk</option>
		<option value="watercolor">Watercolor</option>
		<option value="acrylic">Acrylic</option>
		<option value="oil">Oil</option>
		<option value="tempera">Tempera</option>
		<option value="film">Film</option>
		<option value="digital">digital</option>
		<option value="collage">Collage</option>
		<option value="assemblage">Assemblage</option>
		<option value="other media">Other Media</option>
	</select><br /> 
		Year: <input type="text" name="year" value = "${itemToEdit.year}"><br /> 
		Value: <input type="text" name="value" value = "${itemToEdit.value}"><br /> 
		<input type = "hidden" name = "id" value = "${itemToEdit.id}">
		<input type="submit" value="Save Edited Item">
	</form>
</body>
</html>