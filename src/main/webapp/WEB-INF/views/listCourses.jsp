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
			<a href="addCourse">Add Course</a>
		</button>
		<br> <br>
		<c:choose>
			<c:when test="${not empty courses}">
				<table border="1">
					<tr>
						<th>Course Name</th>
						<th>Course Description</th>
						<th>Course Level</th>
						<th>Action</th>

					</tr>
					<c:forEach items="${courses}" var="course">
						<tr>
							<td>${course.courseName}</td>
							<td>${course.courseDescription}</td>
							<td>${course.courseLevel}</td>
							<th>Edit|Delete</th>
						</tr>

					</c:forEach>
				</table>
	
	</c:when>
	</c:choose>
	</div>	
</body>
</html>