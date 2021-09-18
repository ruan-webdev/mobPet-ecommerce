<%@ page contentType="text/html; charset=ISO-8859-1" language="java"
	pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Cadastro De Cliente</title>

<!-- Font Icon -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">
<link rel="stylesheet" href="vendor/jquery-ui/jquery-ui.min.css">


<!-- Main css -->
<link rel="stylesheet" href="css/cadastro.css">
</head>

<body>


	<div class="main">

		<section class="signup">

			<div class="container">
				<div class="signup-content">

					<c:if test="${not empty requestScope.messages}">
						<div class="alert alert-danger" role="alert"
							style="font-size: 16px;">
							Erros encontrados no preenchimento do formulário:
						
								<c:forEach var="message" items="${messages}">
									<p><c:out value="${message}" /></p>
								</c:forEach>
							
						</div>
					</c:if>

					<form method="POST" id="signup-form" action="cadastro"
						class="signup-form">
						<input type="hidden" name="operation" value="save">
						<div class="form-row">
							<div class="form-group">
								<label for="first_name">Nome Completo</label> <input type="text"
									class="form-input" placeholder="Digite seu nome" name="nome"
									id="nome" required>
							</div>
							<div class="form-group">
								<label for="last_name">CPF</label> <input type="text"
									class="form-input" placeholder="Digite seu cpf" name="cpf"
									id="cpf" 
									onKeyPress="" maxlength="14"
									required>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group form-icon">
								<label for="birth_date">Data de Nascimento</label> <input
									type="date" class="form-input" name="dataNascimento"
									id="dataNascimento" placeholder="YYYY/MM/DD" required>
							</div>
							<div class="form-radio">
								<label for="gender">Genero</label>
								<div class="form-flex">
									<input type="radio" name="genero" value="homem" id="homem"
										checked="checked" /> <label for="homem">Homem</label> <input
										type="radio" name="genero" value="mulher" id="mulher" /> <label
										for="mulher">Mulher</label> <input type="radio" name="genero"
										value="outros" id="outros" /> <label for="outros">Outros</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="phone_number">Telefone</label> <input type="text"
								class="form-input phone-ddd-mask" name="telefone" id="telefone"
								maxlength="16" required
								value="<c:out value="${cliente.telefone}"/>">

						</div>
						<div class="form-group">
							<label for="email">Email</label> <input type="email"
								class="form-input" name="email" id="email"
								placeholder="email@email.com" type="text"
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required>
						</div>
						<div class="form-row">
							<div class="form-group">
								<label for="password">Senha</label> <input type="password"
									class="form-input" name="senha" id="senha" required>

							</div>
							<div class="form-group">
								<label for="re_password">Repita sua senha</label> <input
									type="password" class="form-input" name="confirmarSenha"
									id="confirmarSenha" required>

							</div>
						</div>

						<div class="form-group">
							<input type="submit" name="enviar" id="enviar"
								class="form-submit"
								onclick="validarSenha('password','re_password');"
								value=" Cadastrar" />

						</div>


					</form>

				</div>
			</div>
		</section>

	</div>


	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/jquery-ui/jquery-ui.min.js"></script>
	<script src="vendor/jquery-validation/dist/jquery.validate.min.js"></script>
	<script src="vendor/jquery-validation/dist/additional-methods.min.js"></script>
	<script src="js/main.js"></script>
	<script>
		var alertList = document.querySelectorAll('.alert')
		alertList.forEach(function(alert) {
			new bootstrap.Alert(alert)
		})

		$(document).ready(function() {
			$(".").on("click", function() {
				//cria uma serialização com os dados do formulário
				var dados = $("#signup-form").serialize();

				$.ajax({
					url : "cadastro.html",
					data : dados,
					dataType : "HTML",
					method : "POST"
				}).done(function(retorno) {

				}).fail(function(retorno) {
					alert("Usuario cadastrado com sucesso!");

				});

			});
		});
	</script>

	//<script type="text/javascript">
		//$(document).ready(function() {
			//$("#cpf").mask("999.999.999-99");
		//});
	//</script>

	<script>
		function validarSenha(password, re_password) {
			var senha1 = document.getElementById(password).value;
			var senha2 = document.getElementById(re_password).value;

			if (senha1 != "" && senha2 != "" && senha1 === senha2) {
				console.log("senhas iguais");
				javascript: history.go(-1);
			}

			else if (senha1 == "" || senha2 == "") {
				alert('campo senha vazio');
			} else {
				alert('senhas diferentes');
			}
		}
	</script>

</body>

</html>