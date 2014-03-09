package grails.plugin.mailinglist.core

class MailingListBase implements Serializable {

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

	static mapping = { applicationContext ->
		addedby defaultValue: ''
		emailAddress defaultValue: ''
		title defaultValue: ''
		firstName defaultValue: ''
		middleName defaultValue: ''
		lastName defaultValue: ''
		emailDisplayName defaultValue: ''
		//table applicationContext.grailsApplication.config.mailinglist.table.mailinglist ?: 'MailingList'
		table applicationContext.getBean('grailsApplication').config.mailinglist.table.mailinglist ?: 'MailingList'
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

	String toString() { emailAddress }
}
