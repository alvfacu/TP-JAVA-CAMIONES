


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Sistema Camiones</title>
<!-- Iconos -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<!-- Stylesheets -->
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/bootstrap.css">
<style>
.bienvenida {color:#ec6b6b;}
</style>


</head>

<body>
	<%@page import="capaEntidades.Personal"%>
	<% if((Personal)session.getAttribute("Usuario")!=null){
		Personal pe = new Personal (); 
		pe = (Personal)session.getAttribute("Usuario"); %>
	<%@include file="nav-bar.jsp"%>
	
	<!-- Page Content -->
	<div class="container">

		<div class="row center-block">
			<h2 class="bienvenida">Bienvenido <%= pe.getNombre() %> </h2>
			<hr>
			<!-- <p style="font-family:sans-serif; font-size:30px; text-align:center; color:#982525;">Seleccione la accion que desea realizar</p> -->
			<div class="row center-block" style=" width:auto; margin:30px;;">
				<div class="panel panel-danger">
				  <div class="panel-heading"><h3 class="panel-title">Seleccione la acción que desea realizar</h3></div>
				  <div class="panel-body">
				    <ul id="accordion" class="accordion color">
				<li>
					<div class="link">
						<i class="fa fa-database" aria-hidden="true"></i>Viaje<i
							class="fa fa-chevron-down"></i>
					</div>
					<ul class="submenu">
						<li><a href="generarViaje.jsp"><span
								class="fa fa-truck" aria-hidden="true"
								style="padding: 10px;"></span>Generar Viaje</a></li>
						<li><a href="listadoViajes.jsp"><span
								class="glyphicon glyphicon-file" aria-hidden="true"
								style="padding: 10px;"></span>Listado</a></li>
					</ul>
				</li>
				<li>
					<div class="link">
						<i class="fa fa-truck" aria-hidden="true"></i>Camiones<i
							class="fa fa-chevron-down"></i>
					</div>
					<ul class="submenu">
						<li><a href="altaCamion.jsp"><span
								class="glyphicon glyphicon-arrow-up" aria-hidden="true"
								style="padding: 10px;"></span>Alta</a></li>
						<li><a href="bajaCamiones.jsp"><span
								class="glyphicon glyphicon-arrow-down" aria-hidden="true"
								style="padding: 10px;"></span>Baja</a></li>
						<li><a href="modificarCamion.jsp"><span
								class="glyphicon glyphicon-retweet" aria-hidden="true"
								style="padding: 10px;"></span>Modificacion</a></li>
						<li><a href="listadoCamiones.jsp"><span
								class="glyphicon glyphicon-file" aria-hidden="true"
								style="padding: 10px;"></span>Listado</a></li>
					</ul>
				</li>
				<li>
					<div class="link">
						<i class="fa fa-male" aria-hidden="true"></i>Personal<i
							class="fa fa-chevron-down"></i>
					</div>
					<ul class="submenu">
						<li><a href="altaPersonal.jsp"><span
								class="glyphicon glyphicon-arrow-up" aria-hidden="true"
								style="padding:10px;"></span>Alta</a></li>
						<li><a href="#"><span 
							class="glyphicon glyphicon-arrow-down" aria-hidden="true"
								style="padding: 10px;"></span>Baja</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-retweet"
								aria-hidden="true" style="padding: 10px;"></span>Modificacion</a></li>
						<li><a href="listadoPersonal.jsp"><span
								class="glyphicon glyphicon-file" aria-hidden="true"
								style="padding: 10px;"></span>Listado</a></li>
					</ul>
				</li>
				<li>
					<div class="link">
						<i class="fa fa-globe"></i>Localidades<i
							class="fa fa-chevron-down"></i>
					</div>
					<ul class="submenu">
						<li><a href="listadoLocalidades.jsp"><span
								class="glyphicon glyphicon-file" aria-hidden="true"
								style="padding: 10px;"></span>Listado</a></li>
					</ul>
				</li>
				<li><div class="link">
						<i class="fa fa-star"></i>OTROS<i class="fa fa-chevron-down"></i>
					</div>
					<ul class="submenu">
						<li><a href="#">DEFINIR</a></li>
					</ul>
				</li>
				<li>
					<div class="link">
						<i class="fa fa-globe"></i>Direcciones<i
							class="fa fa-chevron-down"></i>
					</div>
					<ul class="submenu">
						<li><a href="listadoDirecciones.jsp"><span
								class="glyphicon glyphicon-file" aria-hidden="true"
								style="padding: 10px;"></span>Listado</a></li>
								<li><a href="altaDirecciones.jsp"><span
								class="glyphicon glyphicon-arrow-up" aria-hidden="true"
								style="padding: 10px;"></span>Alta</a></li>
								<li><a href="bajaDirecciones.jsp"><span
								class="glyphicon glyphicon-arrow-up" aria-hidden="true"
								style="padding: 10px;"></span>Baja</a></li>
								<li><a href="modificarDirecciones.jsp"><span class="glyphicon glyphicon-retweet"
								aria-hidden="true" style="padding: 10px;"></span>Modificacion</a></li>
					</ul>
				</li>
				<li><div class="link">
						<i class="fa fa-calculator"></i>Configurar Demora<i class="fa fa-chevron-down"></i>
					</div>
					<ul class="submenu">
						<li><a href="modificarDemora.jsp"><span
								class="glyphicon glyphicon-retweet" aria-hidden="true"
								style="padding: 10px;"></span>Cambiar Demora</a></li>
					</ul>
				</li>
			</ul>
				  </div>
				</div>
				
			
			<!-- Contenedor -->
			
		</div>
	</div>
	</div>
	<!-- /.row -->
	<br>
	<br>
	<br>
	 
	<!-- /.container -->
	  <%} else{%>
	  <%@include file="error.html" %>
	  <%}%>
	  <!-- jQuery Version 1.11.1 -->
	<script src="js/jquery.js"></script>
	<script src="js/main.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
</body>
<footer></footer>
</html>

