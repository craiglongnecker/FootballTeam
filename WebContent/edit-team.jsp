<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit the Team and Nickname</title>
</head>
<body>
	<form action="editTeamServlet" method="post">
	Team City/State/College: <input type="text" name="teamName" value="${teamToEdit.teamName}">
	Nickname: <input type="text" name="teamNickname" value="${teamToEdit.teamNickname}">
	<input type="hidden" name="id" value="${teamToEdit.id}">;
	<input type="submit" value="Save Edited Team">;
	</form>
</body>
</html>