<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div>
		<button>
			<a href="addStudent">Add New Student</a>
		</button>
		<br> <br>
		<table border="1">
			<tr>
				<th>Student Name</th>
				<th>Gender</th>
				<th>Dob</th>
				<th>PhoneNumber</th>
				<th>Email</th>
				<th>EntryDate</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${students}" var="student">
				<tr>
					<td>${student.fullName}</td>
					<td>${student.gender}</td>
					<td>${student.dob}</td>
					<td>${student.phone}</td>
					<td>${student.email}</td>
					<td>${student.entryDate}</td>
					<th>Edit|Delete</th>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>