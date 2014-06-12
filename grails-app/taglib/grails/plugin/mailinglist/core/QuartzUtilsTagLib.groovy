package grails.plugin.mailinglist.core
import org.quartz.Scheduler
import org.quartz.Trigger


class QuartzUtilsTagLib {
	
	static namespace = "quartzutils"
	def quartzStatusService
	Scheduler quartzScheduler
	def grailsApplication
	
	def find =  { attrs, body ->
		def jobName = attrs.remove('jobName')?.toString()
		def app_over = quartzStatusService.find(jobName)
		out << "${app_over}"
	}	
	
	def displayResume = {attrs, body ->
		def jobName = attrs.remove('jobName')?.toString()
		def jobs=quartzStatusService.getTriggers(jobName.toString().trim())
		jobs.each { job ->
			if (job.triggerStatus == Trigger.TriggerState.PAUSED) {
				def g = new org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib()
				def fullPath=grailsApplication.metadata['app.name']
				def deployit= g.createLink(uri:'/quartz/resume?jobName='+fullPath+"."+jobName+'&jobGroup=GRAILS_JOBS')
				def isrc=g.resource(dir: "images", file: "resume.png")
				out << """<a  href="${deployit}"><img src="${isrc}" data-tooltip="resume job schedule"/></a>"""
			}
		}	
	} 
	
	def jobRunningTime =  { attrs, body ->
		def jobName = attrs.remove('jobName')?.toString()
		def jobs=quartzStatusService.getTriggers(jobName.toString().trim())
		if (jobs) {
			jobs.each { job ->
				if (quartzScheduler.isInStandbyMode() || job.triggerStatus == Trigger.TriggerState.PAUSED) {
					out << "<td class='hasCountdown countdown_amount'>Paused</td>"
				}else{
					def aa=job.trigger?.nextFireTime?.time ?: ''
					out << "<td class='quartz-countdown' data-next-run='"+aa+"'}'>"
					out << job.trigger?.nextFireTime
					out << "</td>"
				}	
			}
		}else{
			out << "<td></td>"
		}
	}
}
