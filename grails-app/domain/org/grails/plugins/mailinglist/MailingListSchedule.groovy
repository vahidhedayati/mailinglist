package org.grails.plugins.mailinglist

import java.util.Date;
// This class works along side start up of application and if any schedules
// were set prior to a restart and not completed
// this will then pick them up and reschedule them

class MailingListSchedule {
	Date dateCreated
	Date lastUpdated
	String mailFrom=''
	String recipientToGroup=''
	String recipientToList=''
	String recipientBCCList=''
	String recipientCCList=''
	String subject=''
	String mailingListTemplate=''
	String emailMessage=''
	String dateTime=''
	String setDate=''
	String setTime=''
	String sendType=''
	String addedby=''
	String scheduleName=''
	static hasMany = [ attachments: MailingListAttachments]
	Boolean scheduleCancelled=false
	Boolean scheduleComplete=false
	Boolean deploymentComplete=false
	static mapping = {
		emailMessage type: 'text'
		scheduleCancelled  defaultValue: false
		scheduleComplete  defaultValue: false
		deploymentComplete  defaultValue: false
	}
    static constraints = {}
}
