<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" type="text/css" href="resources/css/estiloCadastro.css"/>
<link rel="stylesheet" type="text/css" href="resources/css/table.css"/>



<!-- mascara funcionar tem que colocar estas bibliotecas abaixo -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    
    

<title>Cadastro de Telefones</title>
</head>

<body>

	<div class="form">
		
		<form id="formulario" action="ServletTelefone" method="post">
		
			<a class="div-a" href="menu.jsp"><img alt="home" src="resources/img/home1.png"> Voltar para o menu</a>
		
			<div class="div-cadastrousuario">
				<h1>Cadastro de Telefones</h1>
			</div>
			
			<!-- agrupa os campos do formulário -->
			<fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
					
						<label for="id">Código:</label>
						<input type="text" id="id" name="id" style="width: 8em;" readonly="readonly"
						value="${cliSelecionado}">
						
					</div>
					
					<div class="campo">
					
						<label for="telefonefixo">Tel. Residencial:</label>
						<input type="text" id="telefonefixo" name="telefonefixo" style="width: 10em;" required="required"
						onkeypress="$(this).mask('(00) 0000-0000')" value="${cli.telefonefixo}">
						
					</div>
					
					<div class="campo">
					
						<label for="telefonecelular">Tel. Celular:</label>
						<input type="text" id="telefonecelular" name="telefonecelular" style="width: 10em;" required="required"
						onkeypress="$(this).mask('(00) 0.0000-0000')" value="${cli.telefonecelular}">
						
					</div>
				
				</fieldset>
				
				<button type="submit" class="botao submit" value="Salvar">Salvar</button>
				<button type="submit" class="botao submit" value="Cancelar"
				onclick="document.getElementById('formulario').action = 'ServletCliente?acao=reset'">Cancelar</button>
			
			</fieldset>
		
		</form>
		
		<br>
		
		<div class="content">
		
			<table class="rTable">
				
				<thead>
					
					<tr>
						
						<th>Código</th>
						<th>Número</th>
						<th>Tipo</th>
						<th>Excluir</th>
						
					</tr>
					
				</thead>
				
				<tbody>
					
					<c:forEach items="${telefones}" var="fone">
					
						<tr>
							
							<td><c:out value="${fone.id}"></c:out></td>				
							<td><c:out value="${fone.numero}"></c:out></td>				
							<td><c:out value="${cfoneli.tipo}"></c:out></td>
							
										
							<td><a href="ServletCliente?acao=delete&cli=${fone.id}">
								<img alt="delete" src="resources/img/excluir.png" title="Excluir" 
								style="width: 20px; height: 20px;">
							</a></td>
							
						</tr>
				
					</c:forEach>
				
				</tbody>
				
			</table>
		
		</div>
		
	</div>
	
	

</body>

</html>