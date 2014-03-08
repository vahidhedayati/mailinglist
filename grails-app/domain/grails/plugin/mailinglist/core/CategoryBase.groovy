package grails.plugin.mailinglist.core

import grails.util.Holders

class CategoryBase implements Serializable {
	Date dateCreated
	Date lastUpdated
	
	static hasMany = [ mailinglist: MailingListBase ]
	
	String name
	String addedby
	
	static optionals = [  'addedby' ]
	
    static constraints = {
		name (maxLength: 200, blank: false, unique: true)
		addedby nullable: true
    }
	
	static mapping = {
		sort "name"
		mailinglist cascade: 'all-delete-orphan'
		addedby defaultValue: ''
		table Holders.config.mailinglist.table.categories ?: 'MailingListCategories'
	}
	
	String toString() { "${name}"}
}
