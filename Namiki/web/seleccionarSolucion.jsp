<%-- 
    Document   : seleccionarSolucion
    Created on : Nov 25, 2013, 12:28:07 AM
    Author     : snyder
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="controlador.Aporte" %>
<% HttpSession sesion = request.getSession(); %>
<%
    if(sesion.getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp");
    }
    Aporte.setSolucion(request.getParameter("idproblema"),request.getParameter("idaporte")); 
    response.sendRedirect("mostrarProblemaIH.jsp?idproblema="+request.getParameter("idproblema"));
%>