<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form:form action="add" modelAttribute="student" method="post">

		<fieldset>
			<legend>add an employee</legend>
			<p>
				<form:hidden path="studentId" value="${student.studentId }" />
			</p>



			<p>
				<label for="fullName">Full Name: </label>
				<form:input path="fullName" value="${student.fullName }" />


			</p>
			
			<p>
				<label for="userName">User Name: </label>
				<form:input path="userName" value="${student.userName }" />
				<form:errors path="userName" cssClass="text-danger"/>


			</p>

			<p>
				<label for="dob">Date Of Birth: </label>
				<form:input path="dob" value="${student.dob }" />

			</p>

			<p>
				<label for="gender">Gender: </label>
				<form:input path="gender" value="${student.gender }" />

			</p>


			<p>
				<label for="email">Email Id: </label>
				<form:input path="email" value="${student.email }" />

			</p>

			<p>
				<label for="entryDate">Entry Date: </label>
				<form:input path="entryDate" value="${student.entryDate }" />

			</p>

			<input type="submit" tabindex="5" value="Update" />	

		</fieldset>
	</form:form>
	
</body>
</html>