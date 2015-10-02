<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#main-menu" aria-expanded="false">
                <span class="sr-only"><g:message code="default.toggleNavigation.label" /></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><g:message code="default.app.name" /> </a>
        </div>

        <div class="collapse navbar-collapse" id="main-menu">
            ${raw(body)}
        </div>
    </div>
</nav>