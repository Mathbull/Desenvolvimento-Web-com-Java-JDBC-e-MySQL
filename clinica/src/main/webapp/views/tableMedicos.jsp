
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Medico" %>

<% 	@SuppressWarnings("unchecked")
	ArrayList<Medico> medicos = (ArrayList<Medico>) request.getAttribute("medicos"); %>

<h1>Medicos</h1>

<a href="novoMedico" class="btn medico">Novo medico</a>

<table class="tbPaciente">
			<thead>
				<tr>
					<th>ID</th>
					<th>CRM</th>
					<th>Nome</th>
					<th>Telefone</th>
					<th>Email</th>
					<th>Opções</th>
				</tr>
			</thead>
			
			<tbody>
				<% for(Medico medico: medicos){ %>
					<tr>
						<td> <%= medico.getId() %> </td>
						<td> <%= medico.getCrm() %> </td> 
						<td> <%= medico.getNome() %> </td> 
						<td> <%= medico.getPhone() %> </td> 
						<td> <%= medico.getEmail() %> </td> 
						<td> 
							<a href="selectMedico?id=<%=medico.getId() %>" class="btn medico">Editar</a> 
							<a href="javascript: confirmarDeletMedic(<%= medico.getId() %>)" class="btn delet">Excluir</a>
						 </td> 
					</tr>
				<% } %>
					
			</tbody>
			
</table>
<script src="scripts/confirmador.js"></script>