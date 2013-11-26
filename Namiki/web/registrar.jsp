<%-- 
    Document   : registrar
    Created on : 21/10/2013, 02:25:48 PM
    Author     : Edd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<% HttpSession sesion = request.getSession(); %>
<% String titulo_pagina = "Namiki | Registrate"; %>
<!DOCTYPE html>
<html lang="es">
<head>
    <%@ include file="./inc/head.inc.html"%>
</head>
<body>
    <%
    if(sesion.getAttribute("usuario") == null) {
    %>
        <%@ include file="./inc/navbar-login.inc.html"%>
    <%
    } else {
    %>
        <%@ include file="./inc/navbar.inc.html"%>
    <%
    }
    %>

    <div class="container">
        <form class="form-horizontal" style="max-width: 500px; margin: 0px auto;" action="Usuario" method="POST">
            <h2 class="form-heading">Registrate!</h2>
            <%
            if(request.getAttribute("errorMessage") != null) {
            %>
            <div class="form-group control-group alert alert-danger"> 
                ${errorMessage}
            </div>
            <%
            }
            %>
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
                        <option value="">Selecciona tu carrera (Ninguna para problematico)</option>
                        <option value="0">Ninguna</option>
                        <option value="1">Actuaría</option>
                        <option value="2">Biología</option>
                        <option value="3">Computación</option>
                        <option value="4">Física</option>
                        <option value="5">Matemáticas</option>
                    </select>
                </div>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 50%; float: right; margin-top: 20px;">Registrar</button>
            <div class="clearfix"></div>
        </form>
        
    </div> <!-- /container -->
    
    <%@ include file="./inc/footer.inc.html"%>
    
    <%@ include file="./inc/scripts.inc.html"%>
</body>
</html>
