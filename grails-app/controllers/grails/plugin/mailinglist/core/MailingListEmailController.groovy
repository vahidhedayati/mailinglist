package grails.plugin.mailinglist.core

import grails.transaction.Transactional
import groovy.time.TimeCategory

import java.text.SimpleDateFormat
@Transactional
class MailingListEmailController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	private static final String DATE_FORMAT = "dd/MM/yyyy HH.mm"

	def quartzEmailCheckerService
	def grailsApplication
	
	def index() {
		def curr = new Date()
		[current: new SimpleDateFormat(DATE_FORMAT).format(curr), curr: curr, mlAttach: domainList('MailingListAttachments')]
	}

	def testclients() { }
	


	def contactclients() {
		if (params.emailMessage1) {
			params.emailMessage = params.emailMessage1
		}
		def curr = new Date()
		[params: params, mlSenders: domainList('MailingListSenders'), mlCat:domainList('MailingListCategories'), 
			 mlAttach: domainList('MailingListAttachments'), mlTemp:domainList('MailingListTemplates') ,
			current: new SimpleDateFormat(DATE_FORMAT).format(curr), curr: curr]
	}

	
	def getAjaxCall(String ccontroller,String divId) {
		def myl= domainList(ccontroller)
		render(template: ccontroller+'Display', model: [mlSenders:myl, mlTemp: myl, mlCat: myl,mlAttach: myl,  divId: divId ])
	}
	
	def loadMessageBox() {
		def mlt = TemplatesBase.get(params.id)
		render(template: 'message', model: [ content: mlt?.content ])
	}

	def confirmcontact() {

		boolean ok = true
		def curr = new Date()
		String warnDuplicate=grailsApplication.config.mailinglist.warn.duplicate ?: 'N'
		def period=grailsApplication.config.mailinglist.warn.period
		def today= new Date()
		def goback
		def foundrecord
		use(TimeCategory) {
			if ((warnDuplicate.equals('Y')) && period) {
				if (period.indexOf('H')>-1) {
					def length=period.substring(0,period.indexOf('H'))
					length=length as int
					goback=length.hours.ago
				}else if (period.indexOf('M')>-1) {
					def length=period.substring(0,period.indexOf('M'))
					length=length as int
					goback=length.minutes.ago
				} else if (period.indexOf('D')>-1) {
					def length=period.substring(0,period.indexOf('D'))
					length=length as int
					goback=length.days.ago
				}else if (period.indexOf('m')>-1) {
					def length=period.substring(0,period.indexOf('m'))
					length=length as int
					goback=length.months.ago
				}else if (period.indexOf('y')>-1) {
					def length=period.substring(0,period.indexOf('y'))
					length=length as int
					goback=length.years.ago
				}

				if (goback) {
					foundrecord=ScheduleBase.findByDateCreatedGreaterThanEqualsAndRecipientToGroup(goback, params.recipientToGroup)
				}
			}


		}
		def warnResend
		if (foundrecord) {
			warnResend="""Warning you have sent an email out to this recipientGroup on
						${foundrecord.dateTime} with the following subject: 
						${foundrecord.subject}, click send to Proceed!"""
		}
		
		
		if (!params.dateTime && !params.cronExpression) {
			flash.message = 'Please define dateTime or cronExpression for email schedule'
			ok = false
		}

		if (ok && !params.recipientToGroup) {
			flash.message = 'No Recipient Groups defined - please choose recipient group!'
			ok = false
		}

		if (ok && !params.mailFrom) {
			flash.message = 'Please define who mail is from'
			ok = false
		}

		if (ok && !params.subject) {
			flash.message = 'need a SUBJECT!'
			ok = false
		}

		if (ok && !params.emailMessage) {
			flash.message = 'no message found!'
			ok = false
		}

		if (!ok) {
			render(view: 'contactclients', model: [ params:params,current: new SimpleDateFormat(DATE_FORMAT).format(curr), curr: curr ])
			return
		}

		[params:params, warnResend:warnResend ]
	}

	def scheduleEmail(ScheduleBaseBean bean) { 
		String view="index"
		if (bean.recipientToGroup) {
			view="contactclients"
		}
		if (bean.hasErrors()) {
			render(view: view, model: [mailingListScheduleInstance: bean])
			return
		}
		bean.formatContent()
		def paramsMap=bean.loadValues()
		ScheduleBase mailingListScheduleInstance = new ScheduleBase(paramsMap)
		bean.attachments?.each {
			mailingListScheduleInstance.addToAttachments(it)
		}
		if (!mailingListScheduleInstance.save(flush:true)) {
			flash.message = message(code:'mailinglist.failed.to.save')
			render(view: view, model: [mailingListScheduleInstance: bean])
			return
		}
		bean.id = mailingListScheduleInstance.id
		bean.dateFormat=g.message(code:'mailinglist.date.format', default:'dd MMM yyyy')
		paramsMap.id=bean.id
		log.info("Schedule Email Parameters: $params")
		def result = quartzEmailCheckerService.queueEmail(paramsMap)
		if (result) {
			ScheduleBase sb= ScheduleBase.get(mailingListScheduleInstance.id) //, [lock: true])
			if (sb) {
				sb.scheduleName = result
				sb.merge()
				if (!sb.save(flush: true)) {
					log.info("Error saving ScheduleName to ScheduleBase ::: ")
				}else{
					println "scheduleName set to "+result+" for "+mailingListScheduleInstance.id
				}
			}	
			//mailingListScheduleInstance.scheduleName = result
			//mailingListScheduleInstance.merge()
			//mailingListScheduleInstance.save(flush:true)
			flash.message = message(code: "Scheduled job name: [$result] scheduledEmail success.")
			redirect(controller:'MailingListSchedule',action:'br')
			return
		}
		flash.message = message(code: 'Could not queue job please check quartz queue to ensure schedule slots are free')
		render(view: view, model: [mailingListScheduleInstance: bean])
	}
					  
	private List domainList(def ccontroller) {
		grailsApplication?.domainClasses?.find { it.clazz.simpleName == currentController(ccontroller) }?.clazz?.list()
	} 
	
	private String currentController(String s) {
		s.substring(0,1).toUpperCase() + s.substring(1)
	}
					  
}
