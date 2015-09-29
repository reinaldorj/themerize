package themerize

class ButtonsTagLib extends AbstractTaglib {

    /**
     * Renders a button type="submit" element
     *
     * @attr REQUIRED action Action a ser chamada
     * @attr id ID do elemento DOM
     * @attr class Classe de estilo a ser aplicada
     * @attr style Estilo a ser aplicado
     * @attr value Texto do botão
     * @attr title Texto alternativo do botão
     */
    def submitButton = {attrs, body ->
        def template = getTemplatePath('buttons/submitButton')
        attrs.name = "_action_${attrs.remove('action')}"
        out << render(template: template.path, model: [attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um botão do tipo reset
     */
    def resetButton = {attrs, body ->
        def template = getTemplatePath('buttons/resetButton')
        out << render(template: template.path, plugin: template.plugin)
    }

    /**
     * Renders a link element stylized like a button
     *
     * @attr REQUIRED action Action to be called in controller
     * @attr id Object ID to be included in URL
     * @attr class
     * @attr style
     * @attr value
     * @attr controller Controller to be called
     * @attr link Redirect link
     * @attr type Button type. Allowed values: default, primary, success, warning, danger, info
     * @attr title
     */
    def linkButton = {attrs, body ->
        def template = getTemplatePath('buttons/linkButton')
        attrs.link = attrs.link ?: createLink(controller: attrs.remove('controller'), action: attrs.remove('action'), id: attrs.remove('id'), params: attrs.remove('params'))
        String value = attrs.remove('value')
        attrs.type = attrs.type ?: 'default'
        out << render(template: template.path, model: [attrs: attrs, body: body, value: value], plugin: template.plugin)
    }

    /**
     * Renders a button type="button" element
     *
     * @attr id DOM object ID
     * @attr class
     * @attr style
     * @attr value
     * @attr type Button type. Allowed values: default, primary, success, warning, danger, info
     * @attr title
     */
    def button = { attrs, body ->
        def template = getTemplatePath('buttons/button')
        out << render(template: template.path, model: [attrs: attrs, body: body], plugin: template.plugin)
    }
}
