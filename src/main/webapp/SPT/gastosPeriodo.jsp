<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="server.entity.Funcionario"%>
<%@ page import="java.text.DecimalFormat" %>

<% ArrayList<Funcionario> funcionarios = (ArrayList<Funcionario>) request.getAttribute("funcionarios"); 
   DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
   Double totalPagar = 0.0;
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style.css">
<title>Visualizar Gastos</title>
</head>
<body>
	<div class="container">
		<div class="gastos">
			<form class="filtro-gastos" action="GastosPeriodo">
				<input class="input-text" type="date" name="dataInicial" placeholder=" Data Inicial">
				<input class="input-text" type="date" name="dataFinal" placeholder=" Data Final">
				<input class="input-button" type="button" value="Buscar" onclick="gastosPeriodo()">
			</form>
			<table class="tabela-gastos">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Valor Horas</th>
					<th>Horas Trabalhadas</th>
					<th>Data Trabalhada </th>
					<th>Total a pagar</th>
					<th>Status</th>
				</tt>				
			</thead>
			<tbody>
					<% 
					if(funcionarios != null) {
						for(Funcionario f : funcionarios) { 
					%>
					<tr>
						<td><%= f.getCodigo() %>></td>
						<td><%= f.getNome() %></td>
						<td><%= decimalFormat.format(f.getValorHoras()) %></td>
						<td><%= f.getHorasTrabalhadas() %></td>
						<td><%= f.getDtTrabalhado() %></td>
						<td><%= decimalFormat.format(f.getHorasTrabalhadas() * f.getValorHoras()) %>
						<td><%= f.getAtivo()%></td>
					</tr>
					<% 
						totalPagar += (f.getHorasTrabalhadas() * f.getValorHoras());
						} 
					}	
					%>
					<tr class="total-pagar">
						<td colspan="7"><b>Total: <%= decimalFormat.format(totalPagar) %></b></td>
					</tr>
			</tbody>
			</table>
		</div>
	</div>
	<script src="Script/gastosPeriodo.js"></script>
</body>
</html>