
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>

<% 	@SuppressWarnings("unchecked")
	HashMap<String, String>  dict = (HashMap<String, String>) request.getAttribute("result"); %>

<h1>Adicionar um novo paiente</h1>

<a href="paciente" class="btn paciente">Voltar</a>

<form class="form newPaciente" id="frmNewPaciente" name="frmnovoMedicoOrPaciente"  action="insertPaciente">
	
		<input type="text" name="nome" placeholder="Nome">
	
	
		<input type="text" name="cpf_crm" placeholder="CPF">
	
	
		<input type="text" name="phone" placeholder="Telefone">
	
	
	
		<input type="text" name="email" placeholder="Email">
	
	
	
		<input type="button" value="Adicionar" class="btn paciente"  onclick="validarCampo()">
		
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
