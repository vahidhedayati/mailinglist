package org.grails.plugins.mailinglist

import java.util.Date;

class MailingListSenders {
	Date dateCreated
	Date lastUpdated
	String addedby=''
	String emailAddress=''
	static constraints = {
		addedby(maxlength: 100)
		emailAddress(maxLength:50,email:true,unique:true)
	}
	String toString() {
		"${emailAddress}"
	}
}