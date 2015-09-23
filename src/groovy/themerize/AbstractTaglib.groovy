package themerize

import static org.codehaus.groovy.grails.io.support.GrailsResourceUtils.appendPiecesForUri

import org.codehaus.groovy.grails.web.pages.discovery.GrailsConventionGroovyPageLocator

abstract class AbstractTaglib {

	 static namespace = 'thmrz'

	 def grailsApplication

	 GrailsConventionGroovyPageLocator groovyPageLocator

	 protected Map<String, String> getTemplatePath(String templateName) {
		  String path = appendPiecesForUri("/themerize", templateName)
		  Map<String, String> template = [path: path]
		  def override = groovyPageLocator.findTemplateInBinding(path, pageScope)
		  if (!override) {
				template.plugin = grailsApplication.mergedConfig.grails.themerize.theme
		  }
		  return template
	 }
}
