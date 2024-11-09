
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="model.Paciente" %>
<%@ page import="model.Medico" %>


<% 	@ SuppressWarnings("unchecked")
	ArrayList<Medico> medicos = (ArrayList<Medico>) request.getAttribute("medicos"); %>

<% 	@ SuppressWarnings("unchecked")
	ArrayList<Paciente> pacientes = (ArrayList<Paciente>) request.getAttribute("pacientes"); %>

<% 	@ SuppressWarnings("unchecked")
	HashMap<String, String>  dict = (HashMap<String, String>) request.getAttribute("result"); %>

<h1>Editar a consulta de ID <%= request.getAttribute("id") %></h1>

<a href="consulta" class="btn consulta">Voltar</a>

<form class="form newPaciente" id="frmNewPaciente" name="fmrNovaConsulta"  action="updateConsulta">

		<input type="hidden" name="id" value="<%= request.getAttribute("id") %>" >

		<select id="select sPaceinte" name="selectPaciente" >
			
			<option value="<%=request.getAttribute("idPaciente") %>" > <%= request.getAttribute("Paciente") %></option>
			<% for(Paciente paciente: pacientes){ %>
					
					<option value ="<%= paciente.getId() %>" > <%= paciente.getNome() %> </option>
			<% } %>
		
		</select>
	
		<select id="select sMedico" name="selectMedico">
			
			<option value="<%= request.getAttribute("idMedico") %>" ><%=request.getAttribute("medico") %></option>
			<% for(Medico medico: medicos){ %>
					<option value ="<%= medico.getId() %>"> <%= medico.getNome() %> </option>
			<% } %>
		</select>
	
	
	
		<input class="date" type="date" name="date" value="<%= request.getAttribute("date") %>">
	
	
	
		<input type="button" value="Adicionar" class="btn consulta"  onclick="validarCampoConsulta()">
		
			<% if(dict != null){ %>
				<% if (dict.containsKey("sucesso")) {%>
					<span style="color:blue;" id="errorCampo"> <%= dict.get("sucesso") %> </span>
				<%}else{ %>
					<span style="color:red;" id="errorCampo"><%= dict.get("falha") %> </span>
					
				<%} %>
			<%}else{%>
				<span  id="errorCampo"> </span>
			<%} %>

</form>
