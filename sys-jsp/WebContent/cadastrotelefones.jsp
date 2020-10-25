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
			
			<a class="div-a" href="cadastroclientes.jsp"><img alt="home" src="resources/img/seta-para-tras.png"> Voltar</a>
		
			<div class="div-cadastrousuario">
				<h1>Cadastro de Telefones</h1>
			</div>
			
			<!-- agrupa os campos do formulário -->
			<fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
					
						<label for="id">Cód. Cliente:</label>
						<input type="text" id="id" name="id" style="width: 8em;" readonly="readonly"
						value="${clienteSelecionado.id}">
						
					</div>
					
					<div class="campo">
					
						<label for="nome">Nome:</label>
						<input type="text" id="nome" name="nome" style="width: 25em;" readonly="readonly"
						value="${clienteSelecionado.nome}">
						
					</div>
					
				</fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
					
						<label for="idT">Código:</label>
						<input type="text" id="idT" name="idT" style="width: 8em;" readonly="readonly">
						
					</div>
					
					<div class="campo">
						
						<label for="numero">Número:</label>
						<input type="text" id="numero" name="numero" style="width: 10em;" required="required"
						onkeypress="$(this).mask('(00) 0000-0000')" >
					
					</div>
					
					<div class="campo">
						
						<label for="numero">Tipo:</label>
						<select id="tipo" name="tipo">
							<option disabled="disabled" selected="selected">Selecione uma Opção</option>
							<option>Residencial</option>
							<option>Empresa</option>
							<option>Celular</option>
							<option>Recado</option>
							<option>Outro</option>
						</select>
					
					</div>
				
				</fieldset>
				
				<button type="submit" class="botao submit" value="Salvar">Salvar</button>
				<button type="submit" class="botao submit" value="Cancelar"
				onclick="document.getElementById('formulario').action = 'ServletTelefone?acao=reset'">Cancelar</button>
			
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
					
					<c:forEach items="${telefone}" var="fone">
					
						<tr>
							
							<td><c:out value="${fone.id}"></c:out></td>				
							<td><c:out value="${fone.numero}"></c:out></td>				
							<td><c:out value="${fone.tipo}"></c:out></td>
										
							<td><a href="ServletTelefone?acao=delete&foneId=${fone.id}">
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