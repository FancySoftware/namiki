<%-- 
    Document   : mostrarProblemaIH
    Created on : 17/10/2013, 01:43:36 PM
    Author     : Edd
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<% HttpSession sesion = request.getSession(); %>
<% String titulo_pagina = "Namiki | Aportes"; %>
<%@ page import="controlador.Aporte" %>
 <% if (request.getParameter("borrar") != null) {
      Aporte.borrarAporte(Integer.parseInt(request.getParameter("borrar")));
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
                <li class="active">Aportes</li>
            </ul>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h1>Aportes</h1>
                        </div>
                        <div class="panel-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Título</th>
                                        <th>Tópico</th>
                                        <th>Fecha del problema</th>
                                        <th>Solución</th>
                                        <th>Costo</th>
                                        <th>Fecha del aporte</th>
                                        <th>Contacto</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%= Aporte.mostrarAportesProblematico((String)sesion.getAttribute("idusuario")) %>
                                </tbody>
                            </table>
                       
                            
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- /container -->
        <%@ include file="./inc/footer.inc.html"%>

        <%@ include file="./inc/scripts.inc.html"%>
  </body>
</html>
