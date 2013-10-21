<%-- 
    Document   : registro_usuario
    Created on : 20/10/2013, 03:59:26 PM
    Author     : Edd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Bienvenido a Namiki</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

      <div class="navbar navbar-default">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Namiki</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Problemas</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-cog"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Perfil</a></li>
                <li><a href="#">Mis Aportes</a></li>
                <li><a href="#">Mis Problemas</a></li>
                <li><a href="#">Notificaciones</a></li>
                <li class="divider"></li>
<!--                 <li class="dropdown-header">Nav header</li>
 -->                <li><a href="#">Salir</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>

      <form class="" style="max-width: 500px; margin: 0px auto;" action="Usuario" method="POST">
        <h2 class="form-heading">Registrate!</h2>
        <input type="hidden" name="form_sumbitted" value="1">
        <input type="text" class="form-control" placeholder="nombre de usuario" name="usuario">
        <input type="password" class="form-control" placeholder="password" name="password">
        <input type="password" class="form-control" plaholder="password again!" name="pass2">
        <input type="text" class="form-control" placeholder="email" name="correo">
        <input type="text" class="form-control" placeholder="nombre" name="nombre">
        <input type="text" class="form-control" placeholder="telefono" name="telefono">
        <select class="form-control" name="categoria">
            <option value=""></option>
            <option value="1">Actuaría</option>
            <option value="2">Biología</option>
            <option value="3">Computación</option>
            <option value="4">Fisica</option>
            <option value="5">Matemáticas</option>
        </select>
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 50%; float: right; margin-top: 20px;">Registrar</button>
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
