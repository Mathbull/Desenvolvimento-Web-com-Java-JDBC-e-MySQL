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
			<li class="medico">
				<a href="medico" >Medico</a>
			</li>
			<li>
				<a href="consulta">Consulta</a>
			</li>
		</ul>
		
	</nav>
	
		<img src="imagens/medic.png" width="150" height="150">	
		
		<% if(request.getAttribute("view") == ("views/novoMedico.jsp")){ %>
			<%@  include file="views/novoMedico.jsp" %>
			
		<%}else if(request.getAttribute("view") == ("views/editMedico.jsp")){ %>
			<%@ include file="views/editMedico.jsp" %>
			
		<% }else{%>
			<%@ include file="views/tableMedicos.jsp" %>
		<% } %> 
		
		<script src="scripts/validarCampo.js" ></script>
		
	</body>
</html>