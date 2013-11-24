<%-- 
    Document   : FormularioAporteProblemaIH
    Created on : 17/10/2013, 01:45:55 PM
    Author     : Edd
--%>

<%@ page import="java.net.URLEncoder"%>
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
    int value_form = -1;
    String titulo = "";
    String topico = "";
    String descripcion = "";
    String solucion = "";
    String contacto = "";
    String costo = "";
    if(request.getParameter("nuevo") == null && request.getParameter("idproblema") == null && request.getParameter("idaporte") == null) {
        System.err.println("NULLLLLL");
        response.sendRedirect("perfil.jsp");
       
    } else {
        if(request.getParameter("nuevo") != null && Integer.parseInt(request.getParameter("nuevo")) == 1) {
            tipo_pagina = 1; //Nuevo problema
            value_form = 1;
        } else if(request.getParameter("nuevo") != null && Integer.parseInt(request.getParameter("nuevo")) == 2) {
            tipo_pagina = 2; // Nuevo aporte
            value_form = 1;
        } else if(request.getParameter("idproblema") != null) {
            tipo_pagina = 3; // Editar problema
            value_form = 2;
            if(!Problema.getDatos(Integer.parseInt(request.getParameter("idproblema")))) {
                response.sendRedirect("index.jsp");
            } else {
                titulo = Problema.getTitulo();
                topico = Problema.getTopico();
                descripcion = Problema.getDescripcion();
                
            }
        } else if(request.getParameter("idaporte") != null) {
            tipo_pagina = 4; // Editar aporte
            value_form = 2;
            if(!Aporte.getDatos(Integer.parseInt(request.getParameter("idaporte")))){
                response.sendRedirect("index.jsp");
            } else{
                solucion = Aporte.getSolucion(); 
                costo  = Aporte.getCosto();
                contacto = Aporte.getContacto();
            }
        }
        System.err.println(tipo_pagina+" = tipo pagina");
    }
    String accion = (tipo_pagina == 1 || tipo_pagina == 3) ? "action=\"Problema\"" : "action=\"Aporte\"";
    %>
    <div class="container">
        <form class="form-horizontal" style="max-width: 500px; margin: 0px auto;" <%= accion %> method="POST">
            <h2 class="form-heading"><%= (tipo_pagina == 1 || tipo_pagina == 2) ? "Nuevo " : "Editar " %><%= (tipo_pagina == 1 || tipo_pagina == 3) ? "Problema" : "Aporte" %></h2>
            <input type="hidden" name="idusuario" value="<%= sesion.getAttribute("id_usuario") %>">
            <%System.out.println("EL ID ES " + Integer.parseInt((String)sesion.getAttribute("idusuario")));
            Problema.setidUsuario(Integer.parseInt((String)sesion.getAttribute("idusuario")));
            Aporte.setidUsuario(Integer.parseInt((String)sesion.getAttribute("idusuario")));
            System.out.println("EL ID ES " + Aporte.idUsuario);
            %>
            <input type="hidden" name="idProblema" value="<%= request.getParameter("idproblema") == null ? "" : request.getParameter("idproblema") %>">
            <input type="hidden" name="idAporte" value="<%= request.getParameter("idaporte") == null ? "" : request.getParameter("idaporte") %>">
            <input type="hidden" name="form_sumbitted" value="<%= value_form %>">
            <%
            if(tipo_pagina == 1 || tipo_pagina == 3) {
            %>
            <div class="form-group control-group">
                <label for="titulo_form" class="col-lg-3 control-label">Título</label>
                <div class="col-lg-9 controls">
                    <input type="text" class="form-control" id="titulo_form" required="" name="titulo" placeholder="Título" value="<%= titulo %>">
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="form-group control-group">
                <label for="topico_form" class="col-lg-3 control-label">Tópico</label>
                <div class="col-lg-9 controls">
                    <input type="text" class="form-control" id="topico_form" required="" placeholder="Tópico" name="topico" value="<%= topico %>">
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="form-group control-group">
                <label for="categoria_form" class="col-lg-3 control-label">Área</label>
                <div class="col-lg-9 controls">
                    <select class="form-control" name="categoria" id="categoria_form">
                        <option value="">Selecciona el área</option>
                        <option value="1" <%= (Problema.getidCategoria() == 1) ? "selected" : "" %>>Actuaría</option>
                        <option value="2" <%= (Problema.getidCategoria() == 2) ? "selected" : "" %>>Biología</option>
                        <option value="3" <%= (Problema.getidCategoria() == 3) ? "selected" : "" %>>Computación</option>
                        <option value="4" <%= (Problema.getidCategoria() == 4) ? "selected" : "" %>>Fisica</option>
                        <option value="5" <%= (Problema.getidCategoria() == 5) ? "selected" : "" %>>Matemáticas</option>
                    </select>
                </div>
            </div>
            <div class="form-group control-group">
                <label for="descripcion_form" class="col-lg-3 control-label">Descripción</label>
                <div class="col-lg-9 controls">
                    <textarea class="form-control" id="descripcion_form" required="" placeholder="Descripción" name="descripcion" ><%= descripcion %></textarea>
                    <p class="help-block"></p>
                </div>
            </div>
            <%
            } else {
            %>
            <div class="form-group control-group">
                <label for="solucion_form" class="col-lg-3 control-label">Solución</label>
                <div class="col-lg-9 controls">
                    <textarea class="form-control" id="solucion_form" required="" placeholder="Solución" name="solucion"><%= solucion %></textarea>
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="form-group control-group">
                <label for="costo_form" class="col-lg-3 control-label">Costo</label>
                <div class="col-lg-9 controls">
                    <input type="text" class="form-control" id="costo_form" required="" placeholder="Costo" name="costo" value="<%= costo %>">
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="form-group control-group">
                <label for="contacto_form" class="col-lg-3 control-label">Contacto</label>
                <div class="col-lg-9 controls">
                    <textarea class="form-control" id="contacto_form" required="" placeholder="Contacto" name="contacto"><%= contacto %></textarea>
                    <p class="help-block"></p>
                </div>
            </div>        
            <%    
            }
            %>
            
            <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 50%; float: right; margin-top: 20px;"><%= (tipo_pagina == 1 || tipo_pagina == 2) ? "Registrar" : "Editar" %></button>
            <div class="clearfix"></div>
        </form>
    </div> <!-- /container -->
    <%@ include file="./inc/footer.inc.html"%>

    <%@ include file="./inc/scripts.inc.html"%>
</body>
</html>

