package grails.plugin.mailinglist.core

class FromBase implements Serializable {

	Date dateCreated
	Date lastUpdated
	String addedby
	String emailAddress

	static mapping = { applicationContext ->
		addedby defaultValue: ''
		table applicationContext.grailsApplication.config.mailinglist.table.from ?: 'MailingListFrom'
	}

	static constraints = {
		emailAddress(maxLength:50,email:true,unique:true)
		addedby nullable: true
	}

	String toString() {
		emailAddress
	}
}
