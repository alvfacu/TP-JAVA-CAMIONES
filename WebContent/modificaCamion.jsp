<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="capaEntidades.Camion" %>
<%@ page import="capaNegocio.ControladorCamion" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <!--JQuery para la Tabla-->
    <script type="text/javascript" 	src="//code.jquery.com/jquery-1.12.3.min.js"></script>
    <script type="text/javascript"  src="js/jquery.dataTables.js"></script>
    <script type="text/javascript"  src="js/bootstrap.js"> </script>

    <!--Hojas de Estilo para la tabla-->
    <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
    <title>Listado de Camiones</title>

    <script type="text/javascript"  >
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
  	<%@include file="nav-bar.jsp" %>
<div class="container" >

<div>
 
  <% Camion camion = 
  (Camion)request.getAttribute("recupera"); %>
   <form name="formu" action="ModificaCamion" class="" method="POST" >

                    <h2 class= "alinearh2"><strong>Modificar un Camión </strong></h2>
                    <h2 class= "alinearh2"><small>Ingrese los datos para Modificar un nuevo camión</small></h2>
                    <br>
                    
                    <input name="patente" type="text"  class="form-control" placeholder="Patente" value="" required autofocus>
                        <br>
                    <input name="marca" type="text"  class="form-control" placeholder="Marca" required autofocus>
                        <br>  
                    <input name="modelo" type="text"  class="form-control" placeholder="Modelo" required autofocus>
                        <br>
                    <input name="descripcion" type="text" class="form-control" placeholder="Descripcion"  autofocus>
                        <br>
                    <input id="campo_numerico" name="kmRecorridosEnViaje" type="text"  class="form-control" placeholder="Kilometros Iniciales" required autofocus >
                        <br>
                    <input  type="text" class="form-control" placeholder="Kilometros Recorridos Desde Mantenimiento" required autofocus disabled>
                        <br>                    
                      <div class="row">
                    	<div class="col-lg-2"><input type="radio" name="estado" value="Disponible" checked> Disponible</div>
                        <div class="col-lg-3"><input type="radio" name="estado" value="No Disponible" > No Disponible</div>
                        <div class="col-lg-3"><input type="radio" name="estado" value="Viajando" > Viajando</div>
  					    <div class="col-lg-3"><input type="radio" name="estado" value="Mantenimiento" > Mantenimiento</div>
  					</div><br>
                         <button class="btn btn-lg  btn-primary btn-block" type="submit">Enviar</button><br>
                <!-- End Form --> 
  						</form></div>
</div>      
 <%} else{%>
	  <%@include file="error.html" %>
	  <%}%>
</body>
</html>






