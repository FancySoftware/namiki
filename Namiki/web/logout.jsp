<%-- 
    Document   : logout
    Created on : 22/10/2013, 10:27:11 AM
    Author     : Edd
--%>
<%@ page import="controlador.Usuario" %>
<%@ page session="true" %>
<% HttpSession sesion = request.getSession(); %>
<%
Usuario usuario_c = new Usuario();
usuario_c.cerrarSistema();
sesion.invalidate();
response.sendRedirect("index.jsp");
%>
