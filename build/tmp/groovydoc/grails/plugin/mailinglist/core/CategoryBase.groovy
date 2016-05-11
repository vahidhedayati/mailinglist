package grails.plugin.mailinglist.core

class CategoryBase implements Serializable {
	Date dateCreated
	Date lastUpdated

	static hasMany = [ mailinglist: MailingListBase ]

	String name
	String addedby

	static constraints = {
		name (maxLength: 200, blank: false, unique: true)
		addedby nullable: true
	}

	static mapping = { applicationContext ->
		sort "name"
		mailinglist cascade: 'all-delete-orphan'
		addedby defaultValue: ''
		//table applicationContext?.grailsApplication?.config?.mailinglist.table.categories ?: 'MailingListCategories'
		table applicationContext.getBean('grailsApplication').config.mailinglist.table.categories ?: 'categories'
	}

	String toString() { name }
}
