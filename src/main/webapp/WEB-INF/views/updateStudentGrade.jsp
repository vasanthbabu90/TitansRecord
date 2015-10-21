<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div style="width: 400px">
	<form:form>
    <fieldset>
        <legend>Student Grade Report</legend>
  		      
          <p>
            <label for="studentgrade"><spring:message code="student.grade.label"/></label>
            <form:input path="studentgrade" type="file" />
 	
      	  </p>
 
			<p id="buttons">
				<input id="reset" type="reset" tabindex="4"> <input
					id="submit" type="submit" tabindex="5" value="Update Grades" onclick="studentgradeupdate();"> 
			</p>

		</fieldset>
</form:form>        
 
	</div>
</body>
</html>