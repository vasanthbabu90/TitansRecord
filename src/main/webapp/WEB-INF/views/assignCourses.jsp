<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div>
		<%-- <spring:url value="/assignCourses" var="assign"></spring:url> --%>
		<form:form modelAttribute="courseProf" method="post"
			action="assignCourses">
			<div>
				<p>
					<label for="courses"><spring:message
							code="course.courseName" /> </label>
					<form:select path="courseName">
						<form:option value="NONE" label="--- Select Course---" />
						<form:options items="${availableCourses}" itemLabel="courseName"
							itemValue="courseName" />
					</form:select>
				</p>
				<p>

					<label for="professors"><spring:message
							code="professor.fullName" /> </label>
					<form:select path="professorName">
						<form:option value="NONE" label="--- Select Professor---" />
						<form:options items="${availableProfessors}" itemLabel="fullName"
							itemValue="fullName" />
					</form:select>
				</p>
				<p>
					<form:label path="courseStartDate">
						<spring:message code="courseProfessor.courseStartDate" />
					</form:label>
					<form:input path="courseStartDate" />
				</p>
				<p>
					<form:label path="courseEndDate">
						<spring:message code="courseProfessor.courseEndDate" />
					</form:label>
					<form:input path="courseEndDate" />
				</p>
			</div>
			<p align="center">
				<input id="submit" type="submit" tabindex="5" value="Assign">
			</p>
		</form:form>
	</div>
	<c:if test="${not empty courseProfessorList}">
		<div>
			<table border="1">
				<tr>
					<th>Course Name</th>
					<th>Professor</th>
					<th>Assigned By</th>
					<th>StartDate</th>
					<th>EndDate</th>
					<th>Action</th>

				</tr>
				<c:forEach items="${courseProfessorList}" var="courseProf">
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
	</c:if>
</body>
</html>