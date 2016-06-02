<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="capaEntidades.Camion" %>
<%@ page import="capaNegocio.ControladorCamion;" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <!--JQuery para la Tabla-->
    <script type="text/javascript" language="javascript" src="//code.jquery.com/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>
    <script type="text/javascript" language="javascript" src="js/bootstrap.js"> </script>

    <!--Hojas de Estilo para la tabla-->
    <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
    <title>Listado de Camiones</title>

    <script type="text/javascript" language="javascript" >
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
    <%@include file="nav-bar.jsp" %>
<div class="container" >
    
    <% ArrayList<Camion> camiones = new ControladorCamion().dameTodo();%>

    <table id="example" class="display" cellspacing="0" width="100%">
        
        <thead>
            <tr>
            <th> Patente </th>
            <th> Marca </th>
            <th> Modelo </th>
            <th> Descripcion </th>
            <th> Km Recorridos desde Mantenimiento </th>
            <th> Km Recorridos en viaje (kg) </th>
            <th> Estado </th>
            </tr>
        </thead>

         <tbody>
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
        </tbody>
        </table>
    
</div>
</body>
</html>