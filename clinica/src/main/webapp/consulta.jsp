<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<title>Clinica</title>
		<link rel="icon" href="imagens/icon.png">
		<link rel="stylesheet" href="style.css">
		
	</head>
	
	<body>
	
	<nav>
		<ul>
			<li>
				<a href="index.html" >Home</a>
			</li>
			<li>
				<a href="paciente">Paciente</a>
			</li>
			<li >
				<a href="medico" >Medico</a>
			</li>
			<li class="consulta">
				<a href="consulta">Consulta</a>
			</li>
		</ul>
		
	</nav>
	
		<img src="imagens/index.png" width="150" height="150">	
		
		<% if(request.getAttribute("view") == ("views/novaConsulta.jsp")){ %>
			<%@ include file="views/novaConsulta.jsp" %>
			
		<%}else if(request.getAttribute("view") == ("views/editConsulta.jsp")){ %>
			<%@ include file="views/editConsulta.jsp" %>
			
		<% }else{%>
			<%@ include file="views/tableConsultas.jsp" %>
		<% } %> 
		
		<script src="scripts/validarCampo.js" ></script>
		
	</body>
</html>