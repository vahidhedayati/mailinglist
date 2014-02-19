package org.grails.plugins.mailinglist

import java.util.Date;

class MailingListTemplates {
	Date dateCreated
	Date lastUpdated
	String name
	String addedby
	String content 
	static constraints = {
		name (maxLength: 200, blank: false)
	}
	static mapping = {content type: 'text'}
	String toString() {
		"${name}"
	}
 
	
}
