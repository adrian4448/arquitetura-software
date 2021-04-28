<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="server.entity.Investimento" %>
<%@ page import="java.time.temporal.ChronoUnit" %>
<% List<Investimento> investimentos = (List<Investimento>) request.getAttribute("investimentos"); %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Investimentos</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container-center">
		<div>
			<div class="buttons">
				<a class="btn-adicionar" href="cadastrarInvestimento.html"> Adicionar </a>
				<a class="btn-adicionar" href="inicioSIG.html"> Voltar </a>
				<input type="button" class="btn-adicionar" value="Filtros" onclick="showFilters()">
			</div>
			<dialog class="modal-filters">
				<form class="generic-form">
					<p> Data de Inicio </p>
					<input type="date">
					<p> Data de Fim </p>
					<input type="date">
					<div class="buttons">
						<input type="button" value="Filtrar">
						<input type="button" value="Cancelar" onclick="closeFilters()">
					</div>
				</form>
			</dialog>
			<table class="generic-table">
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Descricao</th>
						<th>Periodo (M)</th>
						<th>Valor Investido (R$)</th>
						<th>Renda Mensal (%)</th>
						<th>Alterar</th>
						<th>Excluir</th>
					</tr>
				</thead>
				<tbody>
					<% for(Investimento investimento : investimentos) { %>
					<tr> 
						<td><%= investimento.getId() %></td>
						<td><%= investimento.getTipoInvestimento() %></td>
						<td><%= ChronoUnit.MONTHS.between(investimento.getDtInicio(), investimento.getDtFim()) %></td>
						<td><%= investimento.getValorInvestido() %></td>
						<td><%= investimento.getRendaDiaria() %></td>
						<td><a class="btn-alterar" href="alterarInvestimento?codigo=<%= investimento.getId() %>"> Alterar </a></td>
						<td><a class="btn-excluir" href="excluirInvestimento?codigo=<%= investimento.getId() %>"> Excluir </a></td>
					</tr>
					<% } %>
				</tbody>
			</table>
		</div>
	</div>
	
	
	
	<script src="scripts/scriptFilter.js"></script>
</body>
</html>