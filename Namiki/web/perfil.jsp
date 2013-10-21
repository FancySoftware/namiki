<%-- 
    Document   : perfil
    Created on : 21/10/2013, 03:10:12 PM
    Author     : Edd
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<% HttpSession sesion = request.getSession(); %>
<%@ page import="controlador.Problema" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--<link rel="shortcut icon" href="../../assets/ico/favicon.png">-->

    <title>Namiki</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/theme-blue.css" rel="stylesheet">

    <style type="text/css">
        body {
                padding: 50px 0px 20px;
        }
    </style>
</head>
<body>
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Namiki</a>
            </div>
            <div class="navbar-collapse collapse">
                <form class="navbar-form navbar-right" action="Usuario" method="POST">
                    <input type="hidden" name="form_sumbitted" value="2">
                    <div class="form-group">
                        <input type="text" placeholder="Nombre de Usuario" class="form-control" name="usuario">
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="Password" class="form-control" name="password">
                    </div>
                    <button type="submit" class="btn btn-success">Entrar</button>
                    <a href="registrar.jsp" class="btn btn-success">Registrate</a>
                </form>
            </div><!--/.navbar-collapse -->
        </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-lg-6">
            <div class="panel panel-default">
                <div class="panel-heading">Mis Problemas</div>
                <div class="panel-body">
                    <% String id = (String) sesion.getAttribute("idusuario"); %>
                    <%= Problema.mostrarProblemasUsr(id) %>
                </div>
            </div>
        </div>
        <div class="col-lg-6">
          <h2>Creativo</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#">View details &raquo;</a></p>
       </div>
      </div>

      <hr>

        <footer>
          <p>Fac. Ciencas UNAM 2013</p>
        </footer>
    </div> <!-- /container -->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script type="text/javascript" scr="js/bootstrap.js"></script>
  </body>
</html>
