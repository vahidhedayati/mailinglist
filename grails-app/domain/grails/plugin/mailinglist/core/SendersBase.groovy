package grails.plugin.mailinglist.core

class SendersBase {
	Date dateCreated
	Date lastUpdated

	String addedby
	String emailAddress

	static mapping = { applicationContext ->
		addedby defaultValue: ''
		//table applicationContext.grailsApplication.config.mailinglist.table.senders ?: 'MailingListSenders'
		table applicationContext.getBean('grailsApplication').config.mailinglist.table.senders ?: 'mailing_list_senders'
	}

	static constraints = {
		emailAddress(maxLength:50,email:true,unique:true)
		addedby nullable: true
	}

	String toString() {
		emailAddress
	}
}
