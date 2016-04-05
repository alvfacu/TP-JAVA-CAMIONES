<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="capaEntidades.Camion" %>
<<<<<<< HEAD
<%@ page import="capaNegocio.*" %>
=======
<%@ page import="capaLogica.CamionNegocio;" %>
>>>>>>> 3a27ab4b3805fbaa38e403c7b0d13fc1fbce83b6
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Camion</title>
</head>

<body>
	<h1 style="font-style: 2 ;color: blue;">LISTADO</h1>
	
<<<<<<< HEAD
	<% Camion ca = new ControladorCamion().dameUno("HIV800");%>
=======
	<% Camion ca = new CamionNegocio().dameUno("HIV800");%>
>>>>>>> 3a27ab4b3805fbaa38e403c7b0d13fc1fbce83b6

<table border="1" bordercolor="Blue" id="contenido">
 <tr style="font-weight: bold;">
  	<td> Patente </td> 
	<td> Marca </td>
	<td> Modelo </td>
	<td> Descripcion </td>
	<td> Km Recorridos desde Mantenimiento </td>
	<td> Km Recorridos en viaje (kg) </td>
	<td> Estado </td>
 </tr> 
 <tr>
 	<td><%=ca.getPatente()%></td>
 	<td><%=ca.getMarca()%></td>
 	<td><%=ca.getModelo()%></td>
 	<td><%=ca.getDescripcion()%></td>
 	<td><%=ca.getKmRecorridosDesdeMantenimiento()%></td>
 	<td><%=ca.getKmRecorridosEnViaje()%></td>
 	<td><%=ca.getEstado().toString()%></td>
 </tr>
</table>
<br>
</body>
</html>