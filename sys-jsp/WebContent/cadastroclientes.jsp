<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" type="text/css" href="resources/css/estiloCadastro.css"/>
<link rel="stylesheet" type="text/css" href="resources/css/table.css"/>


<!-- ara a mascara funcionar tem que colocar estas bibliotecas abaixo -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Cadastro de Clientes</title>
</head>

<body>

	<div class="form">
		
		<form id="formulario" action="ServletCliente" method="post">
		
			<a class="div-a"><img alt="home" src="resources/img/home1.png"> Voltar para o menu</a>
		
			<div class="div-cadastrousuario">
				<h1>Cadastro de Clientes</h1>
			</div>
			
			<div class="div-dadosusuario">
				<h2>Dados do Cliente</h2>
			</div>
			
			<!-- agrupa os campos do formulário -->
			<fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
					
						<label for="id">Código:</label>
						<input type="text" id="id" name="id" style="width: 8em;" readonly="readonly"
						value="${cli.id}">
						
					</div>
				
				</fieldset>
				
				<fieldset class="grupo">
					
					<div class="campo">
					
						<label for="nome">Nome:</label>
						<input type="text" id="nome" name="nome" style="width: 30em;" required="required"
						value="${cli.nome}">
						
					</div>
					
					<div class="campo">
					
						<label for="cpf">CPF:</label>
						<input type="text" id="cpf" name="cpf" style="width: 10em;" required="required"
						onkeypress="$(this).mask('000.000.000-00')" value="${cli.cpf}">
						
					</div>
					
					<div class="campo">
					
						<label for="rg">RG:</label>
						<input type="text" id="rg" name="rg" style="width: 8em;" required="required"
						onkeypress="$(this).mask('0000000000')" value="${cli.rg}">
						
					</div>
					
					<div class="campo">
					
						<label for="orgaoexpeditor">Orgão Exp.:</label>
						<input type="text" id="orgaoexpeditor" name="orgaoexpeditor" style="width: 6em;" required="required"
						onkeypress="$(this).mask('AAA/AA')" value="${cli.orgaoexpeditor}">
						
					</div>
				
				</fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
					
						<label for="datanascimento">Data Nasc.:</label>
						<input type="text" id="datanascimento" name="datanascimento" style="width: 10em;" required="required"
						onkeypress="$(this).mask('00/00/0000')" value="${cli.datanascimento}">
						
					</div>
					
					<div class="campo">
					
						<label for="telefonefixo">Tel. Residencial:</label>
						<input type="text" id="telefonefixo" name="telefonefixo" style="width: 10em;" required="required"
						onkeypress="$(this).mask('(00) 0000-0000')" value="${cli.telefonefixo}">
						
					</div>
					
					<div class="campo">
					
						<label for="telefonecelular">Tel. Celular:</label>
						<input type="text" id="telefonecelular" name="telefonecelular" style="width: 10em;" required="required"
						onkeypress="$(this).mask('(00) 9.0000-0000')" value="${cli.telefonecelular}">
						
					</div>
					
					<div class="campo">
					
						<label for="email">E-mail:</label>
						<input type="text" id="email" name="email" style="width: 25em;" required="required"
						value="${cli.email}">
						
					</div>
				
				
				</fieldset>
				
				<fieldset class="grupo">
					
					<div class="campo">
					
						<label for="observacao">Observação:</label>
						<input type="text" id="observacao" name="observacao" style="width: 60em;" 
						value="${cli.observacao}">
						
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
						<th>Nome</th>
						<th>CPF</th>
						<th>Tel. Residencial</th>
						<th>Tel. Celular</th>
						<th>Email</th>
						<th>Atualizar</th>
						<th>Excluir</th>
						
					</tr>
					
				</thead>
				
				<tbody>
					
					<c:forEach items="${clientes}" var="cli">
					
						<tr>
							
							<td><c:out value="${cli.id}"></c:out></td>				
							<td><c:out value="${cli.nome}"></c:out></td>				
							<td><c:out value="${cli.cpf}"></c:out></td>
							<td><c:out value="${cli.telefonefixo}"></c:out></td>					
							<td><c:out value="${cli.telefonecelular}"></c:out></td>				
							<td><c:out value="${cli.email}"></c:out></td>				
							
							<td><a href="ServletCliente?acao=update&cli=${user.id}">
								<img alt="update" src="resources/img/editar.png" title="Atualizar" 
								style="width: 20px; height: 20px;">
							</a></td>	
							
										
							<td><a href="ServletCliente?acao=delete&cli=${user.id}">
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