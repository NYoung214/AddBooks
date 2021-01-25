<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add A Book Page</title>
	</head>
	<body>
	
		<div align="center">
		    <h1>Add A Book</h1>
			<form action="add" method="post">
		        <c:forEach var="error" items="${errors}">
		        	<p>${error}</p>
		        </c:forEach>			
			    <p>Name: <input type="text" name="name" placeholder="Harry Potter"/></p>
			    <p>Genre: <input type="text" name="genre" placeholder="Fantasy"/></p>
			    <p>Price: <input type="text" name="price" placeholder="21.99"/></p>
			    <input type="submit" value="Add"/>	<a href="book_list">Click to show book list</a>
			    <br/>
			    <table border="1">
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
			</form>
		</div>
	</body>
</html>