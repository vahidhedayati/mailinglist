class MailinglistGrailsPlugin {
	def version = "0.29"
	def grailsVersion = "2.0 > *"
	def title = "Mailing List Plugin"
	def description = 'Schedule emails to a mailing group or to a person using dynamic quartz scheduling. Schedules stored within DB and upon application restart incomplete or future schedules are re-added to quartz queue.'
	def documentation = "http://grails.org/plugin/mailinglist"
	def license = "APACHE"
	def author = "Vahid Hedayati"
	def authorEmail = "badvad@gmail.com"
	def issueManagement = [system: 'GITHUB', url: 'https://github.com/vahidhedayati/mailinglist/issues']
	def scm = [url: 'https://github.com/vahidhedayati/mailinglist']
	
}
