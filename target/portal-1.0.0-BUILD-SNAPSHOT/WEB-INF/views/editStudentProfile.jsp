<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	
	<script type="text/javascript" src="<spring:url value="/resources/js/ajax.js"/>"></script>
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Student</title>
</head>
<body>


<form:form id="studentForm" commandName="student" method="post">
   
   <fieldset>
     <legend>Edit an employee</legend>
     <p>
            <label for="fullName">Full Name: </label>
           <form:input path="fullName" value = "${student.fullName }"/>
 	
 	
       </p>
 
         <p>
            <label for="dob">Date Of Birth: </label>
            <form:input path="dob" value = "${student.dob }" />
 			
        </p>
        
         <p>
            <label for="gender">Gender: </label>
            <form:input path="gender" value = "${student.gender }" />
 			
        </p>
       
        
        <p>
            <label for="email">Email Id: </label>
           <form:input path="email" value = "${student.email }" />
 	
       </p>
       
        <p>
            <label for="entryDate">Entry Date: </label>
           <form:input path="entryDate" value = "${student.entryDate }" />
 	
       </p>
       
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4" />
            <input type="button" tabindex="5" value="Update" onclick="updateStudentProfileAjaxCall();" />
        </p>
       
   </fieldset>
   </form:form> 
 

</body>
</html>