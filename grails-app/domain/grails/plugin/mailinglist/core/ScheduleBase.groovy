package grails.plugin.mailinglist.core

import grails.util.Holders

class ScheduleBase  implements Serializable  {
	Date dateCreated
	Date lastUpdated
	String mailFrom
	String recipientToGroup=''
	String recipientToList=''
	String recipientBCCList=''
	String recipientCCList=''
	String subject
	String mailingListTemplate=''
	String emailMessage
	String dateTime=''
	String setDate=''
	String setTime=''
	String sendType=''
	String addedby=''
	String scheduleName=''
	
	static hasMany = [ attachments: AttachmentsBase]
	
	Boolean scheduleCancelled=false
	Boolean scheduleComplete=false
	Boolean deploymentComplete=false
	
	static optionals = [ 'recipientToGroup','recipientToList','recipientBCCList','recipientCCList',
	'mailingListTemplate','emailMessage','setDate','setTime','sendType','addedby','scheduleName']
	
	static mapping = {
		emailMessage type: 'text'
		mailFrom defaultValue: ''
		recipientToGroup defaultValue: ''
		recipientToList defaultValue: ''
		recipientBCCList defaultValue: ''
		recipientCCList defaultValue: ''
		subject defaultValue: ''
		mailingListTemplate defaultValue: ''
		emailMessage defaultValue: ''
		dateTime defaultValue: ''
		setDate defaultValue: ''
		setTime defaultValue: ''
		sendType defaultValue: ''
		addedby defaultValue: ''
		scheduleName defaultValue: ''
		scheduleCancelled  defaultValue: false
		scheduleComplete  defaultValue: false
		deploymentComplete  defaultValue: false
		table Holders.config.mailinglist.table.schedule ?:  'MailingListSchedule'
	}
	static constraints = {
		addedby nullable: true
		scheduleName nullable: true
		recipientToGroup nullable: true
		setTime nullable: true
		setDate nullable: true
		recipientToList nullable: true
		recipientCCList nullable: true
		recipientBCCList nullable: true
		mailingListTemplate  nullable: true
		
		
	}
	
}