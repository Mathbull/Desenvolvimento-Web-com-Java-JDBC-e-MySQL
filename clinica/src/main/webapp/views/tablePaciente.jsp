
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Paciente" %>

<% 	@SuppressWarnings("unchecked")
	ArrayList<Paciente> pacientes = (ArrayList<Paciente>) request.getAttribute("pacientes"); %>

<h1>Pacientes</h1>

<a href="novoPaciente" class="btn paciente">Novo paciente</a>

<table class="tbPaciente">
	<thead>
		<tr>
			<th>ID</th>
			<th>CPF</th>
			<th>Nome</th>
			<th>Telefone</th>
			<th>Email</th>
			<th>Opções</th>
		</tr>
	</thead>
	
	<tbody>
		<% for(Paciente paciente: pacientes){ %>
			<tr>
				<td> <%= paciente.getId() %> </td>
				<td> <%= paciente.getCpf() %> </td> 
				<td> <%= paciente.getNome() %> </td> 
				<td> <%= paciente.getPhone() %> </td> 
				<td> <%= paciente.getEmail() %> </td> 
				<td> 
					<a href="selectPacient?id=<%=paciente.getId() %>" class="btn paciente">Editar</a> 
					<a href="javascript: confirmar(<%= paciente.getId() %>)" class="btn delet">Excluir</a>
				 </td> 
			</tr>
		<% } %>
			
	</tbody>
			
</table>
<script src="scripts/confirmador.js"></script>