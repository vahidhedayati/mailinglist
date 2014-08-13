grails.project.work.dir = 'target'
grails.project.dependency.resolver = 'maven'
grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		mavenLocal()
		mavenCentral()
		grailsCentral()
		//http://stackoverflow.com/questions/24411420/grails-export-plugin-errors
		mavenRepo "http://repo.grails.org/grails/core"
		
	}
	
	//http://stackoverflow.com/questions/24411420/grails-export-plugin-errors
	dependencies {
		compile 'commons-beanutils:commons-beanutils:1.8.3'
	}
	
	plugins {
		compile ":ckeditor:4.4.1.0"
		compile ':csv:0.3.1'
		compile ':export:1.6'
		compile ':joda-time:1.5'
		
		compile ':jquery-date-time-picker:0.1.1'
		compile ':jquery-ui:1.10.3'
		compile ':mail:1.0.7'
		compile ':quartz:1.0.2'
		compile ":quartz-monitor:1.0"
		compile ':tiny-mce:3.4.9'
		compile ":remote-pagination:0.4.6"
		compile ":pretty-time:2.1.3.Final-1.0.1"
		compile ":modaldynamix:0.5"
		//runtime ":hibernate4:4.3.5.3" // or ":hibernate:3.6.10.15"
		//compile ":hibernate:3.6.10.6", {
		compile ":hibernate:3.6.10.6", {
			export = false
		}

		build ':release:3.0.1', ':rest-client-builder:1.0.3', {
			export = false
		}
	}
}
//grails.plugin.location.'modaldynamix' = "../modaldynamix"
