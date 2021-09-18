<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt_BR">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title> Detalhes Venda</title>

    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
    <div class="page-wrapper">
        <!-- HEADER MOBILE-->
        <header class="header-mobile d-block d-lg-none">
            <div class="header-mobile__bar">
                <div class="container-fluid">
                    <div class="header-mobile-inner">
                        <a class="logo" href="index.jsp">
                            <img src="images/icon/projeto_logo_escrito.png" alt="MobPet" width="180px" height="100px" />
                        </a>
                        <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                        </button>
                    </div>
                </div>
            </div>
            <nav class="navbar-mobile">
                <div class="container-fluid">
                    <ul class="list-unstyled navbar__list">
                        <li>
                            <a href="index.jsp">
                                <i class="fas fa-tachometer-alt"></i>Principal</a>
                        </li>
                        <li>
                            <a href="chart.jsp">
                                <i class="fas fa-chart-bar"></i>+ Graficos</a>
                        </li>

                        <li>
                            <a href="clients.jsp">
                                <i class="fas fa-user"></i>Clientes</a>
                        </li>

                        <li>
                            <a href="table.jsp">
                                <i class="fas fa-table"></i>Produtos</a>
                        </li>

                        <li class="active has-sub">
                            <a class="js-arrow" href="pedidos.jsp">
                                <i class="fas fa-tag"></i>Pedidos</a>
                        </li>
                        
                        <li>
                            <a href="ticket.jsp">
                                <i class="fas fa-ticket-alt"></i>Cupons</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <!-- END HEADER MOBILE-->

        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar d-none d-lg-block">
            <div class="logo">
                <a href="index.jsp">
                    <img src="images/icon/projeto_logo_escrito.png" alt="MobPet" width="200px" height="200px" />
                </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                        <li>
                            <a href="index.jsp">
                                <i class="fas fa-tachometer-alt"></i>Principal</a>
                        </li>
                        <li>
                            <a href="chart.jsp">
                                <i class="fas fa-chart-bar"></i>+ Graficos</a>
                        </li>

                        <li>
                            <a href="clients.jsp">
                                <i class="fas fa-user"></i>Clientes</a>
                        </li>

                        <li>
                            <a href="table.jsp">
                                <i class="fas fa-table"></i>Produtos</a>
                        </li>

                        <li class="active has-sub">
                            <a class="js-arrow" href="pedidos.jsp">
                                <i class="fas fa-tag"></i>Pedidos</a>
                        </li>

                        <li>
                            <a href="ticket.jsp">
                                <i class="fas fa-ticket-alt"></i>Cupons</a>
                        </li>
                        
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container">
            <!-- HEADER DESKTOP-->
            <header class="header-desktop">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap">
                            <div></div>
                            <div class="header-button">
                                <div class="account-wrap">
                                    <div class="account-item clearfix js-item-menu">
                                        <div class="image">
                                            <img src="images/icon/avatar-02.jpg" alt="Ruan Campos" />
                                        </div>
                                        <div class="content">
                                            <a class="js-acc-btn" href="#">Ruan Campos</a>
                                        </div>
                                        <div class="account-dropdown js-dropdown">
                                            <div class="info clearfix">
                                                <div class="image">
                                                    <a href="#">
                                                        <img src="images/icon/avatar-02.jpg" alt="Ruan Campos" />
                                                    </a>
                                                </div>
                                                <div class="content">
                                                    <h5 class="name">
                                                        <a href="#">Ruan Campos</a>
                                                    </h5>
                                                    <span class="email">rcampos@example.com</span>
                                                </div>
                                            </div>
                                            <div class="account-dropdown__footer">
                                                <a href="#">
                                                    <i class="zmdi zmdi-power"></i>Logout</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <!-- HEADER DESKTOP-->

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row"> 	
                            <div class="col-lg-12">
                                <div class="card">
                                    <div class="card-header">
                                        <strong>Detalhes</strong> Venda
                                    </div>
                                    <div class="card-body card-block">
                                        <form>
                                            <h2 class="title-2 m-b-25">Produtos</h2>
                                            <div class="form-row">
                                              <div class="form-group col-md-5">
                                                <label for="nomeProduto">Nome</label>
                                                <input readonly type="text" class="form-control" id="nomeProduto" placeholder="Produto">
                                              </div>
                                              <div class="form-group col-md-5">
                                                <label for="marca">Marca</label>
                                                <input readonly type="text" class="form-control" id="marca" placeholder="Marca">
                                              </div>
                                              <div class="form-group col-md-2">
                                                <label for="quant">Quantidade</label>
                                                <input readonly type="text" class="form-control" id="quant" placeholder="Quant.">
                                              </div>
                                            </div>
                                            <br>
                                            <h2 class="title-2 m-b-25">Comprador</h2>
                                            <div class="form-row">
                                                <div class="form-group col-md-5">
                                                  <label for="nomeComp">Nome</label>
                                                  <input readonly type="text" class="form-control" id="nomeComp" placeholder="Cliente">
                                                </div>
                                                <div class="form-group col-md-4">
                                                  <label for="cpf">CPF</label>
                                                  <input readonly type="text" class="form-control" id="cpf" placeholder="CPF">
                                                </div>
                                                <div class="form-group col-md-3">
                                                  <label for="telMovel">Telefone</label>
                                                  <input readonly type="text" class="form-control" id="telMovel" placeholder="() xxxxx-xxxx">
                                                </div>
                                              </div>
                                            <br>
                                            <h2 class="title-2 m-b-25">Endereco de entrega</h2>
                                            <div class="form-group">
                                              <label for="ender">Endereco</label>
                                              <input readonly type="text" class="form-control" id="ender" placeholder="Apartamento, hotel, casa, etc.">
                                            </div>
                                            <div class="form-row">
                                              <div class="form-group col-md-6">
                                                <label for="cidade">Cidade</label>
                                                <input readonly type="text" class="form-control" id="cidade" placeholder="Cidade">
                                              </div>
                                              <div class="form-group col-md-4">
                                                <label for="estado">Estado</label>
                                                <input readonly type="text" class="form-control" id="estado" placeholder="Estado">
                                              </div>
                                              <div class="form-group col-md-2">
                                                <label for="cep">CEP</label>
                                                <input readonly type="text" class="form-control" id="cep" placeholder="CEP">
                                              </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-md-5">
                                                    <select name="status" id="status" class="form-control">
                                                        <option value="0">Selecionar...</option>
                                                        <option value="1">Em processamento</option>
                                                        <option value="2">Pagamento realizado</option>
                                                        <option value="3">Em transporte</option>
                                                        <option value="4">Troca solicitada</option>
                                                        <option value="5">Troca autorizada</option>
                                                        <option value="6">Troca rejeitada</option>
                                                        <option value="6">Cancelamento solicitado</option>
                                                        <option value="6">Cancelamento rejeitado</option>
                                                        <option value="6">Troca aceita</option>
                                                        <option value="6">Cancelamento aceito</option>
                                                        <option value="6">Entrega realizada</option>
                                                        <option value="6">Troca efetuada</option>
                                                        <option value="6">Cancelamento efetuado</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <button class="btn btn-primary" style="color: white"><a  style="color: white" href="pedidos.jsp">Voltar</a></button>

                                            <input type="submit" hidden><button class="btn btn-primary"><a  style="color: white"  href="pedidos.jsp">Salvar</a></button>
                                          </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="copyright">
                                    <p>Copyright Â© 2021 MobPet. All rights reserved.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery-3.2.1.min.js"></script>
    <script src="https://igorescobar.github.io/jQuery-Mask-Plugin/js/jquery.mask.min.js"></script>            
    <!-- Bootstrap JS-->
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="vendor/slick/slick.min.js">
    </script>
    <script src="vendor/wow/wow.min.js"></script>
    <script src="vendor/animsition/animsition.min.js"></script>
    <script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="vendor/counter-up/jquery.waypoints.min.js"></script>
    <script src="vendor/counter-up/jquery.counterup.min.js">
    </script>
    <script src="vendor/circle-progress/circle-progress.min.js"></script>
    <script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="vendor/select2/select2.min.js">
    </script>

    <!-- Main JS-->
    <script src="js/main.js"></script>

</body>

</html>
<!-- end document-->