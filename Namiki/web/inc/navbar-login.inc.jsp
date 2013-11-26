<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Namiki</a>
        </div>
        <div class="navbar-collapse collapse">
            <form class="navbar-form navbar-right" action="Usuario" method="POST">
                <%
                if(request.getAttribute("errorMessage") != null) {
                %>
                <div class="form-group alert alert-danger">
                    ${errorMessage}
                </div>
                <%
                }
                %>
                <input type="hidden" name="form_sumbitted" value="2">
                <div class="form-group">
                    <input type="text" placeholder="Nombre de Usuario" class="form-control" name="usuario">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Password" class="form-control" name="password">
                </div>
                <button type="submit" class="btn btn-success">Entrar</button>
                <a href="registrar.jsp" class="btn btn-success">Registrate</a>
            </form>
        </div><!--/.navbar-collapse -->
    </div>
</div>
