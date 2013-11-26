<%-- 
    Document   : index
    Created on : 17/10/2013, 01:49:46 PM
    Author     : Edd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<% HttpSession sesion = request.getSession(); %>
<% String titulo_pagina = "Namiki"; %>
<!DOCTYPE html>
<html lang="es">
<head>
    <%@ include file="./inc/head.inc.html"%>
</head>
<body>
    <%
    if(sesion.getAttribute("usuario") == null) {
    %>
        <%@ include file="./inc/navbar-login.inc.jsp"%>
    <%
    } else {
    %>
        <%@ include file="./inc/navbar.inc.jsp"%>
    <%
    }
    %>
    

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container">
            <h1>Namiki</h1>
            <p>Uniendo ideas.</p>
            <!--p><a class="btn btn-primary btn-lg">Learn more &raquo;</a></p-->
        </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-lg-4">
          <h2>Problemático</h2>
          <p>Empresa o persona que tiene un problema o proyecto y busca a quién tenga la mejor solución a través de un sistema web </p>
         <!-- <p><a class="btn btn-default" href="#">View details &raquo;</a></p> -->
        </div>
        <div class="col-lg-4">
          <h2>Creativo</h2>
          <p>Personal de la facultad de ciencias, esto es: académicos, alumnos o ex-alumnos los cuales revisan los problemas y proponen una solución. </p>
         <!--  <p><a class="btn btn-default" href="#">View details &raquo;</a></p> -->
       </div>
        <div class="col-lg-4">
          <h2>Soluciones</h2>
          <p>Aporte elegido por el problemático.</p>
         <!-- <p><a class="btn btn-default" href="#">View details &raquo;</a></p> -->
        </div>
      </div>

        
    </div> <!-- /container -->
    
    <%@ include file="./inc/footer.inc.html"%>
    
    <%@ include file="./inc/scripts.inc.html"%>
</body>
</html>