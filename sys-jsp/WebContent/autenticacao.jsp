<jsp:useBean id="calcula" class="br.com.sysjsp.classes.model.AcessoJsp" type="br.com.sysjsp.classes.model.AcessoJsp"
scope="page"/>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/estiloLogin.css"/>
<title>Login</title>
</head>

<body>

	<div class="form">
	
		<h1>Login</h1>
		
				<form action="ServletLogin" method="post">
				
					<input type="hidden" id="url" name="url" value="<%= request.getParameter("url")%>" />
				
					<label>Usuário:</label>
					<input type="text" id="usuario" name="usuario" placeholder="Informe o usuário" required="required"/>
					
					<label>Senha:</label>
					<input type="password" id="senha" name="senha" placeholder="Informe a senha" required="required"/>
					
					<button type="submit" class="btn" value="logar">Acessar</button>
			
				</form>
	
	</div>	
		
</body>

</html>