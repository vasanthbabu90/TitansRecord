<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div>
		<form:form modelAttribute="courseProf" method="post"
			action="assignCourses">
			<div>
				<p>
					<label for="courses"><spring:message
							code="course.courseName" /> </label>
					<form:select path="courseName">
						<form:option value="NONE" label="--- Select Course---" />
						<form:options items="${courses}" itemLabel="courseName"
							itemValue="courseName" />
					</form:select>
				</p>				
			</div>
			<p align="center">
				<input id="submit" type="submit" tabindex="5" value="Students">
			</p>
		</form:form>
	</div>
	<%-- <c:if test="${not empty courseStudentsList}">
		<div>
			<table border="1">
				<tr>
					<th>Student Id</th>
					<th>Grade</th>	

				</tr>
				<c:forEach items="${courseStudentsList}" var="courseProf">
					<tr>
						<td>${courseProf.courseName}</td>
						<td>${courseProf.professorName}</td>
						<td></td>
						<td>${courseProf.courseStartDate}</td>
						<td>${courseProf.courseEndDate}</td>

						<th>Edit|Delete</th>
					</tr>

				</c:forEach>
			</table>
		</div>
	</c:if> --%>
</body>
</html>