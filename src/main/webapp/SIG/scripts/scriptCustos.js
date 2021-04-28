function cadastrarCusto() {
	const form = document.querySelector('.generic-form');

	if(isNull(form.descricao.value) || isNull(form.valorMensal.value) || isNull(form.ativo.value)) {
		alert('Preencha todos os campos !!');
	}else {
		form.submit();
	}
}

function alterarCusto() {
	const form = document.querySelector('.generic-form');

	if(isNull(form.descricao.value) || isNull(form.valorMensal.value) || isNull(form.ativo.value) || isNull(form.codigo.value)) {
		alert('Preencha todos os campos !!');
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

