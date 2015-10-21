<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	Language:
	<a href="?language=en">English</a>|
	<a href="?language=es">spanish</a>
	<div>
		<div style="width: 400px">
			<form:form modelAttribute="addCourse" action="addCourse"
				method="post">
				<fieldset>
					<legend>Add Course :</legend>
					<p>
						<form:label path="courseName">
							<spring:message code="course.courseName" />
						</form:label>
						<form:input path="courseName" />
					</p>
					<p>
						<form:label path="courseLevel">
							<spring:message code="course.courseLevel" />
						</form:label>
						<form:input path="courseLevel" />
					</p>
					<%-- <div style="text-align: center;">
					<form:errors path="fullName" cssStyle="color : red;" />
				</div> --%>

					<p>
						<form:label path="courseDescription">
							<spring:message code="course.courseDescription" />
						</form:label>
						<form:input path="courseDescription" />
					</p>

					<p id="buttons">
						<input id="reset" type="reset" tabindex="4"> <input
							id="submit" type="submit" tabindex="5" value="Save">
					</p>

				</fieldset>
			</form:form>
		</div>
</body>
</html>