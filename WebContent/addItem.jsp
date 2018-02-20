<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addItemServlet" method="post">
		<br /> *Title: <input type="text" name="title"><br />
		*Artist: <input type="text" name="artistName"><br />
		Media: <select name="media">
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
			Year: <input type="text" name="year"><br /> 
			Value: <input type="text" name="value"><br /> 
			<input type="submit" value="Add Art Piece">
	</form>
	<p>* denotes required field</p>
	<a href="index.html">Back to home</a>
	<br />
	<a href="viewAllItemsServlet">View the complete list of artwork</a>
	<br />
</body>
</html>