package $pack

import org.quartz.Scheduler

import static org.quartz.impl.matchers.GroupMatcher.jobGroupEquals

import java.text.SimpleDateFormat
import java.util.Map;

import org.quartz.Scheduler
import org.quartz.Trigger
class QuartzEmailCheckerService {
	Scheduler quartzScheduler
	def grailsApplication
	def quartzStatusService
	static final Map<String, Trigger> triggers = [:]

	def requeueEmail(params) {
		StringBuilder sb=new StringBuilder()
		for (int i=0;i < $amount; i++) {
			Boolean running=true

			running=quartzStatusService.getQuartzStatus("ScheduleEmail"+i+"Job")
		
			def scheduledDate
			
			def cdt=params.dateTime
			def dFormat="dd/MM/yyyy HH.mm"
			if (cdt.indexOf(':')>-1) {
				dFormat="dd/MM/yyyy HH:mm"
			}
			
			
			SimpleDateFormat dateFormat = new SimpleDateFormat(dFormat)
			try {
				scheduledDate = dateFormat.parse(params.dateTime)
			}catch(Exception pe) {
				log.error("ERROR: Cannot parse"+scheduledDate)
			}
			
			if (scheduledDate) {
				scheduledDate = dateFormat.parse(params.dateTime)
				println "Scheduled EMAIL set for "+params.dateTime+" ("+scheduledDate+") "
				def paramsMap = [:]
				paramsMap.put('dateTime',params.dateTime)
				paramsMap.put('recipientCCList',params.recipientCCList)
				paramsMap.put('mailFrom',params.mailFrom)
				paramsMap.put('addedby',params.addedby)
				paramsMap.put('emailMessage',params.emailMessage)
				paramsMap.put('subject',params.subject)
				paramsMap.put('recipientBCCList',params.recipientBCCList)
				paramsMap.put('recipientToList',params.recipientToList)
				paramsMap.put('recipientToGroup',params.recipientToGroup)
				paramsMap.put('mailingListTemplate',params.mailingListTemplate)
				paramsMap.put('setDate',params.setDate)
				paramsMap.put('setTime',params.setTime)
				paramsMap.put('sendType',params.sendType)
				paramsMap.put('id',params.id)
				paramsMap.put('scheduleid',params.id)
				if (running==false) {
$jobMapping	
				}		
			}else{
				sb.append('Invalid schedule date & time given')
			}
		}
		return sb.toString()
	}
	
	
	def queueEmail(params) {
		StringBuilder sb=new StringBuilder()
		for (int i=0;i < $amount; i++) {
			Boolean running=true
			running=quartzStatusService.getQuartzStatus("ScheduleEmail"+i+"Job")
			def scheduledDate
			def cdt=params.dateTime
			def dFormat="dd/MM/yyyy HH.mm"
			if (cdt.indexOf(':')>-1) {
				dFormat="dd/MM/yyyy HH:mm"
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat(dFormat)
			try {
				scheduledDate = dateFormat.parse(params.dateTime)
			}catch(Exception pe) {
				log.error("ERROR: Cannot parse"+scheduledDate)
			}
			
			if (scheduledDate) {
				scheduledDate = dateFormat.parse(params.dateTime)
				println "Scheduled EMAIL set for "+params.dateTime+" ("+scheduledDate+") "
				if (running==false) {
$jobMapping
				}
			}else{
				sb.append('Invalid schedule date & time given')
			}
		}	
		return sb.toString()
	}
	
}
