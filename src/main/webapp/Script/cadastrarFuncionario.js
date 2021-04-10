function validarCadastro() {
	var nome = document.querySelector('.form-cadastro').nome.value;
	var valorHoras = document.querySelector('.form-cadastro').valorHoras.value;
	if(!nome || !valorHoras) {
		alert('Digite todos os campos');
	}else {
		document.querySelector('.form-cadastro').submit();
	}
}