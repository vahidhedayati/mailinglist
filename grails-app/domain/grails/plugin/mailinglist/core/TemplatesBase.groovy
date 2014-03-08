package grails.plugin.mailinglist.core

import java.util.Date;

class TemplatesBase {
	Date dateCreated
	Date lastUpdated
	String name
	String addedby
	String content
	 
	static constraints = {
		name (maxLength: 200, blank: false)
	}
	
	static mapping = {
		content type: 'text'
		
	}
	static optionals = [  'addedby' ]
	
	static mappings = {
		table Holders.config.mailinglist.table.templates ?: 'MailingListTemplates'
	}
	
	String toString() {
		"${name}"
	}
 
}
