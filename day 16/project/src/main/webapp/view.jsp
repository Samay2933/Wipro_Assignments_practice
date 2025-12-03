<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${contacts == null || contacts.isEmpty()}">
			<p>No Contacts Added Yet.</p>
		</c:when>
		<c:otherwise>
			
			<h2>All Contacts:</h2>
			<table border="1" >
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Phone No.</th>
				</tr>
				<c:forEach var="contact" items="${contacts}">
					<tr>
						<td><c:out value="${contact.id}"></c:out></td>
						<td><c:out value="${contact.name}"></c:out></td>
						<td><c:out value="${contact.phone}"></c:out></td>
					</tr>
				</c:forEach>
			</table>
			<a href="index.jsp">
				<button>Home</button>	
			</a>
		</c:otherwise>
	</c:choose>
</body>
</html>