<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="capaEntidades.Camion" %>
<%@ page import="capaNegocio.ControladorCamion;" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
      <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-frontpage.css" rel="stylesheet">

<title>Listado de Camiones</title>
</head>

<body>
<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">SYSCAM</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    
<div class="container">
<h2>Camiones ~<small>                              Listado de Camiones</small></h2>    
    <% ArrayList<Camion> camiones = new ControladorCamion().dameTodo();%>

<table class="table table-hover table-responsive table-bordered" >
 <tr class="active" style="font-weight: bold;">
    <td> Patente </td>
    <td> Marca </td>
    <td> Modelo </td>
    <td> Descripcion </td>
    <td> Km Recorridos desde Mantenimiento </td>
    <td> Km Recorridos en viaje (kg) </td>
    <td> Estado </td>
 </tr>
 <% for(int i=0; i<camiones.size();i++) { %>
  <tr>
        <td align="center"> <%= camiones.get(i).getPatente() %> </td>
        <td align="center"> <%= camiones.get(i).getMarca() %> </td>
        <td align="center"> <%= camiones.get(i).getModelo() %> </td>
        <td align="center"> <%= camiones.get(i).getDescripcion() %> </td>
        <td align="center"> <%= camiones.get(i).getKmRecorridosDesdeMantenimiento() %> </td>
        <td align="center"> <%= camiones.get(i).getKmRecorridosEnViaje() %> </td>
        <td align="center"> <%= camiones.get(i).getEstado().toString() %> </td>
  </tr>
 <% } %> 
</table>
<br>
</div>

 <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>


