package themerize

import org.springframework.web.servlet.support.RequestContextUtils as RCU

class PageItemsTagLib extends AbstractTaglib {

    /**
     * Adiciona os recursos de CSS e Javascript à página
     */
    def resources = { attrs, body ->
        def template = getTemplatePath('resources/resources')
        out << render(template: template.path, model: [body: body], plugin: template.plugin)
    }


    /**
     * Define o que será exibido nos breadcrumbs
     */
    def breadcrumbs = { attrs, body ->
        def template = getTemplatePath('breadcrumbs/breadcrumbs')
        out << render(template: template.path, model: [body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um item de breadcrumb
     */
    def breadcrumbItem = {attrs, body ->
        def template = getTemplatePath('breadcrumbs/breadcrumbItem')
        out << render(template: template.path, model: [conteudo: body()], plugin: template.plugin)
    }

    /**
     * Renderiza o submenu
     */
    def submenu = { attrs, body ->
        def template = getTemplatePath('submenus/submenu')
        out << render(template: template.path, model: [body: body()], plugin: template.plugin)
    }

    /**
     * Renderiza um item do submenu
     *
     * @attr position Define a posição do item no submenu.<br> Valores possíveis: left, right. <br>Default: left
     */
    def submenuItem = { attrs, body ->
        def template = getTemplatePath('submenus/submenuItem')
        attrs.position = attrs.position ?: 'left'
        out << render(template: template.path, model: [body: body(), position: attrs.position], plugin: template.plugin)
    }

    /**
     * Renderiza uma barra lateral
     */
    def sidebar = { attrs, body ->
        def template = getTemplatePath('sidebar/sidebar')
        out << render(template: template.path, model: [body: body()], plugin: template.plugin)
    }

    /**
     * Renderiza um item da barra lateral
     *
     * @attr title Título para ser exibido no quadro
     */
    def sidebarItem = { attrs, body ->
        def template = getTemplatePath('sidebar/sidebarItem')
        out << render(template: template.path, model: [body: body(), title: attrs.title], plugin: template.plugin)
    }

    /**
     * Renders a sortable column to support sorting in list views.<br/>
     *
     * Attribute title or titleKey is required. When both attributes are specified then titleKey takes precedence,
     * resulting in the title caption to be resolved against the message source. In case when the message could
     * not be resolved, the title will be used as title caption.<br/>
     *
     * Examples:<br/>
     *
     * &lt;g:sortableColumn property="title" title="Title" /&gt;<br/>
     * &lt;g:sortableColumn property="title" title="Title" style="width: 200px" /&gt;<br/>
     * &lt;g:sortableColumn property="title" titleKey="book.title" /&gt;<br/>
     * &lt;g:sortableColumn property="releaseDate" defaultOrder="desc" title="Release Date" /&gt;<br/>
     * &lt;g:sortableColumn property="releaseDate" defaultOrder="desc" title="Release Date" titleKey="book.releaseDate" /&gt;<br/>
     *
     * @emptyTag
     *
     * @attr property - name of the property relating to the field
     * @attr defaultOrder default order for the property; choose between asc (default if not provided) and desc
     * @attr title title caption for the column
     * @attr titleKey title key to use for the column, resolved against the message source
     * @attr params a map containing request parameters
     * @attr action the name of the action to use in the link, if not specified the list action will be linked
     * @attr namespace controller namespace (optional)
     * @attr params A map containing URL query parameters
     * @attr class CSS class name
     */
    def sortableColumn = { attrs, body ->
        def template = getTemplatePath('sortableColumn/sortableColumn')
        def texto = g.sortableColumn(attrs, body)
        texto = texto.split("href=\"")[1]
        def link = texto.split("\"")[0]
        def title = texto.split(">")[1].split("<")[0]

        out << render(template: template.path, model: [attrs: attrs, link: link, title: title], plugin: template.plugin)
    }

    /**
     * Creates next/previous links to support pagination for the current controller.<br/>
     *
     * &lt;g:paginate total="${Account.count()}" /&gt;<br/>
     *
     * @emptyTag
     *
     * @attr total REQUIRED The total number of results to paginate
     * @attr action the name of the action to use in the link, if not specified the default action will be linked
     * @attr controller the name of the controller to use in the link, if not specified the current controller will be linked
     * @attr id The id to use in the link
     * @attr params A map containing request parameters
     * @attr prev The text to display for the previous link (defaults to "Previous" as defined by default.paginate.prev property in I18n messages.properties)
     * @attr next The text to display for the next link (defaults to "Next" as defined by default.paginate.next property in I18n messages.properties)
     * @attr max The number of records displayed per page (defaults to 10). Used ONLY if params.max is empty
     * @attr maxsteps The number of steps displayed for pagination (defaults to 10). Used ONLY if params.maxsteps is empty
     * @attr offset Used only if params.offset is empty
     * @attr fragment The link fragment (often called anchor tag) to use
     */
    def paginate = { attrs ->
        def writer = out
        if (attrs.total == null) {
            throwTagError("Tag [paginate] is missing required attribute [total]")
        }
        def messageSource = grailsAttributes.messageSource
        def locale = RCU.getLocale(request)

        def total = attrs.int('total') ?: 0
        def action = (attrs.action ? attrs.action : (params.action ? params.action : "index"))
        def offset = params.int('offset') ?: 0
        def max = params.int('max')
        def maxsteps = (attrs.int('maxsteps') ?: 10)

        if (!offset) offset = (attrs.int('offset') ?: 0)
        if (!max) max = (attrs.int('max') ?: 10)

        def linkParams = [:]
        if (attrs.params) linkParams.putAll(attrs.params)
        linkParams.offset = offset - max
        linkParams.max = max
        if (params.sort) linkParams.sort = params.sort
        if (params.order) linkParams.order = params.order

        def linkTagAttrs = [action:action]
        if (attrs.namespace) {
            linkTagAttrs.namespace = attrs.namespace
        }
        if (attrs.controller) {
            linkTagAttrs.controller = attrs.controller
        }
        if (attrs.id != null) {
            linkTagAttrs.id = attrs.id
        }
        if (attrs.fragment != null) {
            linkTagAttrs.fragment = attrs.fragment
        }
        //add the mapping attribute if present
        if (attrs.mapping) {
            linkTagAttrs.mapping = attrs.mapping
        }

        linkTagAttrs.params = linkParams

        def cssClasses = "pagination"
        if (attrs.class) {
            cssClasses = "pagination " + attrs.class
        }

        // determine paging variables
        def steps = maxsteps > 0
        int currentstep = (offset / max) + 1
        int firststep = 1
        int laststep = Math.round(Math.ceil(total / max))

        writer << "<ul class=\"${cssClasses}\">"
        // display previous link when not on firststep
        if (currentstep > firststep) {
            linkParams.offset = offset - max
            def template = getTemplatePath('paginate/previous')
            writer << render(template: template.path, model: [attrs: attrs, linkTagAttrs: linkTagAttrs], plugin: template.plugin)
        }
        else {
            def template = getTemplatePath('paginate/previousDisabled')
            writer << render(template: template.path, model: [attrs: attrs], plugin: template.plugin)
        }

        // display steps when steps are enabled and laststep is not firststep
        if (steps && laststep > firststep) {
            linkTagAttrs.class = 'step'

            // determine begin and endstep paging variables
            int beginstep = currentstep - Math.round(maxsteps / 2) + (maxsteps % 2)
            int endstep = currentstep + Math.round(maxsteps / 2) - 1

            if (beginstep < firststep) {
                beginstep = firststep
                endstep = maxsteps
            }
            if (endstep > laststep) {
                beginstep = laststep - maxsteps + 1
                if (beginstep < firststep) {
                    beginstep = firststep
                }
                endstep = laststep
            }

            // display firststep link when beginstep is not firststep
            if (beginstep > firststep) {
                linkParams.offset = 0
                def template = getTemplatePath('paginate/firstStep')
                writer << render(template: template.path, model: [linkTagAttrs: linkTagAttrs.clone(), firststep: firststep], plugin: template.plugin)
            }

            // display paginate steps
            (beginstep..endstep).each { i ->
                if (currentstep == i) {
                    def template = getTemplatePath('paginate/currentStep')
                    writer << render(template: template.path, model: [i: i], plugin: template.plugin)
                }
                else {
                    linkParams.offset = (i - 1) * max
                    def template = getTemplatePath('paginate/paginateStep')
                    writer << render(template: '/themerize/paginate/paginateStep', model: [linkTagAttrs: linkTagAttrs.clone(), i: i], plugin: template.plugin)
                }
            }

            // display laststep link when endstep is not laststep
            if (endstep < laststep) {
                linkParams.offset = (laststep -1) * max
                def template = getTemplatePath('paginate/lastStep')
                writer << render(template: template.path, model: [linkTagAttrs: linkTagAttrs.clone(), laststep: laststep], plugin: template.plugin)
            }
        }

        // display next link when not on laststep
        if (currentstep < laststep) {
            linkParams.offset = offset + max
            def template = getTemplatePath('paginate/next')
            writer << render(template: template.path, model: [linkTagAttrs: linkTagAttrs.clone(), attrs: attrs], plugin: template.plugin)
        }
        else {
            linkParams.offset = offset + max
            def template = getTemplatePath('paginate/nextDisabled')
            writer << render(template: template.path, model: [attrs: attrs], plugin: template.plugin)
        }

        writer << '</ul>'
    }
}
