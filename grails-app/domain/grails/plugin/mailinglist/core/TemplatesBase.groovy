package grails.plugin.mailinglist.core

class TemplatesBase {
	Date dateCreated
	Date lastUpdated
	String name
	String addedby
	String content

	static mapping = { applicationContext ->
		addedby defaultValue: ''
		content type: 'text'
		table applicationContext.grailsApplication.config.mailinglist.table.templates ?: 'MailingListTemplates'
	}

	static constraints = {
		name (maxLength: 200, blank: false)
		addedby nullable: true
	}

	String toString() {
		name
	}
}
