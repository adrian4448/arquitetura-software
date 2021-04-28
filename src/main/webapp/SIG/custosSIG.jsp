<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="server.entity.Custo" %>
<%@ page import="java.util.ArrayList" %>
<% List<Custo> custos = (ArrayList<Custo>) request.getAttribute("custos");%>
	
	<!DOCTYPE html>
	<html lang="pt-br">
	<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="style.css">
	<title>Gerenciar Custos</title>
	</head>
	<body>
		
		<div class="container-center">
			<div>
				<table class="generic-table">
					<div class="buttons">
						<a class="btn-adicionar" href="cadastrarCusto.html"> Adicionar Custo </a>
						<a class="btn-adicionar" href="inicioSIG.html"> Voltar </a>
					</div>
					<thead>
						<tr>
							<th> Codigo </th>
							<th> Descricao Custo </th>
							<th> Valor Mensal </th>
							<th> Ativo </th>
							<th> Alterar </th>
							<th> Excluir </th>
						</tr>
					</thead>
					<tbody>
						<% for(Custo custo : custos) { %>
						<tr>
							<td><%= custo.getId() %></td>
							<td><%= custo.getDescricaoCusto() %></td>
							<td><%= custo.getValorMensal() %></td>
							<td><%= custo.getAtivo() %></td>
							<td><a class="btn-alterar" href="alterarCusto?codigo=<%= custo.getId() %>">Alterar</a></td>
							<td><a class="btn-excluir" href="excluirCusto?codigo=<%= custo.getId() %>">Excluir</a></td>
						</tr>
						<% } %>
					</tbody>
				</table>
			</div>
		</div>
			
	</body>
	</html>