package grails.plugin.mailinglist.core

class AttachmentsBase implements Serializable {
	Date dateCreated
	Date lastUpdated

	String name
	String fullname
	byte[] attachment
	String contentType

	String addedby

	static belongsTo = [ScheduleBase]

	static mapping = { applicationContext ->
		attachment type: "binary" // or "blob"?
		addedby defaultValue: ''
		name defaultValue: ''
		fullname defaultValue: ''
		contentType defaultValue: ''
		table applicationContext.grailsApplication.config.mailinglist.table.attachments ?: 'MailingListAttachments'
	}

	static constraints = {
		attachment(maxSize: 8388608, blank:false, minsize: 1) // 1MB
		addedby nullable: true
	}

	String toString() { fullname }
}
