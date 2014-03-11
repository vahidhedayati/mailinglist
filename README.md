mailinglist 0.1
=======================


mailinglist is a Grails plugin which makes use of quartz to dynamically schedule either group or specific email address contact.
You create html email templates with images etc, then define time and date for this to be sent. The job is then added to quartz and set to email at given time.
The queue can easily be controlled via bootstrap so that nothing is ever lost.

Do you want to email a person at 11:41 pm or maybe a group of people at 2.15am? then look no further.

You can schedule an email to be scheduled and to run on a set date and time. 

Supports HTML emails with inline images as well as attachments has been tested on outlook and result appears to load fine.



WARNING ! - this will copy over controllers/views/domainClasses/services and create Quartz jobs within your project, if this is your first time using this plugin, it would be advised to create a new project and test the plugin, before attempting to install it on main project.

This plugin is still under development and has not been released


For a walk through guide on how to install this plugin goto : https://github.com/vahidhedayati/ml-test

## Installation:
Add plugin Dependency in BuildConfig.groovy :

	compile ":mailinglist:0.1"


#### BuildConfig.groovylayout/main.gsp update:

##### jquery, jquery-ui libraries:
your layouts main.gsp: (add jquery-ui and jquery - or add them into ApplicationResources.groovy and ensure you refer to it in your main.gsp or relevant file

	<g:javascript library="jquery-ui"/>
	<g:javascript library="jquery"/>
	…
	<g:layoutHead/>



Now with that all in place open grails console or from the command line run

	grails mlsetup org.example.com 5

	Where org.example.com is your package and 5 is the amount of dynamic schedule jobs to generate,

Assuming package was labelled as above org.example.com and schedule jobs as 5, install script will create

	Controllers under org.example.com
	Domains 	under org.example.com
	Views 		under views/mailingList[a-z]

	Jobs under 	org.example.com/ScheduleEmail0Job.groovy
			   	org.example.com/ScheduleEmail1Job.groovy
			   	org.example.com/ScheduleEmail2Job.groovy
			   	org.example.com/ScheduleEmail3Job.groovy
			   	org.example.com/ScheduleEmail4Job.groovy

	Services 	under org.example.com
				It will update QuartzEmailCheckerService to only schedule physical jobs ScheduleEmail[0-4]Job


The domains generated in your application extend base domains within plugin, besides this the rest of the controllers etc are pushed to your own application for you to do what you like with it.



#### Config.groovy changes

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
	
	// Your date format that matches input of jquery datepicker config 
	//mailinglist.dtFormat='dd/MM/yyyy HH.mm'


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



You will notice 	grails.baseURL externalUploadPath within ckeditor, this was done to externalise image uploads so upon a redployment the images were still available, the approach I took to this was to run values from setenv.sh within tomcat and pass this values in as variables into config.groovy as per below:


// configuration for plugin testing - will not be included in the plugin zip


// In my tomcat setenv.sh

	//UPLOADLOC="$CATALINA_HOME/uploads"
	//JAVA_OPTS="$JAVA_OPTS -DUPLOADLOC=$UPLOADLOC"
	//HOSTNAME=$(hostname)
	//JAVA_OPTS="$JAVA_OPTS -DSERVERURL=$HOSTNAME"


Produces running tomcat with the following values:

	// -DUPLOADLOC=/opt/tomcat7/tc1/uploads
	// -DSERVERURL=my.server.com


In my Config.groovy at the top I have this

	if (System.getProperty('UPLOADLOC')) {
		externalUploadPath=System.getProperty('UPLOADLOC')+File.separator
	}
	if (System.getProperty('SERVERURL')) {
		grails.baseURL='http://'+System.getProperty('SERVERURL')
	}else{
		grails.baseURL='http://localhost'
	}

Now those values are valid within the ckeditor configuration



#### Boostrap changes

An example BootStrap call to requeue outstanding or interuppted schedules is to add something like this :


    class BootStrap {
        ..
        def mailingListEmailService

        ..
        def getEmails = MailingListSchedule.findAllByScheduleCompleteAndScheduleCancelled(false,false)
        getEmails.each { params ->
            if (params.dateTime && params.emailMessage) {
                println "RESCHEDULING MAIL QUEUE ${params?.id} --       ${params?.mailFrom}---${params?.recipientToGroup}--${params?.recipientToList}"
                mailingListEmailService.rescheduleit(params)
            }
        }
        ..
    }
 
 
    
#### Pop up Modal boxes within contact clients
 
 I have ammended the plugin to include bootstrap-min.js & ml-boostrap-combined.min.css, 
  the plugin will write the js file only if does not already exist within your local web-apps/js folder.
  The new css is added and referred to within contactclients.gsp where the same js file is also called.
  This then allows modal popups to work within the standard grails framework. 
 Ammended the css file from the standard to remove a large chunk from the top so that the default 
  grails site still worked as per normal. The standed boostrap css shifts the site to the left.
  
##### Modal Examples

There are some cool stuff I have attempted with modal updating existing form, so it may come in useful if you need some good examples of 
how to load up a pop ups that update existing form values without any refreshes.

	views/mailingListEmail/contactclients
	
This page has 4 buttons on the top of an existing form that do several different types of calls to modal pop up boxes.

	views/mailingListModal/*

This folder contains some of the inner workins of modal calls from above gsp

New Sender?

This calls on a grails remote form through _modalcreate.gsp which then calls _modalForm.gsp to load up the remoteForm, it itself contains a grails java script that holds on to dynamic labelled CloseModal() function.
This script closes model loads up existing div that contains the modal form with the actual form that was cloned in contactclients. Finally refreshes the DIV that contains the select form for Senders Email Address and appends new value.
There are no refreshes on the main page through all of this. The only downside is if user inputs bad email or invalid email it will just close and refresh with no changes.



Upload CSV?

Ok This now calls on a totally new method since uploading a file does not work too well with javascript serialization or JSON etc.
So how to get around this was to write a new _modaliframe.gsp which simply loads up the upload form as a url wihin an iframe on the modal segment that would normally load the form
The actual repsponse is as per normal i.e. if it was outside of modal, so it posts and shows the show page for record, to close this modal two close buttons provided at top and bottom. 
These call dynamicCloseModal() function which like above actually now close this modal and as above the information produced on first go for producing iframe data is cloned and put back after is cloned.
As above the actual div containing the list of CSV files (checkboxes is now updated) 
No refreshes occur during this process


UploadAttachments?
Refer to Upload CSV


Upload Template
This is very similar to New Sender but decided to use a different technique whilst I was playing around, its always good to show alternative methods. This process calls on _modalbasicSelfPost.gsp which is a self posting form.

It calls on mailingListTemplates/_formAjax.gsp which has <g:form name="${formId }" id="1"  which at the very bottom also has another java script to update ckeditor value to what was last in the form.
When posted it hits $('#${formId}').submit(function() {, this then serliazes form posts back to itself, upon success shows update on the page and then calls on dynamicCloseModal() function below it.
This like above closes the div, updates the form div that contains templates select box with the new template value.
Again no refreshes occur. I have just noticed one bug with this which is the new call does not allow edit its ckeditor specifc. Will fix this soon

phew.... thats over.. that all took a long time to put correctly.

		

###### New Email Address?

This little green button calls o 
 
New Email Address is a fully functional updater that just updates div once it has added record, so no redirect occur on page.

The rest of the green buttons on the contact page all add elements and do a redirect back to contact page. 




#### Future upgrades etc

This project at the moment installs nearly everything to your local project which means you have great power over changes to how things work. This does mean future updates i.e. by running the install script will overwrite everything including changes to anything local to this project made on your local copy.
Advice for now if or until method changes is to always backup your existing project before either running the mlsetup to increase pool or running to upgrade upon future releases. 
If you are not going to make any changes to the plugin code then nothing to worry about update as much as required. 


## Finally

A big thank you as always to Burt Beckwith for forking and fixing up a lot of my wild wild west code :). 
Unfortunately due to issues with merging back the original fork and after a few attempts to fix the issue I decided to rm -rf git repo and upload correct bit which included his changes. 
Those changes are here: https://github.com/burtbeckwith/mailinglist/

   
 

    
