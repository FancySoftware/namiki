<div class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp">Namiki</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-cog"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="perfil.jsp">Perfil</a></li>
                                <%
                                if(sesion.getAttribute("type") == null) {
                                %>
                                    <li id="navbar-mostrar-aporte"><a href="mostrarAporteIH.jsp">Aportes</a></li>
                                <%
                                } else {
                                %>
                                    <li id="navbar-mostrar-problema"><a href="mostrarProblemaIH.jsp">Problemas</a></li>
                                <%
                                }
                                %>
                                <li><a href="mostrarNotificacionIH.jsp">Notificaciones</a></li>
                                <li class="divider"></li>
                                <li><a href="logout.jsp">Salir</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!--/.navbar-collapse -->
            </div>
        </div>