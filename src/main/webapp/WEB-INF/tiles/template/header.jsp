<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



	<h2 style="color: red; text-align: center;">Welcome Titans University </h2>

<br>
<div id="menu">
	<ul>
		<li class="first active"><a href="#">Home</a></li>
		<li><a href="<c:url value="/admin/listStudents" />">Student</a></li>
		<li><a href="<c:url value="/admin/listProfessors" /> ">Professor</a></li>
		<li><a href="<c:url value="/admin/listCourses" />">Course</a></li>
		<li><a href="<c:url value="/admin/assignCourses" />">Assign Courses</a></li>

	</ul>
</div>



