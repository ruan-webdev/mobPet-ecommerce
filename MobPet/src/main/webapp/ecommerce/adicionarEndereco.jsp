<%@ page contentType="text/html; charset=ISO-8859-1" language="java"
	pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<!-- Meta Tag -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name='copyright' content=''>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Title Tag  -->
<title>MobPet - Endereço</title>
<!-- Favicon -->
<link rel="icon" type="image/png" href="images/favicon.png">
<!-- Web Font -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

<!-- StyleSheet -->

<!-- Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- Magnific Popup -->
<link rel="stylesheet" href="css/magnific-popup.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="css/font-awesome.css">
<!-- Fancybox -->
<link rel="stylesheet" href="css/jquery.fancybox.min.css">
<!-- Themify Icons -->
<link rel="stylesheet" href="css/themify-icons.css">
<!-- Nice Select CSS -->
<link rel="stylesheet" href="css/niceselect.css">
<!-- Animate CSS -->
<link rel="stylesheet" href="css/animate.css">
<!-- Flex Slider CSS -->
<link rel="stylesheet" href="css/flex-slider.min.css">
<!-- Owl Carousel -->
<link rel="stylesheet" href="css/owl-carousel.css">
<!-- Slicknav -->
<link rel="stylesheet" href="css/slicknav.min.css">

<!-- Eshop StyleSheet -->
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="style.css.map">
<link rel="stylesheet" href="css/responsive.css">



</head>

<body class="js">

	<!-- Header -->
	<header class="header shop">
		<!-- Topbar -->

		<!-- End Topbar -->
		<div class="middle-inner">
			<div class="container">
				<div class="row">
					<div class="col-lg-2 col-md-2 col-12">
						<!-- Logo -->
						<div class="logo">
							<a href="signed.jsp"><img src="images/logo.png" alt="logo"></a>
						</div>
						<!--/ End Logo -->
						<!-- Search Form -->
						<div class="search-top">
							<div class="top-search">
								<a href="#0"><i class="ti-search"></i></a>
							</div>
							<!-- Search Form -->
							<div class="search-top">
								<form class="search-form">
									<input type="text" placeholder="Procure aqui..." name="search">
									<button value="search" type="submit">
										<i class="ti-search"></i>
									</button>
								</form>
							</div>
							<!--/ End Search Form -->
						</div>
						<!--/ End Search Form -->
						<div class="mobile-nav"></div>
					</div>
					<div class="col-lg-8 col-md-7 col-12">
						<div class="search-bar-top">
							<div class="search-bar">
								<select>
									<option selected="selected">Todas as categorias</option>
									<option>Rações</option>
									<option>Acessórios</option>
									<option>Higiene</option>
									<option>Roupas</option>
									<option>Medicamentos</option>
								</select>
								<form>
									<input name="search" placeholder="O que deseja procurar?....."
										type="search">
									<button class="btnn">
										<i class="ti-search"></i>
									</button>
								</form>
							</div>
						</div>
					</div>
					<div class="col-lg-2 col-md-3 col-12">
						<div class="right-bar">
							<!-- Search Form -->
							<div class="sinlge-bar">
								<a href="#" class="single-icon"><i class="fa fa-heart-o"
									aria-hidden="true"></i></a>
							</div>
							<div class="sinlge-bar">
								<a href="#" class="single-icon"><i
									class="fa fa-user-circle-o" aria-hidden="true"></i></a>
							</div>
							<div class="sinlge-bar shopping">
								<a href="#" class="single-icon"><i class="ti-bag"></i> <span
									class="total-count">2</span></a>
								<!-- Shopping Item -->
								<div class="shopping-item">
									<div class="dropdown-cart-header">
										<span>3 Items</span> <a href="#">Ver carrinho</a>
									</div>
									<ul class="shopping-list">
										<li><a href="#" class="remove" title="Remove this item"><i
												class="fa fa-remove"></i></a> <a class="cart-img" href="#"><img
												src="https://via.placeholder.com/70x70" alt="#"></a>
											<h4>
												<a href="#">Ração Dogs</a>
											</h4>
											<p class="quantity">
												1x - <span class="amount">R$99.00</span>
											</p></li>
										<li><a href="#" class="remove" title="Remove this item"><i
												class="fa fa-remove"></i></a> <a class="cart-img" href="#"><img
												src="https://via.placeholder.com/70x70" alt="#"></a>
											<h4>
												<a href="#">Ração Cats</a>
											</h4>
											<p class="quantity">
												1x - <span class="amount">R$35.00</span>
											</p></li>
									</ul>
									<div class="bottom">
										<div class="total">
											<span>Total</span> <span class="total-amount">R$134.00</span>
										</div>
										<a href="checkout.jsp" class="btn animate">Checkout</a>
									</div>
								</div>
								<!--/ End Shopping Item -->
							</div>
							

						</div>

					</div>
				</div>
			</div>
		</div>
		<!-- Header Inner -->
		<div class="header-inner">
			<div class="container">
				<div class="cat-nav-head">
					<div class="row">

						<div class="col-lg-9 col-12">
							<div class="menu-area">
								<!-- Main Menu -->
								<nav class="navbar navbar-expand-lg">
									<div class="navbar-collapse">
										<div class="nav-inner">
											<ul class="nav main-menu menu navbar-nav">
												<li class="active"><a href="#">Home</a></li>
												<li><a href="dogsProduct.jsp">Cachorros</a></li>
												<li><a href="catsProduct.jsp">Gatos</a></li>
												<li><a href="birdsProduct.jsp">Passáros</a></li>
												<li><a href="animalsProduct.jsp">Outros Animais</a></li>
												<li><a href="contact.jsp">Contato</a></li>
											</ul>
										</div>
									</div>
								</nav>
								<!--/ End Main Menu -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/ End Header Inner -->
	</header>



	<div class="sidebar">
		<header>Sua Conta</header>
		<a href="perfilCliente.jsp"> <i class="fas fa-user"></i> <span>Alterar
				Dados</span>
		</a> <a href="alterarSenha.jsp"> <i class="fas fa-lock"></i> <span>Alterar
				Senha</span>
		</a> <a href="adicionarEndereco.jsp" class="active"> <i
			class="fas fa-map-marker-alt"></i> <span>Endereços</span>
		</a> <a href="adicionarCartao.jsp"> <i class="fas fa-credit-card"></i>
			<span>Cartões</span>
		</a>

		<header>Pedidos</header>
		<a href="meusPedidos.jsp"> <i class="fas fa-box-open"></i> <span>Status</span>
		</a> <a href="minhasTrocas.jsp"> <i class="fas fa-people-carry"></i> <span>Trocas</span>
		</a>
	</div>
	
	<c:if test="${not empty requestScope.messages}">
			<div class="alert alert-danger" role="alert" style="font-size: 16px;">
				Erros encontrados no preenchimento do formulário:
				<ul>
					<c:forEach var="message" items="${messages}">
						<li><c:out value="${message}"/></li>
					</c:forEach>
				</ul>
			</div>
		</c:if>


	<form id="dadosCliente" action="adicionarEndereco" method="POST">
	
			<input type="hidden" name="userId" value="${loggedUser.id}">
			<input type="hidden" name="operation" value="save">
			
		<div class="form-row">

			<div class="form-group col-md-3">
				<label for="inputCep4">CEP</label> 
				<input name="cep"
					class="form-control" type="text" id="cep" value="" size="10"
					maxlength="9" OnKeyPress="formatar('#####-###', this)" /></label><br />
			</div>
			<div class="form-group col-md-4">
				<label for="inputLog4">Logradouro</label> <input type="text"
					class="form-control" name="logradouro" id="logradouro" required="">
			</div>
			<div class="form-group col-md-2">
				<label for="inputEmail4">Numero</label> <input type="number"
					class="form-control" name="num" id="num" required="">
			</div>


		</div>

		<div class="form-row">
			<div class="form-group col-md-3">
				<label for="inputBairro4">Bairro</label> <input type="text"
					class="form-control" name="bairro" id="bairro" required="">
			</div>
			<div class="form-group col-md-3">
				<label for="inputEmail4">Cidade</label> <input type="text"
					class="form-control" name="cidade" id="cidade" required="">
			</div>
			<div class="form-group col-md-3">
				<label for="inputEmail4">Estado</label> <input type="text"
					class="form-control" name="estado" id="estado" required="">
			</div>
		</div>
		<br>
		<div class="form-row">
			<div class="form-group col-md-3">
				<label for="inputTelefone">Complemento</label> <input type="text"
					class="form-control" name="complemento" id="complemento">
			</div>

			<div class="form-group col-md-3">
				<label for="inputNome4">Nome Personalizado</label> <input
					type="text" class="form-control" id="nomePerso" name="nomePerso">
			</div>
			<div class="form-group col-md-2">
				<label for="inputCep4">Tipo de Endereço</label> <select name="tipo"
					id="tipo">
					<option value="entrega">Entrega</option>
					<option value="cobranca">Cobrança</option>
					<option value="entrega">Entrega + Cobrança</option>
				</select>
			</div>
		</div>
		
			<div class="form-group">
			<input type="submit" class="salvarButton" style="color:white; background-color:green " id="cadastrarEndereco" name="enviar" id="enviar" class="form-submit"
				value=" Cadastrar" />
			</div>
	
	<table class="table table-bordered" style="width: 800px">
			<thead>
				<tr>
					<th scope="col">Cadastros</th>
					<th scope="col">Cep</th>
					<th scope="col">Logradouro</th>
					<th scope="col">Bairro</th>
					<th scope="col">Cidade</th>
					<th scope="col">Estado</th>
					<th scope="col">TipoEndereco</th>
					<th scope="col">Complemento</th>
					<th scope="col">Nome Personalizado</th>
					<th scope="col">Editar</th>
					<th scope="col">Excluir</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="endereco" items="${enderecos}">
					<tr>
						<td>< value="${endereco.id}" /></td>
						<td>< value="${endereco.cep}" /></td>
						<td>< value="${endereco.logradouro}" /></td>
						<td>< value="${endereco.bairro}" /></td>
						<td>< value="${endereco.cidade}" /></td>
						<td>< value="${endereco.estado}" /></td>
						<td>< value="${endereco.tipoEndereco}" /></td>
						<td>< value="${endereco.complemento}" /></td>
						<td>< value="${endereco.nomePerso}" /></td>
						<td><i class="fas fa-pencil-alt"></i></td>
						<td><i class="fas fa-trash"></i></td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
		
		</form>

		<br>

		


	<footer class="footer">
		<!-- Footer Top -->
		<div class="footer-top section">
			<div class="container">
				<div class="row">
					<div class="col-lg-5 col-md-6 col-12">
						<!-- Single Widget -->
						<div class="single-footer about">
							<div class="logo">
								<a href="index.jsp"><img src="images/logo2.png"
									style="width: 150px" alt="#"></a>
							</div>

						</div>
						<!-- End Single Widget -->
					</div>

					<!-- End Single Widget -->

				</div>
				<!-- End Single Widget -->
			</div>
		</div>
		</div>
		</div>
		<!-- End Footer Top -->
		<div class="copyright">
			<div class="container">
				<div class="inner">
					<div class="row">
						<div class="col-lg-6 col-12">
							<div class="left">
								<p>
									Copyright © 2020 MobPet -
									Todos os direitos reservados.
								</p>
							</div>
						</div>
						<div class="col-lg-6 col-12">
							<div class="right">
								<img src="images/payments.png" alt="#">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>


	<!-- Jquery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery-migrate-3.0.0.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<!-- Popper JS -->
	<script src="js/popper.min.js"></script>
	<!-- Bootstrap JS -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Color JS -->
	<script src="js/colors.js"></script>
	<!-- Slicknav JS -->
	<script src="js/slicknav.min.js"></script>
	<!-- Owl Carousel JS -->
	<script src="js/owl-carousel.js"></script>
	<!-- Magnific Popup JS -->
	<script src="js/magnific-popup.js"></script>
	<!-- Waypoints JS -->
	<script src="js/waypoints.min.js"></script>
	<!-- Countdown JS -->
	<script src="js/finalcountdown.min.js"></script>
	<!-- Nice Select JS -->
	<script src="js/nicesellect.js"></script>
	<!-- Flex Slider JS -->
	<script src="js/flex-slider.js"></script>
	<!-- ScrollUp JS -->
	<script src="js/scrollup.js"></script>
	<!-- Onepage Nav JS -->
	<script src="js/onepage-nav.min.js"></script>
	<!-- Easing JS -->
	<script src="js/easing.js"></script>
	<!-- Active JS -->
	<script src="js/active.js"></script>

	<script src="js/main.js"></script>

	<script>
		$(document)
				.ready(
						function() {

							function limpa_formulario_cep() {
								// Limpa valores do formulario de cep.
								$("#rua").val("");
								$("#bairro").val("");
								$("#cidade").val("");
								$("#estado").val("");
								$("#ibge").val("");
							}

							//Quando o campo cep perde o foco.
							$("#cep")
									.blur(
											function() {

												var cep = $(this).val()
														.replace(/\D/g, '');

												//Verifica se campo cep possui valor informado.
												if (cep != "") {

													//Expresso regular para validar o CEP.
													var validacep = /^[0-9]{8}$/;

													//Valida o formato do CEP.
													if (validacep.test(cep)) {

														//Preenche os campos com "..." enquanto consulta webservice.
														$("#logradouro").val("...");
														$("#bairro").val("...");
														$("#cidade").val("...");
														$("#estado").val("...");
														$("#ibge").val("...");

														//Consulta o webservice viacep.com.br/
														$
																.getJSON(
																		"https://viacep.com.br/ws/"
																				+ cep
																				+ "/json/?callback=?",
																		function(
																				dados) {

																			if (!("erro" in dados)) {
																				//Atualiza os campos com os valores da consulta.
																				$(
																						"#logradouro")
																						.val(
																								dados.logradouro);
																				$(
																						"#bairro")
																						.val(
																								dados.bairro);
																				$(
																						"#cidade")
																						.val(
																								dados.localidade);
																				$(
																						"#estado")
																						.val(
																								dados.uf);
																				$(
																						"#ibge")
																						.val(
																								dados.ibge);
																			} //end if.
																			else {
																				//CEP pesquisado nÃ£o foi encontrado.
																				limpa_formulario_cep();
																				alert("CEP não encontrado.");
																			}
																		});
													} //end if.
													else {

														limpa_formulario_cep();
														alert("Formato de CEP invalido.");
													}
												} //end if.
												else {
													//cep sem valor, limpa formulario.
													limpa_formulario_cep();
												}
											});
						});
	</script>
</body>
</html>