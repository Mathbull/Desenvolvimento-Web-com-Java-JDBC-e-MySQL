
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Consulta" %>

<% 	@ SuppressWarnings("unchecked")
	ArrayList<Consulta> consultas = (ArrayList<Consulta>) request.getAttribute("consultas"); %>

<h1>Consultas</h1>

<a href="novaConsulta" class="btn consulta">Nova consulta</a>

<table class="tbPaciente">
	<thead>
		<tr>
			<th>ID</th>
			<th>Paciente</th>
			<th>Medico</th>
			<th>Agendamento</th>
			<th>Opções</th>
		</tr>
	</thead>
	
	<tbody>
		<% for(Consulta consulta: consultas){ %>
			<tr>
				<td> <%= consulta.getId() %> </td>
				<td> <%= consulta.getPaciente() %> </td> 
				<td> <%= consulta.getMedico() %> </td> 
				<td> <%= consulta.getDataConsulta() %> </td> 
				<td> 
					<a href="selectConsulta?id=<%=consulta.getId() %>" class="btn consulta">Editar</a> 
					<a href="javascript: confirmarDeletConsulta(<%= consulta.getId() %>)" class="btn delet">Excluir</a>
				 </td> 
			</tr>
		<% } %>
			
	</tbody>
			
</table>
<script src="scripts/confirmador.js"></script>