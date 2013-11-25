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
            <%@ include file="./inc/navbar.inc.jsp"%>
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
                        if(request.getParameter("idp") == null) { 
                        %>
                        <%= Problema.mostrarProblemas(request.getParameter("cat")) %>
                        <%
                        %>
                        <%
                        } else {
                            if(Problema.getDatos(Integer.parseInt(request.getParameter("idp")))) {
                        %>
                            <div class="jumbotron">
                                <h3><%= Problema.getTitulo() %></h3>
                            <span class="label label-default">Tópico</span>
                            <span class="label label-info"><%= Problema.getCategoria() %></span>
                            <p><%= Problema.getDescripcion() %></p>
                            <p>
                            <a class="btn btn-primary" href="#">Aportar</a>
                            </p>
                            </div>
                        <%
                            }
                        }%>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- /container -->
        <%@ include file="./inc/footer.inc.html"%>

        <%@ include file="./inc/scripts.inc.html"%>
  </body>
</html>
