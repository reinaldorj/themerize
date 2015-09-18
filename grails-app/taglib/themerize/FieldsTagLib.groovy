package themerize

import org.codehaus.groovy.grails.web.pages.discovery.GrailsConventionGroovyPageLocator

import static org.codehaus.groovy.grails.io.support.GrailsResourceUtils.appendPiecesForUri

class FieldsTagLib {
    static namespace = 'thmrz'

    def grailsApplication

    GrailsConventionGroovyPageLocator groovyPageLocator

    Map<String, String> getTemplatePath(String templateName) {
        String path = appendPiecesForUri("/themerize", templateName)
        Map<String, String> template = [path: path]
        def override = groovyPageLocator.findTemplateInBinding(path, pageScope)
        if (!override) {
            template.plugin = grailsApplication.config.grails.themerize.theme
        }
        return template
    }

    /**
     * Renderiza um campo de texto do tema instalado
     *
     * @attr label Label
     * @attr name REQUIRED
     * @attr id
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def textFieldLabel = { attrs, body ->
        def template = getTemplatePath('fields/textFieldLabel')
        out << render(template: template.path, model: [label: attrs.remove('label'), attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo de texto do tema instalado
     *
     * @attr name REQUIRED
     * @attr id
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def textField = { attrs, body ->
        def template = getTemplatePath('fields/textField')
        out << g.render(template: template.path, model: [attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza uma área de texto do tema instalado
     *
     * @attr label Label
     * @attr name REQUIRED
     * @attr id
     * @attr value
     * @attr class
     * @attr style
     * @attr rows
     * @attr cols
     * @attr required
     */
    def textAreaLabel = { attrs, body ->
        def template = getTemplatePath('fields/textAreaLabel')
        out << render(template: template.path, model: [label: attrs.remove('label'), attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza uma área de texto do tema instalado
     *
     * @attr name REQUIRED
     * @attr id
     * @attr value
     * @attr class
     * @attr style
     * @attr rows
     * @attr cols
     * @attr required
     */
    def textArea = { attrs, body ->
        def template = getTemplatePath('fields/textArea')
        out << render(template: template.path, model: [attrs: attrs, body: 'body'], plugin: template.plugin)
    }

    /**
     * Renderiza um campo de data do tema instalado
     *
     * @attr label
     * @attr name REQUIRED
     * @attr id
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def dateFieldLabel = { attrs, body ->
        def template = getTemplatePath('fields/dateFieldLabel')
        out << render(template: template.path, model: [label: attrs.remove('label'), attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo de data do tema instalado
     *
     * @attr name REQUIRED
     * @attr id
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def dateField = { attrs, body ->
        def template = getTemplatePath('fields/dateField')
        out << render(template: template.path, model: [attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo select do tema instalado
     *
     * @attr label
     * @attr name REQUIRED
     * @attr id
     * @attr from REQUIRED
     * @attr optionKey
     * @attr optionValue
     * @attr noSelection
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def selectLabel = { attrs, body ->
        def template = getTemplatePath('fields/selectLabel')
        out << render(template: template.path, model: [label: attrs.remove('label'), attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo select do tema instalado
     *
     * @attr name REQUIRED
     * @attr id
     * @attr from REQUIRED
     * @attr optionKey
     * @attr optionValue
     * @attr noSelection
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def select = { attrs, body ->
        def template = getTemplatePath('fields/select')
        out << render(template: template.path, model: [attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo de seleção de locale do tema instalado
     *
     * @attr label
     * @attr name REQUIRED
     * @attr id
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def localeSelectLabel = { attrs, body ->
        def template = getTemplatePath('fields/localeSelectLabel')
        out << render(template: template.path, model: [label: attrs.remove('label'), args: attrs.remove('args'), attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo de seleção de locale do tema instalado
     *
     * @attr name REQUIRED
     * @attr id
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def localeSelect = { attrs, body ->
        def template = getTemplatePath('fields/localeSelect')
        out << render(template: template.path, model: [attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo de seleção de timezone do tema instalado
     *
     * @attr label
     * @attr name REQUIRED
     * @attr id
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def timeZoneSelectLabel = { attrs, body ->
        def template = getTemplatePath('fields/timeZoneSelectLabel')
        out << render(template: template.path, model: [label: attrs.remove('label'), args: attrs.remove('args'), attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo de seleção de timezone do tema instalado
     *
     * @attr name REQUIRED
     * @attr id
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def timeZoneSelect = { attrs, body ->
        def template = getTemplatePath('fields/timeZoneSelect')
        out << render(template: template.path, model: [attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo de seleção de moeda do tema instalado
     *
     * @attr label
     * @attr name REQUIRED
     * @attr id
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def currencySelectLabel = { attrs, body ->
        def template = getTemplatePath('fields/currencySelectLabel')
        out << render(template: template.path, model: [label: attrs.remove('label'), args: attrs.remove('args'), attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo de seleção de moeda do tema instalado
     *
     * @attr name REQUIRED
     * @attr id
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def currencySelect = { attrs, body ->
        def template = getTemplatePath('fields/currencySelect')
        out << render(template: template.path, model: [attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo genérico do tema instalado
     *
     * @attr label
     * @attr name REQUIRED
     * @attr id
     * @attr type
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def fieldLabel = { attrs, body ->
        def template = getTemplatePath('fields/fieldLabel')
        out << render(template: template.path, model: [label: attrs.remove('label'), args: attrs.remove('args'), attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo genérico do tema instalado
     *
     * @attr name REQUIRED
     * @attr id
     * @attr type
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def field = { attrs, body ->
        def template = getTemplatePath('fields/field')
        out << render(template: template.path, model: [attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo checkbox do tema instalado
     *
     * @attr label
     * @attr name REQUIRED
     * @attr id
     * @attr type
     * @attr value
     * @attr class
     * @attr required
     * @attr estilo Um dos seguintes valores: none, primary, success, warning, danger, info. Padrão: primary
     */
    def checkBoxLabel = { attrs, body ->
        def template = getTemplatePath('fields/checkBoxLabel')
        out << render(template: template.path, model: [label: attrs.remove('label'), args: attrs.remove('args'), attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo checkbox do tema instalado
     *
     * @attr name REQUIRED
     * @attr id
     * @attr type
     * @attr value
     * @attr class
     * @attr required
     * @attr estilo Um dos seguintes valores: none, primary, success, warning, danger, info. Padrão: primary
     */
    def checkBox = { attrs, body ->
        def template = getTemplatePath('fields/checkBox')
        attrs.id = attrs.id ?: attrs.name
        out << render(template: template.path, model: [attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo de senha do tema instalado
     *
     * @attr label Label
     * @attr name REQUIRED
     * @attr id
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def passwordFieldLabel = { attrs, body ->
        def template = getTemplatePath('fields/passwordFieldLabel')
        out << render(template: template.path, model: [label: attrs.remove('label'), args: attrs.remove('args'), attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo de senha do tema instalado
     *
     * @attr name REQUIRED
     * @attr id
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def passwordField = { attrs, body ->
        def template = getTemplatePath('fields/passwordField')
        out << render(template: template.path, model: [attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo de senha do tema instalado
     *
     * @attr label Label
     * @attr name REQUIRED
     * @attr id
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def uploadFieldLabel = { attrs, body ->
        def template = getTemplatePath('fields/uploadFieldLabel')
        out << render(template: template.path, model: [label: attrs.remove('label'), args: attrs.remove('args'), attrs: attrs, body: body], plugin: template.plugin)
    }

    /**
     * Renderiza um campo de upload de arquivo do tema instalado
     *
     * @attr name REQUIRED
     * @attr id
     * @attr value
     * @attr class
     * @attr style
     * @attr required
     */
    def uploadField = { attrs, body ->
        def template = getTemplatePath('fields/uploadField')
        def name = attrs.remove('name')
        def id = attrs.remove('id')
        id = id ?: name
        def extensoes = attrs.remove('extensoes')
        boolean required = Boolean.valueOf(attrs.remove('required'))
        out << render(template: template.path, model: [name: name, id: id, extensoes: extensoes, required: required], plugin: template.plugin)
    }
}

