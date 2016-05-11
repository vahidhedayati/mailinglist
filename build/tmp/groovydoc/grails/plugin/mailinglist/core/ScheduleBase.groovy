package grails.plugin.mailinglist.core

class ScheduleBase implements Serializable {
	
	public static final byte NONE=0
	public static final byte SCHEDULE_CANCELLED=1
	public static final byte SCHEDULE_RUNNING=2
	public static final byte SCHEDULE_COMPLETE=3
	public static final byte CRON=4
	public static final byte CRON_CANCELLED=5
	public static final List SCHEDULE_TYPES=[NONE,SCHEDULE_CANCELLED,SCHEDULE_RUNNING,SCHEDULE_COMPLETE,CRON,CRON_CANCELLED]
	
	Date dateCreated
	Date lastUpdated
	String mailFrom
	String recipientToGroup
	String recipientToList
	String recipientBCCList
	String recipientCCList
	String subject
	String mailingListTemplate
	String emailMessage
	String dateTime
	String setDate
	String setTime
	String sendType
	String addedby
	String scheduleName
	String cronExpression

	static hasMany = [ attachments: AttachmentsBase]

	Byte scheduleStatus=NONE

	static mapping = { applicationContext ->
		emailMessage type: 'text'
		//table applicationContext.grailsApplication.config.mailinglist.table.schedule ?: 'MailingListSchedule'
		table applicationContext.getBean('grailsApplication').config.mailinglist.table.schedule ?: 'mailing_list_schedule'
	}

	static constraints = {
		addedby nullable: true
		scheduleName nullable: true
		cronExpression nullable: true
		recipientToGroup nullable: true
		recipientToList nullable: true
		recipientBCCList nullable: true
		mailingListTemplate nullable:true
		recipientCCList nullable: true
		setTime nullable: true
		setDate nullable: true
		sendType nullable: true
		addedby nullable:true
		scheduleStatus(min:(byte)0, max:(byte)5, inList:SCHEDULE_TYPES)
		dateTime(nullable:true)
	}
	String toString() { id }
}
