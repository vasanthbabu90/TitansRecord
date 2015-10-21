<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	
	<script type="text/javascript" src="<spring:url value="/resources/js/ajax.js"/>"></script>
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enroll Courses</title>
</head>
<body>


<h1> Enroll Course </h1>
<form id="enrollCourseForm">	
		
				First Block Course:</br>
				<select name="firstBlock" id="firstBlock">
				<c:forEach items="${courseIds}" var="id">
   					 <option value="${id}">${id}</option>
				</c:forEach>
				</select></br>
			
		
				Second Block Course:</br>
				<select name="secondBlock" id="secondBlock">
				<c:forEach items="${courseIds}" var="id">
   					 <option value="${id}">${id}</option>
				</c:forEach>
				</select></br> </br>
			
			
				<input type="button" value="Ajax Submit" onclick="makeEnrollCourseAjaxCall();">
			
		
	</form>

</body>
</html>