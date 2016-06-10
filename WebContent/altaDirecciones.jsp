<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="martin-facu" content="formulario de alta">
 	
 	<title>Alta de Direcciones</title>
 	
 	<!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/business-frontpage.css" rel="stylesheet">
     
     <script type="text/javascript">

     function validacion()  {
    	 
    	 valor = document.getElementById("campo_numerico").value;
    	 
    	 if (isNaN(valor)) 
         {   	
    		 alert("Error:\nEste campo debe tener sólo números.");
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
					<form name="formu" action="AltaDireccion" class="" method="POST" onSubmit="return validacion();">
                    <h2 class= "alinearh2"><strong>Registrar una Nueva Direccion </strong></h2>
                    <h2 class= "alinearh2"><small>Ingrese los datos para registrar un nuevo cami�n</small></h2><br>
                    <input name="calle" type="text"  class="form-control" placeholder="Calle" required autofocus><br>
                    <input name="nro" type="text"  class="form-control" placeholder="Numero" required autofocus><br>
                    <input name="dpto" type="text"  class="form-control" placeholder="Departamento"  autofocus><br>
                    <input name="piso" type="text" class="form-control" placeholder="Piso"  autofocus><br>
                    <input name="letra" type="text" class="form-control" placeholder="Letra"  autofocus><br>
                    <br>
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