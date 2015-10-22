<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div>
		<form:form modelAttribute="studentEnrolled" action="editStudentGrade">
			<fieldset>
				<legend>Update Grade</legend>
				<form:hidden path="enrolledId" />
				<form:hidden path="courseIdLevel" />

				<p>
					<form:label path="studentID">
						<spring:message code="student.studentId" />
					</form:label>
					<form:input path="studentID" />
				</p>
				<p>
					<label for="grade"><spring:message
							code="student.grade.label" /></label>
					<form:input path="grade" />
				</p>
				<p id="buttons">
					<input id="submit" type="submit" tabindex="5" value="Update">
				</p>
			</fieldset>
		</form:form>

	</div>
</body>
</html>