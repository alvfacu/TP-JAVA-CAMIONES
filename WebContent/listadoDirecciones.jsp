<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="capaEntidades.Direccion"%>
<%@ page import="capaNegocio.ControladorDireccion"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!--JQuery para la Tabla-->
<script type="text/javascript" src="//code.jquery.com/jquery-1.12.3.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/bootstrap.js">
</script>
<!--Hojas de Estilo para la tabla-->
<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
<title>Listado de Camiones</title>
<script type="text/javascript" >
        $(document).ready(function() {
            $('#example').dataTable( {
            "oLanguage": {
            "sLengthMenu": "Mostrar _MENU_ registros",
             "sSearch": "Busqueda:"
             },
            "aLengthMenu": [[10,25, 50, 75, -1], [10,25, 50, 75, "All"]],
            "pageLength": 10
            } );
        } );
    </script>
</head>
<body>
	<%@page import="capaEntidades.Personal"%>
	<% if((Personal)session.getAttribute("Usuario")!=null){ %>
	<%@include file="nav-bar.jsp"%>
	<div class="container">
		<% ArrayList<Direccion> direcciones = new ControladorDireccion().dameTodo();%>
		<table id="example" class="display" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>Calle</th>
					<th>Numero</th>
					<th>Piso</th>
					<th>Letra</th>
					<th>Localidad</th>
					
				</tr>
			</thead>
			<tbody>
				<% for(int i=0; i<direcciones.size();i++) { %>
				<tr>
					<td align="center"><%= direcciones.get(i).getCalle() %></td>
					<td align="center"><%= direcciones.get(i).getNro() %></td>
					<td align="center"><%= direcciones.get(i).getPiso() %></td>
					<td align="center"><%= direcciones.get(i).getDepto() %></td>
					<td align="center"><%= direcciones.get(i).getLoc().getNombreLocalidad() %></td>
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