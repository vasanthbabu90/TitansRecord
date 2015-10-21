<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

	<div style="width: 400px">
		<form:form modelAttribute="editProfessor" action="editProfessor" >			 
			<fieldset>
				<legend>Professor's Information :</legend>
				<form:hidden path="id"/>
				<p>
					<form:label path="fullName">
						<spring:message code="professor.fullName" />
					</form:label>
					<form:input path="fullName" />
				</p>
				<p>
					<form:label path="gender">
						<spring:message code="professor.gender" />
					</form:label>
					<form:input path="gender" />
				</p>
					<%-- <div style="text-align: center;">
					<form:errors path="fullName" cssStyle="color : red;" />
				</div> --%>
				
				<p>
					<form:label path="email">
						<spring:message code="professor.email" />
					</form:label>
					<form:input path="email" />
				</p>
				<p>
					<form:label path="Phone">
						<spring:message code="professor.phone" />
					</form:label>
					<form:input path="phone" />
				</p>
							
				<p id="buttons">
					<input id="reset" type="reset" tabindex="4"> <input
						id="submit" type="submit" tabindex="5" value="Update">
				</p>

			</fieldset>
		</form:form>
	</div>
</body>
</html>