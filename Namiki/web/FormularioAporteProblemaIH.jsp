<%-- 
    Document   : FormularioAporteProblemaIH
    Created on : 17/10/2013, 01:45:55 PM
    Author     : Edd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Bienvenido a Namiki</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

      <form class="" style="max-width: 500px; margin: 0px auto;" action="Aporte" method="POST">
        <h2 class="form-heading">Registra tu Problema(Solución)</h2>
        <input type="text" class="form-control" placeholder="solucion">
        <input type="text" class="form-control" placeholder="costo"> 
        
        <select class="form-control">
         <option value="0">Selecciona una categoria</option>
            <option value="1">Actuaría</option>
            <option value="2">Biología</option>
            <option value="3">Computación</option>
            <option value="4">Fisica</option>
            <option value="5">Matemáticas</option>
        </select>
   
        <input type="text" class="form-control" placeholder="Email(contacto)" autofocus>
       
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 50%; float: right; margin-top: 20px;">Registrar</button>
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>

