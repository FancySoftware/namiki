<%-- 
    Document   : perfil
    Created on : 21/10/2013, 03:10:12 PM
    Author     : Edd
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<% HttpSession sesion = request.getSession(); %>
<%@ page import="controlador.Problema" %>
<%@ page import="controlador.Aporte" %>
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
        <ul class="breadcrumb">
            <li><a href="/index.jsp">Inicio</a></li>
            <li class="active">Perfil</li>
        </ul>
        <!-- Example row of columns -->
        <div class="row">
        <%
            String id = (String) sesion.getAttribute("idusuario");
            if(sesion.getAttribute("type") == null) {//Es problematico
        %>
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">Mis Problemas</div>
                    <div class="panel-body">
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
                                <%= Problema.mostrarProblemasUsr(id) %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        <%
            } else { //Creativo
        %>
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">Mis Aportes</div>
                    <div class="panel-body">
                        <table class="table">
                            <thead>
                              <tr>
                                  <th>ID Problema</th>
                                  <th>ID Usuario</th>
                                  <th>Solución</th>
                                  <th>Costo</th>
                                  <th>Fecha</th>
                                  <th>Contacto</th>
                                  <th>Elegido</th>
                                  <th>Acciones</th>
                              </tr>
                            </thead>
                            <tbody>
                                <%= Aporte.mostrarAportesUsr(new Integer(id)) %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        <%                
            }
        %>        
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
