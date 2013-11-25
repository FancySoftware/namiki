<%-- 
    Document   : seleccionarSolucion
    Created on : Nov 25, 2013, 12:28:07 AM
    Author     : snyder
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="controlador.Aporte" %>
<%@page import= "controlador.Notificacion"%>
<% HttpSession sesion = request.getSession(); %>
<%
    if(sesion.getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp");
    }
    Aporte.setSolucion(request.getParameter("idproblema"),request.getParameter("idaporte")); 
    %>
    
    <%
    // ENVIANDO CORREO
    Notificacion notificacion = new Notificacion();
    String correo = Notificacion.getDatos(request.getParameter("idaporte"));
    notificacion.setEmail(correo);
    notificacion.enviarCorreo();
    
    response.sendRedirect("mostrarProblemaIH.jsp?idproblema="+request.getParameter("idproblema"));
%>