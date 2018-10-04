<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Football Teams</title>
</head>
<body>
	<form method="post" action="editFootballTeamServlet">
	<table>
	<c:forEach items="${requestScope.allItems}" var="currentteam">
	<tr>
		<td><input type="radio" name="id" value="${currentteam.id}"></td>
		<td>${currentteam.teamName}</td>
		<td>${currentteam.teamNickname}</td>
		</tr>
	</c:forEach>
	</table>
	<input type="submit" value="Edit Selected Team" name="doThisToTeam">
	<input type="submit" value="Delete Selected Team" name="doThisToTeam">
	<input type="submit" value="Add New Team" name="doThisToTeam">
	</form>
</body>
</html>