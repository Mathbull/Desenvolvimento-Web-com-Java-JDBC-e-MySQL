/**
 	Validar Campos
 */

function validarCampo(){
	document.getElementById("errorCampo").textContent = "";  
	let nome = frmnovoMedicoOrPaciente.nome.value;
	let cpf_crm = frmnovoMedicoOrPaciente.cpf_crm.value;
	let phone = frmnovoMedicoOrPaciente.phone.value;
	let errorCampo = document.getElementById("errorCampo")
	
	
	if(nome === ""){
		errorCampo.classList.add("error")
		errorCampo.textContent = "Nome é obrigatório";
		frmnovoMedicoOrPaciente.nome.focus();
		return false;
		
	}else if(cpf_crm === ""){
		errorCampo.classList.add("error")
		errorCampo.textContent = "CPF é obrigatório";
		frmnovoMedicoOrPaciente.cpf_crm.focus();
		return false;
		
	}else if(phone === ""){
		errorCampo.classList.add("error")
		errorCampo.textContent = "Telefone é obrigatório";
		frmnovoMedicoOrPaciente.phone.focus();
		return false;	
			
	}else{
		errorCampo.classList.remove("error")
		document.forms["frmnovoMedicoOrPaciente"].submit()
	}
	
}

function validarCampoConsulta(){
	document.getElementById("errorCampo").textContent = "";
	let selectPct = fmrNovaConsulta.selectPaciente.value
	let selectMdc = fmrNovaConsulta.selectMedico.value
	let date = fmrNovaConsulta.date.value;
	
	if(selectPct === ""){
		errorCampo.classList.add("error")
		errorCampo.textContent = "Selecione um paciente";
		fmrNovaConsulta.selectPaciente.focus();
		return false;
	}else if(selectMdc === ""){
		errorCampo.classList.add("error")
		errorCampo.textContent = "Selecione um medico";
		fmrNovaConsulta.selectMedico.focus();
		return false;
	}else if(date === ""){
		errorCampo.classList.add("error")
		errorCampo.textContent = "Selecione a data da consulta";
		fmrNovaConsulta.date.focus();
		return false;
	}else{
		errorCampo.classList.remove("error")
		document.forms["fmrNovaConsulta"].submit()
	}
}