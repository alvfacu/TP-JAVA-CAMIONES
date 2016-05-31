<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="capaEntidades.Viaje" %>
<%@ page import="capaNegocio.ControladorViaje" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date;" %>
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

<title>Listado de Viajes</title>
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
                <a class="navbar-brand" href="index.html">SYSTRUCK</a>
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
<h2>Viajes ~<small>                              Listado de Viajes</small></h2>    
    <% ArrayList<Viaje> viajes = new ControladorViaje().dameTodo(); %>
    <% SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); %>
<table class="table table-hover table-responsive table-bordered" >
 <tr class="active" style="font-weight: bold;">
    <td> Nro de Viaje </td>
    <td> Fecha Hora Salida (Pactada) </td>
    <td> Fecha Hora Llegada (Pactada) </td>
    <td> Fecha Hora Salida (Real) </td>
    <td> Fecha Hora Llegada (Real) </td>
    <td> Km Totales </td>
    <td> Km Reales </td>
    <td> Camionero </td>
    <td> Cami�n </td>    
    <td> Estado </td>
 </tr>
 <% for(int i=0; i<viajes.size();i++) { %>
  <tr>
        <td align="center"> <%= viajes.get(i).getNroViaje() %> </td>
        <td align="center"> <%= dateFormat.format(viajes.get(i).getFechaHoraSalidaPactada().getTime()) %> </td>
        <td align="center"> <%= dateFormat.format(viajes.get(i).getFechaHoraLlegadaPactada().getTime()) %> </td>
        <td align="center"> <%= viajes.get(i).getFechaHoraSalidaReal()==null?" ":dateFormat.format(viajes.get(i).getFechaHoraSalidaReal().getTime()) %> </td>
		<td align="center"> <%= viajes.get(i).getFechaHoraLlegadaReal()==null?" ":dateFormat.format(viajes.get(i).getFechaHoraLlegadaReal().getTime()) %> </td>
		<td align="center"> <%= viajes.get(i).getKmTotales() %> </td>
		<td align="center"> <%= viajes.get(i).getKmReales() %> </td>
		<td align="center"> <%= viajes.get(i).getCamionero().getApellido()+", "+viajes.get(i).getCamionero().getNombre() %> </td>
		<td align="center"> <%= viajes.get(i).getCamion().getPatente() %> </td>
		<td align="center"> <%= viajes.get(i).getEstado().toString() %> </td>

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


