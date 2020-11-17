<%@page import="br.com.sysjsp.classes.model.ProdutoCsv"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" type="text/css" href="resources/css/estiloCadastro.css"/>
<link rel="stylesheet" type="text/css" href="resources/css/table.css"/>

<!-- mascara funcionar tem que colocar estas bibliotecas abaixo -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    

<title>Cadastro de ProdutosCsv</title>
</head>

<body>
	
	<section>

		<form id="formulario" action="ServletProdutoCsv" method="post">
		
			<a class="div-a" href="menu.jsp"><img alt="home" src="resources/img/home1.png"> Menu</a>
		
				<div class="div-cadastrousuario">
					<h1>[ - Cadastro de ProdutosCSV - ]</h1>
				</div>
				
				<div class="div-dadosusuario">
					<h2>[ - Dados do Produto - ]</h2>
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
							value="${produtocsv.id}">
							
						</div>
					
					</fieldset>
					
					<fieldset class="grupo">
					
						<div class="campo">
						
							<label for="revenda">Revenda:*</label>
							<input type="text" id="revenda" name="revenda" style="width: 30em;"
							value="${produtocsv.revenda}" required="required" autofocus="autofocus">
							
						</div>
						
						<div class="campo">
	
							<label for="cnpjRevenda">CNPJ Revenda:*</label> 
							<input type="text" id="cnpjRevenda" name="cnpjRevenda" style="width: 12em;" required="required"
							onkeypress="$(this).mask('000.000.000/0000-00')" value="${produtocsv.cnpjRevenda}">
	
						</div>
						
						<div class="campo">
	
						<label for="dataColeta">Data da Coleta:*</label> 
						<input type="date" id="dataColeta" name="dataColeta" style="width: 11em;"
						required="required" value="${produtocsv.dataColeta}" pattern="dd/MM/yyyy">
	
					</div>
					
					</fieldset>
					
					<fieldset class="grupo">
						
						<div class="campo">
						
							<label for="descricaoProduto">Descrição do Produto:*</label>
							<input type="text" id="descricaoProduto" name="descricaoProduto" style="width: 30em;"
							value="${produtocsv.descricaoProduto}" required="required">
							
						</div>
						
						<div class="campo">
						
							<label for="valorCompra">Valor Compra:*</label>
							<input type="text" id="valorCompra" name="valorCompra" style="width: 10em;"
							onkeypress="$(this).mask('###.###.##0,00', {reverse: true});"
							value="${produtocsv.valorCompra}" required="required">
							
						</div>
						
						<div class="campo">
						
							<label for="valorVenda">Valor Venda:*</label>
							<input type="text" id="valorVenda" name="valorVenda" style="width: 10em;"
							onkeypress="$(this).mask('###.###.##0,00', {reverse: true});"
							value="${produtocsv.valorVenda}" required="required">
							
						</div>
						
						<div class="campo">
						
							<label for="quantidade">Quantd.:*</label>
							<input type="number" id="quantidade" name="quantidade" style="width: 8em;"
							min="1" max="100000" onkeypress="$(this).mask('000000')"
							value="${produtocsv.quantidade}" required="required">
							
						</div>
						
						<div class="campo">
						
						<label>Unid. Medida:*</label>
						<select id="unidadeMedida" name="unidadeMedida">
						
							<option disabled="disabled" selected="selected">[- Selecione -]</option>
							
							<option value="R$/Litro"
								
								<%
									if(request.getAttribute("produtocsv") != null){
										
										ProdutoCsv produtoCsv = (ProdutoCsv) request.getAttribute("produtocsv");
										
										if(produtoCsv.getUnidadeMedida().equalsIgnoreCase("R$/Litro")){
											out.print(" ");
											out.print("selected=\"selected\"");
											out.print(" ");
										}
									}
								%>
							
							>R$/Litro</option>
							
						</select>
					
					</div>
							
					</fieldset>
					
					<fieldset class="grupo">
					
						<div class="campo">
						
						<label>Tipo Combust.:*</label>
						<select id="tipo" name="tipo">
						
							<option disabled="disabled" selected="selected">[- Selecione -]</option>
							
							<option value="Diesel"
								
								<%
									if(request.getAttribute("produtocsv") != null){
										
										ProdutoCsv produtoCsv = (ProdutoCsv) request.getAttribute("produtocsv");
										
										if(produtoCsv.getTipo().equalsIgnoreCase("Diesel")){
											out.print(" ");
											out.print("selected=\"selected\"");
											out.print(" ");
										}
									}
								%>
							
							>Diesel</option>
							
							<option value="Diesel S10"
								
								<%
									if(request.getAttribute("produtocsv") != null){
										
										ProdutoCsv produtoCsv = (ProdutoCsv) request.getAttribute("produtocsv");
										
										if(produtoCsv.getTipo().equalsIgnoreCase("Diesel S10")){
											out.print(" ");
											out.print("selected=\"selected\"");
											out.print(" ");
										}
									}
								%>
							
							>Diesel S10</option>
							
							<option value="Diesel Aditivado"
								
								<%
									if(request.getAttribute("produtocsv") != null){
										
										ProdutoCsv produtoCsv = (ProdutoCsv) request.getAttribute("produtocsv");
										
										if(produtoCsv.getTipo().equalsIgnoreCase("Diesel Aditivado")){
											out.print(" ");
											out.print("selected=\"selected\"");
											out.print(" ");
										}
									}
								%>
							
							>Diesel Aditivado</option>
							
							<option value="Diesel Premium"
								
								<%
									if(request.getAttribute("produtocsv") != null){
										
										ProdutoCsv produtoCsv = (ProdutoCsv) request.getAttribute("produtocsv");
										
										if(produtoCsv.getTipo().equalsIgnoreCase("Diesel Premium")){
											out.print(" ");
											out.print("selected=\"selected\"");
											out.print(" ");
										}
									}
								%>
							
							>Diesel Premium</option>
							
							<option value="Etanol"
								
								<%
									if(request.getAttribute("produtocsv") != null){
										
										ProdutoCsv produtoCsv = (ProdutoCsv) request.getAttribute("produtocsv");
										
										if(produtoCsv.getTipo().equalsIgnoreCase("Etanol")){
											out.print(" ");
											out.print("selected=\"selected\"");
											out.print(" ");
										}
									}
								%>
							
							>Etanol</option>
							
							<option value="Gasolina"
								
								<%
									if(request.getAttribute("produtocsv") != null){
										
										ProdutoCsv produtoCsv = (ProdutoCsv) request.getAttribute("produtocsv");
										
										if(produtoCsv.getTipo().equalsIgnoreCase("Gasolina")){
											out.print(" ");
											out.print("selected=\"selected\"");
											out.print(" ");
										}
									}
								%>
							
							>Gasolina</option>
							
							<option value="Gasolina Aditivada"
								
								<%
									if(request.getAttribute("produtocsv") != null){
										
										ProdutoCsv produtoCsv = (ProdutoCsv) request.getAttribute("produtocsv");
										
										if(produtoCsv.getTipo().equalsIgnoreCase("Gasolina Aditivada")){
											out.print(" ");
											out.print("selected=\"selected\"");
											out.print(" ");
										}
									}
								%>
							
							>Gasolina Aditivada</option>
							
							<option value="GNV"
								
								<%
									if(request.getAttribute("produtocsv") != null){
										
										ProdutoCsv produtoCsv = (ProdutoCsv) request.getAttribute("produtocsv");
										
										if(produtoCsv.getTipo().equalsIgnoreCase("GNV")){
											out.print(" ");
											out.print("selected=\"selected\"");
											out.print(" ");
										}
									}
								%>
							
							>GNV</option>
							
						</select>
					
					</div>
					
					<div class="campo">
						
							<label for="bandeira">Bandeiras:*</label>
							<select id="bandeira" name="id_bandeira">
							
								<option disabled="disabled" selected="selected">[- Selecione -]</option>
								
								<c:forEach items="${bandeiras}" var="band">
									<option  id="${band.id}" value="${band.id}"
									
										<c:if test="${band.id == produtocsv.id_bandeira}">
		        							<c:out value="selected=\"selected\""/>
		    							</c:if>
									
									>
										
									${band.nome}
									</option>
									
								</c:forEach>
								
							</select>
						
						</div>
						
						<div class="campo">
						
							<label for="estados">Estado:*</label>
							<select id="estados" name="estado">
								<option disabled="disabled" selected="selected">[- Selecione -]</option>
								<option value=""
								
								
								></option>
							</select>
							
						</div>
						
						<div class="campo">
							
							<label for="cidades">Cidade:*</label>
							<select id="cidades" name="cidade" style="width: 20em;">
								<option disabled="disabled" selected="selected">[- Selecione -]</option>
							</select>
							
						</div>
					
					</fieldset>
					
									
				<button type="submit" class="botao submit" value="Salvar">Salvar</button>
				<button type="submit" class="botao submit" value="Cancelar"
				onclick="document.getElementById('formulario').action = 'ServletProdutoCsv?acao=reset'">Cancelar</button>
			
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
								<th style="width: 30%; text-align: center;">Revenda</th>
								<th style="width: 15%; text-align: center;">CNPJ</th>
								<th style="width: 20%; text-align: center;">Descricao Prod.</th>
								<th style="width: 8%; text-align: center;">QTD/L</th>
								<th style="width: 10%; text-align: center;">Valor Compra</th>
								<th style="width: 10%; text-align: center;">Valor Venda</th>
								<th style="width: 8%; text-align: center;">#</th>
								<th style="width: 8%; text-align: center;">#</th>
								
							</tr>
							
						</thead>
						
					</table>
					
				</div>
				
				<div class="tbl-content">
				
				<table>
					
					<tbody>
						
						<c:forEach items="${produtos}" var="produtocsv">
						
							<tr>
								
								<td style="width: 8%;"><c:out value="${produtocsv.id}"></c:out></td>				
								<td style="width: 30%;"><c:out value="${produtocsv.revenda}"></c:out></td>				
								<td style="width: 15%;"><c:out value="${produtocsv.cnpjRevenda}"></c:out></td>				
								<td style="width: 20%;"><c:out value="${produtocsv.descricaoProduto}"></c:out></td>
								<td style="width: 8%;"><c:out value="${produtocsv.quantidade}"></c:out></td>
								<td style="width: 10%;"><fmt:formatNumber type="currency" maxFractionDigits="2" value="${produtocsv.valorCompra}"/></td>					
								<td style="width: 10%;"><fmt:formatNumber type="currency" maxFractionDigits="2" value="${produtocsv.valorVenda}"/></td>					
								
								<td style="width: 8%;"><a href="ServletProdutoCsv?acao=update&produtocsv=${produtocsv.id}">
									<img alt="update" src="resources/img/editar.png" title="Atualizar" 
									style="width: 20px; height: 20px;">
								</a></td>	
								
											
								<td style="width: 8%;"><a href="ServletProdutoCsv?acao=delete&produtocsv=${produtocsv.id}">
									<img alt="delete" src="resources/img/excluir.png" title="Excluir" 
									style="width: 20px; height: 20px;">
								</a></td>
								
							</tr>
					
						</c:forEach>
					
					</tbody>
					
				</table>
				
			</div>
		
		</section>
		
		
		
	<script type="text/javascript">

		$().ready(function() {
			setTimeout(function () {
				$('#mensagem').hide(); // "foo" é o id do elemento que seja manipular.
			}, 4000); // O valor é representado em milisegundos.
		});

		$(document).ready(function () {
			
			$.getJSON('https://gist.githubusercontent.com/ografael/2037135/raw/5d31e7baaddd0d599b64c3ec04827fc244333447/estados_cidades.json', function (data) {
				var items = [];
				var options = '<option value="">[- Selecione -]</option>';	
				$.each(data, function (key, val) {
					options += '<option value="' + val.nome + '">' + val.nome + '</option>';
				});					
				$("#estados").html(options);				
				
				$("#estados").change(function () {				
				
					var options_cidades = '';
					var str = "";					
					
					$("#estados option:selected").each(function () {
						str += $(this).text();
					});
					
					$.each(data, function (key, val) {
						if(val.nome == str) {							
							$.each(val.cidades, function (key_city, val_city) {
								options_cidades += '<option value="' + val_city + '">' + val_city + '</option>';
							});							
						}
					});
					$("#cidades").html(options_cidades);
					
				}).change();		
			
			});
		
		});

	</script>

</body>

</html>