<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="martin-facu" content="formulario de alta">
 	
 	<title>Alta de Camión</title>
 	
 	<!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/business-frontpage.css" rel="stylesheet">
     
     <script type="text/javascript">

     function validacion()  {
    	 
    	 valor = document.getElementById("campo_numerico").value;
    	 
    	 if (isNaN(valor)) 
         {   	
    		 alert("Error:\nEste campo debe tener sÃ³lo nÃºmeros.");
    		 return (false);
    	 }
       }
     	</script>

</head>

<body>
	<%@page import="capaEntidades.Personal"%>
	<% if((Personal)session.getAttribute("Usuario")!=null){ %>
  	<%@include file="nav-bar.jsp" %>
<div class="container">
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
					<!-- Form -->
					<form name="formu" action="AltaCamion" class="" method="POST" onSubmit="return validacion();">
                    <h2 class= "alinearh2"><strong>Registrar un nuevo Camión </strong></h2>
                    <h2 class= "alinearh2"><small>Ingrese los datos para registrar un nuevo camión</small></h2><br>
                    <input name="patente" type="text"  class="form-control" placeholder="Patente" required autofocus><br>
                    <input name="marca" type="text"  class="form-control" placeholder="Marca" required autofocus><br>
                    <input name="modelo" type="text"  class="form-control" placeholder="Modelo" required autofocus><br>
                    <input name="descripcion" type="text" class="form-control" placeholder="Descripcion"  autofocus><br>
                    <input id="campo_numerico" name="kmRecorridosEnViaje" type="text"  class="form-control" placeholder="Kilometros Iniciales" required autofocus><br>
                    <input  type="text" class="form-control" placeholder="Kilometros Recorridos Desde Mantenimiento" required autofocus disabled><br>
                    <div class="row">
                    	<div class="col-lg-2"><input type="radio" name="estado" value="Disponible" checked> Disponible</div>
                        <div class="col-lg-3"><input type="radio" name="estado" value="No Disponible" disabled> No Disponible</div>
                        <div class="col-lg-3"><input type="radio" name="estado" value="Viajando" disabled> Viajando</div>
  					    <div class="col-lg-3"><input type="radio" name="estado" value="Mantenimiento" disabled> Mantenimiento</div>
  					</div><br>
                         <button class="btn btn-lg  btn-primary btn-block" type="submit">Enviar</button><br>
                	<!-- End Form --> 
  					</form>
  			</div>
          </div>
<div class="col-lg-3"></div>
</div> <!-- End Cointainer -->
  	<!-- jQuery -->
    <script src="js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	  <%} else{%>
	  <%@include file="error.html" %>
	  <%}%>
</body>
</html>