package org.grails.plugins.mailinglist

import java.util.Date;

class MailingListCat {
	Date dateCreated
	Date lastUpdated
	String name
	String addedby=''
	static hasMany = [ mailinglist: MailingList ]
    static constraints = {
		name (maxLength: 200, blank: false, unique: true)
		addedby(maxlength: 100)	
		
    }
	static mapping = {
		sort "name"
		mailinglist cascade: 'all-delete-orphan'
	}
	static optionals = [  'addedby' ]
	String toString() { "${name}"}
}
