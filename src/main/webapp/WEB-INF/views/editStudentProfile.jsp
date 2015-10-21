<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<script type="text/javascript"
	src="<spring:url value="/resources/js/ajax.js"/>"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Student</title>
</head>
<body>

	<c:choose>

		<c:when test="${student.imageUploadedOrNot eq false}">
			<h1>Please upload the Profile Picture</h1>
			<form:form commandName="student" action="upoadProfilePicture"
				method="post" enctype="multipart/form-data">

				<p>
					<form:hidden path="studentId" value="${student.studentId }" />
				</p>

				<p>
					<label for="productImage">Student Image: </label>
					<form:input id="productImage" path="productImage" type="file" />
				</p>

				<p id="buttons">

					<input type="submit" tabindex="5" value="Upload">
				</p>
			</form:form>
		</c:when>


		<c:otherwise>
		
		<div style="width:900px;">
				<div style="height: 250px; width: 900px; margin:0 auto">

				
					<img src="<c:url value="/image/${student.studentId}.jpg"></c:url>"
						alt="image" align="right" style="height: 200px; width: 400px;" />
				</div>
				<div style="width:450px; margin:0 auto;">
				<%-- <img src="C:/Users/vasanthbabu/WAAWorkspace/TitansRecord/src/main/webapp/images/${student.studentId}.jpg" alt="image"  style = "width:100%"/> --%>
				<form:form commandName="student" action="upoadProfilePicture"
					method="post" enctype="multipart/form-data">

					<form:hidden path="studentId" value="${student.studentId }" />

					<div align="right">
						<label for="productImage">Update Profile Picture: </label>
						<form:input id="productImage" path="productImage" type="file" />
					</div>


					<div align="right">
						<input type="submit" tabindex="5" value="Update">
					</div>

				</form:form>
				</div>
			</div>
		</c:otherwise>
	</c:choose>


	<form:form id="studentForm" modelAttribute="student" method="post">

		<fieldset>
			<legend>Edit an employee</legend>
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

			<p id="buttons">
				<input id="reset" type="reset" tabindex="4" /> <input type="button"
					tabindex="5" value="Update"
					onclick="updateStudentProfileAjaxCall();" />
			</p>

		</fieldset>
	</form:form>


</body>
</html>