package grails.plugin.mailinglist.core

import org.grails.web.util.WebUtils

import static org.quartz.impl.matchers.GroupMatcher.jobGroupEquals
import grails.plugins.quartz.QuartzMonitorJobFactory

import org.quartz.Scheduler
import org.quartz.Trigger
import org.quartz.impl.matchers.GroupMatcher
import org.springframework.context.i18n.LocaleContextHolder as LCH


class QuartzStatusService {
	Scheduler quartzScheduler
	def messageSource
	static final Map<String, Trigger> triggers = [:]
	boolean getQuartzStatus(String s) {
		boolean running = false
	   String currentController = currentController(s)
		def jobsList = []
		quartzScheduler.jobGroupNames?.each { jobGroup ->
			quartzScheduler.getJobKeys(jobGroupEquals(jobGroup))?.each { jobKey ->
				String jobName = jobKey.name
				quartzScheduler.getTriggersOfJob(jobKey)?.each { trigger ->
					if (jobName.endsWith(currentController)) {
						running = true
						log.info messageSource.getMessage('default.schedule.booked.label', ["${jobName}"].toArray(), "Scheduled job ${jobName} running will try next job", LCH.getLocale())
					}
				}	
			}
		}
		return running
	}

	def stop() {
		def webUtils = WebUtils.retrieveGrailsWebRequest()
		def currentrequest=webUtils.getCurrentRequest()
		//def currentresponse=webUtils.getCurrentResponse()
		//def currentcontext=webUtils.getServletContext()
		def triggerKeys = quartzScheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(params.triggerGroup))
		def key = triggerKeys?.find { it.name == params.triggerName }
		if (key) {
			def trigger = quartzScheduler.getTrigger(key)
			if (trigger) {
				triggers.put(params.jobName, trigger)
				quartzScheduler.unscheduleJob(key)
			}
			else {
				//flash.message = "No trigger could be found for $key"
				flash.message=messageSource.getMessage('default.no.trigger.found.label', ["${key}"].toArray(), "No trigger could be found for ${key}", currentrequest.getLocale())
			}
		}
		else {
			//flash.message = "No trigger key could be found for $params.triggerGroup : $params.triggerName"
			flash.message=messageSource.getMessage('default.no.trigger.found.label', ["${params.triggerGroup}", "${params.triggerName}"].toArray(), "No trigger key could be found for ${params.triggerGroup} : ${params.triggerName}", currentrequest.getLocale())
		}
		redirect(action: "list")
	}

	def list() {
		def jobsList = []
		quartzScheduler.jobGroupNames?.each { jobGroup ->
			quartzScheduler.getJobKeys(jobGroupEquals(jobGroup))?.each {jobKey ->
				String jobName = jobKey.name
				List<Trigger> triggers = quartzScheduler.getTriggersOfJob(jobKey)
				if (triggers) {
					triggers.each { trigger ->
						def currentJob = quartzController.createJob(jobGroup, jobName, jobsList, trigger.key.name)
						currentJob.trigger = trigger
						def state = quartzScheduler.getTriggerState(trigger.key)
						currentJob.triggerStatus = Trigger.TriggerState.find {
							it == state
						} ?: "UNKNOWN"
					}
				}
				else {
					createJob(jobGroup, jobName, jobsList)
				}
			}
		}
		[jobs: jobsList, now: new Date(), scheduler: quartzScheduler]
	}

	def stop(params) {
		def webUtils = WebUtils.retrieveGrailsWebRequest()
		def currentrequest=webUtils.getCurrentRequest()
		StringBuilder sb = new StringBuilder()
		def triggerKeys = quartzScheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(params.triggerGroup))
		def key = triggerKeys?.find {it.name == params.triggerName}
		if (key) {
			def trigger = quartzScheduler.getTrigger(key)
			if (trigger) {
				triggers.put(params.jobName, trigger)
				quartzScheduler.unscheduleJob(key)
			}
			else {
				//sb.append("No trigger could be found for ").append(key)
				def msg=messageSource.getMessage('default.no.trigger.for.label', null, "No trigger could be found for ", currentrequest.getLocale())
				sb.append(msg).append(key)
			}
		}
		else {
			//sb.append("No trigger key could be found for ").append(params.triggerGroup).append(" : ").append(params.triggerName)
			def msg=messageSource.getMessage('default.no.trigger.for.label', null, "No trigger could be found for ", currentrequest.getLocale())
			sb.append(msg).append(params.triggerGroup).append(" : ").append(params.triggerName)
		}
		//sb.append('Schedule cancelled from Quartz Schedule List')
		def msg=messageSource.getMessage('default.schedule.cancelled.label', null, "Schedule cancelled from Quartz Schedule List' ", currentrequest.getLocale())
		sb.append(msg)
		return sb.toString()
	}

	def getTriggers(String injobName) {
	   String currentController = currentController(injobName)
		def jobsList = []
		quartzScheduler.jobGroupNames?.each { jobGroup ->
			quartzScheduler.getJobKeys(jobGroupEquals(jobGroup))?.each {jobKey ->
				String jobName = jobKey.name
				if (jobName.endsWith(currentController)) {
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
					}
					else {
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

	def find(String injobName) {
		def resultset = [:]
		def jobsList = []
		String results = ""
		String currentController = currentController(injobName)
		quartzScheduler.jobGroupNames?.each { jobGroup ->
			quartzScheduler.getJobKeys(jobGroupEquals(jobGroup))?.each {jobKey ->
				String jobName = jobKey.name
				if (jobName.endsWith(currentController)) {
					List<Trigger> triggers = quartzScheduler.getTriggersOfJob(jobKey)
					if (triggers) {
						triggers.each { trigger ->
							resultset.put('jobName', jobName)
							resultset.put('triggerName', trigger.key.name)
							resultset.put('triggerGroup', trigger.key.group)
						}
					}
				}
			}
		}
		return resultset
	}

	private String currentController(String s) {
		s.substring(0,1).toUpperCase() + s.substring(1)
	}
}
