<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="capaEntidades.Personal" %>
<%@ page import="capaNegocio.ControladorPersonal;" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
      <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-frontpage.css" rel="stylesheet">

<title>Listado del Personal</title>
</head>

<body>
<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">SYSCAM</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    /* 	private String dni;
	private String nombre;
	private String apellido;
	private int telefono;
	private String direccion;	
	private String usuario;
	private String password;
	private boolean disponibilidad;
	private Tipo tipo;	*/
	
<div class="container">
<h2>Personal ~<small>Listado del Personal</small></h2>    
    <% ArrayList<Personal> personal = new ControladorPersonal().dameTodo();%>

<table class="table table-hover table-responsive table-bordered" >
 <tr class="active" style="font-weight: bold;">
  	<td> Dni </td>
  	<td> Usuario </td>
  	<td> Nombre </td>
  	<td> Apellido </td>
  	<td> Telefono </td>
  	<td> Direccion </td>
  	<td> Disponibilidad </td>
  	<td> Tipo </td>

  	
 </tr>
 <% for(int i=0; i<personal.size();i++) { %>
  <tr>
        <td align="center"> <%= personal.get(i).getDni() %> </td>
 		<td align="center"> <%= personal.get(i).getUsuario() %> </td>
 		<td align="center"> <%= personal.get(i).getNombre() %> </td>
 		<td align="center"> <%= personal.get(i).getApellido() %> </td>
 		<td align="center"> <%= personal.get(i).getTelefono() %> </td>
 		<td align="center"> <%= personal.get(i).getDireccion() %> </td>
 		<td align="center"> <%= personal.get(i).getDisponibilidad() %> </td>
 		<td align="center"> <%= personal.get(i).getTipo() %> </td>
 	
  </tr>
 <% } %> 
</table>
<br>
</div>

 <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
