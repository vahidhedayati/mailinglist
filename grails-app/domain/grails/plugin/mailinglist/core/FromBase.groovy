package grails.plugin.mailinglist.core

import grails.util.Holders

class FromBase implements Serializable {
	def grailsApplication
	Date dateCreated
	Date lastUpdated
	
	String addedby
	
	String emailAddress
	
	static optionals = [  'addedby' ]
	
	static mappings = {
		table Holders.config.mailinglist.table.from ?: 'MailingListFrom'
	}
	static constraints = {
		emailAddress(maxLength:50,email:true,unique:true)
	}
	
	String toString() {
		"${emailAddress}"
	}
}