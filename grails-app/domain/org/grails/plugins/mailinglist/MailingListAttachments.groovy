package org.grails.plugins.mailinglist

import java.util.Date;

class MailingListAttachments {

	Date dateCreated
	Date lastUpdated
	String name
	String fullname
	byte[] attachment
	String contentType
	
	String addedby=''
	
	static belongsTo= [ MailingListSchedule]
	static mapping = {
		
		//photo column: "photo_data", sqlType: "blob"
		//attachment type: "blob" ,  sqlType: "blob"
		attachment type: "binary" // or "blob"?
	}
	static constraints = {
	//	name(maxLength: 100, unique: true, blank: false)
	//	fullname(maxLength: 240, blank:false, unique:true, matches: "[a-zA-Z0-9-_\\ \\+]+\\.{1}+[a-z]{3}")
		
		//attachment(maxSize: 502400, blank:false, minsize: 1) // 500Kb
		attachment(maxSize: 8388608, blank:false, minsize: 1) // 1MB
		
	}
	static optionals = [  'name', 'fullname', 'contentType']
	String toString() {
		"${fullname}"
	}

}
