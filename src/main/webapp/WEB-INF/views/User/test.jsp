<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


				<table class="display" id="table_id">
					<thead>
						<tr>
							<th>ID</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th class="text-center">Email Address</th>
							<th class="text-center">Date Of Birth</th>
							<th class="text-right">Password</th>
							
						</tr>
					</thead>
					<tbody>

						<c:forEach var="student" items="${theListOFUSeer}">
							<tr>
								<td>${student.id}</td>
								<td><a href="#">${student.firstName}</a></td>
								<td>${student.lastName}</td>
								<td>${student.email}</td>
								<td>${student.dateOfBirth}</td>
								<td>${student.password}</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>






</body>
</html>