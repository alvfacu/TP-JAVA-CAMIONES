<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="capaEntidades.Viaje" %>
<%@ page import="capaNegocio.ControladorViaje" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
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
   <%@page import="capaEntidades.Personal"%>
	<% if((Personal)session.getAttribute("Usuario")!=null){ %>
  	<%@include file="nav-bar.jsp" %>
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
    <td> Camión </td>    
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
     <%} else{%>
	  <%@include file="error.html" %>
	  <%}%>
</body>
</html>


