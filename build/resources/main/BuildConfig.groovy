grails.project.work.dir = 'target'
//grails.project.dependency.resolver = 'maven'
grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		grailsCentral()
		mavenLocal()
		mavenCentral()
		mavenRepo "https://repo.grails.org/grails/plugins"
		mavenRepo "http://repo.grails.org/grails/core"
	}
	
	//http://stackoverflow.com/questions/24411420/grails-export-plugin-errors
	dependencies {
		compile 'commons-beanutils:commons-beanutils:1.8.3'
		compile 'org.apache.commons:commons-io:1.3.2'
	}
	
	plugins {
		compile ":ckeditor:4.4.1.0"
		compile ':csv:0.3.1'
		compile ':export:1.6'
		compile ':joda-time:1.5'
		
		compile ":jquery-date-time-picker:0.2.0"
		compile ':mail:1.0.7'
		compile ':quartz:1.0.2'
		compile ":quartz-monitor:1.0"
		//compile ':tiny-mce:3.4.9'
		compile ":remote-pagination:0.4.6"
		compile ":pretty-time:2.1.3.Final-1.0.1"
		compile ":modaldynamix:0.12", { excludes 'jquery' }

		// Grails 2.3 resources sites
		//compile ":hibernate:3.6.10.6", { export = false }

		// Assets based 2.4+ sites
		compile ":hibernate4:4.3.5.4", {
			export = false
		}
		runtime ':pluginbuddy:0.3'
		compile ":jquery-ui:1.10.3", { excludes 'jquery' }
        build ':release:3.0.1', ':rest-client-builder:1.0.3',  {
			export = false
		}
		compile "org.grails.plugins:migrate2-grails3:0.3.2"
	}
}
//grails.plugin.location.'modaldynamix' = "../modaldynamix"
