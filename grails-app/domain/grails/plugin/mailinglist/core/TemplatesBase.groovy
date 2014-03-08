package grails.plugin.mailinglist.core

import java.util.Date;

class TemplatesBase {
	Date dateCreated
	Date lastUpdated
	String name
	String addedby
	String content


	static optionals = [  'addedby' ]
	
	static mappings = {
		addedby defaultValue: ''
		content type: 'text'
		table Holders.config.mailinglist.table.templates ?: 'MailingListTemplates'
	}
	
	static constraints = {
		name (maxLength: 200, blank: false)
	}
	
	String toString() {
		"${name}"
	}
 
}
