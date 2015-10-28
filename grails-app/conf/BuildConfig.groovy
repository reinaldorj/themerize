grails.project.work.dir = 'target'

grails.project.dependency.resolver = "maven"
grails.project.dependency.resolution = {

    inherits "global"
    log "warn"

    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()

        //NÃO COMMITAR ISSO!!
        mavenRepo id:"Artifactory" , url:"http://artifactory.willcrisis.com/artifactory/repo"
    }

    plugins {
        build(":release:3.1.1", ":rest-client-builder:2.1.1") {
            export = false
        }
        compile ":plugin-config:0.2.1"
        runtime ":jquery:1.11.1"
    }
}

//NÃO COMMITAR ISSO!!
grails.project.repos.default = "willcrisis"
grails.project.groupId = "com.willcrisis.plugins"