
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>

<% 	@SuppressWarnings("unchecked")
	HashMap<String, String>  dict = (HashMap<String, String>) request.getAttribute("result"); %>

<h1>Adicionar um novo medico</h1>

<a href="medico" class="btn medico">Voltar</a>

<form class="form newPaciente" id="frmNewPaciente" name="frmnovoMedicoOrPaciente"  action="insertMedico">
	
		<input type="text" name="nome" placeholder="Nome">
	
	
		<input type="text" name="cpf_crm" placeholder="CRM">
	
	
		<input type="text" name="phone" placeholder="Telefone">
	
	
	
		<input type="text" name="email" placeholder="Email">
	
	
	
		<input type="button" value="Adicionar" class="btn medico"  onclick="validarCampo()">
		
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
