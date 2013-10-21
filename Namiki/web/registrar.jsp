<%-- 
    Document   : registrar
    Created on : 21/10/2013, 02:25:48 PM
    Author     : Edd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
      <form class="form-horizontal" style="max-width: 500px; margin: 0px auto;" action="Usuario" method="POST">
        <h2 class="form-heading">Registrate!</h2>
        <input type="hidden" name="form_sumbitted" value="1">
        <div class="form-group control-group">
            <label for="usuario_registro" class="col-lg-3 control-label">Usuario</label>
            <div class="col-lg-9 controls">
                <input type="text" class="form-control" id="usuario_registro" required="" name="usuario" placeholder="Usuario" data-validation-username-message="No es un usuario válido">
                <p class="help-block"></p>
            </div>
        </div>
        <div class="form-group control-group">
            <label for="password_registro" class="col-lg-3 control-label">Contraseña</label>
            <div class="col-lg-9 controls">
                <input type="password" class="form-control" id="password_registro" required="" placeholder="contraseña" name="password">
                <p class="help-block"></p>
            </div>
        </div>
        <div class="form-group control-group">
            <label for="password2_registro" class="col-lg-3 control-label">Repetir Contraseña</label>
            <div class="col-lg-9 controls">
                <input type="password" class="form-control" id="password2_registro" required="" placeholder="repetir contraseña" name="pass">
                <p class="help-block"></p>
            </div>
        </div>
        <div class="form-group control-group">
            <label for="email_registro" class="col-lg-3 control-label">Correo</label>
            <div class="col-lg-9 controls">
                <input type="text" class="form-control" id="email_registro" required="" placeholder="email" name="correo">
                <p class="help-block"></p>
            </div>
        </div>
        <div class="form-group control-group">
            <label for="nombre_registro" class="col-lg-3 control-label">Nombre</label>
            <div class="col-lg-9 controls">
                <input type="text" class="form-control" id="nombre_registro" required="" placeholder="nombre" name="nombre">
                <p class="help-block"></p>
            </div>
        </div>
        <div class="form-group control-group">
            <label for="telefono_registro" class="col-lg-3 control-label">Teléfono</label>
            <div class="col-lg-9 controls">
                <input type="text" class="form-control" id="telefono_registro" required="" placeholder="telefono" name="telefono">
                <p class="help-block"></p>
            </div>
        </div>
        <div class="form-group control-group">
            <label for="categoria_registro" class="col-lg-3 control-label">Carrera</label>
            <div class="col-lg-9 controls">
                <select class="form-control" name="categoria" id="categoria_registro">
                    <option value="">Selecciona tu carrera</option>
                    <option value="0">Ninguna</option>
                    <option value="1">Actuaría</option>
                    <option value="2">Biología</option>
                    <option value="3">Computación</option>
                    <option value="4">Fisica</option>
                    <option value="5">Matemáticas</option>
                </select>
            </div>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 50%; float: right; margin-top: 20px;">Registrar</button>
        <div class="clearfix"></div>
      </form>

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
