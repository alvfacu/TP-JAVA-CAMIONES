<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<meta name="description" content="">

<title>Generar Viaje</title>

</head>
<body>
	<%@page import="capaEntidades.Personal"%>
	<% if((Personal)session.getAttribute("Usuario")!=null){ %>
<!-- Necesito
				- Personal
				- Camion
				- Ruta(S)	  -->


 	  <%} else{%>
	  <%@include file="error.html" %>
	  <%}%>
</body>
</html>