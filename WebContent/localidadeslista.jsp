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

    <script type="text/javascript" language="javascript" src="//code.jquery.com/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" language="javascript" src="js/jquery.dataTables.js">
    </script>

    <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
	

	<title></title>
	<script type="text/javascript" language="javascript" >
    

$(document).ready(function() {
    $('#example').DataTable();
} );


    </script>
</head>
<body>
<div class="container">

  <% ArrayList<Localidad> localidad = new ControladorLocalidad().dameTodo();%>

<table id="example" class="display" cellspacing="0" width="50%">
        
        <thead>
            <tr>
                <th> Codigo Postal </th>
                <th> Localidad </th>
                <th> Provincia </th>
            </tr>
        </thead>

   		 <tbody>
                <% for(int i=0; i<localidad.size();i++) { %>
                    <tr>
                        <td align="center"> <%= localidad.get(i).getCodigoPostal() %> </td>
                         <td align="center"> <%= localidad.get(i).getNombreLocalidad() %> </td>
                         <td align="center"> <%= localidad.get(i).getProv().getNombreProvincia() %> </td>
                    </tr>
                <% } %> 
        </tbody>

</table>
</div>
</body>
</html>