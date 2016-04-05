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

<title>Listado de Camiones</title>
</head>

<body>
<div class="container">
<div class="row">
  <div class="col-md-3"></div>
  <div class="col-md-6">
  <h2>Alta Camión<br><small>Cargar un nuevo Camión, introduzca los datos</small></h2>
<!--  Declaracion del formulario -->
				<form action="AltaCamion" class="form-group" method="POST">
                    <input name="patente" type="text" id="patente" class="form-control" placeholder="Patente" required autofocus>
                    <br>
                    <input name="marca" type="text" id="marca" class="form-control" placeholder="Marca" required autofocus>
                    <br> 
                    <input name="modelo" type="text" id="modelo" class="form-control" placeholder="Modelo" required autofocus> 
                    <br> 
                     <input name="descripcion" type="text" id="descripcion" class="form-control" placeholder="Descripcion" required autofocus> 
                    <br> 
                 	<input name="estado" type="text" id="estado" class="form-control" placeholder="Estado" required autofocus> 
                 	<br> 
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button><br>
                </form> 
<!--  Fin del formulario -->

</div>
<div class="col-md-3"></div>

</div>
</div>

 <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>