
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>

<% 	@SuppressWarnings("unchecked")
	HashMap<String, String>  dict = (HashMap<String, String>) request.getAttribute("result"); %>

<h1>Editar o medico de ID <%= request.getAttribute("id") %></h1>


<a href="medico" class="btn paciente">Voltar</a>

<form class="form newPaciente" id="frmNewPaciente" name="frmnovoMedicoOrPaciente"  action="updateMedico">
		
		<input type="hidden" name="id" readonly value="<% out.print(request.getAttribute("id")); %>">
		
		<input type="text" name="nome" placeholder="Nome" value="<%= request.getAttribute("nome") %>">
	
	
		<input type="text" name="cpf_crm" placeholder="CPF" value="<%= request.getAttribute("cpf_crm") %>">
	
	
		<input type="text" name="phone" placeholder="Telefone" value="<%= request.getAttribute("phone") %>">
	
	
	
		<input type="text" name="email" placeholder="Email" value="<%= request.getAttribute("email") %>">
	
	
	
		<input type="button" value="Editar" class="btn medico"  onclick="validarCampo()">
		<span  id="errorCampo"> </span>
	

</form>

