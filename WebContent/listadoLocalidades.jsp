<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="capaEntidades.Localidad" %>
<%@ page import="capaNegocio.ControladorLocalidad;" %>
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

<title>Listado de Localidades</title>
</head>

<body>
   <%@include file="nav-bar.jsp" %>
<div class="container">
<h2>Localidades ~<small>Listado de Localidades</small></h2>    
    <% ArrayList<Localidad> localidad = new ControladorLocalidad().dameTodo();%>

<table class="table table-hover table-responsive table-bordered" >
 <tr class="active" style="font-weight: bold;">
  	<td> Codigo Postal </td>
  	<td> Localidad </td>
  	<td> Provincia </td>
 </tr>
 <% for(int i=0; i<localidad.size();i++) { %>
  <tr>
        <td align="center"> <%= localidad.get(i).getCodigoPostal() %> </td>
 		<td align="center"> <%= localidad.get(i).getNombreLocalidad() %> </td>
 		<td align="center"> <%= localidad.get(i).getProv().getNombreProvincia() %> </td>
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
