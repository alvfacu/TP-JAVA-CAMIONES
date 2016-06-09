<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="capaEntidades.Localidad"%>
<%@ page import="capaNegocio.ControladorLocalidad"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!--  Ver con cual quedarnos -->
<script type="text/javascript" src="//code.jquery.com/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.js">    </script>
<script type="text/javascript" src="js/jquery.js"> </script>
<script type="text/javascript" src="js/bootstrap.js"> </script>
<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<title></title>
<script type="text/javascript" >  
$(document).ready(function() {
    $('#example').dataTable( {
    "oLanguage": {
     "sSearch": "BUSQUEDA:"
     },
    "aLengthMenu": [[25, 50, 75, -1], [25, 50, 75, "All"]],
    "pageLength": 25
    } );
} );
    </script>
</head>
<body>
	<%@page import="capaEntidades.Personal"%>
	<% if((Personal)session.getAttribute("Usuario")!=null){ %>
	<%@include file="nav-bar.jsp"%>
	<div class="container">
		<% ArrayList<Localidad> localidad = new ControladorLocalidad().dameTodo();%>
		<table id="example" class="display" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>Codigo Postal</th>
					<th>Localidad</th>
					<th>Provincia</th>
				</tr>
			</thead>
			<tbody>
				<% for(int i=0; i<localidad.size();i++) { %>
				<tr>
					<td align="center"><%= localidad.get(i).getCodigoPostal() %></td>
					<td align="center"><%= localidad.get(i).getNombreLocalidad() %>
					</td>
					<td align="center"><%= localidad.get(i).getProv().getNombreProvincia() %>
					</td>
				</tr>
				<% } %>
			</tbody>
		</table>
	</div>
	<%} else{%>
	<%@include file="error.html"%>
	<%}%>
</body>
</html>