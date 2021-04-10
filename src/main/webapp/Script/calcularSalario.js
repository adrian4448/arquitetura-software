function calcularSalario() {
	let form = document.querySelector('.form-cadastro');
	let horasTrabalhadas = form.horasTrabalhadas.value;
	let dtTrabalhada = form.dataTrabalhada.value;
	if(horasTrabalhadas || dtTrabalhada) {
		form.idFuncionario.options[form.idFuncionario.selectedIndex].value = form.idFuncionario.options[form.idFuncionario.selectedIndex].getAttribute("data-id");
		form.submit();
	}else {
		alert('Informe Todos os campos');
	}
}