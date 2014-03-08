package grails.plugin.mailinglist.core

import grails.util.Holders

class MailingListBase  implements Serializable {

	CategoryBase categories
	
	Date dateCreated
	Date lastUpdated
	
	String emailAddress
	
	String emailDisplayName=''
	String title=''
	String firstName=''
	String middleName=''
	String lastName=''
	String addedby=''
	
	static optionals = ['title','firstName', 'middleName','lastName', 'addedby', 'emailDisplayName']
	
	static mapping = {
		addedby defaultValue: ''
		emailAddress defaultValue: ''
		title defaultValue: ''
		firstName defaultValue: ''
		middleName defaultValue: ''
		lastName defaultValue: ''
		emailDisplayName defaultValue: ''
		table Holders.config.mailinglist.table.mailinglist ?: 'MailingList'
	}

	static constraints = {
		emailAddress(maxLength:100,email:true, blank:false)
		emailDisplayName nullable: true
		title nullable: true
		firstName nullable: true
		middleName nullable: true
		lastName nullable: true
		addedby nullable: true
	}
	
	String toString() { "${emailAddress}" }
	
}