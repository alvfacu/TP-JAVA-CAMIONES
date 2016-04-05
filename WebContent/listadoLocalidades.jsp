<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="capaEntidades.Localidad" %>
<<<<<<< HEAD
<%@ page import="capaNegocio.*" %>
=======
<%@ page import="capaLogica.LocalidadNegocio" %>
>>>>>>> 3a27ab4b3805fbaa38e403c7b0d13fc1fbce83b6
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Listado de Localidades</title>
</head>

<body>
	<h1 style="font-style: 2 ;color: blue;">LISTADO</h1>
	
	<% ArrayList<Localidad> localidades = new LocalidadNegocio().dameTodo();%>

<table border="1" bordercolor="Blue" id="contenido">
 <tr style="font-weight: bold;">
  	<td> Codigo Postal </td>
  	<td> Localidad </td>
  	<td> Provincia </td>
 </tr>
 <% for(int i=0; i<localidades.size();i++) { %>
  <tr>
  		<td align="center"> <%= localidades.get(i).getCodigoPostal() %> </td>
 		<td align="center"> <%= localidades.get(i).getNombreLocalidad() %> </td>
 		<td align="center"> <%= localidades.get(i).getProv().getNombreProvincia() %> </td>
  </tr>
 <% } %> 
</table>
<br>
</body>
</html>