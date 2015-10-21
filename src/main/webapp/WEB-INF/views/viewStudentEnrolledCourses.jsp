<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Enrolled Courses </title>
</head>
<body>


welcome ${studentID }

<table>
 <tr> 
 	<td> <h1> CourseLevel </h1>  </td> 
 	<td> <h1> CourseDescription </h1> </td>
 	<td> <h1> Grade </h1></td>
 </tr>
<c:forEach items="${listOfCoursesEnrolled }" var="course">
<tr>
	<td> <c:out value="${course.courseIdLevel }"></c:out> </td>
	<td> <c:out value="${course.courseDescription }"></c:out> </td>
	<td> <c:out value="${course.grade }"></c:out> </td>
 </tr>

</c:forEach>

</table>

 If U want change the course please contact CS Department csregistar@vasanth.com
</body>
</html>