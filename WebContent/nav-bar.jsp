
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
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Stylesheets -->
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <style>
    body {
        padding-top: 70px;
        
    }
    .active{
    background-color: yellow; }
    </style>
</head>
<body>
    
<!-- Inicio barra de navegación -->
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 
    	data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="index.jsp">SysTruck</a>
    <!-- Aca va lo que se depliega del menu cuando se hace responsive -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav" style="font-size:20px; padding:5px;">
        <li class="active"><a href="index.jsp"><i class="fa fa-home"></i> &nbsp Inicio<span class="sr-only">(current)</span></a></li>
          <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
           aria-haspopup="true" aria-expanded="false">Viajes <span class="caret"></span></a>
          <ul class="dropdown-menu" style="font-size:18px; padding:5px;">
            <li><a href="altaViaje.jsp">Alta</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="bajaViaje.jsp">Baja</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="modificarViaje.jsp">Modificacion</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="listadoViajes.jsp">Listado</a></li>
          </ul>
        </li>
         <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
           aria-haspopup="true" aria-expanded="false">Camiones <span class="caret"></span></a>
          <ul class="dropdown-menu" style="font-size:18px; padding:5px;">
            <li><a href="altaCamion.jsp">Alta</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="bajaCamiones.jsp">Baja</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="modificarCamion.jsp">Modificacion</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="listadoCamiones.jsp">Listado</a></li>
          </ul>
        </li>
         <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
           aria-haspopup="true" aria-expanded="false">Personal <span class="caret"></span></a>
          <ul class="dropdown-menu" style="font-size:18px; padding:5px;">
            <li><a href="altaPersonal.jsp">Alta</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="bajaPersonal.jsp">Baja</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="modificarPersonal.jsp">Modificacion</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="listadoPersonal.jsps">Listado</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
           aria-haspopup="true" aria-expanded="false">Direcciones <span class="caret"></span></a>
          <ul class="dropdown-menu" style="font-size:18px; padding:5px;">
            <li><a href="altaDirecciones.jsp">Alta</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="bajaDirecciones.jsp">Baja</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="bajaDirecciones.jsp">Modificacion</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="listadoDirecciones.jsp">Listado</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right" style="font-size:20px;">
        <li><a href="#"><i class="fa fa-user" style="padding:5px;"></i>Mi Perfil</a></li>
        <li><a href="Logout"><i class="fa fa-sign-out" style="padding:5px;"></i>Salir</a></li>
      </ul>
</div><!--Fin de contenedor del menu-->
</div><!-- Fin Contenedor -->
</nav><!-- Fin barra de navegación -->

   

</body>
</html>
        