<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkformLogin"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Login</h1>
	
		<form action="${linkformLogin}" method="post">
			Empresa: 		 <input type="text" name="login"/>
			Data de Abertura <input type="password" name="senha"/>
							 <input type="hidden" name="acao" value="Login" />
							 <input type="submit"/>
		</form>
</body>
</html>