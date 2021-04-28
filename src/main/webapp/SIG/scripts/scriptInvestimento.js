function cadastrarInvestimento() {
	const form = document.querySelector('.generic-form');
	
	if(isNull(form.tipoInvestimento.value) || isNull(form.valorInvestido.value) || isNull(form.rendaDiaria.value) ||
		isNull(form.dtInicio.value) || isNull(form.dtFim.value) || form.dtInicio.value == form.dtFim.value) {
			alert('Informe todos os campos');
	}else {
		form.submit();
	}
}

function alterarInvestimento() {
	const form = document.querySelector('.generic-form');
	
	if(isNull(form.codigo.value) || isNull(form.tipoInvestimento.value) || isNull(form.valorInvestido.value) || isNull(form.rendaDiaria.value) ||
		isNull(form.dtInicio.value) || isNull(form.dtFim.value) || form.dtInicio.value == form.dtFim.value) {
			alert('Informe todos os campos');
	}else {
		form.submit();
	}
} 

function isNull(value) {
	if(value === '' || value === 0 || value === null || value === undefined) {
		return true;
	}
	return false;
}
