<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
	<body>
		<h1 id="banner">Welcome to Titan University</h1>  
		<form:form modelAttribute="loginUser" method="POST">
			<table>
				<tr>
					<td>UserID/UserName:</td>
					<td><form:input path='userId' /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path='password' /></td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit">&nbsp;<input name="reset" type="reset"></td>
				</tr>
				
				<tr>
					<td colspan="2">&nbsp; ${Message }</td>
				</tr>
				
			</table>
			
			
			
		</form:form>
	</body>
</html>