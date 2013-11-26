<%--
    Document   : mostrarNotificacionesIH
    Created on : 24/11/2013, 02:55:37 PM
    Author     : Edd
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<% HttpSession sesion = request.getSession(); %>
<%@ page import="controlador.Notificacion" %>
<% String titulo_pagina = "Namiki | Notificaciones"; %>
<!DOCTYPE html>
<html>
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
                <li class="active">Notificaciones</li>
            </ul>
             <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h1>Problemas</h1>
                        </div>
                        <div class="panel-body">
                            <% 
                            Notificacion notificacion = new Notificacion(); 
                            System.out.println("????");
                            String[] mensajes = notificacion.desplegarMensaje((Integer)request.getAttribute("idusuario"));
                            System.out.println(mensajes == null);
                            for(int i = 0; i < mensajes.length; i++) {
                            %>
                            <div class="jumbotron">
                                <p><%= mensajes[i] %></p>
                            </div>
                            <%
                            }
                            %>
                        </div>
                    </div>
             </div>
        </div><!-- /container -->
        <%@ include file="./inc/footer.inc.html"%>

        <%@ include file="./inc/scripts.inc.html"%>
    </body>
</html>
