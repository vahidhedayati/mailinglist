package org.grails.plugins.mailinglist

import org.quartz.Scheduler;

import org.quartz.Scheduler

import static org.quartz.impl.matchers.GroupMatcher.jobGroupEquals
import grails.plugins.quartz.QuartzMonitorJobFactory

import org.quartz.Scheduler
import org.quartz.Trigger
import org.quartz.impl.matchers.GroupMatcher
class QuartzStatusService {
	Scheduler quartzScheduler
	def grailsApplication
	def ret_triggerName
	def ret_triggerGroup
	def ret_jobName
	static final Map<String, Trigger> triggers = [:]
	Boolean getQuartzStatus(String s) {
	   Boolean running=false
	   String domclass1= (s.substring(0,1).toUpperCase())
	   String domclass2=s.substring(1,s.length())
	   String domclass=domclass1+domclass2
	   def fullPath=grailsApplication.metadata['app.name']
	   def currentController=fullPath+"."+domclass
		def jobsList = []
		def listJobGroups = quartzScheduler.getJobGroupNames()
		listJobGroups?.each {jobGroup ->
			quartzScheduler.getJobKeys(jobGroupEquals(jobGroup))?.each {jobKey ->
				def jobName = jobKey.name
				List<Trigger> triggers = quartzScheduler.getTriggersOfJob(jobKey)
				if (triggers) {
					triggers.each {trigger ->
						if (jobName.equals(currentController)) {
							running=true
							println "Scheduled job "+jobName+" running will try next job"
						}	
					}
				}
			}
		}
		return running
	}
	
	def stop = {
		def triggerKeys = quartzScheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(params.triggerGroup))
		def key = triggerKeys?.find {it.name == params.triggerName}
		if (key) {
			def trigger = quartzScheduler.getTrigger(key)
			if (trigger) {
				triggers.put(params.jobName, trigger)
				quartzScheduler.unscheduleJob(key)
			} else {
				flash.message = "No trigger could be found for $key"
			}
		} else {
			flash.message = "No trigger key could be found for $params.triggerGroup : $params.triggerName"
		}
		redirect(action: "list")
	}
	
	
	def list = {
		def jobsList = []
		def listJobGroups = quartzScheduler.getJobGroupNames()
		listJobGroups?.each {jobGroup ->
			quartzScheduler.getJobKeys(jobGroupEquals(jobGroup))?.each {jobKey ->
				def jobName = jobKey.name
				List<Trigger> triggers = quartzScheduler.getTriggersOfJob(jobKey)
				if (triggers) {
					triggers.each {trigger ->
						def currentJob = quartzController.createJob(jobGroup, jobName, jobsList, trigger.key.name)
						currentJob.trigger = trigger
						def state = quartzScheduler.getTriggerState(trigger.key)
						currentJob.triggerStatus = Trigger.TriggerState.find {
							it == state
						} ?: "UNKNOWN"
					}
				} else {
					quartzController.createJob(jobGroup, jobName, jobsList)
				}
			}
		}
		[jobs: jobsList, now: new Date(), scheduler: quartzScheduler]
	}


	def stop (params) {
		StringBuilder sb=new StringBuilder()
		def triggerKeys = quartzScheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(params.triggerGroup))
		def key = triggerKeys?.find {it.name == params.triggerName}
		if (key) {
			def trigger = quartzScheduler.getTrigger(key)
			if (trigger) {
				triggers.put(params.jobName, trigger)
				quartzScheduler.unscheduleJob(key)
			} else {
				sb.append( "No trigger could be found for $key")
			}
		} else {
			sb.append( "No trigger key could be found for $params.triggerGroup : $params.triggerName")
		}
		sb.append('Schedule cancelled from Quartz Schedule List')
		return sb.toString()
	}


	
	def getTriggers(String injobName) {
		def results=""
		def s=injobName
		String domclass1= (s.substring(0,1).toUpperCase())
		String domclass2=s.substring(1,s.length())
		String domclass=domclass1+domclass2
		def fullPath=grailsApplication.metadata['app.name']
		def currentController=fullPath+"."+domclass
		
			def jobsList = []
			def listJobGroups = quartzScheduler.jobGroupNames
			listJobGroups?.each {jobGroup ->
				quartzScheduler.getJobKeys(jobGroupEquals(jobGroup))?.each {jobKey ->
					def jobName = jobKey.name
					
					if (jobName.equals(currentController)) {
					List<Trigger> triggers = quartzScheduler.getTriggersOfJob(jobKey)
					if (triggers) {
						triggers.each {trigger ->
							def currentJob = createJob(jobGroup, jobName, jobsList, trigger.key.name)
							currentJob?.trigger = trigger
							def state = quartzScheduler?.getTriggerState(trigger.key)
							currentJob?.triggerStatus = Trigger.TriggerState.find {
								it == state
							} ?: "UNKNOWN"
						}
					}else {
                    	createJob(jobGroup, jobName, jobsList)
					}
				}
			}	
		}
		return jobsList
		
	}
	private createJob(String jobGroup, String jobName, List jobsList, String triggerName = "") {
		def currentJob = [group: jobGroup, name: jobName]
		def map = QuartzMonitorJobFactory.jobRuns[triggerName]
		if (map) currentJob << map
		jobsList << currentJob
		return currentJob
	}

	def find (String injobName) {
		def jobsList = []
		def results=""
		def s=injobName
		String domclass1= (s.substring(0,1).toUpperCase())
		String domclass2=s.substring(1,s.length())
		String domclass=domclass1+domclass2
		def fullPath=grailsApplication.metadata['app.name']
		def currentController=fullPath+"."+domclass
		
		
		def listJobGroups = quartzScheduler.getJobGroupNames()
		listJobGroups?.each {jobGroup ->
			quartzScheduler.getJobKeys(jobGroupEquals(jobGroup))?.each {jobKey ->
				def jobName = jobKey.name
				if (jobName.equals(currentController)) { 
					List<Trigger> triggers = quartzScheduler.getTriggersOfJob(jobKey)
					if (triggers) {
						triggers.each {trigger ->
							ret_jobName=jobName
							def triggerName=trigger.key.name
							ret_triggerName=triggerName
							def triggerGroup=trigger.key.group
							ret_triggerGroup=triggerGroup
							results= " jobName: "+ret_jobName+" | triggerName: "+triggerName+" | triggerGroup: "+triggerGroup
							
						}
					} 
				}
			}
		}
		return results
	}
   
}
