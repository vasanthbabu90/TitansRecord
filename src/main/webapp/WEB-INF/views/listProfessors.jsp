<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div>
		<button class="first active">
			<a href="addProfessor">Add Professor</a>
		</button>
		<br> <br>
		<c:choose>
			<c:when test="${not empty professors}">
				<table border="1">
					<tr>
						<th>Professor Name</th>
						<th>Gender</th>
						<th>PhoneNumber</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					<c:forEach items="${professors}" var="professor">
						<tr>
							<td>${professor.fullName}</td>
							<td>${professor.gender}</td>
							<td>${professor.phone}</td>
							<td>${professor.email}</td>
							<td><a href="editProfessor?id=${professor.id}">Edit</a> | <a
								href="deleteProfessor?id=${professor.id}">Delete</a></td>

						</tr>

					</c:forEach>
				</table>
			</c:when>
		</c:choose>
	</div>
</body>
</html>