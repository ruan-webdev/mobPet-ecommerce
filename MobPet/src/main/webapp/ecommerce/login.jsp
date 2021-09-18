<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-BR">

<head>
<title>Login Cliente</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/login.css">

</head>

<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Login MobPet</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-12 col-lg-10">
					<div class="wrap d-md-flex">
						<div
							class="text-wrap p-4 p-lg-5 text-center d-flex align-items-center order-md-last">
							<div class="text w-100">
								<h2>Login</h2>
								<p>Não tem uma conta?</p>
								<a href="cadastro.jsp" name="cadUser" id="cadButton"
									class="btn btn-white btn-outline-white">Cadastrar</a>
							</div>
						</div>
						<div class="login-wrap p-4 p-lg-5">
							<div class="d-flex">
								<div class="w-100">
									<h3 class="mb-4">Login</h3>
								</div>
								<div class="w-100">
									<p class="social-media d-flex justify-content-end">
										<a href="#"
											class="social-icon d-flex align-items-center justify-content-center"><span
											class="fa fa-facebook"></span></a> <a href="#"
											class="social-icon d-flex align-items-center justify-content-center"><span
											class="fa fa-twitter"></span></a>
									</p>
								</div>
							</div>

							<c:if test="${not empty requestScope.messages}">
								<div class="alert alert-danger" role="alert"
									style="font-size: 16px;">
									Erros encontrados no preenchimento do formulário:

									<c:forEach var="message" items="${messages}">
										<p>
											<c:out value="${message}" />
										</p>
									</c:forEach>

								</div>
							</c:if>



							<form action="../login" method="POST" class="signin-form">
								<input type="hidden" name="operation" value="login">

								<div class="form-group mb-3">
									<label class="label" for="name">Email</label> <input
										type="text" class="form-control" placeholder="Email"
										id="email" name="email" required>
								</div>
								<div class="form-group mb-3">
									<label class="label" for="password">Senha</label> 
									<input type="password" class="form-control" id="inputPassword"
										placeholder="Senha" name="senha"  required>
								</div>
								<div class="form-group">
									<input type="submit" id="myButton"
										class="form-control btn btn-primary submit px-3"
										value='Entrar'>
								</div>
								<div class="form-group d-md-flex">
									
									<div class="w-50 text-md-right">
										<a href="#">Esqueceu a senha?</a>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>



</body>

</html>