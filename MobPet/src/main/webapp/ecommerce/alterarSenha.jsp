<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<html>

<head>
    <!-- Meta Tag -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name='copyright' content=''>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Title Tag  -->
    <title>MobPet - Alterar senha</title>
    <!-- Favicon -->
    <link rel="icon" type="image/png" href="images/favicon.png">
    <!-- Web Font -->
    <link
        href="https://fonts.googleapis.com/css?family=Poppins:200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

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
                            <a href="index.jsp"><img src="images/logo.png" alt="logo"></a>
                        </div>
                        <!--/ End Logo -->
                        <!-- Search Form -->
                        <div class="search-top">
                            <div class="top-search"><a href="#0"><i class="ti-search"></i></a></div>
                            <!-- Search Form -->
                            <div class="search-top">
                                <form class="search-form">
                                    <input type="text" placeholder="Procure aqui..." name="search">
                                    <button value="search" type="submit"><i class="ti-search"></i></button>
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
                                    <input name="search" placeholder="O que deseja procurar?....." type="search">
                                    <button class="btnn"><i class="ti-search"></i></button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-3 col-12">
                        <div class="right-bar">
                            <!-- Search Form -->
                            <div class="sinlge-bar">
                                <a href="#" class="single-icon"><i class="fa fa-heart-o" aria-hidden="true"></i></a>
                            </div>
                            <div class="sinlge-bar">
                                <a href="#" class="single-icon"><i class="fa fa-user-circle-o"
                                        aria-hidden="true"></i></a>
                            </div>
                            <div class="sinlge-bar shopping">
                                <a href="#" class="single-icon"><i class="ti-bag"></i> <span
                                        class="total-count">2</span></a>
                                <!-- Shopping Item -->
                                <div class="shopping-item">
                                    <div class="dropdown-cart-header">
                                        <span>3 Items</span>
                                        <a href="#">Ver carrinho</a>
                                    </div>
                                    <ul class="shopping-list">
                                        <li>
                                            <a href="#" class="remove" title="Remove this item"><i
                                                    class="fa fa-remove"></i></a>
                                            <a class="cart-img" href="#"><img src="https://via.placeholder.com/70x70"
                                                    alt="#"></a>
                                            <h4><a href="#">Ração Dogs</a></h4>
                                            <p class="quantity">1x - <span class="amount">R$99.00</span></p>
                                        </li>
                                        <li>
                                            <a href="#" class="remove" title="Remove this item"><i
                                                    class="fa fa-remove"></i></a>
                                            <a class="cart-img" href="#"><img src="https://via.placeholder.com/70x70"
                                                    alt="#"></a>
                                            <h4><a href="#">Ração Cats</a></h4>
                                            <p class="quantity">1x - <span class="amount">R$35.00</span></p>
                                        </li>
                                    </ul>
                                    <div class="bottom">
                                        <div class="total">
                                            <span>Total</span>
                                            <span class="total-amount">R$134.00</span>
                                        </div>
                                        <a href="checkout.jsp" class="btn animate">Checkout</a>
                                    </div>
                                </div>
                                <!--/ End Shopping Item -->
                            </div>
                            <div class="sinlge-bar">
                                <h1 id="cadastrar"><a href="login.html">Bem vindo, Ruan</a></h1>
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
        <a href="perfilCliente.jsp">
            <i class="fas fa-user"></i>
            <span>Alterar Dados</span>
        </a>
        <a href="alterarSenha.jsp" class="active">
            <i class="fas fa-lock"></i>
            <span>Alterar Senha</span>
        </a>
        <a href="adicionarEndereco.jsp">
            <i class="fas fa-map-marker-alt"></i>
            <span>Endereços</span>
        </a>
        <a href="adicionarCartao.jsp">
            <i class="fas fa-credit-card"></i>
            <span>Cartões</span>
        </a>

        <header>Pedidos</header>
        <a href="meusPedidos.jsp">
            <i class="fas fa-box-open"></i>
            <span>Status</span>
        </a>
        <a href="minhasTrocas.jsp">
            <i class="fas fa-people-carry"></i>
            <span>Trocas</span>
        </a>
    </div>

    <form id="dadosCliente">
        <div class="form-row">
            <div class="form-group col-md-10">
                <label for="inputSenha4">Senha antiga</label>
                <input type="password" class="form-control" id="senha" placeholder="Senha" disabled>
            </div>

        </div>
        <div class="form-row">
            <div class="form-group col-md-10">
                <label for="inputSenha4">Nova senha</label>
                <input type="password" class="form-control" id="senha" placeholder="Senha" disabled>
            </div>

        </div>
        <div class="form-row">
            <div class="form-group col-md-10">
                <label for="inputReSenha4">Repita sua senha</label>
                <input type="password" class="form-control" id="re-senha" placeholder="Repetir Senha" disabled>
            </div>
        </div>

        <button type="button" class="editarButton" id="editClient"><i class="fas fa-pencil-alt">Editar</i></button>
        <button type="button" class="salvarButton" id="cadastrarEndereco" onclick="atualizarCadastro()"><i
                class="fas fa-save"> Salvar</i></button>
    </form>

    <footer class="footer">
        <!-- Footer Top -->
        <div class="footer-top section">
            <div class="container">
                <div class="row">
                    <div class="col-lg-5 col-md-6 col-12">
                        <!-- Single Widget -->
                        <div class="single-footer about">
                            <div class="logo">
                                <a href="index.jsp"><img src="images/logo2.png" style="width:150px" alt="#"></a>
                            </div>

                        </div>
                        <!-- End Single Widget -->
                    </div>

                    <!-- End Single Widget -->

                </div>
                <!-- End Single Widget -->
            </div>
        </div>

        <!-- End Footer Top -->
        <div class="copyright">
            <div class="container">
                <div class="inner">
                    <div class="row">
                        <div class="col-lg-6 col-12">
                            <div class="left">
                                <p>Copyright © 2020 MobPet -
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
    </script>
</body>



</html>