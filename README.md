mailinglist 0.32
=======================

mailinglist is a Grails plugin which makes use of quartz to dynamically schedule either group or specific email address contact.
You create html email templates with images etc, then define time and date for this to be sent. The job is then added to quartz and set to email at given time.
The queue can easily be controlled via bootstrap so that nothing is ever lost.

Do you want to email a person at 11:41 pm or maybe a group of people at 2.15am? then look no further.

You can schedule an email to be scheduled and to run on a set date and time. 

Supports HTML emails with inline images as well as attachments has been tested on outlook and result appears to load fine.


For a walk through guide on how to install this plugin goto : https://github.com/vahidhedayati/ml-test

## Installation for grails 2.4+ assets based sites:
Add plugin Dependency in BuildConfig.groovy :
```groovy
compile ":mailinglist:0.32"
```

#### Under 2.4.0 you may need to review hibernate version and update to:
```
runtime ":hibernate4:4.3.5.4"
```

Please refer to [example site:](https://github.com/vahidhedayati/testmlist)


## Installation for grails < 2.4 based resources sites 2.X -> 2.3.X
Under Resources based application you can still use the latest code base, but you need to exclude hibernate. Something like this:
```
compile (":maillinglist:X.XX") { excludes 'hibernate' }
```

If you wish you could also use the very last build under compatible hibernate version built under resources:
Add plugin Dependency in BuildConfig.groovy :
```groovy
compile ":mailinglist:0.19"
```

## Since 0.23 you also require:
In the latest app I had to also enable fixes for export plugin, unsure why it did not pull it from within plugin...

Under BuildConfig.groovy:

```
	repositories {
		......
		mavenRepo "http://repo.grails.org/grails/core"
    	}

    	dependencies {
		.....
		compile 'commons-beanutils:commons-beanutils:1.8.3'
    	}
```
The two extra lines one to repositories and one to dependencies.


## Resources based sites : (Grails pre 2.4 )  grails-app/layouts/main.gsp update:

##### jquery, jquery-ui libraries:
your layouts main.gsp: (add jquery-ui and jquery  - or add them into ApplicationResources.groovy and ensure you refer to it in your main.gsp or relevant file
```gsp
	<g:javascript library="jquery"/>
	<g:javascript library="jquery-ui"/>
	…
	…
	<g:layoutHead/>
	<mailinglist:loadbootstrap/>
</head>
```

You will also notice <mailinglist:loadbootstrap/> this loads up bootstrap to make modalbox work - if you already have bootstrap then change this to 
```gsp
<mailinglist:loadplugincss/>
```	
I have found using this method of calling bootstrap within one of my projects to have caused a problem when looking at source it was loading before jquery, 
so by moving this block further below end head tag resolved the issue.

## Assets based sites : (Grails 2.4+ ) grails-app/layouts/main.gsp update:
A default site just add the mailingList line below application.js to grails-app/layouts/main.gsp
```
	<asset:stylesheet src="application.css"/>
        <asset:javascript src="application.js"/>
        <mailinglist:loadbootstrap/>
```
Or if you already have bootstrap initialised :
```
	<mailinglist:loadplugincss/>
```

replace the loadboostrap to loadplugincss

Now with that all in place open grails console or from the command line run
```
grails mlsetup org.example.com 5
```

Where org.example.com is your package and 5 is the amount of dynamic schedule jobs to generate,

Assuming package was labelled as above org.example.com and schedule jobs as 5, install script will create
```

Views 		under views/mailingList/_addedby.gsp

Jobs under 	org.example.com/ScheduleEmail0Job.groovy
		   	org.example.com/ScheduleEmail1Job.groovy
		   	org.example.com/ScheduleEmail2Job.groovy
		   	org.example.com/ScheduleEmail3Job.groovy
		   	org.example.com/ScheduleEmail4Job.groovy

Services 	under org.example.com
			It will update QuartzEmailCheckerService to only schedule physical jobs ScheduleEmail[0-4]Job
```


The domains generated in your application extend base domains within plugin, besides this the rest of the controllers etc are pushed to your own application for you to do what you like with it.


#### i18n support

From 1.17 you can configure your i18n/messages_{locale}.properties to include translations for terms used within this plugin, to get the latest running terms for translation please refer to the [wiki](https://github.com/vahidhedayati/mailinglist/wiki/i18n-terms---support)

## Version changes
```
0.32 Pull request https://github.com/vahidhedayati/mailinglist/pull/5 

martofeld added some commits 5 hours ago
 @martofeld	Add support for using templates in the mail			5495ef2
 @martofeld	Avoid parsing if values are already a List + fix typo			ed30889
 @martofeld	Missed some implementations of the new template			a3a5601
 
 
0.31 #3 Improvement of the mlsetup script and produced services 
	If you have refreshed mlsetup script as part of 0.30, its worth doing it again. This will produce tidier services.
0.30 #3 further tidyup of cron expression rule checking
0.29 #3 Cron expressions introduced so either send via cron schedule or specify date time
0.28 minor change update modaldynamix to 0.28  and pluginbuddy 0.3 
0.27 minor change update to modaldynamix ver 0.27
0.26 Updated to 2.4.2, cleaned up end user app verification by using pluginbuddy. 
0.25 latest modaldynamix called - pop up boxes loading correctly according to screen size
0.24 Fixed datetime issue under assets based sites.
0.23 Latest modaldynamix plugin version used - modalboxes resized according to requirement - colour added to modalbox button callers.
0.22 Excess css entries removed from MailingList.css - causing larger buttons and unnessary spacing issues.
0.21 Missing jquery-ui js file manually inserted in for assets based sites.
0.20 Release of assets version - identical to 0.19 but hibernate bumped to match assets based sites.
0.19 last release for resources based sites. to keep upto date update your underlying site to assets
0.18 i18n support added to services - further tidy up of contact a person page.
0.17 Tidy up of mailSent view on main menu, added i18n support to most of the calls.
0.16 latest ckeditor added
0.15 mailinglist.warn.duplicate and mailinglist.warn.period added, issue with search mailingList fixed. Duplicate email warnings to same contactGroup  set to show on preview screen
0.14 fixed pagination / export features on mailinglist page.
0.13 issue with list - export feature was not working - format was not being passed - format now set to extension params
0.12 Changed ckeditor to 4.4.0.0-SNAPSHOT http://jira.grails.org/browse/GPCKEDITOR-40
0.11 Removal of non thread safe calls within QuartsStatusService ret_triggerName ret_triggerGroup ret_jobName, now returned as  map and parsed as params back in modSchedule
0.10 more tidying up fixes to minor broken calls
0.9 tidyup to taglib/service and gsps 
0.8 minor changes to _list1-top.gsp - called correct controller to display more information on scheduled jobs
0.7 updates to default db table names, readme updates, correct ckeditor call for in index.gsp, giving upload feature for images 
0.6 minor fix MailingList controller save wrong parameter for categories
0.5 minor fix gsp listing wrong domainClass in mailingList/_form.gsp
0.4 moved out all of the manual modalbox calls and called modaldynamix plugin 
0.3 Missing images, alerts left in java scripts tut tut, contactclients gsp page had lots of bugs now fixed, scheduling looks a lot healthier.
0.2 moved most back into actual plugin - bug with existing used schedule issues whilst attempting to schedule something for now whilst others queued.
0.1 release - nearly everything written to clients project
```


#### Config.groovy changes

Required `Config.groovy` configurations:
```groovy
/*
 * Optional values to override DB table names for this plugin:
 * mailinglist.table.attachments='mailing_list_attachments'
 * mailinglist.table.categories='categories'
 * mailinglist.table.mailinglist='mailing_list'
 * mailinglist.table.schedule='mailing_list_schedule'
 * mailinglist.table.senders='mailing_list_senders'
 * mailinglist.table.templates='mailing_list_templates'
 * These options define if there should be a warning to confirm an email was sent to same group within defined period
 * mailinglist.warn.duplicate='Y'
 * --- Periods are:  | H for Hours | D for days | M for minutes | m for months | y for years | 
 * mailinglist.warn.period='2H'
 * These are all the local tables created that in turn extend domainClasses from this plugin.
 * Check out your domainClass folder under the package you provided after you run the mlsetup command.
 */
 
	
// Your date format that matches input of jquery datepicker config 
//mailinglist.dtFormat='dd/MM/yyyy HH.mm'


ckeditor {
	//config = "/js/myckconfig.js"
	skipAllowedItemsCheck = false
	defaultFileBrowser = "ofm"
	upload {
	
		// basedir = "/uploads/"
		
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
```


You will notice `grails.baseURL` externalUploadPath within ckeditor, this was done to externalise image uploads so upon a redployment the images were still available, the approach I took to this was to run values from setenv.sh within tomcat and pass this values in as variables into `Config.groovy` as per below:


// configuration for plugin testing - will not be included in the plugin zip


// In my tomcat setenv.sh
```sh
//UPLOADLOC="$CATALINA_HOME/uploads"
//JAVA_OPTS="$JAVA_OPTS -DUPLOADLOC=$UPLOADLOC"
//HOSTNAME=$(hostname)
//JAVA_OPTS="$JAVA_OPTS -DSERVERURL=$HOSTNAME"
```

Produces running tomcat with the following values:
```
// -DUPLOADLOC=/opt/tomcat7/tc1/uploads
// -DSERVERURL=my.server.com
```

In my `Config.groovy` at the top I have this
```groovy
if (System.getProperty('UPLOADLOC')) {
	externalUploadPath=System.getProperty('UPLOADLOC')+File.separator
}
if (System.getProperty('SERVERURL')) {
	grails.baseURL='http://'+System.getProperty('SERVERURL')
} else{
	grails.baseURL='http://localhost'
}
```

Now those values are valid within the ckeditor configuration



#### Boostrap changes

An example BootStrap call to requeue outstanding or interuppted schedules is to add something like this :
```groovy
import grails.plugin.mailinglist.core.ScheduleBase

class BootStrap {
	def mailingListEmailService
    def init = { servletContext ->
		def getEmails = ScheduleBase.findAllByScheduleCompleteAndScheduleCancelled(false,false)
		getEmails.each { params ->
			if (params.dateTime && params.emailMessage) {
				println "RESCHEDULING MAIL QUEUE ${params?.id} --       ${params?.mailFrom}---${params?.recipientToGroup}--${params?.recipientToList}"
				mailingListEmailService.rescheduleit(params)
			}
		}
	}
}

``` 
 
#### addedby within forms

There is a field passed around through the application and by default it is blank, this is due to a file called `views/mailingList/_addedby.gsp`

Take a look at this, if your existing application has some form of user and current user is being returned via session or another method i.e. params or something then update this page to refer to this value.
This should fix the issue all around the site, no guarantee haha.


#### conf/UrlMappings.groovy & plugin default holding page

If this plugin is the only purpose of your site, then simply update your url mappings to point to the holding page of this plugin:
```groovy
"/" {
	controller = "MailingList"
	action = "index"
}
// Commented out default and put in above
//"/"(view:"/index")
```
			
The plugin has a menu which can be found under: `http://yoursite:8080/mailinglist/MailingList`	

This is the main menu, the two core options on the top left hand side, Email a person and contact clients.

![mailinglist menu](https://raw.github.com/vahidhedayati/ml-test/master/documentation/mailinglist-menu.png)

The rest of the menu are the manual methods of reviewing email list, or removing attachments etc.


![Email a person](https://raw.github.com/vahidhedayati/ml-test/master/documentation/mailinglist-sendperson.png)
This is what to expect when emailing a person

![Configure schedule date time](https://raw.github.com/vahidhedayati/ml-test/master/documentation/mailinglist-sendperson1.png)
The now button defaults to now, other than that choose actual date time you wish to email this person.



![When submitted](https://raw.github.com/vahidhedayati/ml-test/master/documentation/mailinglist-sent-person.png)
It will just sit in that queue you can stop the job or force it play now from that same scheduling menu.


![Contacting group](https://raw.github.com/vahidhedayati/ml-test/master/documentation/mailinglist-contact-group.png)
This is the look and feel of contact group, subject is the only thing defined, everything else is clickable or uploadable. At the top are some green buttons, each one will update this form dynamically.


![New Template](https://raw.github.com/vahidhedayati/ml-test/master/documentation/mailinglist-contact-group1.png)
Adding a new template, if you do not have a preset template to use for sending emails then create a new one from the first green button at the top of the page.

![Attach a file](https://raw.github.com/vahidhedayati/ml-test/master/documentation/mailinglist-contact-group2.png)
This is if you wish to attach files like documents to be sent with email.

![After attaching](https://raw.github.com/vahidhedayati/ml-test/master/documentation/mailinglist-contact-group3.png)
Attachments run in iframes, so for changes to take effect on main form you need to use the close button on the top of the page. 


![Upload Contact Group CSV](https://raw.github.com/vahidhedayati/ml-test/master/documentation/mailinglist-contact-group4.png)
CSV Uploader which will be your group of users to contact, please note it will always miss out on the first line since on exports usually the first line is the field name

![Add Sender](https://raw.github.com/vahidhedayati/ml-test/master/documentation/mailinglist-contact-group5.png)
The senders from group emails come from the Senders DB table, so you need to register it once set it should remain for reuse on next use.

![Schedule DateTime of email](https://raw.github.com/vahidhedayati/ml-test/master/documentation/mailinglist-contact-group6.png)
Set the time you wish to email to this group, you have now selected and ticked everything else including once template was uploaded you clicked the select box to choose it which then popped open your presaved template.


![Preview Group Email](https://raw.github.com/vahidhedayati/ml-test/master/documentation/mailinglist-contact-group7.png)
Since emailing a group of people usually requires more care, there has been a preview screen added to ensure you are happy with what is being done. if so click confirm sending email otherwise click edit to go back,


![Schedule menu](https://raw.github.com/vahidhedayati/ml-test/master/documentation/mailinglist-contact-group8.png)
This now contains our previous job which is set in a few hours plus our new job for now, we will now choose Completed schedules from the drop down to see:


![Completed jobs](https://raw.github.com/vahidhedayati/ml-test/master/documentation/mailinglist-contact-group9.png)
This group email as completed


![Mail Log on machine](https://raw.github.com/vahidhedayati/ml-test/master/documentation/mailinglist-contact-group10.png)
This is my email log confirming it sent an email from set email to the uploaded csv which had 3 gmail emails, it bounced cos my sendmail is not configured and just as well considering the amount of junk I been sending haha




#Common Issues:
After attempting to run 
```
mlsetup org.example.com 5
```
you must referesh the project and run
```
grails refresh-dependencies
```

If your in ggts you may still see red asterix you can run:
```
grails clean 
```

These are the manual command lines goto project right click grails tools, grails command wizard will help you with those or actual command prompt below just drop the grails in front of all of the above.


Date Format: Trying to schedule and can not ?
```
dd/MM/yyyy HH.mm
```

You may see this :
```
Could not queue job please check quartz queue to ensure schedule slots are free
```
If you look at the console logs you will see it could not parse and it shows a date and time, look closely at the time you will find it has a : seperating the hour and mins.
I know I should have set this as the default right :) This is the defaults sadly so please review main config and ensure your jquery date time config is set properly to match what is needed:
```groovy
mailinglist.dtFormat='dd/MM/yyyy HH.mm'
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
```

This is in the main config above, but worth a remention, so if you want to set a different input type for date time, 
then define this value in your config to match aboves config to get around the standard config which is a dot seperating hours and minutes.
```groovy
mailinglist.dtFormat='dd/MM/yyyy HH.mm'	
```
	
Ensure all of above tallies up for it all work properly
    
#### Pop up Modal boxes within contact clients
 
 Take a look at  https://github.com/vahidhedayati/modaldynamix follow the guide then refer to pages within this plugin to get a better idea on how to use it all together.
 
  




## Finally

A big thank you as always to Burt Beckwith for cleaning up the code:
Unfortunately due to issues with merging repo was cleaned up, original code cna be found here:
Those changes are here: https://github.com/burtbeckwith/mailinglist/

[@martofeld martin](https://github.com/martofeld) For adding template support to the plugin


[Sergey Ponomarev](https://github.com/stokito) For cleaning up and adding formating to the README.md 

Thank you all for you contributions. If you wish to contribute or add stuff I be happy to add you as a project member. I am no longer using this project so will not be getting much updates from me.


    
