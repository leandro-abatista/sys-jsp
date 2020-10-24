<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<title>Cadastro de Usuários</title>
</head>

<body>
	
	<div class="form">
	
		<form id="formulario" action="ServletUsuario" method="post">
		
			<a class="div-a"><img alt="home" src="resources/img/home1.png"> Voltar para o menu</a>
		
			<div class="div-cadastrousuario">
				<h1>Cadastro de Usuários</h1>
			</div>
			
			<div class="div-dadosusuario">
				<h2>Dados do Usuário</h2>
			</div>
			
			<!-- agrupa os campos -->
			<fieldset>
			
				<fieldset class="grupo">
						
					<div class="campo">
						
						<label for="id">Código:</label>
						<input type="text" id="id" name="id" style="width: 8em;" 
						value="${user.id}" readonly="readonly">
						
					</div>
						
				</fieldset>
				
				<fieldset class="grupo">
					
					<div class="campo">
						
						<label for="primeironome">Nome:</label>
						<input type="text" id="primeironome" name="primeironome" style="width: 15em;" 
						value="${user.primeironome}" required="required">
						
					</div>
						
					<div class="campo">
						
						<label for="sobrenome">Sobrenome:</label>
						<input type="text" id="sobrenome" name="sobrenome" style="width: 15em;" 
						value="${user.sobrenome}" required="required">
						
					</div>
						
					<div class="campo">
						
						<label for="ultimonome">Último Nome:</label>
						<input type="text" id="ultimonome" name="ultimonome" style="width: 15em;" 
						value="${user.ultimonome}" required="required">
						
					</div>
				
				</fieldset>
				
				<fieldset class="grupo">
					
					<div class="campo">
						
						<label for="usuario">Usuário:</label>
						<input type="text" id="usuario" name="usuario" style="width: 20em;" 
						value="${user.usuario}" required="required">
					
					</div>
					
					<div class="campo">
						
						<label for="senha">Senha:</label>
						<input type="password" id="senha" name="senha" style="width: 20em;" 
						value="${user.senha}" required="required">
					
					</div>
				
				</fieldset>
				
				<fieldset class="grupo">
					
					<div class="campo">
						
						<label for="telefone">Tel. Celular:</label>
						<input type="text" id="telefone" name="telefone" style="width: 10em;" 
						value="${user.telefone}" required="required"
						onkeypress="$(this).mask('(00) 9.0000-0000')">
					
					</div>
					
					<div class="campo">
						
						<label for="email">E-mail:</label>
						<input type="text" id="email" name="email" style="width: 25em;" 
						value="${user.email}" required="required">
					
					</div>
				
				</fieldset>
				
					
				<button type="submit" class="botao submit" value="Salvar">Salvar</button>
				
				<button type="submit" class="botao submit" value="Cancelar"
				onclick="document.getElementById('formulario').action = 'ServletUsuario?acao=reset'">Cancelar</button>
				
			
			</fieldset>
		
		</form>
		
		<br>
		
		<div class="content">
			
			<table class="rTable">
			
					<thead>
						<tr>
							<th>Código</th>
							<th>Nome</th>
							<th>Usuário</th>
							<th>Senha</th>
							<th>Telefone</th>
							<th>E-mail</th>
							<th>Atualizar</th>
							<th>Excluir</th>
						</tr>
					</thead>
				
				<tbody>
				
					<c:forEach items="${usuarios}" var="user">
					
						<tr>
							
							<td><c:out value="${user.id}"></c:out></td>				
							<td><c:out value="${user.primeironome} ${user.sobrenome} ${user.ultimonome}"></c:out></td>				
							<td><c:out value="${user.usuario}"></c:out></td>				
							<td><c:out value="${user.senha}"></c:out></td>				
							<td><c:out value="${user.telefone}"></c:out></td>				
							<td><c:out value="${user.email}"></c:out></td>				
							
							<td><a href="ServletUsuario?acao=update&user=${user.id}">
								<img alt="update" src="resources/img/editar.png" title="Atualizar" 
								style="width: 20px; height: 20px;">
							</a></td>	
							
										
							<td><a href="ServletUsuario?acao=delete&user=${user.id}">
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

	var msg = "<strong>registro salvo com sucesso!</strong>";
	

	function mostraDialogo(mensagem, tipo, tempo){
	    
	    // se houver outro alert desse sendo exibido, cancela essa requisição
	    if($("#message").is(":visible")){
	        return false;
	    }

	    // se não setar o tempo, o padrão é 3 segundos
	    if(!tempo){
	        var tempo = 3000;
	    }

	    // se não setar o tipo, o padrão é alert-info
	    if(!tipo){
	        var tipo = "info";
	    }

	    // monta o css da mensagem para que fique flutuando na frente de todos elementos da página
	    var cssMessage = "display: block; position: fixed; top: 0; left: 20%; right: 20%; width: 60%; padding-top: 10px; z-index: 9999";
	    var cssInner = "margin: 0 auto; box-shadow: 1px 1px 5px black;";

	    // monta o html da mensagem com Bootstrap
	    var dialogo = "";
	    dialogo += '<div id="message" style="'+cssMessage+'">';
	    dialogo += '    <div class="alert alert-'+tipo+' alert-dismissable" style="'+cssInner+'">';
	    dialogo += '    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>';
	    dialogo +=          mensagem;
	    dialogo += '    </div>';
	    dialogo += '</div>';

	    // adiciona ao body a mensagem com o efeito de fade
	    $("body").append(dialogo);
	    $("#message").hide();
	    $("#message").fadeIn(200);

	    // contador de tempo para a mensagem sumir
	    setTimeout(function() {
	        $('#message').fadeOut(300, function(){
	            $(this).remove();
	        });
	    }, tempo); // milliseconds

	}

	
	</script>
	
</body>

</html>