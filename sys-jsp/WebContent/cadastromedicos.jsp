<%@page import="br.com.sysjsp.classes.model.Medico"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>

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

<title>Cadastro de Médicos</title>
</head>

<body>

	<section>

		<form id="formulario" action="ServletMedico" method="post">
	
			<a class="div-a" href="menu.jsp"><img alt="home" src="resources/img/home1.png"> Voltar para o menu</a>
	
			<div class="div-cadastrousuario">
				<h1>[ - Cadastro de Médicos - ]</h1>
			</div>
	
			<div class="div-dadosusuario">
				<h2>[ - Dados Pessoais - ]</h2>
			</div>
	
			<!-- agrupa os campos do formulário -->
			<fieldset>
	
				<fieldset class="grupo">
	
					<div class="campo">
	
						<label for="id">Código:</label> 
						<input type="text" id="id" name="id" style="width: 8em;" readonly="readonly"
							value="${med.id}">
	
					</div>
	
				</fieldset>
	
				<fieldset class="grupo">
	
					<div class="campo">
	
						<label for="nome">Nome:</label> 
						<input type="text" id="nome" name="nome" style="width: 30em;" required="required"
							value="${med.nome}" autofocus="autofocus">
	
					</div>
	
					<div class="campo">
	
						<label for="cpf">CPF:</label> 
						<input type="text" id="cpf"	name="cpf" style="width: 10em;" required="required"
							onkeypress="$(this).mask('000.000.000-00')" value="${med.cpf}">
	
					</div>
	
					<div class="campo">
	
						<label for="crm">CRM:</label> 
						<input type="text" id="crm" name="crm" style="width: 7em;" required="required"
							onkeypress="$(this).mask('0000000000')" value="${med.crm}">
	
					</div>
	
					<div class="campo">
	
						<label for="uf">UF:</label>
							<select id="uf" name="uf">
								<option disabled="disabled" selected="selected">Selecione um UF</option>
								<option value="AC"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("AC")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>AC</option>
								<option value="AL"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("AL")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>AL</option>
								<option value="AP"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("AP")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>AP</option>
								<option value="AM"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("AM")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>AM</option>
								<option value="BA"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("BA")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>BA</option>
								<option value="CE"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("CE")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>CE</option>
								<option value="DF"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("DF")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>DF</option>
								<option value="ES"
									
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("ES")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>ES</option>
								<option value="GO"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("GO")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>GO</option>
								<option value="MA"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("MA")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>MA</option>
								<option value="MT"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("MT")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>MT</option>
								<option value="MS"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("MS")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>MS</option>
								<option value="MG"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("MG")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>MG</option>
								<option value="PA"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("PA")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>PA</option>
								<option value="PB"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("PB")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>PB</option>
								<option value="PR"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("PR")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>PR</option>
								<option value="PE"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("PE")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>PE</option>
								<option value="PI"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("PI")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>PI</option>
								<option value="RJ"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("RJ")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>RJ</option>
								<option value="RN"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("RN")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>RN</option>
								<option value="RS"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("RS")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>RS</option>
								<option value="RO"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("RO")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>RO</option>
								<option value="RR"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("RR")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>RR</option>
								<option value="SC"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("SC")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>SC</option>
								<option value="SP"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("SP")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>SP</option>
								<option value="SE"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("SE")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>SE</option>
								<option value="TO"
								
									<%
										if(request.getAttribute("med") != null){
											
											Medico medic = (Medico) request.getAttribute("med");
											
											if(medic.getUf().equalsIgnoreCase("TO")){
												out.print(" ");
												out.print("selected=\"selected\"");
												out.print(" ");
											}
										}
									%>
								
								>TO</option>
							</select>
	
					</div>
	
				</fieldset>
	
				<fieldset class="grupo">
				
					<div class="campo">
	
						<label for="especialidade">Especialidade:</label>
						<select id="especialidade" name="id_especialidade">
						
							<option disabled="disabled" selected="selected">Selecione uma Opção</option>
							
							<c:forEach items="${especialidades}" var="espec">
							
									<option  id="${espec.id}" value="${espec.id}"
									
										<c:if test="${espec.id == med.especialidade}">
		        							<c:out value="selected=\"selected\""/>
		    							</c:if>
									
									>
										
									${espec.descricao}	
									</option>
									
								</c:forEach>
						
						</select>	
	
					</div>
	
					<div class="campo">
	
						<label for="datacadastro">Data do Cadastro:</label> 
						<input type="date" id="datacadastro" name="datacadastro" style="width: 11em;"
							required="required" value="${med.dataCadastro}" pattern="dd/MM/yyyy">
	
					</div>
					
					<div class="campo">
	
						<label for="datanascimento">Data de Nascimento:</label> 
						<input type="date" id="datanascimento" name="datanascimento" style="width: 11em;"
							required="required" value="${med.dataNascimento}" pattern="dd/MM/yyyy">
	
					</div>
					
					<div class="campo">
					
						<label for="genero">Gênero:</label>
						
						<select id="genero" name="genero">
						
							<option disabled="disabled" selected="selected">Selecione uma Opção</option>
							
							<option value="Masculino"
							
								<%
									
									if(request.getAttribute("med") != null){
										
										Medico medic = (Medico) request.getAttribute("med");
										
										if(medic.getGenero().equalsIgnoreCase("Masculino")){
											out.print(" ");
											out.print("selected=\"selected\"");
											out.print(" ");
										}
									}
								
								%>
							
							>Masculino</option>
							
							<option value="Feminino"
							
								<%
									
									if(request.getAttribute("med") != null){
										
										Medico medic = (Medico) request.getAttribute("med");
										
										if(medic.getGenero().equalsIgnoreCase("Feminino")){
											out.print(" ");
											out.print("selected=\"selected\"");
											out.print(" ");
										}
									}
								
								%>
							
							>Feminino</option>
							
							<option value="Outro"
							
								<%
									
									if(request.getAttribute("med") != null){
										
										Medico medic = (Medico) request.getAttribute("med");
										
										if(medic.getGenero().equalsIgnoreCase("Outro")){
											out.print(" ");
											out.print("selected=\"selected\"");
											out.print(" ");
										}
									}
								
								%>
							
							>Outro</option>
							
						</select>
					
					</div>
	
				</fieldset>
				
				<fieldset class="grupo">
				
					<div class="campo">
	
						<label for="email">E-mail:</label> 
						<input type="text" id="email" name="email" style="width: 25em;" required="required"
							value="${med.email}">
	
					</div>				
				
				</fieldset>
	
				<div class="div-dadosusuario">
					<h2>[ - Dados do Endereço - ]</h2>
				</div>
	
				<fieldset class="grupo">
	
					<div class="campo">
	
						<label for="cep">CEP:</label> 
						<input type="text" id="cep"
							name="cep" style="width: 10em;" onblur="consultaCep();"
							value="${med.cep}" placeholder="Informe cep válido"
							onkeypress="$(this).mask('00000000')">
	
					</div>
	
					<div class="campo">
	
						<label for="endereco">Endereço:</label> 
						<input type="text" id="endereco" name="endereco" style="width: 30em;"
							value="${med.endereco}">
	
					</div>
	
					<div class="campo">
	
						<label for="numero">Número:</label> 
						<input type="text" id="numero" name="numero" style="width: 8em;"
							onkeypress="$(this).mask('00000000')" value="${med.numero}">
	
					</div>
	
				</fieldset>
	
				<fieldset class="grupo">
	
					<div class="campo">
	
						<label for="bairro">Bairro:</label> 
						<input type="text" id="bairro" name="bairro" style="width: 20em;" value="${med.bairro}">
	
					</div>
	
					<div class="campo">
	
						<label for="cidade">Cidade:</label> 
						<input type="text" id="cidade" name="cidade" style="width: 20em;" value="${med.cidade}">
	
					</div>
	
					<div class="campo">
	
						<label for="estado">UF:</label> 
						<input type="text" id="estado" name="estado" style="width: 5em;" value="${med.estado}">
	
					</div>
	
					<div class="campo">
	
						<label for="ibge">Cód. IBGE:</label> 
						<input type="text" id="ibge" name="ibge" style="width: 8em;" value="${med.ibge}">
	
					</div>
	
				</fieldset>
	
				<button type="submit" class="botao submit" value="Salvar">Salvar</button>
				<button type="submit" class="botao submit" value="Cancelar"
					onclick="document.getElementById('formulario').action = 'ServletMedico?acao=reset'">Cancelar</button>
	
			</fieldset>
	
		</form>
	
	</section>

	<section>

		<div class="caption">Médicos Cadastrados</div>

		<div class="tbl-header">

			<table>

				<thead>

					<tr>

						<th style="width: 8%; text-align: center;">Código</th>
						<th style="width: 30%; text-align: center;">Nome</th>
						<th style="width: 12%; text-align: center;">CPF</th>
						<th style="width: 12%; text-align: center;">CRM/UF</th>
						<th style="width: 30%; text-align: center;">Email</th>
						<th style="width: 8%; text-align: center;">#</th>
						<th style="width: 8%; text-align: center;">#</th>
						<th style="width: 8%; text-align: center;">#</th>

					</tr>

				</thead>

			</table>

		</div>

		<div class="tbl-content">

			<table>

				<tbody>

					<c:forEach items="${medicos}" var="med">

						<tr>

							<td style="width: 8%;"><c:out value="${med.id}"></c:out></td>
							<td style="width: 30%;"><c:out value="${med.nome}"></c:out></td>
							<td style="width: 12%;"><c:out value="${med.cpf}"></c:out></td>
							<td style="width: 12%;"><c:out value="${med.crm}/${med.uf}"></c:out></td>
							<td style="width: 30%;"><c:out value="${med.email}"></c:out></td>


							<td style="width: 8%;"><a href="ServletMedico?acao=update&med=${med.id}">
									<img alt="update" src="resources/img/editar.png"
									title="Atualizar" style="width: 24px; height: 24px;">
							</a></td>

							<td style="width: 8%;"><a href="ServletMedico?acao=delete&med=${med.id}">
									<img alt="delete" src="resources/img/excluir.png"
									title="Excluir" style="width: 24px; height: 24px;">
							</a></td>

							<td style="width: 8%;"><a href="ServletTelefoneMedico?acao=addTelefone&med=${med.id}">
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