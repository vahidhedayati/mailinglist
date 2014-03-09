package $pack

import static org.quartz.impl.matchers.GroupMatcher.jobGroupEquals

import grails.plugins.quartz.QuartzMonitorJobFactory

import org.quartz.Scheduler
import org.quartz.Trigger
import org.quartz.impl.matchers.GroupMatcher

class QuartzStatusService {

	Scheduler quartzScheduler
	def grailsApplication

	String ret_triggerName
	String ret_triggerGroup
	String ret_jobName

	static final Map<String, Trigger> triggers = [:]

	boolean getQuartzStatus(String s) {
		boolean running = false
	   String currentController = currentController(s)
		def jobsList = []
		quartzScheduler.jobGroupNames?.each { jobGroup ->
			quartzScheduler.getJobKeys(jobGroupEquals(jobGroup))?.each { jobKey ->
				String jobName = jobKey.name
				quartzScheduler.getTriggersOfJob(jobKey)?.each {trigger ->
					if (jobName.equals(currentController)) {
						running = true
						log.info "Scheduled job \$jobName running will try next job"
					}
				}
			}
		}
		return running
	}

	def stop() {
		def triggerKeys = quartzScheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(params.triggerGroup))
		def key = triggerKeys?.find { it.name == params.triggerName }
		if (key) {
			def trigger = quartzScheduler.getTrigger(key)
			if (trigger) {
				triggers.put(params.jobName, trigger)
				quartzScheduler.unscheduleJob(key)
			}
			else {
				flash.message = "No trigger could be found for \$key"
			}
		}
		else {
			flash.message = "No trigger key could be found for \$params.triggerGroup : \$params.triggerName"
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
					quartzController.createJob(jobGroup, jobName, jobsList)
				}
			}
		}
		[jobs: jobsList, now: new Date(), scheduler: quartzScheduler]
	}

	def stop(params) {
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
				sb.append("No trigger could be found for ").append(key)
			}
		}
		else {
			sb.append("No trigger key could be found for ").append(params.triggerGroup).append(" : ").append(params.triggerName)
		}
		sb.append('Schedule cancelled from Quartz Schedule List')
		return sb.toString()
	}

	def getTriggers(String injobName) {
	   String currentController = currentController(injobName)
		def jobsList = []
		quartzScheduler.jobGroupNames?.each { jobGroup ->
			quartzScheduler.getJobKeys(jobGroupEquals(jobGroup))?.each {jobKey ->
				String jobName = jobKey.name
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
		def jobsList = []
		String results = ""
	   String currentController = currentController(injobName)

		quartzScheduler.jobGroupNames?.each { jobGroup ->
			quartzScheduler.getJobKeys(jobGroupEquals(jobGroup))?.each {jobKey ->
				String jobName = jobKey.name
				if (jobName.equals(currentController)) {
					List<Trigger> triggers = quartzScheduler.getTriggersOfJob(jobKey)
					if (triggers) {
						triggers.each { trigger ->
							ret_jobName = jobName
							ret_triggerName = trigger.key.name
							ret_triggerGroup = trigger.key.group
							results = " jobName: " + ret_jobName + " | triggerName: " + ret_triggerName + " | triggerGroup: " + trigger.key.group
						}
					}
				}
			}
		}
		return results
	}

	private String currentController(String s) {
		String domclass = s.substring(0,1).toUpperCase() + s.substring(1)
		grailsApplication.metadata['app.name'] + "." + domclass
	}
}
