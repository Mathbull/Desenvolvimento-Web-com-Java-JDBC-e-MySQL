/*

Confirmar a excluções de um Paciente, medico ou consulta

*/


function confirmar(id){
	let resposta = confirm("Confirma a exclusão desse paciente")
	
	if(resposta === true){
		window.location.href = "dltPacient?id=" +id
	}else{
		
	}

	
}

function confirmarDeletMedic(id){
	let resposta = confirm("Confirma a exclusão desse medico")
	
	if(resposta === true){
		window.location.href = "dltMedico?id=" +id
	}else{
		
	}
}

function confirmarDeletConsulta(id){
	let resposta = confirm("Confirma a exclusão dessa consulta")
	
	if(resposta === true){
		window.location.href = "dltConsulta?id=" +id
	}else{
		
	}
	
}