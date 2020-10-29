<jsp:useBean id="calcula" class="br.com.sysjsp.classes.model.AcessoJsp"
	type="br.com.sysjsp.classes.model.AcessoJsp" scope="page" />

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet" href="resources/css/estiloMenu.css">

<title>Menu</title>

</head>

<body>

	<jsp:setProperty property="*" name="calcula" />

	<input type="checkbox" id="btn_menu">
	<label for="btn_menu"><img alt="init" src="resources/img/init.png"></label>

	<nav class="menu">

		<ul>

			<li><a href="#">Home</a>

				<ul>

					<li><a href="menu.jsp">In�cio</a></li>

				</ul>
				
			</li>

			<li><a href="#">Cadastro</a>

				<ul>

					<li><a href="ServletUsuario?acao=listartodos">Cadastro	Usu�rios</a></li>
					<li><a href="ServletCliente?acao=listartodos">Cadastro	Clientes</a></li>
					<li><a href="ServletProduto?acao=listartodos">Cadastro	Produtos</a></li>

				</ul>
			
			</li>

			<li><a href="#">Relat�rio</a></li>

			<li><a href="#">Consulta</a>

				<ul>

					<li><a href="ServletConsPro?acao=listartodos">Consulta Produtos</a></li>
					<li><a href="ServletConsCli?acao=listartodos">Consulta Clientes</a></li>

				</ul>
				
			</li>

			<li><a href="#">Agendamento</a></li>

			<li><a href="#">Sobre</a>

				<ul>

					<li><a href="#">Sobre o Sistema</a></li>
					<li><a href="#">Sobre o Desenvolvedor</a></li>

				</ul>
				
			</li>

			<li><a href="#">Sair</a>

				<ul>

					<li><a href="index.jsp">Logout</a></li>

				</ul>
				
			</li>

		</ul>

	</nav>
	
</body>

</html>