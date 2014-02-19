// configuration for plugin testing - will not be included in the plugin zip

//setenv.sh 
//UPLOADLOC="$CATALINA_HOME/uploads"
//JAVA_OPTS="$JAVA_OPTS -DUPLOADLOC=$UPLOADLOC"
//HOSTNAME=$(hostname)
//JAVA_OPTS="$JAVA_OPTS -DSERVERURL=$HOSTNAME"


// -DUPLOADLOC=/opt/tomcat7/tc1/uploads 
// -DSERVERURL=my.server.com
if (System.getProperty('UPLOADLOC')) {
	externalUploadPath=System.getProperty('UPLOADLOC')+File.separator
}
if (System.getProperty('SERVERURL')) {
	grails.baseURL='http://'+System.getProperty('SERVERURL')
}else{
	grails.baseURL='http://localhost'
}

log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
           'org.codehaus.groovy.grails.web.pages', //  GSP
           'org.codehaus.groovy.grails.web.sitemesh', //  layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping', // URL mapping
           'org.codehaus.groovy.grails.commons', // core / classloading
           'org.codehaus.groovy.grails.plugins', // plugins
           'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}
ckeditor {
	//config = "/js/myckconfig.js"
		skipAllowedItemsCheck = false
	defaultFileBrowser = "ofm"
	upload {
		//basedir = "/uploads/"
		
		baseurl="${grails.baseURL}"+'/uploads/'
		basedir = "${externalUploadPath}"
			overwrite = false
			link {
				browser = true
				upload = false
				allowed = []
				denied = ['html', 'htm', 'php', 'php2', 'php3', 'php4', 'php5',
						  'phtml', 'pwml', 'inc', 'asp', 'aspx', 'ascx', 'jsp',
						  'cfm', 'cfc', 'pl', 'bat', 'exe', 'com', 'dll', 'vbs', 'js', 'reg',
						  'cgi', 'htaccess', 'asis', 'sh', 'shtml', 'shtm', 'phtm']
			}
			image {
				browser = true
				upload = true
				allowed = ['jpg', 'gif', 'jpeg', 'png']
				denied = []
			}
			flash {
				browser = false
				upload = false
				allowed = ['swf']
				denied = []
			}
	}
}
jqueryDateTimePicker1 {
	format {
		java {
			datetime = "dd-MM-yyyy HH:mm"
			date = "dd-MM-yyyy"
		}
		picker {
			date = "'dd-mm-yy'"
			time = "'H-mm'"
		}
	}
}
jqueryDateTimePicker {
	format {
		java {
			datetime = "dd/MM/yyyy HH.mm"
			date = "dd/MM/yyyy"
		}
		picker {
			date = "'dd/mm/yy'"
			time = "'H.mm'"
		}
	}
}

grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
	xml: ['text/xml', 'application/xml'],
	text: 'text-plain',
	js: 'text/javascript',
	rss: 'application/rss+xml',
	atom: 'application/atom+xml',
	css: 'text/css',
	csv: 'text/csv',
	pdf: 'application/pdf',
	rtf: 'application/rtf',
	excel: 'application/vnd.ms-excel',
	ods: 'application/vnd.oasis.opendocument.spreadsheet',
	all: '*/*',
	json: ['application/json','text/json'],
	form: 'application/x-www-form-urlencoded',
	multipartForm: 'multipart/form-data'
  ]


