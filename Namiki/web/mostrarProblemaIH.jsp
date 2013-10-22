<%-- 
    Document   : mostrarProblemaIH
    Created on : 17/10/2013, 01:43:36 PM
    Author     : Edd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="controlador.Problema" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Namiki | Notificaciones</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <!-- <link href="navbar.css" rel="stylesheet"> -->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

      <!-- Static navbar -->
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
      <table class="table">
          <thead>
            <tr>
                
                <th>ID Categoría</th>
                <th>ID idusuario</th>
                <th>titulo</th>
                <th>topico</th>
                <th>descripcion</th>
                <th>fecha</th>
                <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
              <%= Problema.mostrarProblemasUsr("1")%>
              
            
          </tbody>
      </table>
      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h3>Título</h3>
        <span class="label label-default">Tópico</span>
        <span class="label label-info">Categorías</span>
        <p>Intro descripción. Fulano Godínez ha seleccionado tu propuesta, y quiere ponerse en contacto contigo.</p>
        <p>
          <a class="btn btn-primary" href="../../components/#navbar">Leer más &raquo;</a>
        </p>
      </div>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
