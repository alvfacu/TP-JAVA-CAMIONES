<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="capaEntidades.Personal" %>
<%@ page import="capaNegocio.ControladorPersonal" %>
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

<title>Listado del Personal</title>
</head>

<body>
   <%@page import="capaEntidades.Personal"%>
	<% if((Personal)session.getAttribute("Usuario")!=null){ %>
  	<%@include file="nav-bar.jsp" %>
<div class="container">
<h2>Personal ~<small>Listado del Personal</small></h2>    
   <!-- <//% ArrayList<Personal> personal = new ControladorPersonal().dameTodo();%> -->
	<% Personal personal = new ControladorPersonal().dameUno("37450910");%>
<table class="table table-hover table-responsive table-bordered" >
 <tr class="active" style="font-weight: bold;">
  	<td> Dni </td>
  	<td> Usuario </td>
  	<td> Nombre </td>
  	<td> Apellido </td>
  	<td> Telefono </td>
  	<td> Direccion </td>
  	<td> Disponibilidad </td>
  	<td> Tipo </td>
  	<td> Imagen </td>

  	
 </tr>
 <!-- <//% for(int i=0; i<personal.size();i++) { %> -->
  <tr>
      <!--  <td align="center"> <-%= personal.get(i).getDni() %> </td>
 		<td align="center"> <-%= personal.get(i).getUsuario() %> </td>
 		<td align="center"> <-%= personal.get(i).getNombre() %> </td>
 		<td align="center"> <-%= personal.get(i).getApellido() %> </td>
 		<td align="center"> <-%= personal.get(i).getTelefono() %> </td>
 		<td align="center"> <-%= personal.get(i).getDireccion() %> </td>
 		<td align="center"> <-%= personal.get(i).getDisponibilidad() %> </td>
 		<td align="center"> <-%= personal.get(i).getTipo() %> </td>
 		<td aling="center"> <-%= personal.get(i).getImagen() %> </td>-->
 		<td aling="center">	<%= personal.getDni() %> </td>
 		<td align="center"> <%= personal.getUsuario() %> </td>
 		<td align="center"> <%= personal.getNombre() %> </td>
 		<td align="center"> <%= personal.getApellido() %> </td>
 		<td align="center"> <%= personal.getTelefono() %> </td>
 		<td align="center"> <%= personal.getDireccion() %> </td>
 		<td align="center"> <%= personal.getDisponibilidad() %> </td>
 		<td align="center"> <%= personal.getTipo() %> </td>
 		
 	//			response.reset();
 	//	response.setContentType("image/jpeg"); personal.getByteArrayString() %> "> </td>
  </tr>
 <!--  <-% } %> -->
</table>
<br>
</div>

 <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
   	  <%} else{%>
	  <%@include file="error.html" %>
	  <%}%>
</body>
</html>
