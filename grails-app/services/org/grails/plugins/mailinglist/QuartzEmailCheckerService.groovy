package org.grails.plugins.mailinglist

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
		for (int i=0;i < 20; i++) {
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
					if (i==0) {
						ScheduleEmail0Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==1) {
						ScheduleEmail1Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==2) {
						ScheduleEmail2Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==3) {
						ScheduleEmail3Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==4) {
						ScheduleEmail4Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==5) {
						ScheduleEmail5Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==6) {
						ScheduleEmail6Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==7) {
						ScheduleEmail7Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail7Job")
						break
					}else if (i==8) {
						ScheduleEmail8Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==9) {
						ScheduleEmail9Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==10) {
						ScheduleEmail10Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==11) {
						ScheduleEmail11Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail11Job")
						break
					}else if (i==12) {
						ScheduleEmail12Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==13) {
						ScheduleEmail13Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==14) {
						ScheduleEmail14Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==15) {
						ScheduleEmail15Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==16) {
						ScheduleEmail16Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==17) {
						ScheduleEmail17Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==18) {
						ScheduleEmail18Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==19) {
						ScheduleEmail19Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else if (i==20) {
						ScheduleEmail20Job.schedule(scheduledDate, paramsMap)
						sb.append("ScheduleEmail${i}Job")
						break
					}else{
						sb.append("No Email schedules found - all booked up")
						break
					}
				}
			}else{
				sb.append('Invalid schedule date & time given')
			}
		}
		return sb.toString()
	}
	
	
	def queueEmail(params) {
		StringBuilder sb=new StringBuilder()
		for (int i=0;i < 20; i++) {
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
				if (i==0) {
					ScheduleEmail0Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==1) {
					ScheduleEmail1Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==2) {
					ScheduleEmail2Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==3) {
					ScheduleEmail3Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==4) {
					ScheduleEmail4Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==5) {
					ScheduleEmail5Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==6) {
					ScheduleEmail6Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==7) {
					ScheduleEmail7Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==8) {
					ScheduleEmail8Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==9) {
					ScheduleEmail9Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==10) {
					ScheduleEmail10Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==11) {
					ScheduleEmail11Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==12) {
					ScheduleEmail12Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==13) {
					ScheduleEmail13Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==14) {
					ScheduleEmail14Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==15) {
					ScheduleEmail15Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==16) {
					ScheduleEmail16Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==17) {
					ScheduleEmail17Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==18) {
					ScheduleEmail18Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==19) {
					ScheduleEmail19Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else if (i==20) {
					ScheduleEmail20Job.schedule(scheduledDate, params)
					sb.append("ScheduleEmail${i}Job")
					break
				}else{
					sb.append("No Email schedules found - all booked up")
					break
				}
			}
			}else{
				sb.append('Invalid schedule date & time given')
			}
		}	
		return sb.toString()
	}
	
}
