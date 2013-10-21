<%-- 
    Document   : registro
    Created on : 20/10/2013, 03:23:56 PM
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

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
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
      
      <form class="" style="max-width: 500px; margin: 0px auto;" action="Problema" method="POST">
        <h2 class="form-heading">Registra tu Problema(Solución)</h2>
        <input type="hidden" name="idProblema" value="<%= request.getParameter("idproblema") == null ? "" : request.getParameter("idproblema") %>">
        <input type="hidden" name="form_sumbitted" value="1">
        <input type="text" class="form-control" placeholder="Título del Poblema(Solución)" name="titulo">
        <input type="text" class="form-control" placeholder="Tópico" name="topico" value="<%= problema.getTopico() %>">
        <select class="form-control" name="categoria">
            <option value="0">Selecciona una categoria</option>
            <option value="1">Actuaría</option>
            <option value="2">Biología</option>
            <option value="3">Computación</option>
            <option value="4">Fisica</option>
            <option value="5">Matemáticas</option>
        </select>
        <textarea class="form-control" placeholder="Descripción" name="descripcion"></textarea>
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 50%; float: right; margin-top: 20px;">Registrar</button>
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>

