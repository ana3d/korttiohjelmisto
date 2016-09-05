<%
	if (request.getAttribute("kortti") == null) {
		response.sendRedirect("KorttiServlet");
		return;
	}
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Muokkaa osoitetietoja</title>
</head>
<link rel="stylesheet" type="text/css" href="main.css">
<body>


	
		<div class="div">
		<form method="post" name="edit" action="Edit"> 
			<font class="card">
			
			<input type="text" name="etunimi" value="<c:out value="${kortti.etunimi}" />" required>
			<input type="text" name="sukunimi" value="<c:out value="${kortti.sukunimi}" />" required>
			<input type="text" name="osoite" value="<c:out value="${kortti.osoite}" />" required>
			<input type="text" name="zip" value="<c:out value="${kortti.zip}" />" required>
			<input type="text" name="postitoimipaikka" value="<c:out value="${kortti.postitoimipaikka}" />" required>
	
			
			
			
			<input type="hidden" name="id" value="${kortti.id}">
			<input type="hidden" name="muokkaus" value="edit">
			<a href="kortit.jsp"><button class="button">Cancel</button></a>
					<button class="button">Save</button>
			</font>		
			</form>
			
		</div>


</body>
</html>