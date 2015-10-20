<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div style="width: 400px">
		<form:form modelAttribute="addStudent" action="addStudent"
			method="post">
			<fieldset>
				<legend>Student Information :</legend>
				<p>
					<form:label path="studentId">
						<spring:message code="student.studentId" />
					</form:label>
					<form:input path="studentId" />
				</p>
				<div style="text-align: center;">
					<form:errors path="studentId" cssStyle="color : red;" />
				</div>
				<p>
					<form:label path="fullName">
						<spring:message code="student.fullName" />
					</form:label>
					<form:input path="fullName" />
				</p>
				<p>
					<form:label path="gender">
						<spring:message code="student.gender" />
					</form:label>
					<form:input path="gender" />
				</p>
				<p>
					<form:label path="dob">
						<spring:message code="student.dob" />
					</form:label>
					<form:input path="dob" />
				</p>
				<p>
					<form:label path="email">
						<spring:message code="student.email" />
					</form:label>
					<form:input path="email" />
				</p>
				<p>
					<form:label path="Phone">
						<spring:message code="student.phone" />
					</form:label>
					<form:input path="phone" />
				</p>
				<p>
					<form:label path="entryDate">
						<spring:message code="student.entry.date" />
					</form:label>
					<form:input path="entryDate" />
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