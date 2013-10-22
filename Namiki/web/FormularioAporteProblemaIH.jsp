<%-- 
    Document   : FormularioAporteProblemaIH
    Created on : 17/10/2013, 01:45:55 PM
    Author     : Edd
--%>

<%@ page import="java.util.Map"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<% HttpSession sesion = request.getSession(); %>
<%@ page import="controlador.Problema" %>
<%@ page import="controlador.Aporte" %>
<% String titulo_pagina = "Namiki"; %>
<!DOCTYPE html>
<html lang="es">
<head>
    <%@ include file="./inc/head.inc.html"%>
</head>

<body>
    <%
    if(sesion.getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp");
    } else {
    %>
        <%@ include file="./inc/navbar.inc.html"%>
    <%
    }
    %>
    <%
    int tipo_pagina = -1;
    if(request.getParameter("nuevo") == null && request.getParameter("idproblema") == null && request.getParameter("idaporte") == null) {
        response.sendRedirect("perfil.jsp");
    } else {
        if(request.getParameter("nuevo") != null && Integer.parseInt(request.getParameter("nuevo")) == 1) {
            tipo_pagina = 1; //Nuevo problema
        } else if(request.getParameter("nuevo") != null && Integer.parseInt(request.getParameter("nuevo")) == 2) {
            tipo_pagina = 2; // Nuevo aporte
        } else if(request.getParameter("idproblema") != null) {
            tipo_pagina = 3; // Editar problema
        } else if(request.getParameter("idaporte") != null) {
            tipo_pagina = 4; // Editar problema
        }
        System.err.println(tipo_pagina+" = tipo pagina");
    }
    String accion = (tipo_pagina == 1 || tipo_pagina == 3) ? "Problema" : "Usuario";
    Problema.getDatos(Integer.parseInt(request.getParameter("idproblema")));
    %>
    <div class="container">
        <form class="form-horizontal" style="max-width: 500px; margin: 0px auto;" action="Problema" method="POST">
            <h2 class="form-heading">Nuevo Problema</h2>
            <input type="hidden" name="idUsuario" value="<%= sesion.getAttribute("idusuario") %>">
            <input type="hidden" name="idProblema" value="<%= request.getParameter("idproblema") == null ? "" : request.getParameter("idproblema") %>">
            <input type="hidden" name="form_sumbitted" value="1">
            <div class="form-group control-group">
                <label for="titulo_form" class="col-lg-3 control-label">Título</label>
                <div class="col-lg-9 controls">
                    <input type="text" class="form-control" id="titulo_form" required="" name="titulo" placeholder="Título" data-validation-username-message="No es un usuario válido">
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="form-group control-group">
                <label for="topico_form" class="col-lg-3 control-label">Tópico</label>
                <div class="col-lg-9 controls">
                    <input type="text" class="form-control" id="topico_form" required="" placeholder="Tópico" name="topico">
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="form-group control-group">
                <label for="categoria_form" class="col-lg-3 control-label">Área</label>
                <div class="col-lg-9 controls">
                    <select class="form-control" name="categoria" id="categoria_form">
                        <option value="">Selecciona el área</option>
                        <option value="1">Actuaría</option>
                        <option value="2">Biología</option>
                        <option value="3">Computación</option>
                        <option value="4">Fisica</option>
                        <option value="5">Matemáticas</option>
                    </select>
                </div>
            </div>
            <div class="form-group control-group">
                <label for="descripcion_form" class="col-lg-3 control-label">Descripción</label>
                <div class="col-lg-9 controls">
                    <textarea class="form-control" id="descripcion_form" required="" placeholder="Descripción" name="descripcion"></textarea>
                    <p class="help-block"></p>
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

