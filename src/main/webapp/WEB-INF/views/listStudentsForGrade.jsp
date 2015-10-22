<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<c:if test="${not empty studentsList}">
		<div>
			<table border="1">
				<tr>
					<th>Student Id</th>
					<th>Grade</th>
				</tr>
				<c:forEach items="${studentsList}" var="courseStudent">
					<tr>
						<td>${courseStudent.studentID}</td>
						<c:choose>
							<c:when test="${not empty courseStudent.grade }">
								<td>${courseStudent.grade}</td></c:when>
							<c:otherwise>
								<td><a
									href="editStudentGrade?id=${courseStudent.enrolledId}">AddGrade</a></td>
							</c:otherwise>
						</c:choose>
					</tr>

				</c:forEach>
			</table>
			<a href="listCourses">Finish</a>
		</div>
	</c:if>
</body>
</html>