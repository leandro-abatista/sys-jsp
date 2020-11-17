<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" type="text/css" href="resources/css/estiloCadastro.css" />
<link rel="stylesheet" type="text/css" href="resources/css/table.css" />

<!-- mascara funcionar tem que colocar estas bibliotecas abaixo -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<title>Cadastro de Especialidades</title>
</head>

<body>

	<section>

		<form id="formulario" action="ServletEspecialidade" method="post">
	
			<a class="div-a" href="menu.jsp"><img alt="home" src="resources/img/home1.png"> Menu</a>
	
			<div class="div-cadastrousuario">
				<h1>[ - Cadastro de Especialidades - ]</h1>
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
							value="${especialidade.id}">
	
					</div>
	
				</fieldset>
	
				<fieldset class="grupo">
	
					<div class="campo">
	
						<label for="descricao">Descrição:*</label> 
						<input type="text" id="descricao" name="descricao" style="width: 30em;" required="required"
							value="${especialidade.descricao}" autofocus="autofocus">
	
					</div>
	
				</fieldset>
	
				<button type="submit" class="botao submit" value="Salvar">Salvar</button>
				<button type="submit" class="botao submit" value="Cancelar"
					onclick="document.getElementById('formulario').action = 'ServletEspecialidade?acao=reset'">Cancelar</button>
	
			</fieldset>
			
			<fieldset class="grupo">
				
				<div class="campo">
					
					<label for="pesquisar">Pesquisar:</label>
					<input type="search" id="pesquisar" name="pesquisar" style="width: 30em;" 
					value="${especialidade.descricao}">
					
				</div>
			
			</fieldset>
	
		</form>
	
	</section>

	<section>

		<div class="caption">Especialidades Cadastradas</div>

		<div class="tbl-header">

			<table>

				<thead>

					<tr>

						<th style="width: 8%; text-align: center;">Código</th>
						<th style="width: 30%; text-align: center;">Descrição</th>
						<th style="width: 8%; text-align: center;">Atualizar</th>
						<th style="width: 8%; text-align: center;">Excluir</th>

					</tr>

				</thead>

			</table>

		</div>

		<div class="tbl-content">

			<table>

				<tbody>

					<c:forEach items="${especialidades}" var="especialidade">

						<tr>

							<td style="width: 8%;"><c:out value="${especialidade.id}"></c:out></td>
							<td style="width: 30%;"><c:out value="${especialidade.descricao}"></c:out></td>


							<td style="width: 8%;"><a href="ServletEspecialidade?acao=update&especialidade=${especialidade.id}">
									<img alt="update" src="resources/img/editar.png"
									title="Atualizar" style="width: 24px; height: 24px;">
							</a></td>

							<td style="width: 8%;"><a href="ServletEspecialidade?acao=delete&especialidade=${especialidade.id}">
									<img alt="delete" src="resources/img/excluir.png"
									title="Excluir" style="width: 24px; height: 24px;">
							</a></td>

						</tr>

					</c:forEach>

				</tbody>

			</table>

		</div>

	</section>

	
</body>

</html>