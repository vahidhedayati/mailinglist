grails.project.work.dir = 'target'
grails.project.dependency.resolver = 'maven'
grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		mavenLocal()
		mavenCentral()
		grailsCentral()
		
	}

	plugins {
		compile ':ckeditor:3.6.6.1.1'
		compile ':csv:0.3.1'
		compile ':export:1.5'
		compile ':joda-time:1.4'
		compile ':jquery-date-time-picker:0.1.1'
		compile ':jquery-ui:1.10.3'
		compile ':mail:1.0.4'
		compile ':quartz:1.0.1'
		compile ':quartz-monitor:0.3-RC3'
		compile ':tiny-mce:3.4.9'
		compile ":remote-pagination:0.4.6"
		compile ":pretty-time:2.1.3.Final-1.0.1"
		compile ":modaldynamix:0.2"
		
		compile ":hibernate:3.6.10.6", {
			export = false
		}

		build ':release:3.0.1', ':rest-client-builder:1.0.3', {
			export = false
		}
	}
}
//grails.plugin.location.'modaldynamix' = "../modaldynamix"
