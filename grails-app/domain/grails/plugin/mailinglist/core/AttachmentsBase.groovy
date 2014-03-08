package grails.plugin.mailinglist.core

import grails.util.Holders


class AttachmentsBase  implements Serializable {	
	Date dateCreated
	Date lastUpdated
	
	String name
	String fullname
	byte[] attachment
	String contentType
	
	String addedby=''
	
	static belongsTo= [ ScheduleBase]
	
	static mapping = {
		attachment type: "binary" // or "blob"?
		table Holders.config.mailinglist.table.attachments ?: 'MailingListAttachments'
	}
	
	static constraints = {
		attachment(maxSize: 8388608, blank:false, minsize: 1) // 1MB	
	}
	
	static optionals = [  'name', 'fullname', 'contentType']
	
	String toString() {	"${fullname}" }

}

    
