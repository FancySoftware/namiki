<%-- 
    Document   : mostrarProblemaIH
    Created on : 17/10/2013, 01:43:36 PM
    Author     : Edd
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<% HttpSession sesion = request.getSession(); %>
<%@ page import="controlador.Problema" %>
<% String titulo_pagina = "Namiki | Problemas"; %>

  <% if (request.getParameter("borrar") != null) {
      Problema.borrarProblema(Integer.parseInt(request.getParameter("borrar")));
      response.sendRedirect("perfil.jsp");
  }
  %>
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
        <div class="container">
            <ul class="breadcrumb">
                <li><a href="/index.jsp">Inicio</a></li>
                <li class="active">Problemas</li>
            </ul>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h1>Problemas</h1>
                        </div>
                        <div class="panel-body">
                        <%
                        if(request.getParameter("idproblema") == null) { 
                            String cat = (request.getParameter("cat") == null) ? "0" : request.getParameter("cat");
                            request.getParameter("idproblema");
                            Problema.mostrarProblemas(cat);
                        %>
                            <%= Problema.mostrarProblemas(cat) %>
                        <%
                        } else {
                            //obtener los datos del problema para agregar aportes
                        %>
                            <div class="jumbotron">
                            <h3>Título</h3>
                            <span class="label label-default">Tópico</span>
                            <span class="label label-info">Categorías</span>
                            <p>Intro descripción. Fulano Godínez ha seleccionado tu propuesta, y quiere ponerse en contacto contigo.</p>
                            <p>
                            <a class="btn btn-primary" href="../../components/#navbar">Leer más &raquo;</a>
                            </p>
                            </div>
                        <% }%>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- /container -->
        <%@ include file="./inc/footer.inc.html"%>

        <%@ include file="./inc/scripts.inc.html"%>
  </body>
</html>
