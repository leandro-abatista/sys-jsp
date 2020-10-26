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
						value="${produto.id}">
						
					</div>
				
				</fieldset>
				
				<fieldset class="grupo">
					
					<div class="campo">
					
						<label for="descricao">Descrição:</label>
						<input type="text" id="descricao" name="descricao" style="width: 30em;"
						value="${produto.descricao}">
						
					</div>
					
					<div class="campo">
					
						<label for="quantidade">Quantd.:</label>
						<input type="number" id="quantidade" name="quantidade" style="width: 8em;"
						min="1" max="2000" onkeypress="$(this).mask('0000')"
						value="${produto.quantidade}">
						
					</div>
					
					<div class="campo">
					
						<label for="valorcompra">Valor Compra:</label>
						<input type="text" id="valorcompra" name="valorcompra" style="width: 10em;"
						onkeypress="$(this).mask('R$ 999.990,00', {reverse: true});"
						value="${produto.valorcompra}">
						
					</div>
					
					<div class="campo">
					
						<label for="valoritem">Valor Item:</label>
						<input type="text" id="valoritem" name="valoritem" style="width: 10em;"
						onkeypress="$(this).mask('R$ 999.990,00', {reverse: true});"
						value="${produto.valoritem}">
						
					</div>
					
					<div class="campo">
					
						<label for="valoritem">Categoria:</label>
						<select id="categoria" name="categoria">
							<option disabled="disabled" selected="selected">Selecione uma Opção</option>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
						
					</div>
					
				
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
						<th>Descrição</th>
						<th>Valor Compra</th>
						<th>Valor Item</th>
						<th>Categoria</th>
						<th>Atualizar</th>
						<th>Excluir</th>
						
					</tr>
					
				</thead>
				
				<tbody>
					
					<c:forEach items="${produtos}" var="produto">
					
						<tr>
							
							<td><c:out value="${produto.id}"></c:out></td>				
							<td><c:out value="${produto.descricao}"></c:out></td>				
							<td><c:out value="${produto.quantidade}"></c:out></td>
							<td><c:out value="${produto.valorcompra}"></c:out></td>					
							<td><c:out value="${produto.valoritem}"></c:out></td>				
							<td><c:out value="${produto.categoria}"></c:out></td>				
							
							<td><a href="ServletProduto?acao=update&produto=${produto.id}">
								<img alt="update" src="resources/img/editar.png" title="Atualizar" 
								style="width: 20px; height: 20px;">
							</a></td>	
							
										
							<td><a href="ServletProduto?acao=delete&produto=${produto.id}">
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