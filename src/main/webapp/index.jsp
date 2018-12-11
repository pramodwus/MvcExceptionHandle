<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Spring MVC @ExceptionHandler Example</h2>

	<c:if test="${not empty msg}">
		<h2>${msg}</h2>
	</c:if>

</body>
</html>