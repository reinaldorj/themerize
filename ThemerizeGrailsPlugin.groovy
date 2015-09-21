class ThemerizeGrailsPlugin {
    // the plugin version
    def version = "0.1.0"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.5 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def title = "Themerize" // Headline display name of the plugin
    def author = "Willian Krause"
    def authorEmail = "krause.willian@gmail.com"
    def description = '''\
A Grails plugin that allow you to easily develop themes to your app.
'''

    def documentation = "https://github.com/willcrisis/themerize/"

    def license = "APACHE"

    def issueManagement = [ system: "GITHUB", url: "https://github.com/willcrisis/themerize/issues" ]

    def scm = [ url: "https://github.com/willcrisis/themerize/" ]
}
