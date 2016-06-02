


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Sistema Camiones</title>
    <!-- Iconos -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Stylesheets -->
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <style>
    body {
        padding-top: 70px;
       
    }
    </style>
   

</head>

<body>
	<%@page import="capaEntidades.Personal"%>
	<% if((Personal)session.getAttribute("Usuario")!=null){ %>
   	<%@include file="nav-bar.jsp" %>

    <!-- Page Content -->
    <div class="container">

        <div class="row center-block" >
                 <h3>Seleccione la acción que desea realizar</h3>
    <!-- Contenedor -->
    <ul id="accordion" class="accordion">
         <li>
            <div class="link"><i class="fa fa-database" aria-hidden="true"></i>Viaje<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="listadoViajes.jsp"><span class="glyphicon glyphicon-file" aria-hidden="true" style="padding:10px;"></span>Listado</a></li>
            </ul>
        </li>
        <li>
            <div class="link"><i class="fa fa-truck" aria-hidden="true"></i>Camiones<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="altaCamion.jsp"><span class="glyphicon glyphicon-arrow-up" aria-hidden="true" style="padding:10px;"></span>Alta</a></li>
                <li><a href="bajaCamiones.jsp"><span class="glyphicon glyphicon-arrow-down" aria-hidden="true" style="padding:10px;"></span>Baja</a></li>
                <li><a href="modificarCamion.jsp"><span class="glyphicon glyphicon-retweet" aria-hidden="true" style="padding:10px;"></span>Modificacion</a></li>
                <li><a href="listadoCamiones.jsp"><span class="glyphicon glyphicon-file" aria-hidden="true" style="padding:10px;"></span>Listado</a></li>
            </ul>
        </li>
        <li>
            <div class="link"><i class="fa fa-male" aria-hidden="true"></i>Personal<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="altaPersonal.jsp"><span class="glyphicon glyphicon-arrow-up" aria-hidden="true" style="padding:10px;"></span>Alta</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-arrow-down" aria-hidden="true" style="padding:10px;"></span>Baja</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-retweet" aria-hidden="true" style="padding:10px;"></span>Modificacion</a></li>
                <li><a href="listadoPersonal.jsp"><span class="glyphicon glyphicon-file" aria-hidden="true" style="padding:10px;"></span>Listado</a></li>
            </ul>
        </li>
        <li>
            <div class="link"><i class="fa fa-globe"></i>Localidades<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                 <li><a href="listadoLocalidades.jsp"><span class="glyphicon glyphicon-file" aria-hidden="true" style="padding:10px;"></span>Listado</a></li>
               
            </ul>
        </li>
        <li><div class="link"><i class="fa fa-star"></i>OTROS<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="#">DEFINIR</a></li>
            </ul>
        </li>
    </ul>
            </div>

        </div>
        <!-- /.row -->
           <br><br><br>
          <div class="row"> <div class="col-lg-12 text-center">Cerrar Sección</div></div>
    <!-- /.container -->

    <!-- jQuery Version 1.11.1 -->
    <script src="js/jquery.js"></script>
    <script src="js/main.js"></script>
     <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
   	  <%} else{%>
	  <%@include file="error.html" %>
	  <%}%>
</body>
<footer></footer>
</html>

