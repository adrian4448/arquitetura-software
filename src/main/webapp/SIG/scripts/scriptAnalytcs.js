graficoCustos();
graficoInvestimentos();

function graficoCustos() {
	let xhr = new XMLHttpRequest();
	const ctx = document.getElementsByClassName('graph-custos');
	xhr.open('GET', 'http://localhost:8080/arquitetura-software/SIG/graphCustos');
	 
	xhr.onreadystatechange = () => {
	    if(xhr.readyState == 4) {
	        if(xhr.status == 200) {
	            var response = JSON.parse(xhr.responseText);
	            const labels = [];
	            const data = [];
	            response.forEach(custo => {
	                labels.push(custo.descricaoCusto);
	                data.push(custo.valorMensal);
	            });
	            
	            const chartGraph = new Chart(ctx, {
	                type: 'bar',
	                data: {
	                    labels: labels,
	                    datasets: [{
	                        label: "Custos",
	                        data: data,
	                        borderWidth: 3,
	                        borderColor: 'black',
	                        backgroundColor: 'blue'
	                    }]
	                },
	                options: {
	                    title: {
	                        display: true,
	                        fontSize: 20,
	                        text: "Custos"
	                    }
	                }
	            });
	        }
	    }
	};
	
	xhr.send();
}

function graficoInvestimentos() {
	let xhr = new XMLHttpRequest();
	const ctx = document.getElementsByClassName('graph-investimento');
	xhr.open('GET', 'http://localhost:8080/arquitetura-software/SIG/graphInvestimentos');
	 
	xhr.onreadystatechange = () => {
	    if(xhr.readyState == 4) {
	        if(xhr.status == 200) {
	            var response = JSON.parse(xhr.responseText);
	            const labels = [];
	            const data = [];
	            response.forEach(investimento => {
	                labels.push(investimento.tipoInvestimento);
	                data.push(investimento.valorInvestido * (investimento.rendaDiaria / 100));
	            });
	            
	            const chartGraph = new Chart(ctx, {
	                type: 'doughnut',
	                data: {
	                    labels: labels,
	                    datasets: [{
	                        label: "Investimentos",
	                        data: data,
	                        borderWidth: 3,
	                        borderColor: 'black',
	                        backgroundColor: 'blue'
	                    }]
	                },
	                options: {
	                    title: {
	                        display: true,
	                        fontSize: 20,
	                        text: "Investimentos"
	                    }
	                }
	            });
	        }
	    }
	};
	
	xhr.send();
}