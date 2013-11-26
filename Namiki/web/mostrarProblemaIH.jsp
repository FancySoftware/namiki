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
      request.setAttribute("successMessage", "Problema borrado!");
      request.getRequestDispatcher("/perfil.jsp").forward(request, response);
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
                <li><a href="index.jsp">Inicio</a></li>
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
                            if(request.getAttribute("successMessage") != null) {
                        %>
                            <div class="alert alert-success">${successMessage}</div>
                        <%
                            } else {
                                System.err.println("request.getA(succesmessage) == null:-");
                            }
                        %>
                        <%= Problema.mostrarProblemas(session.getAttribute("type").toString()) %>
                        <%
                        } else {
                            Problema.getDatos(Integer.parseInt(request.getParameter("idproblema")));
                        %>
                            <div class="jumbotron">
                            <h3><%= Problema.getTitulo() %></h3>
                            <span class="label label-default"><%= Problema.getTopico() %></span>
                            <span class="label label-info"><%= Problema.getidCategoria() %></span>
                            <p><%= Problema.getDescripcion() %></p>
                            <%
                            if(session.getAttribute("type")!=null) {
                            %>
                            <p>
                            <a class="btn btn-primary" href="FormularioAporteProblemaIH.jsp?nuevo=2&idproblema=<%= Problema.getidProblema() %>">Relizar un aporte &raquo;</a>
                            </p>
                            <%
                            }
                            %>
                            </div>
                            <div class="jumbotron">
                            <h3>Aportes</h3>
                            <%= Problema.mostrarAportes(request.getParameter("idproblema"),Integer.parseInt((String)sesion.getAttribute("idusuario"))) %>                            </div>
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
