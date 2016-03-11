package grails.plugin.mailinglist.core

import grails.validation.Validateable

import org.joda.time.LocalDate
import org.joda.time.Years

@Validateable
class ScheduleBaseBean {
	def id 
	String mailFrom
	//we will sort out previous issues and do 2 setters
	String recipientToGroup
	String subject
	//we will sort out previous issues and do 2 setters
	List attachments
	String mailingListTemplate
	String dateTime
	String setDate
	String cronExpression
	String setTime

	String sendType
	String addedby
	String recipientToList 
	String emailMessage
	String recipientCCList
	String recipientBCCList
	//String sendtype
	String quartzSchedule
	
	String setTime_hour
	String setTime_minute
	List storeAttachments=[]
	
	Byte scheduleStatus=ScheduleBase.SCHEDULE_RUNNING
	String scheduleName=''
	
	
	//Content outside of params used for rendering and services
	String ttype = 'Email Announcement'
	String dateFormat='dd MMM yyyy'
	
	static constraints = {
		id(nullable:true,bindable:true)
		addedby nullable: true
		scheduleName nullable: true
		cronExpression(nullable: true, validator:checkCronExpression)
		recipientToGroup (nullable: true, validator:checkEmailTo)
		recipientToList (nullable: true, validator:checkEmailTo)
		recipientBCCList (nullable: true, validator:checkEmailTo)
		recipientCCList (nullable: true, validator:checkEmailTo)
		mailingListTemplate (nullable:true)
		setTime nullable: true
		setDate nullable: true
		sendType nullable: true
		addedby nullable:true
		scheduleStatus(min:(byte)0, max:(byte)4, inList:ScheduleBase.SCHEDULE_TYPES)
		dateFormat(nullable:true)
		dateTime(nullable:true)
		quartzSchedule(nullable:true)
		attachments(nullable:true)
		setTime_hour(nullable:true)
		setTime_minute(nullable:true)
		
	}
	static def checkCronExpression = {val,obj,errors->
		if (val) {
			String ce=val
			def c=ce.split(' ',-1)
			String seconds=c[0] //0-59
			String minutes=c[1] //0-59
			String hours=c[2] //0-23
			String dayOfMonth=c[3] //1-31
			String month=c[4] //1-12 or JAN - DEC, ?
			String dayOfWeek=c[5]  //1-7 or SUN-SAT, ?
			String year  //[optional]
			if (c.length>6) {
				year=c[6]
			}
			String always='*'
			String startupTime='?'
			if (seconds.contains('-')) {
				def sec=seconds.split('-')
				int sec1=sec[0] as int
				int sec2=sec[1] as int
				if ((sec1 < 0 || sec1 >59)||(sec2 < 0 || sec2 >59)) {
					errors.rejectValue(propertyName,"cron.seconds.invalid",[''] as Object[],'')
				}
			} else if (seconds.contains('/')) {
				def sec=seconds.split('/')
				int sec1=sec[0] as int
				int sec2=sec[1] as int
				if ((sec1 < 0 || sec1 >59) && (sec2 < 0 || sec2 >59)) {
					errors.rejectValue(propertyName,"cron.seconds.invalid",[''] as Object[],'')
				}
			} else {
				if (seconds!=always && seconds !=startupTime) {
					def sec=seconds as int
					if (sec < 0 || sec >59) {
						errors.rejectValue(propertyName,"cron.seconds.invalid",[''] as Object[],'')
					}
				}
			}
			
			if (minutes.contains('-')) {
				def sec=minutes.split('-')
				int sec1=sec[0] as int
				int sec2=sec[1] as int
				if ((sec1 < 0 || sec1 >59)||(sec2 < 0 || sec2 >59)) {
					errors.rejectValue(propertyName,"cron.minutes.invalid",[''] as Object[],'')
				}
			} else if (minutes.contains('/')) {
				def sec=minutes.split('/')
				int sec1=sec[0] as int
				int sec2=sec[1] as int
				if ((sec1 < 0 || sec1 >59)||(sec2 < 0 || sec2 >59)) {
					errors.rejectValue(propertyName,"cron.minutes.invalid",[''] as Object[],'')
				} 	
			} else {
				if (minutes!=always && minutes !=startupTime) {
					def sec=minutes as int
					if (sec < 0 || sec >59) {
						errors.rejectValue(propertyName,"cron.minutes.invalid",[''] as Object[],'')
					}
				}
			}
			
			if (hours.contains('-')) {
				def sec=hours.split('-')
				int sec1=sec[0] as int
				int sec2=sec[1] as int
				if ((sec1 < 0 || sec1 >23)||(sec2 < 0 || sec2 >23)) {
					errors.rejectValue(propertyName,"cron.hours.invalid",[''] as Object[],'')
				}
			} else if (hours.contains('/')) {
				def sec=hours.split('/')
				int sec1=sec[0] as int
				int sec2=sec[1] as int
				if ((sec1 < 0 || sec1 >23)||(sec2 < 0 || sec2 >23)) {
					errors.rejectValue(propertyName,"cron.hours.invalid",[''] as Object[],'')
				}
			} else {
				if (hours!=always && hours !=startupTime) {
					def sec=hours as int
					if (sec < 0 || sec >23) {
						errors.rejectValue(propertyName,"cron.hours.invalid",[''] as Object[],'')
					}
				}
			}
			
			if (dayOfMonth.contains('-')) {
				def sec=dayOfMonth.split('-')
				int sec1=sec[0] as int
				int sec2=sec[1] as int
				if ((sec1 < 1 || sec1 >31)||(sec2 < 1 || sec2 >31)) {
					errors.rejectValue(propertyName,"cron.dayOfMonth.invalid",[''] as Object[],'')
				} else {
					if (dayOfWeek != startupTime) { 
						errors.rejectValue(propertyName,"cron.invalid.dom.dow",[''] as Object[],'')
					}
				}
			} else if (dayOfMonth.contains('/')) {
				def sec=dayOfMonth.split('/')
				int sec1=sec[0] as int
				int sec2=sec[1] as int
				if ((sec1 < 1 || sec1 >31)||(sec2 < 1 || sec2 >31)) {
					errors.rejectValue(propertyName,"cron.dayOfMonth.invalid",[''] as Object[],'')
				} else {
					if (dayOfWeek != startupTime) { 
						errors.rejectValue(propertyName,"cron.invalid.dom.dow",[''] as Object[],'')
					}
				}
			} else {
				if (dayOfMonth!=always && dayOfMonth !=startupTime) {
					def sec=dayOfMonth as int
					if (sec < 1 || sec >31) {
						errors.rejectValue(propertyName,"cron.dayOfMonth.invalid",[''] as Object[],'')
					} else {
						if (dayOfWeek != startupTime) { 
							errors.rejectValue(propertyName,"cron.invalid.dom.dow",[''] as Object[],'')
						}
					}	
				}
			}
			
			if (month.contains('-')) {
				def sec=month.split('-')
				int sec1=sec[0] as int
				int sec2=sec[1] as int
				if ((sec1 < 1 || sec1 >12)||(sec2 < 1 || sec2 >12)) {
					errors.rejectValue(propertyName,"cron.month.invalid",[''] as Object[],'')
				}
			} else if (month.contains('/')) {
				def sec=month.split('/')
				int sec1=sec[0] as int
				int sec2=sec[1] as int
				if ((sec1 < 1 || sec1 >12)||(sec2 < 1 || sec2 >12)) {
					errors.rejectValue(propertyName,"cron.month.invalid",[''] as Object[],'')
				}
			} else {
				if (month!=always && month !=startupTime) {
					def sec=month as int
					if (sec < 1 || sec >12) {
						errors.rejectValue(propertyName,"cron.month.invalid",[''] as Object[],'')
					}
				}
			}
			
			if (dayOfWeek.contains('-')) {
				def sec=dayOfWeek.split('-')
				int sec1=sec[0] as int
				int sec2=sec[1] as int
				if ((sec1 < 1 && sec1 >7)||(sec2 < 1 && sec2 >7)) {
					errors.rejectValue(propertyName,"cron.dayOfWeek.invalid",[''] as Object[],'')
				} else {
					if (dayOfMonth != startupTime) { 
						errors.rejectValue(propertyName,"cron.invalid.dom.dow1",[''] as Object[],'')
					}
				}	
			} else if (dayOfWeek.contains('/')) {
				def sec=dayOfWeek.split('/')
				int sec1=sec[0] as int
				int sec2=sec[1] as int
				if ((sec1 < 1 || sec1 >7)||(sec2 < 1 || sec2 >7)) {
					errors.rejectValue(propertyName,"cron.dayOfWeek.invalid",[''] as Object[],'')
				} else {
					if (dayOfMonth != startupTime) { 
						errors.rejectValue(propertyName,"cron.invalid.dom.dow1",[''] as Object[],'')
					}
				}	
			} else {
				if (dayOfWeek!=always && dayOfWeek !=startupTime) {
					def sec=dayOfWeek as int
					if (sec < 1 || sec >7) {
						errors.rejectValue(propertyName,"cron.dayOfWeek.invalid",[''] as Object[],'')
					} else {
						if (dayOfMonth != startupTime) { 
							errors.rejectValue(propertyName,"cron.invalid.dom.dow1",[''] as Object[],'')
						}
					}
					
				}
			}
			if (year) {
				if (year!=always&& year !=startupTime) {
					LocalDate givenYear = new LocalDate (year as int, 1, 1)
					LocalDate now = new LocalDate()
					Years valid = Years.yearsBetween(givenYear, now)
					if (!valid || !valid >= 0) {
						errors.rejectValue(propertyName,"cron.year.invalid",[''] as Object[],'')
					}
				}
			}
		}
		
	}
	static def checkEmailTo = {val,obj,errors->
		if (!obj.recipientToGroup && !obj.recipientToList && !obj.recipientCCList && !obj.recipientBCCList) {
			errors.rejectValue(propertyName,"mailingList.define.to.address",[''] as Object[],'')
		}
	}
	
	static def checkDateTime = {val,obj,errors->
		if (!obj.dateTime && !obj.cronExpression) {
			errors.rejectValue(propertyName,"mailinglist.define.date.or.cron",[''] as Object[],'')
			return
		}
	}
	
	String getEmailMessage() {
		return emailMessage?.trim()?.replace('[SETDATE]',setDate ? setDate : '' )?.replace('[SETTIME]', setTime ? setTime : '')
	}
	void setAttachments(String t) {
		attachments=[AttachmentsBase.get(t)]
	}
	void setAttachments(List t) {
		attachments=t.collect{AttachmentsBase.get(it)}
	}
	void setRecipientToGroup(String t) {
		recipientToGroup=t
	}
	void setRecipientToGroup(List t) {
		recipientToGroup=t.join(',')
	}
	def loadValues() {
		return [mailFrom:mailFrom, recipientToGroup: recipientToGroup, subject: subject,
			mailingListTemplate: mailingListTemplate, dateTime: dateTime, setDate: setDate,
			setTime: setTime,emailMessage: emailMessage, recipientToList: recipientToList,
			recipientCCList: recipientCCList, cronExpression: cronExpression, 
			recipientBCCList: recipientBCCList, addedby: addedby,
			sendType: sendType, scheduleStatus: scheduleStatus
		]
	}
	protected def formatContent() {
		if (!recipientToGroup) {
			ttype='Email Person'
		}
	}
}
