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
    
    

<title>Cadastro de Clientes</title>
</head>

<body>

	<div class="form">
		
		<form id="formulario" action="ServletProduto" method="post">
		
			<a class="div-a" href="menu.jsp"><img alt="home" src="resources/img/home1.png"> Voltar para o menu</a>
		
			<div class="div-cadastrousuario">
				<h1>Cadastro de Produtos</h1>
			</div>
			
			<div class="div-dadosusuario">
				<h2>Dados do Produto</h2>
			</div>
			
			<!-- agrupa os campos do formulário -->
			<fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
					
						<label for="id">Código:</label>
						<input type="text" id="id" name="id" style="width: 8em;" readonly="readonly"
						>
						
					</div>
				
				</fieldset>
				
				<fieldset class="grupo">
					
					
				
				</fieldset>
				
				<fieldset class="grupo">
				
					
				
				
				</fieldset>
				
				<button type="submit" class="botao submit" value="Salvar">Salvar</button>
				<button type="submit" class="botao submit" value="Cancelar"
				onclick="document.getElementById('formulario').action = 'ServletProduto?acao=reset'">Cancelar</button>
			
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
						<th>Telefones</th>
						
					</tr>
					
				</thead>
				
				<tbody>
					
					<c:forEach items="${produutos}" var="produto">
					
						<tr>
							
							<td><c:out value="${cli.id}"></c:out></td>				
							<td><c:out value="${cli.nome}"></c:out></td>				
							<td><c:out value="${cli.cpf}"></c:out></td>
							<td><c:out value="${cli.telefonefixo}"></c:out></td>					
							<td><c:out value="${cli.telefonecelular}"></c:out></td>				
							<td><c:out value="${cli.email}"></c:out></td>				
							
							<td><a href="ServletProduto?acao=update&cli=${cli.id}">
								<img alt="update" src="resources/img/editar.png" title="Atualizar" 
								style="width: 20px; height: 20px;">
							</a></td>	
							
										
							<td><a href="ServletProduto?acao=delete&cli=${cli.id}">
								<img alt="delete" src="resources/img/excluir.png" title="Excluir" 
								style="width: 20px; height: 20px;">
							</a></td>
							
						</tr>
				
					</c:forEach>
				
				</tbody>
				
			</table>
		
		</div>
		
	</div>
	
	<script type="text/javascript">

		

	</script>

</body>

</html>