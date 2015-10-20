<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<li><a href="addStudent">Student</a></li>
	<spring:eval expression="student.phone" />

</body>
</html>
