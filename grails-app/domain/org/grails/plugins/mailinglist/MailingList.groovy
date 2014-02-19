package org.grails.plugins.mailinglist

import java.util.Date;

class MailingList {
	Date dateCreated
	Date lastUpdated
	String title=''
	String firstName=''
	String middleName=''
	String lastName=''
	String suffix=''
	String emailAddress=''
	String emailDisplayName=''
	String addedby=''
	String siteid=''
	MailingListCat mlcategories
	static searchable = [only: ['emailAddress']]
	static mapping = {
		addedby defaultValue: ''
		emailAddress defaultValue: ''
		title defaultValue: ''
		firstName defaultValue: ''
		middleName defaultValue: ''
		lastName defaultValue: ''
		emailDisplayName defaultValue: ''
		siteid defaultValue: ''
		suffix defaultValue: ''
	}
	static constraints = {
		addedby(maxlength: 100,nullable:true)
		emailAddress(maxLength:100,email:true, blank:false)
		title(nullable:true)
		firstName(nullable:true)
		middleName(nullable:true)
		lastName(nullable:true)
		emailDisplayName(nullable:true)
		siteid(nullable:true)
		suffix(nullable:true)
	}
	String toString() { "${emailAddress}" }
	
	
}

/*mlcategories (nullable:true)
 siteid (nullable:true)
 , validator: { val, obj ->
	 if(val) {
	   return val.mailinglist == obj
	 }
  })*/
