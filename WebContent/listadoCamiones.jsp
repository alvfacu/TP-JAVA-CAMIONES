<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="capaEntidades.Camion" %>
<%@ page import="capaLogica.CamionNegocio;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Listado de Camiones</title>
</head>

<body>
	<h1 style="font-style: 2 ;color: blue;">LISTADO</h1>
	
	<% ArrayList<Camion> camiones = new CamionNegocio().dameTodo();%>

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
</body>
</html>