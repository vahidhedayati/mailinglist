package $pack

import grails.core.GrailsApplication
import grails.core.support.GrailsApplicationAware
import org.quartz.Trigger
import org.springframework.context.i18n.LocaleContextHolder as LCH

import java.text.SimpleDateFormat

class QuartzEmailCheckerService implements GrailsApplicationAware {

	def config
	GrailsApplication grailsApplication
	//Scheduler quartzScheduler

	def quartzStatusService
	def messageSource
	static final Map<String, Trigger> triggers = [:]

	String requeueEmail(params) {
		StringBuilder sb = new StringBuilder()
		Boolean isStarted=false
		String cdt = params.dateTime
		Date scheduledDate
		if (cdt) {
			scheduledDate = parse(cdt)
		}
		String cronExpression = params.cronExpression
		//int totalRunners=0
		${amount}.times { int i ->
			if (((!isRunning(i))&&(!isStarted))&&(scheduledDate||cronExpression)) {
				//if (isRunning(i)) { totalRunners++ }
				try {
					//log.info "Scheduled EMAIL set for \$cdt (\$scheduledDate)"
					log.info messageSource.getMessage('default.schedule.set.label', ["\${cdt}","\${scheduledDate}"].toArray(), "Scheduled EMAIL set for \$cdt (\$scheduledDate)", LCH.getLocale())
					sb = new StringBuilder()
					def paramsMap = [
						dateTime: cdt,
						recipientCCList: params.recipientCCList,
						mailFrom: params.mailFrom,
						addedby: params.addedby,
						emailMessage: params.emailMessage,
						subject: params.subject,
						recipientBCCList: params.recipientBCCList,
						recipientToList: params.recipientToList,
						recipientToGroup: params.recipientToGroup,
						mailingListTemplate: params.mailingListTemplate,
						setDate: params.setDate,
						setTime: params.setTime,
						sendType: params.sendType,
						id: params.id,
						scheduleid: params.id]
$jobMapping
				}
				catch(e) {
					//log.error("ERROR: Cannot parse \$cdt: \$e.message", e)
					//sb.append("Schedule_UNAVAILABLE")
					log.error messageSource.getMessage('default.error.parse.dateTime.format.label', ["\${cdt}","\${e.message}"].toArray(), "ERROR: Cannot parse \$cdt: \$e.message", LCH.getLocale()), e
					def msg=messageSource.getMessage('default.no.schedule.label',null, "Schedule_UNAVAILABLE",LCH.getLocale())
					sb.append(msg)
				}
			}
			//if ((totalRunners==${amount})&&(!isStarted)) {
			//	sb.append("COULD NOT SCHEDULE SLOTS 0 - ${amount} have been used")
			//}
				
		}
		return sb.toString()
	}

	String queueEmail(params) {
		StringBuilder sb = new StringBuilder()
		Boolean isStarted=false
		String cdt = params.dateTime
		Date scheduledDate
		if (cdt) {
			scheduledDate = parse(cdt)
		}
		String cronExpression = params.cronExpression
		//int totalRunners=0
		${amount}.times { int i ->
			if (((!isRunning(i))&&(!isStarted))&&(scheduledDate||cronExpression)) {
				//if (isRunning(i)) { totalRunners++ }
				try {
					//log.info "Scheduled EMAIL set for \$cdt (\$scheduledDate)"
					if (scheduledDate) {
						log.info messageSource.getMessage('default.schedule.set.label', ["\${cdt}","\${scheduledDate}"].toArray(), "Scheduled EMAIL set for \$cdt (\$scheduledDate)", LCH.getLocale())
					}
					sb = new StringBuilder()
$queueMapping
				
				}
				catch(e) {
					//log.error("ERROR: Cannot parse \$cdt: \$e.message", e)
					//sb.append("Schedule_UNAVAILABLE")
					log.error messageSource.getMessage('default.error.parse.dateTime.format.label', ["\${cdt}","\${e.message}"].toArray(), "ERROR: Cannot parse \$cdt: \$e.message", LCH.getLocale()), e
					def msg=messageSource.getMessage('default.no.schedule.label',null, "Schedule_UNAVAILABLE",LCH.getLocale())
					sb.append(msg)
				}
			}
			//if ((totalRunners==${amount})&&(!isStarted)) {
			//	sb.append("COULD NOT SCHEDULE SLOTS 0 - ${amount} have been used")
			//}
		}
		return sb.toString()
	}

	private boolean isRunning(int i) {
		quartzStatusService.getQuartzStatus("ScheduleEmail" + i + "Job")
	}

	private Date parse(String cdt) {
		String dFormat=config.mailinglist.dtFormat ?: 'dd/MM/yyyy HH.mm'
		try {
			new SimpleDateFormat(dFormat).parse(cdt)
		}catch(Exception pe) {
			//log.error("ERROR: Cannot parse"+cdt)
			log.error messageSource.getMessage('default.error.parse.dateTime.format.label', ["\${cdt}","\${pe.message}"].toArray(), "ERROR: Cannot parse \$cdt: \$pe.message", LCH.getLocale()), pe
		}
	}
	void setGrailsApplication(GrailsApplication ga) {
		config = ga.config
	}
}
