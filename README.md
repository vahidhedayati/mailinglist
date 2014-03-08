mailinglist 0.1
=======================


mailinglist is a Grails plugin which makes use of quartz to dynamically schedule either group or specific email address contact.
You create html email templates with images etc, then define time and date for this to be sent. The job is then added to quartz and set to email at given time.
The queue can easily be controlled via bootstrap so that nothing is ever lost.


WARNING ! - this will copy over controllers/views/domainClasses/services and create Quartz jobs within your project, if this is your first time using this plugin, it would be advised to create a new project and test the plugin, before attempting to install it on main project.

This plugin is still under development and has not been released



## Installation:
Add plugin Dependency :

	compile ":mailinglist:0.1" 

Or via grails command line:

	grails install-plugin mailinglist




## Required plugins to be installed in target project:	

	compile (":csv:0.3.1", ":quartz:1.0.1" , ":quartz-monitor:0.3-RC3",
			":ckeditor:3.6.6.1.1" , ":tiny-mce:3.4.9" , ":joda-time:1.4",
			":jquery-date-time-picker:0.1.0" , ":export:1.5" , ":mail:1.0.4",  ":jquery-ui:1.10.3")
	

## layout/main.gsp update:  
###jquery, jquery-ui libraries:
your layouts main.gsp: (add jquery-ui and jquery - or add them into ApplicationResources.groovy and ensure you refer to it in your main.gsp or relevant file

	<g:javascript library="jquery-ui"/>
	<g:javascript library="jquery"/>
	…
	<g:layoutHead/>



Now with that all in place open grails console or from the command line run

	grails mlsetup org.example.com 5
	
	Where org.example.com is your package and 5 is the amount of dynamic schedule jobs to generate, thats it ! (besides configuration below)
	


Required Config.groovy configurations:


	// Optional values to override DB table names for this plugin:
	//mailinglist.table.schedule='MyScheduler'
	//mailinglist.table.attachments='something'
	//mailinglist.table.categories='something'
	//mailinglist.table.from='something'
	//mailinglist.table.mailinglist='something'
	//mailinglist.table.schedule='something'
	//mailinglist.table.senders='something'
	//mailinglist.table.templates='something'
	

	
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
	
	
	
	
	

    class BootStrap {
        ..
        EmailController ec=new EmailController()

            ..
            def getEmails=MailingListSchedule.findAllByScheduleCompleteAndScheduleCancelled(false,false)
            getEmails.each {  params ->
                    if ( (params.dateTime) && (params.emailMessage)) {
                        println "RESCHEDULING MAIL QUEUE  "+params?.id+" --             "+params?.mailFrom+"---"+params?.recipientToGroup+"--"+params?.recipientToList
                    ec.rescheduleit(params)
                    }
            }

        ..

    }

	
	
		