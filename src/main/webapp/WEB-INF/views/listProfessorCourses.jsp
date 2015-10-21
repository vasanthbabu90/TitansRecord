<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div>
		<br>		 
		<br>
		<table border="1">
			<tr>
				<th>Professor Name </th>
				<th>Course Name</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${professorCourses}" var="course">
				<tr>
					<td>${course.professorName}</td>
					<td>${course.courseName}</td>
					<td>${course.courseStartDate}</td>
					<td>${course.courseEndDate}</td>
					<th>Edit|Delete</th>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>