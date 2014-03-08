package grails.plugin.mailinglist.core

import java.util.Date;

class SendersBase {
	Date dateCreated
	Date lastUpdated
	
	String addedby
	String emailAddress
	
	static constraints = {
		emailAddress(maxLength:50,email:true,unique:true)
	}
	static optionals = [  'addedby' ]
	
	static mappings = {
		table Holders.config.mailinglist.table.senders ?: 'MailingListSenders'
	}
	String toString() {
		"${emailAddress}"
	}
	
}