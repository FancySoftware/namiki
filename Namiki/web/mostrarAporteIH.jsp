<%-- 
    Document   : mostrarAporteIH
    Created on : 15/10/2013, 11:44:51 AM
    Author     : Edd
--%>
 <%@ page import="controlador.Aporte" %>
 <% if (request.getParameter("borrar") != null) {
      Aporte.borrarAporte(Integer.parseInt(request.getParameter("borrar")));
      response.sendRedirect("perfil.jsp");
  }
  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">

        <title>Namiki | Mis aportes</title>
    </head>
    <body>
             <tbody>
                 <%= Aporte.mostrarAportesUsr(Integer.parseInt(request.getParameter("idusuario")) %>
          </tbody>
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
