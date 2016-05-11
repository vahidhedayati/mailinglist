package mailinglist

import grails.plugins.*

class MailinglistGrailsPlugin extends Plugin {
        def grailsVersion = "3.0 > *"

        def title = "Mailing List Plugin"
        def description = 'Schedule emails to a mailing group or to a person using dynamic quartz scheduling. Schedules stored within DB and upon application restart incomplete or future schedules are re-added to quartz queue.'
        def documentation =  "http://grails.org/plugin/mailinglist"
        def license = "APACHE-2"
        def author = "Vahid Hedayati"
        def authorEmail = "badvad@gmail.com"
	def issueManagement = [system: 'GITHUB', url: 'https://github.com/vahidhedayati/mailinglist/issues']
	def scm = [url: 'https://github.com/vahidhedayati/mailinglist']
}
