<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	
	<script type="text/javascript">

$(function(){
	 $("#professorForm :input").prop("disabled", 'disabled');
})

$(document).ready(function(){
	//$("#studentForm").attr('disabled','disabled');
});
</script>
 
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Professor Profile</title>
</head>
<body>
<h1 align="center"> Welcome ${professor.fullName }</h1>



<form:form id="professorForm" modelAttribute="professor" method="post">
   
   <fieldset>
     <legend>Profile Details</legend>
     <p> <form:hidden path="id" value = "${professor.id }"/> </p>
     
     	
       
     <p>
            <label for="fullName">Full Name: </label>
           <form:input path="fullName" value = "${professor.fullName }"/>
 	
 	
       </p>
 
      
        
         <p>
            <label for="gender">Gender: </label>
            <form:input path="gender" value = "${professor.gender }" />
 			
        </p>
       
        
        <p>
            <label for="email">Email Id: </label>
           <form:input path="email" value = "${professor.email }" />
 	
       </p>
       
        <p>
            <label for="phone">Phone: </label>
           <form:input path="phone" value = "${professor.phone }" />
 	
       </p>
       
      
       
   </fieldset>
   </form:form> 
 

</body>
</html>