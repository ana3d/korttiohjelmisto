
<%
	if (request.getAttribute("kortit_data") == null) {
		response.sendRedirect("KorttiServlet");
		return;
	}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Osoitekirja</title>
</head>
<link rel="stylesheet" type="text/css" href="main.css">


<body>

	<div class="div" id="addNew">
		<form action="AddServlet" method="post" id="add">
			<table class="table-add">
				<thead>
					<tr>
						<th colspan="2">Lisää yhteystieto</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Etunimi:</td>
						<td><input type="text" name="etunimi" required></td>
					</tr>
					<tr>
						<td>Sukunimi:</td>

						<td><input type="text" name="sukunimi" required></td>
					</tr>
					<tr>
						<td>Osoite:</td>

						<td><input type="text" name="osoite" required></td>
					</tr>
					<tr>
						<td>Postinro:</td>

						<td><input type="number" step="1" min="0" max="99999"
							name="zip" required></td>
					</tr>
					<tr>
						<td>Postitoimipaikka:</td>

						<td><input type="text" name="postitoimipaikka" required></td>
					</tr>

					<tr>
						<td colspan="2"><input type="submit"
							onclick="return IsEmpty();" value="Lisää uusi yhteystieto"
							class="button"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>


<div id="wrapper">
	<c:forEach var="data" items="${kortit_data}">
		<div class="div">
			<form method="post" name="del" action="Delete">
				<span class="delete"> <input type="hidden" name="id"
					value="${data.id}">
					<button class="button">X</button>
				</span>
			</form>
			<font class="card">
			
			<input type="text" name="etunimi" value="<c:out value="${data.etunimi}" />" disabled>
			<input type="text" name="sukunimi" value="<c:out value="${data.sukunimi}" />" disabled>
			<input type="text" name="osoite" value="<c:out value="${data.osoite}" />" disabled>
			<input type="text" name="zip" value="<c:out value="${data.zip}" />" disabled>
			<input type="text" name="postitoimipaikka" value="<c:out value="${data.postitoimipaikka}" />" disabled>
	
			</font>
			
			<form method="post" name="edit" action="Edit">
				<span class="edit"> <input type="hidden" name="id"
					value="${data.id}">
					<button class="button">Edit</button>
				</span>
			</form>
		</div>
	</c:forEach>
</div>	
</body>
</html>