package grails.plugin.mailinglist.core

import org.quartz.Scheduler
import org.springframework.dao.DataIntegrityViolationException

class MailingListScheduleController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def quartzStatusService
	Scheduler quartzScheduler

	def showmsg() {
		def record = ScheduleBase.get(params.id)
		if (record) {
			render record.emailMessage
		}
	}

	def br(Integer max, String s, String viewtype) {
		params.max = Math.min(params.int('max') ?: 50, 100)

		def userchoice = params.userchoice
		def foundHistory
		String pageSizes = params.pageSizes ?: '10'
		String envid = params.envid ?: ''
		int total = 0
		String order = params.order ?: "desc"
		String sortby = params.sortby ?: "lastUpdated"
		int offset = (params.offset ?: '0') as int
		def inputid = params.id
		String max1 = ""

		def paginationParams = [sort: sortby, order: order, offset: offset, max: params.max]
		switch (s) {
			case 'u':
				foundHistory = ScheduleBase.findAllByAddedby( params.id, paginationParams)
				total = ScheduleBase.countByAddedby(params.id)
				break
			case 'od':
				foundHistory = ScheduleBase.findAllByScheduleComplete(true, paginationParams)
				total = ScheduleBase.countByScheduleComplete(true)
				break
			case 'oc':
				foundHistory = ScheduleBase.findAllByScheduleCancelled(true, paginationParams)
				total = ScheduleBase.countByScheduleCancelled(true)
				break
			default:
				s = 'oa'
				foundHistory = ScheduleBase.findAllByScheduleCompleteAndScheduleCancelled(false, false, paginationParams)
				total = ScheduleBase.countByScheduleComplete(false)
		}
		params.template = request.xhr ? "mini-main" : "main"
		render view: 'list2', model: [now: new Date(), scheduler: quartzScheduler, divupdate: 'siteContent', evid:envid,
		                              pageSizes: pageSizes, offset: offset, viewtype: viewtype ?: "normal", max: max,
		                              userchoice: userchoice, deploymentInfoHistoryInstanceList: foundHistory,
		                              deploymentInfoHistoryInstanceTotal: total, inputid: inputid, s: s, order: order,
		                              sortby:sortby, action: 'br', template: params.template]
	}

	def modSchedule(String id, String calltype, String jobName) {
		StringBuilder sb = new StringBuilder()
		if (calltype) {
			if (id) {
				def cr = ScheduleBase.get(id)
				cr?.each { crec ->
					if (calltype.equals('cancel')) {
						sb.append('MailingListSchedule row marked as Cancelled ')
						crec.scheduleCancelled=true
					}
					if (calltype.equals('complete')) {
						sb.append('MailingListSchedule row marked as completed ')
						crec.scheduleComplete=true
					}
					cr.save(flush:true)
				}
			}

			if (jobName) {
				def ag = quartzStatusService.find(jobName)
				params.triggerName = quartzStatusService.ret_triggerName
				params.triggerGroup = quartzStatusService.ret_triggerGroup
				params.jobName = quartzStatusService.ret_jobName
				if (params.triggerName && params.triggerGroup) {
					sb.append(' | ').append(quartzStatusService.stop(params))
				}
			}
		}
		flash.message = sb.toString()
		redirect(url: request.getHeader('referer'))
	}

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		[mailingListScheduleInstanceList: ScheduleBase.list(params), mailingListScheduleInstanceTotal: ScheduleBase.count()]
	}

	def show(Long id) {
		def mailingListScheduleInstance = ScheduleBase.get(id)
		if (!mailingListScheduleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'ScheduleBase.label', default: 'MailingListSchedule'), id])
			redirect(action: "list")
			return
		}

		[mailingListScheduleInstance: mailingListScheduleInstance]
	}
}
