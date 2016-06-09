<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="capaEntidades.Demora" %>
<%@ page import="capaNegocio.ControladorDemora" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
<title>Modificar Demora</title>
    <link href="css/bootstrap.css" rel="stylesheet">

<STYLE TYPE="text/css">
 .demora {font-size: 20px;}
 .demora {color:green;}
 .demora1 {font-size: 20px;}
 .demora1 {color:red;}
 </STYLE>

</head>
<body>
<%@include file="nav-bar.jsp" %>
  <% Demora demora = new ControladorDemora().dameDemoraActual();%>
	<!-- Cointainer -->
	<div class="container">
	
	 <form name="formu" action="ModificarDemora" class="" method="POST" >
	<h2 class= "alinearh2"><strong>Modificar la demora </strong></h2>
	<h4>Recordar que la demora ingresada equivale a la demora que tarda un camión en realizar 100km</h4><br>
	<label class="demora">Demora Actual</label><br>
	<label class="demora1">Horas: <%= demora.getHoras() %> </label><br>
	<label class="demora1">Minutos: <%= demora.getMinutos() %></label><br>
	<br>
	<label class="demora">Nueva Demora</label><br>
	<input name="horas" type="number"  placeholder="Horas" value="" required autofocus >
	<input name="minutos" type="number"   placeholder="Minutos" value="" required autofocus  >
		
	<button type="submit">Guardar</button>
	</form>
	
	</div>

</body>
</html>