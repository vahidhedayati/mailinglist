package grails.plugin.mailinglist.core

import java.util.Date;

class SendersBase {
	Date dateCreated
	Date lastUpdated
	
	String addedby
	String emailAddress

	static optionals = [  'addedby' ]
	
	static mappings = {
		addedby defaultValue: ''
		table Holders.config.mailinglist.table.senders ?: 'MailingListSenders'
	}
	
	static constraints = {
		emailAddress(maxLength:50,email:true,unique:true)
		addedby nullable: true
	}
	String toString() {
		"${emailAddress}"
	}
	
}