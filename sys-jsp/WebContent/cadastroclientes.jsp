<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" type="text/css"
	href="resources/css/estiloCadastro.css" />
<link rel="stylesheet" type="text/css" href="resources/css/table.css" />



<!-- mascara funcionar tem que colocar estas bibliotecas abaixo -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>



<title>Cadastro de Clientes</title>
</head>

<body>

	<section>

		<form id="formulario" action="ServletCliente" method="post"	enctype="multipart/form-data">
	
			<a class="div-a" href="menu.jsp"><img alt="home" src="resources/img/home1.png"> Voltar para o menu</a>
	
			<div class="div-cadastrousuario">
				<h1>Cadastro de Clientes</h1>
			</div>
	
			<div class="div-dadosusuario">
				<h2>Dados Pessoais</h2>
			</div>
	
			<!-- agrupa os campos do formulário -->
			<fieldset>
	
				<fieldset class="grupo">
	
					<div class="campo">
	
						<label for="id">Código:</label> 
						<input type="text" id="id"
							name="id" style="width: 8em;" readonly="readonly"
							value="${cli.id}">
	
					</div>
	
				</fieldset>
	
				<fieldset class="grupo">
	
					<div class="campo">
	
						<label for="nome">Nome:</label> 
						<input type="text" id="nome"
							name="nome" style="width: 30em;" required="required"
							value="${cli.nome}">
	
					</div>
	
					<div class="campo">
	
						<label for="cpf">CPF:</label> 
						<input type="text" id="cpf"
							name="cpf" style="width: 10em;" required="required"
							onkeypress="$(this).mask('000.000.000-00')" value="${cli.cpf}">
	
					</div>
	
					<div class="campo">
	
						<label for="rg">RG:</label> 
						<input type="text" id="rg" name="rg"
							style="width: 8em;" required="required"
							onkeypress="$(this).mask('0000000000')" value="${cli.rg}">
	
					</div>
	
					<div class="campo">
	
						<label for="orgaoexpeditor">Orgão Exp.:</label> 
						<input type="text"
							id="orgaoexpeditor" name="orgaoexpeditor" style="width: 6em;"
							required="required" onkeypress="$(this).mask('AAA/AA')"
							value="${cli.orgaoexpeditor}">
	
					</div>
	
				</fieldset>
	
				<fieldset class="grupo">
	
					<div class="campo">
	
						<label for="datanascimento">Data Nasc.:</label> 
						<input type="date"
							id="datanascimento" name="datanascimento" style="width: 11em;"
							required="required" value="${cli.datanascimento}">
	
					</div>
	
					<div class="campo">
	
						<label for="telefonefixo">Tel. Residencial:</label> 
						<input
							type="text" id="telefonefixo" name="telefonefixo"
							style="width: 10em;" required="required"
							onkeypress="$(this).mask('(00) 0000-0000')"
							value="${cli.telefonefixo}">
	
					</div>
	
					<div class="campo">
	
						<label for="telefonecelular">Tel. Celular:</label> 
						<input
							type="text" id="telefonecelular" name="telefonecelular"
							style="width: 10em;" required="required"
							onkeypress="$(this).mask('(00) 0.0000-0000')"
							value="${cli.telefonecelular}">
	
					</div>
	
					<div class="campo">
	
						<label for="email">E-mail:</label> 
						<input type="text" id="email"
							name="email" style="width: 25em;" required="required"
							value="${cli.email}">
	
					</div>
	
	
				</fieldset>
	
				<fieldset class="grupo">
	
					<div class="campo">
	
						<label for="observacao">Observação:</label> 
						<input type="text"
							id="observacao" name="observacao" style="width: 60em;"
							value="${cli.observacao}">
	
					</div>
	
				</fieldset>
	
				<fieldset class="grupo">
	
					<div class="campo">
	
						<label for="foto">Foto:</label> 
						<input type="file" id="foto"
							name="foto" style="width: 10em; margin-left: 0.6em;"> <input
							type="hidden" name="fotoTemp" readonly="readonly"
							value="${cli.fotoBase64}"> <input type="hidden"
							name="contentTypeTemp" readonly="readonly"
							value="${cli.contentType}">
	
					</div>
	
				</fieldset>
	
				<fieldset class="grupo">
	
					<div class="campo">
	
						<label for="arquivo">Arquivo PDF:</label> 
						<input type="file"
							id="arquivo" name="arquivo"
							style="width: 10em; margin-left: 0.6em;"> <input
							type="hidden" name="arquivoTemp" readonly="readonly"
							value="${cli.arquivoBase64}"> <input type="hidden"
							name="arquivoContentTypeTemp" readonly="readonly"
							value="${cli.contentTypeArquivo}">
	
					</div>
	
				</fieldset>
	
				<div class="div-dadosusuario">
					<h2>Dados do Endereço</h2>
				</div>
	
				<fieldset class="grupo">
	
					<div class="campo">
	
						<label for="cep">CEP:</label> 
						<input type="text" id="cep"
							name="cep" style="width: 10em;" onblur="consultaCep();"
							value="${cli.cep}" placeholder="Informe cep válido"
							onkeypress="$(this).mask('00000000')">
	
					</div>
	
					<div class="campo">
	
						<label for="endereco">Endereço:</label> 
						<input type="text"
							id="endereco" name="endereco" style="width: 30em;"
							value="${cli.endereco}">
	
					</div>
	
					<div class="campo">
	
						<label for="numero">Número:</label> 
						<input type="text" id="numero"
							name="numero" style="width: 8em;"
							onkeypress="$(this).mask('00000000')" value="${cli.numero}">
	
					</div>
	
				</fieldset>
	
				<fieldset class="grupo">
	
					<div class="campo">
	
						<label for="bairro">Bairro:</label> 
						<input type="text" id="bairro"
							name="bairro" style="width: 20em;" value="${cli.bairro}">
	
					</div>
	
					<div class="campo">
	
						<label for="cidade">Cidade:</label> 
						<input type="text" id="cidade"
							name="cidade" style="width: 20em;" value="${cli.cidade}">
	
					</div>
	
					<div class="campo">
	
						<label for="estado">UF:</label> 
						<input type="text" id="estado"
							name="estado" style="width: 5em;" value="${cli.estado}">
	
					</div>
	
					<div class="campo">
	
						<label for="ibge">Cód. IBGE:</label> 
						<input type="text" id="ibge"
							name="ibge" style="width: 8em;" value="${cli.ibge}">
	
					</div>
	
				</fieldset>
	
				<button type="submit" class="botao submit" value="Salvar">Salvar</button>
				<button type="submit" class="botao submit" value="Cancelar"
					onclick="document.getElementById('formulario').action = 'ServletCliente?acao=reset'">Cancelar</button>
	
			</fieldset>
	
		</form>
	
	</section>

	<section>

		<div class="caption">Produtos Cadastrados</div>

		<div class="tbl-header">

			<table>

				<thead>

					<tr>

						<th style="width: 8%; text-align: center;">Código</th>
						<th style="width: 30%; text-align: center;">Nome</th>
						<th style="width: 12%; text-align: center;">CPF</th>
						<th style="width: 30%; text-align: center;">Email</th>
						<th style="width: 8%; text-align: center;">PDF</th>
						<th style="width: 8%; text-align: center;">Foto</th>
						<th style="width: 8%; text-align: center;">Atualizar</th>
						<th style="width: 8%; text-align: center;">Excluir</th>
						<th style="width: 10%; text-align: center;">Telefones</th>

					</tr>

				</thead>

			</table>

		</div>

		<div class="tbl-content">

			<table>

				<tbody>

					<c:forEach items="${clientes}" var="cli">

						<tr>

							<td style="width: 8%;"><c:out value="${cli.id}"></c:out></td>
							<td style="width: 30%;"><c:out value="${cli.nome}"></c:out></td>
							<td style="width: 12%;"><c:out value="${cli.cpf}"></c:out></td>
							<td style="width: 30%;"><c:out value="${cli.email}"></c:out></td>

							<c:if test="${cli.arquivoBase64.isEmpty() == false}">
							
								<td style="width: 8%;"><a href="ServletCliente?acao=download&tipo=arquivoEmPdf&cli=${cli.id}">
										<img src="resources/img/pdf.png" alt="ArquivoPDF"
										title="Baixar PDF" style="width: 24px; height: 24px;">
								</a></td>
								
							</c:if>

							<c:if test="${cli.arquivoBase64.isEmpty() || cli.arquivoBase64 == null}">
							
								<td style="width: 8%;">
									<img src="resources/img/semPdf.png" alt="ArquivoPDF"
									title="Sem PDF" style="width: 24px; height: 24px;"
									onclick="alert('Não Possui PDF Cadastrado!');">
								</td>
								
							</c:if>

							<c:if test="${cli.fotoBase64.isEmpty() == false}">
								
								<td style="width: 8%;"><a href="ServletCliente?acao=download&tipo=imagem&cli=${cli.id}">
										<img src='<c:out value="${cli.tempFotoCliente}"/>'
										alt="ImagemFoto" title="Baixar Imagem"
										style="width: 24px; height: 24px;">
								</a></td>
							</c:if>

							<c:if test="${cli.fotoBase64.isEmpty() || cli.fotoBase64.isEmpty() == null}">
							
								<td style="width: 8%;">
									<img src="resources/img/semImagem.png" alt="ImagemFoto"
									title="Sem Imagem" style="width: 24px; height: 24px;"
									onclick="alert('Não Possui Imagem Cadastrada!');">
									
								</td>
								
							</c:if>

							<td style="width: 8%;"><a href="ServletCliente?acao=update&cli=${cli.id}">
									<img alt="update" src="resources/img/editar.png"
									title="Atualizar" style="width: 24px; height: 24px;">
							</a></td>

							<td style="width: 8%;"><a href="ServletCliente?acao=delete&cli=${cli.id}">
									<img alt="delete" src="resources/img/excluir.png"
									title="Excluir" style="width: 24px; height: 24px;">
							</a></td>

							<td style="width: 10%;"><a href="ServletTelefone?acao=addTelefone&cli=${cli.id}">
									<img alt="telefone" src="resources/img/telefone.png"
									title="Adicionar Telefone" style="width: 24px; height: 24px;">
							</a></td>

						</tr>

					</c:forEach>

				</tbody>

			</table>

		</div>

	</section>

	<script type="text/javascript">
		function consultaCep() {
			/*pegando cep digitado no input pelo usuário*/
			var cep = $("#cep").val();

			/*fazendo a requisição ajax*/
			//Consulta o webservice viacep.com.br/
			$.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?",
					function(dados) {

						/*se não houver erro na busca do dados*/
						if (!("erro" in dados)) {

							//Atualiza os campos com os valores da consulta.
							$("#endereco").val(dados.logradouro);
							$("#numero").val(dados.numero);
							$("#bairro").val(dados.bairro);
							$("#cidade").val(dados.localidade);
							$("#estado").val(dados.uf);
							$("#ibge").val(dados.ibge);

						} //end if.
						else {

							//caso o cep não seja encontrado, limpa os campos.
							$("#cep").val('');
							$("#endereco").val('');
							$("#numero").val('');
							$("#bairro").val('');
							$("#cidade").val('');
							$("#estado").val('');
							$("#ibge").val('');
							//CEP pesquisado não foi encontrado.
							alert("CEP não encontrado.");
						}
					});
		}
	</script>

</body>

</html>