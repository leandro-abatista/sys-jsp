<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" type="text/css" href="resources/css/estiloCadastro.css" />
<link rel="stylesheet" type="text/css" href="resources/css/estiloConsultaP.css" />


<!-- mascara funcionar tem que colocar estas bibliotecas abaixo -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<title>Consulta de Clientes</title>
</head>

<body>

	<section>

		<form id="formulario" action="ServletConsCli" method="post">
		
		<a class="div-a" href="menu.jsp"><img alt="home" src="resources/img/home1.png"> Voltar para o menu</a>

			<h1>Clientes Cadastrados</h1>

			<div class="tbl-header">

				<table>

					<thead>

						<tr>
							<th style="width: 8%; text-align: center;">Código</th>
							<th style="width: 30%; text-align: center;">Nome</th>
							<th style="width: 10%; text-align: center;">CPF</th>
							<th style="width: 30%; text-align: center;">Email</th>
							<th style="width: 10%; text-align: center;">Arquivo PDF</th>
							<th style="width: 10%; text-align: center;">Foto</th>
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
								<td style="width: 10%;"><c:out value="${cli.cpf}"></c:out></td>
								<td style="width: 30%;"><c:out value="${cli.email}"></c:out></td>
								
								<c:if test="${cli.arquivoBase64.isEmpty() == false}">
									<td style="width: 10%;">
										<a href="ServletConsCli?acao=download&tipo=arquivoEmPdf&cli=${cli.id}">
											<img src="resources/img/pdf.png" alt="ArquivoPDF" 
											title="Baixar PDF" style="width: 24px; height: 24px;">
										</a>
									</td>
								</c:if>
								
								<c:if test="${cli.arquivoBase64.isEmpty() || cli.arquivoBase64 == null}">
									<td style="width: 10%;">
										<img src="resources/img/semPdf.png" alt="ArquivoPDF" 
										title="Sem PDF" style="width: 24px; height: 24px;" 
										onclick="alert('Não Possui PDF Cadastrado!');">
									</td>
								</c:if>
								
								<c:if test="${cli.fotoBase64.isEmpty() == false}"><!--  -->
									<td style="width: 10%;">
										<a href="ServletConsCli?acao=download&tipo=imagem&cli=${cli.id}">
											<img src='<c:out value="${cli.tempFotoCliente}"/>' alt="ImagemFoto" 
											title="Baixar Imagem" style="width: 24px; height: 24px;">
										</a>
									</td>
								</c:if>
								
								<c:if test="${cli.fotoBase64.isEmpty() || cli.fotoBase64.isEmpty() == null}">
									<td style="width: 10%;">
										<img src="resources/img/semImagem.png" alt="ImagemFoto" 
										title="Sem Imagem" style="width: 24px; height: 24px;" 
										onclick="alert('Não Possui Imagem Cadastrada!');">
									</td>
								</c:if>
							
							</tr>

						</c:forEach>

					</tbody>

				</table>

			</div>

		</form>

	</section>

	<script type="text/javascript">
		$(window).on(
				"load resize ",
				function() {
					var scrollWidth = $('.tbl-content').width()
							- $('.tbl-content table').width();
					$('.tbl-header').css({
						'padding-right' : scrollWidth
					});
				}).resize();
	</script>

</body>

</html>