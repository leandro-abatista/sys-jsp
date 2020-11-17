<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>

<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
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

<title>Consulta de Produtos</title>
</head>

<body>

	<section>

		<form id="formulario" action="ServletConsPro" method="post">
		
		<a class="div-a" href="menu.jsp"><img alt="home" src="resources/img/home1.png"> Menu</a>

			<h1>Produtos Cadastrados</h1>

			<div class="tbl-header">

				<table>

					<thead>

						<tr>
							<th style="width: 8%; text-align: center;">Código</th>
							<th style="width: 30%; text-align: center;">Descrição</th>
							<th style="width: 10%; text-align: center;">Quantd.</th>
							<th style="width: 15%; text-align: center;">Valor Compra</th>
							<th style="width: 15%; text-align: center;">Valor Item</th>
							<th style="width: 10%; text-align: center;">Categoria</th>
						</tr>

					</thead>

				</table>

			</div>

			<div class="tbl-content">

				<table>

					<tbody>
					
						<c:forEach items="${produtos}" var="produto">

							<tr>

								<td style="width: 8%;"><c:out value="${produto.id}"></c:out></td>
								<td style="width: 30%;"><c:out value="${produto.descricao}"></c:out></td>
								<td style="width: 10%;"><c:out value="${produto.quantidade}"></c:out></td>
								<td style="width: 15%;"><fmt:formatNumber type="currency" maxFractionDigits="2" value="${produto.valorcompra}"/></td>
								<td style="width: 15%;"><fmt:formatNumber type="currency" maxFractionDigits="2" value="${produto.valoritem}"/></td>
								<td style="width: 10%;"><c:out value="${produto.categoria}"></c:out></td>
								
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