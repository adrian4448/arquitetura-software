function gastosPeriodo() {
	let formulario = document.querySelector('.filtro-gastos');
	let dtInicio = formulario.dataInicial.value;
	let dtFim = formulario.dataFinal.value;
	if(dtInicio || dtFim) {
		formulario.submit();
	}else {
		alert('Informe o periodo da pesquisa');
	}
}