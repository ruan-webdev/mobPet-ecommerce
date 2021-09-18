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
    <title>Pedidos</title>

    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
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
                            <a  href="chart.jsp">
                                <i class="fas fa-chart-bar"></i>+ Gráficos</a>
                        </li>

                        <li>
                            <a href="clients.jsp">
                                <i class="fas fa-user"></i>Clientes</a>
                        </li>

                        <li>
                            <a  class="js-arrow" href="#">
                                <i class="fas fa-table"></i>Produtos</a>
                        </li>

                        <li class="active has-sub">
                            <a href="pedidos.jsp">
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
                            <a  href="chart.jsp">
                                <i class="fas fa-chart-bar"></i>+ Gráficos</a>
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
                            <a class="js-arrow" href="#">
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
            <!-- END HEADER DESKTOP-->

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row m-t-30">
                            <div class="col-md-12">
                                <!-- DATA TABLE-->
                                <h2 class="title-1 m-b-25">Status Vendas</h2>
                                <div class="table-data__tool">
                                    <div class="table-data__tool-left">
                                        <div class="rs-select2--light rs-select2--md">
                                            <select class="js-select2" name="property">
                                                <option selected="selected">Filtros</option>
                                                <option value="">Opção 1</option>
                                                <option value="">Opção 2</option>
                                            </select>
                                            <div class="dropDownSelect2"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="table-responsive m-b-40">
                                    <table class="table table-borderless table-data3">
                                        <thead>
                                            <tr>
                                                <th>data</th>
                                                <th>produto</th>
                                                <th>descrição</th>
                                                <th>status</th>
                                                <th>preço</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <tr class='clickable-row' style="cursor: pointer;" data-href='sales.jsp'>
                                                <td>2018-09-29 05:57</td>
                                                <td>Ração</td>
                                                <td>....</td>
                                                <td class="process">Entregue</td>
                                                <td>R$999.00</td>
                                            </tr>

                                            <tr class='clickable-row' style="cursor: pointer;" data-href='sales.jsp'>
                                                <td>2018-09-28 01:22</td>
                                                <td>Brinquedo</td>
                                                <td>...</td>
                                                <td class="process">Entregue</td>
                                                <td>R$756.00</td>
                                            </tr>
                                            <tr class='clickable-row' style="cursor: pointer;" data-href='sales.jsp'>
                                                <td>2018-09-27 02:12</td>
                                                <td>Sapatinho</td>
                                                <td>...</td>
                                                <td class="denied">Em andamento</td>
                                                <td>R$22.00</td>
                                            </tr>
                                            <tr class='clickable-row' style="cursor: pointer;" data-href='sales.jsp'>
                                                <td>2018-09-26 23:06</td>
                                                <td>Remedio</td>
                                                <td>...</td>
                                                <td class="denied">Em andamento</td>
                                                <td>R$199.00</td>
                                            </tr>
                                            <tr class='clickable-row' style="cursor: pointer;" data-href='sales.jsp'>
                                                <td>2018-09-25 19:03</td>
                                                <td>Petiscos</td>
                                                <td>...</td>
                                                <td class="process">Entregue</td>
                                                <td>R$10.00</td>
                                            </tr>
                                            <tr class='clickable-row' style="cursor: pointer;" data-href='sales.jsp'>
                                                <td>2018-09-29 05:57</td>
                                                <td>Coleiras passeio</td>
                                                <td>...</td>
                                                <td class="denied">Em andamento</td>
                                                <td>R$199.00</td>
                                            </tr>
                                            <tr class='clickable-row' style="cursor: pointer;" data-href='sales.jsp'>
                                                <td>2018-09-24 19:10</td>
                                                <td>Shampoos</td>
                                                <td>...</td>
                                                <td class="process">Entregue</td>
                                                <td>R$69.00</td>
                                            </tr>
                                            
                                        </tbody>
                                    </table>
                                </div>
                                <!-- END DATA TABLE-->
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="copyright">
                                    <p>Copyright © 2021 MobPet. All rights reserved.</p>
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
    
<script>
    jQuery(document).ready(function($) {
        $(".clickable-row").click(function() {
            window.location = $(this).data("href");
        });
    });
</script>

</body>

</html>