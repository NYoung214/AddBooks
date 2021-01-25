<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Book List</title>
	</head>
	<body>
	    <h1 align="center">My Book List</h1>
	    <br/>
	    <table border="1" cellpadding="10">
	        <tr>
	            <th>Name</th><th>Genre</th><th>Price</th>
	        </tr>
	        <c:forEach var="book" items="${books}">
	        <tr>
	            <td>${book.getName()}</td>
	            <td>${book.getGenre()}</td>
	            <td>${book.getPrice()}</td>
	        </tr>    
	        </c:forEach>
	    </table>
	</body>
</html>