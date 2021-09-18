
function formatar(mascara, documento) {
	var i = documento.value.length;
	var saida = mascara.substring(0, 1);
	var texto = mascara.substring(i);

	if (texto.substring(0, 1) != saida) {
		documento.value += texto.substring(0, 1);
	}

}

var alertList = document.querySelectorAll('.alert')
alertList.forEach(function (alert) {
	new bootstrap.Alert(alert)
})


$(document).ready(function () {
	$(".").on("click", function () {
		//cria uma serialização com os dados do formulário
		var dados = $("#signup-form").serialize();

		$.ajax({
			url: "cadastro.html",
			data: dados,
			dataType: "HTML",
			method: "POST"
		}).done(function (retorno) {


		}).fail(function (retorno) {
			alert("Usuario cadastrado com sucesso!");

		});

	});
});

$('#exampleModal').on('show.bs.modal', function (event) {
	var button = $(event.relatedTarget) // Botão que acionou o modal
	var recipient = button.data('whatever') // Extrai informação dos atributos data-*
	// Se necessário, você pode iniciar uma requisição AJAX aqui e, então, fazer a atualização em um callback.
	// Atualiza o conteúdo do modal. Nós vamos usar jQuery, aqui. No entanto, você poderia usar uma biblioteca de data binding ou outros métodos.
	var modal = $(this)
	modal.find('.modal-body input').val(recipient)
})



function myFunction() {

	var x;
	var r = confirm("Deseja Excluir esse cadastro?");
	if (r == true) {
		x = alert("Endereço deletado com sucesso!")
	}
	else {
	}
	document.getElementById("demo").innerHTML = x;
}

function cadastrarEndereco() {
	alert("Endereço cadastrado com sucesso!");
	location.reload();
}


function atualizarCadastro() {
	alert("Usuario atualizado com sucesso!");
	location.reload();
}

function liberarEdicaoCliente() {

}

function cadastrarCartao() {
	alert("Cartão cadastrado com sucesso!");
	location.reload();
}


$(document).ready(function () {
	$("#editClient").click(function () {
		// habilita o campo 
		$("input").prop("disabled", false);

	});

	$("#disable").click(function () {
		// desabilita o campo 
		$("input").prop("disabled", true);
	});
});

function deletarCartao() {

	var x;
	var r = confirm("Deseja Excluir esse cadastro?");
	if (r == true) {
		x = alert("Cartão deletado com sucesso!")
	}
	else {
	}
	document.getElementById("demo").innerHTML = x;
}

function validarSenha(password, re_password) {
	var senha1 = document.getElementById(password).value;
	var senha2 = document.getElementById(re_password).value;

	if (senha1 != "" && senha2 != "" && senha1 === senha2) {
		console.log("senhas iguais");
		javascript: history.go(-1);
	}

	else if (senha1 == "" || senha2 == "") {
		alert('campo senha vazio');
	}
	else {
		alert('senhas diferentes');
	}
}

var inputsCEP = $('#logradouro, #bairro, #localidade');
var inputsRUA = $('#cep, #bairro');
var validacep = /^[0-9]{8}$/;

function limpa_formulário_cep(alerta) {
	if (alerta !== undefined) {
		alert(alerta);
	}

	inputsCEP.val('');
}

function get(url) {

	$.get(url, function (data) {

		if (!("erro" in data)) {

			if (Object.prototype.toString.call(data) === '[object Array]') {
				var data = data[0];
			}

			$.each(data, function (nome, info) {
				$('#' + nome).val(nome === 'cep' ? info.replace(/\D/g, '') : info).attr('info', nome === 'cep' ? info.replace(/\D/g, '') : info);
			});



		} else {
			limpa_formulário_cep("CEP não encontrado.");
		}

	});
}

$(document).ready(function () {

	function limpa_formulario_cep() {
		// Limpa valores do formulário de cep.
		$("#rua").val("");
		$("#bairro").val("");
		$("#cidade").val("");

	}

	//Quando o campo cep perde o foco.
	$("#cep").blur(function () {

		//Nova variável "cep" somente com dígitos.
		var cep = $(this).val().replace(/\D/g, '');

		//Verifica se campo cep possui valor informado.
		if (cep != "") {

			//Expressão regular para validar o CEP.
			var validacep = /^[0-9]{8}$/;

			//Valida o formato do CEP.
			if (validacep.test(cep)) {

				//Preenche os campos com "..." enquanto consulta webservice.
				$("#rua").val("...");
				$("#bairro").val("...");
				$("#cidade").val("...");

				//Consulta o webservice viacep.com.br/
				$.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?", function (dados) {

					if (!("erro" in dados)) {
						//Atualiza os campos com os valores da consulta.
						$("#rua").val(dados.logradouro);
						$("#bairro").val(dados.bairro);
						$("#cidade").val(dados.localidade);

					} //end if.
					else {
						//CEP pesquisado não foi encontrado.
						limpa_formulário_cep();
						alert("CEP não encontrado.");
					}
				});
			} //end if.
			else {
				//cep é inválido.
				limpa_formulario_cep();
				alert("Formato de CEP inválido.");
			}
		} //end if.
		else {
			//cep sem valor, limpa formulário.
			limpa_formulario_cep();
		}
	});
});

