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
    
<title>Cadastro de Bandeiras</title>
</head>

<body>

	<section>
		
		<form id="formulario" action="ServletBandeira" method="post">
		
			<a class="div-a" href="menu.jsp"><img alt="home" src="resources/img/home1.png"> Voltar para o menu</a>
			
			<div class="div-cadastrousuario">
				<h1>[ - Cadastro de Bandeiras - ]</h1>
			</div>
			
			<div class="div-h4">
				<h4>Campos obrigatórios com (*)</h4>
			</div>
			
			<!-- agrupa os campos do formulário -->
			<fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
					
						<label for="id">Código:</label>
						<input type="text" id="id" name="id" style="width: 8em;" readonly="readonly"
						value="${band.id}">
						
					</div>
					
				</fieldset>
				
				<fieldset class="grupo">
					
					<div class="campo">
						
						<label for="nome">Nome:*</label>
						<input type="text" id="nome" name="nome" style="width: 30em;"
						value="${band.nome}" required="required" autofocus="autofocus">
					
					</div>
				
				</fieldset>
				
				<button type="submit" class="botao submit" value="Salvar">Salvar</button>
				<button type="submit" class="botao submit" value="Cancelar"
				onclick="document.getElementById('formulario').action='ServletBandeira?acao=reset'">Cancelar</button>
			
			</fieldset>
		
		</form>
		
	</section>
		
	<section>
	
		<div class="caption">Bandeiras Cadastrados</div>
		
		<div class="tbl-header">
		
			<table>
				
				<thead>
					
					<tr>
						
						<th style="width: 30%; text-align: center;">Código</th>
						<th style="width: 30%; text-align: center;">Nome</th>
						<th style="width: 8%; text-align: center;">#</th>
						<th style="width: 8%; text-align: center;">#</th>
						
					</tr>
					
				</thead>
				
			</table>
			
		</div>
		
		<div class="tbl-content">
				
			<table>
			
				<tbody>
					
					<c:forEach items="${bandeiras}" var="band">
					
						<tr>
							
							<td><c:out value="${band.id}"></c:out></td>				
							<td><c:out value="${band.nome}"></c:out></td>				
										
							<td style="width: 8%;"><a href="ServletBandeira?acao=update&band=${band.id}">
								<img alt="update" src="resources/img/editar.png" title="Atualizar" 
								style="width: 20px; height: 20px;">
							</a></td>	
											
							<td style="width: 8%;"><a href="ServletBandeira?acao=delete&band=${band.id}">
								<img alt="delete" src="resources/img/excluir.png" title="Excluir" 
								style="width: 20px; height: 20px;">
							</a></td>
							
						</tr>
				
					</c:forEach>
				
				</tbody>
				
			</table>
		
		</div>
		
	</section>
		
</body>

</html>