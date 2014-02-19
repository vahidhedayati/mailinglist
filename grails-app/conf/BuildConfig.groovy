grails.project.work.dir = 'target'

grails.project.dependency.resolver = 'maven'

grails.project.dependency.resolution = {
	
    inherits 'global'
    log 'warn'
	 
    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
		mavenRepo "http://download.java.net/maven/2/"
		mavenRepo "http://repo.grails.org/grails/core"
		
    }
   
	dependencies {
	}

    plugins {
		// Required for quartz-monitor
		runtime (":hibernate:3.6.10.6") { export=false }
		compile ":csv:0.3.1"
		compile ":ckeditor:3.6.6.1.1"
		compile ":tiny-mce:3.4.9"
		compile ":joda-time:1.4"
		
		compile ":jquery-date-time-picker:0.1.0"
		compile ":export:1.5"
		compile ":searchable:0.6.6"
		
	    build(":release:3.0.1",":rest-client-builder:1.0.3") { export = false }
		compile (":mail:1.0.1") { excludes 'spring-test' }
		compile (":quartz:1.0.1" , ":quartz-monitor:0.3-RC3")  { export = false }
    }
}
