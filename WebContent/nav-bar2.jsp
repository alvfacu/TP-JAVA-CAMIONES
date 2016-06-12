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
 <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#MyNavBar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="sr-only"></span>
                    <span class="sr-only"></span>
                    <span class="sr-only"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">SysTruck</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse " id="#MyNavBar">
				<ul class="nav navbar-nav" style="padding:5px; font-family: Arial; font-size: 17px;">
					<li class="" style="font-size:21px;"><a href="index.jsp"><b>Inicio</b></a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#" style="margin-left:30px;">Viaje <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="altaViaje.jsp">Alta</a></li>
							<li><a href="bajaViaje.jsp">Baja</a></li>
							<li><a href="modificarViaje.jsp">Modificacion</a></li>
							<li><a href="listadoViajes.jsp">Listado</a></li>
						</ul></li>
					<li><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Camiones<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="altaCamion.jsp">Alta</a></li>
							<li><a href="bajaCamiones.jsp">Baja</a></li>
							<li><a href="modificarCamion.jsp">Modificacion</a></li>
							<li><a href="listadoCamiones.jsp">Listado</a></li>
						</ul></li>
					<li><a class="dropdown-toggle"
						data-toggle="dropdown"  href="#">Personal<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="altaPersonal.jsp">Alta</a></li>
							<li><a href="bajaPersonal.jsp">Baja</a></li>
							<li><a href="modificarPersonal.jsp">Modificacion</a></li>
							<li><a href="listadoPersonal.jsp">Listado</a></li>
						</ul></li>
					<li><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Direcciones<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="altaDirecciones.jsp">Alta</a></li>
							<li><a href="bajaDirecciones.jsp">Baja</a></li>
							<li><a href="modificarDirecciones.jsp">Modificacion</a></li>
							<li><a href="listadoDirecciones.jsp">Listado</a></li>
						</ul></li>
							</ul>
					<ul class="nav navbar-nav navbar-right" style="font-family: Arial; font-size: 20px;">
							<li><a href="#"> 
								<span class="glyphicon glyphicon-user" aria-hidden="true" style="padding: 5px;">
									</span> Mi perfil</a></li>
							<li><a href="Logout"><span
									class="glyphicon glyphicon-log-out" aria-hidden="true"
									style="text-size:20px;padding: 5px;"></span> Salir</a></li>
						</ul>
			</div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

</body>
</html>