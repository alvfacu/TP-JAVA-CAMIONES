<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="martin-facu" content="formulario de alta">

 	 <title>Formulario de Alta</title>

 	  <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/business-frontpage.css" rel="stylesheet">
    
   <!--   <script src="js/jquery.js" type="text/javascript"></script>
	<script type="text/javascript">
    $(document).ready(function(){
        $(".dni").change(function(){
            var dni = $(this).val();
            if(dni.length >= 3){
                $(".statusdni").html("Checking availability");
                 $.ajax({
                    type: "GET",
                    url: "check",
                    data: "dni="+ dni,
                    success: function(msg){
    
                            $(".statusdni").html(msg);
                            if (msg = '<font color=red>PERSONA YA REGISTRADA, INGRESE UN DNI NUEVO</font>'){
                            	  $('#Enviar').attr("disabled", true);
                            	}
                            else  {$('#Enviar').attr("disabled", false	);}
   
                    }
                }); 
            }
            else{
                 
                $(".statusdni").html("<font color=red>Ingrese un dni de longitud mayor</font>");
                $('#Enviar').attr("disabled", true);
            }
            
        });
    });
        	 
        </script>
     
     <script type="text/javascript">

     function validacion()  {
    	 
    	 var p1 = document.getElementById("password").value;
    	 var p2 = document.getElementById("repetir").value;
    	 
    	 if (p1 != p2) {
    		  alert("Las passwords deben de coincidir");
    		  return false;
    		} else {
    		  return true; 
    		}
       }
     	</script>
-->
</head>

<body>

	<!-- Cointainer -->
	<div class="container">
		<hr>
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
					<!-- Form -->
					<form name="formu" action="AltaPersonal" class="" method="POST" onSubmit="return validacion();">

                    <h2 class= "alinearh2"><strong>Registrar nuevo Personal ~</strong></h2>
                    <h2 class= "alinearh2"><small>Ingrese los datos para registrar un nuevo personal</small></h2>
                    <br>
                    
                    <input name="nombre" type="text"  class="form-control" placeholder="Nombre" required autofocus>
                        <br>
                    <input name="apellido" type="text"  class="form-control" placeholder="Apellido" required autofocus>
                        <br>  
                    <input name="direccion" type="text"  class="form-control" placeholder="Direccion" required autofocus>
                        <br>
                    <input name="dni" type="text" class="form-control dni" placeholder="DNI"  autofocus>
                     <span class="statusdni"></span>
                        <br>
                    <input name="telefono" type="text"  class="form-control" placeholder="Telefono" required autofocus >
                        <br>                      
                    <input name="usuario" type="text"  class="form-control " placeholder="Usuario" required autofocus >
                        
                        <br>
                    <input id="password" name="password" type="password"  class="form-control" placeholder="Password" required autofocus >
                        <br>
                    <input id="repetir" name="repetir" type="password"  class="form-control" placeholder="Repetir password" required autofocus >
                        <br>
                    <label> Tipo de Personal </label>
                    <div class="row" align="center">                    	
                    	<div class="col-lg-3"><input type="radio" name="tipo" value="Administrador"> Administrador</div>
                        <div class="col-lg-3"><input type="radio" name="tipo" value="Camionero"> Camionero</div>
                        <div class="col-lg-3"><input type="radio" name="tipo" value="Operador"> Operador</div>
  					</div><br>
  					<label> Disponibilidad </label>
                    <div class="row" align="center">                    	
                    	<div class="col-lg-3"><input type="radio" id="dispo" name="disponibilidad" value="true"> Si</div>
                        <div class="col-lg-3"><input type="radio" id="dispo" name="disponibilidad" value="false"> No</div>
  					</div><br> 
                         <button class="btn btn-lg  btn-primary btn-block" type="submit" id="Enviar">Enviar</button><br>
                <!-- End Form --> 
  						</form></div>
                	
			</div>
			<div class="col-lg-3"></div>
		
	</div> <!-- End Cointainer -->

  	<!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>
</html>