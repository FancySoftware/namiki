<%-- 
    Document   : perfil
    Created on : 21/10/2013, 03:10:12 PM
    Author     : Edd
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<% HttpSession sesion = request.getSession(); %>
<%@ page import="controlador.Problema" %>
<%@ page import="controlador.Aporte" %>
<% String titulo_pagina = "Namiki | Perfil"; %>
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
            <li class="active">Perfil</li>
        </ul>
        <!-- Example row of columns -->
        <div class="row">
        <%
            String id = (String) sesion.getAttribute("idusuario");
            if(sesion.getAttribute("type") == null) {//Es problematico
        %>
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <p>Mis Problemas<a href="FormularioAporteProblemaIH.jsp?nuevo=1" class="btn btn-success pull-right">Agregar</a></p>
                    </div>
                    <div class="panel-body">
                        <table class="table">
                            <thead>
                              <tr>
                                  <th>ID Categoría</th>
                                  <th>ID idusuario</th>
                                  <th>titulo</th>
                                  <th>topico</th>
                                  <th>descripcion</th>
                                  <th>fecha</th>
                                  <th>Acciones</th>
                              </tr>
                            </thead>
                            <tbody>
                                <%= Problema.mostrarProblemasUsr(id) %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        <%
            } else { //Creativo
        %>
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <p>Mis Aportes</p>
                    </div>
                    <div class="panel-body">
                        <table class="table">
                            <thead>
                              <tr>
                                  <!--th>ID Problema</th-->
                                  <th>ID Usuario</th>
                                  <th>Solución</th>
                                  <th>Costo</th>
                                  <th>Fecha</th>
                                  <th>Contacto</th>
                                  <th>Elegido</th>
                                  <th>Acciones</th>
                              </tr>
                            </thead>
                            <tbody>
                                <%= Aporte.mostrarAportesUsr(new Integer(id)) %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        <%                
            }
        %>        
        </div>
    </div> <!-- /container -->
    <%@ include file="./inc/footer.inc.html"%>

    <%@ include file="./inc/scripts.inc.html"%>
    <script type="text/javascript">
        $(document).ready(function() {
            $(".borrar").click(function(event){
                event.preventDefault();
                if (confirm("Seguro que deseas borrar este problema?")){
                    window.location=$(this).attr("href");
                }              
                
            });
        });
        
    </script>
</body>
</html>
