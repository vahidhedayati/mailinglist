package $pack

import static org.quartz.impl.matchers.GroupMatcher.jobGroupEquals

import java.text.SimpleDateFormat

import org.quartz.Scheduler
import org.quartz.Trigger

class QuartzEmailCheckerService {

	Scheduler quartzScheduler
	def grailsApplication
	def quartzStatusService

	static final Map<String, Trigger> triggers = [:]

	String requeueEmail(params) {
		StringBuilder sb = new StringBuilder()
		Boolean isStarted=false
		${amount}.times { int i ->
			String cdt = params.dateTime
			try {
				Date scheduledDate = parse(cdt)
				log.info "Scheduled EMAIL set for \$cdt (\$scheduledDate)"
				if ((!isRunning(i))&&(!isStarted)) {
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
			}
			catch(e) {
				log.error("ERROR: Cannot parse \$cdt: \$e.message", e)
				sb.append("Invalid schedule date & time given: \$cdt")
			}
		}
		return sb.toString()
	}

	String queueEmail(params) {
		StringBuilder sb = new StringBuilder()
		Boolean isStarted=false
		${amount}.times { int i ->
			String cdt = params.dateTime
			try {
				Date scheduledDate = parse(cdt)
				log.info "Scheduled EMAIL set for \$cdt (\$scheduledDate)"
				if ((!isRunning(i))&&(!isStarted)) {
$queueMapping
				}
			}
			catch(e) {
				log.error("ERROR: Cannot parse \$cdt: \$e.message", e)
				sb.append("Invalid schedule date & time given: \$cdt")
			}
		}
		return sb.toString()
	}

	private boolean isRunning(int i) {
		quartzStatusService.getQuartzStatus("ScheduleEmail" + i + "Job")
	}

	private Date parse(String cdt) {
		String dFormat = "dd/MM/yyyy HH.mm"
		if (cdt.indexOf(':') > -1) {
			dFormat = "dd/MM/yyyy HH:mm"
		}

		new SimpleDateFormat(dFormat).parse(cdt)
	}
}
