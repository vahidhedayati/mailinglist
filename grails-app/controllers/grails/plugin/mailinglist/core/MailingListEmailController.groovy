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
			warnResend="""Warning you have sent an email out to this recipientGroup on ${foundrecord.dateTime} with the following subject: ${foundrecord.subject}, click send to Proceed!"""
		}
		
		
		if (!params.dateTime) {
			flash.message = 'Please define dateTime for email schedule'
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
			render(view: 'contactclients', model: [ params:params ])
			return
		}

		[params:params, warnResend:warnResend]
	}

	def scheduleEmail(String mailFrom, String recipientToGroup, String subject, String attachments,
	                  String mailingListTemplate, String dateTime, String setDate, String setTime,
	                  String sendType, String addedby, String recipientToList, String emailMessage,
	                  String recipientCCList, String recipientBCCList,String sendtype) {
		if (!recipientToGroup) {
			if (!recipientToList && !recipientCCList && !recipientBCCList) {
				flash.message = message(code: 'Forgot to define either To or BCC or CC field, no one to contact !')
				render(view: "index", model: [mailingListScheduleInstance: params])
				return
			}
		}
		
		if (!setTime) { setTime=''}
		if (!setDate) { setDate=''}
		if (!recipientToGroup) { recipientToGroup=''}
		if (!mailingListTemplate) {mailingListTemplate=''}
		if (!recipientToList) { recipientToList=''}
		if (!recipientCCList) {recipientCCList='' }
		if (!recipientBCCList) {recipientBCCList='' }
		if (!emailMessage) { emailMessage='' }

		String ttype = 'Email Announcement'
		if (recipientToGroup) {
			if (!sendtype) { sendtype='bulk' }
			//emailMessage=''
		}
		else {
			if (!sendtype) { sendtype='individual' }
			ttype='Email Person'
		}

		if (!dateTime) {
			flash.message = message(code: 'Forgot to define the Time and Date to be run !')
			if (recipientToGroup) {
				render(view: "contactclients", model: [mailingListScheduleInstance: params])
			}
			else{
				render(view: "index", model: [mailingListScheduleInstance: params])
			}
			return
		}
		// 0.10 to get around recipientToGroup and attachments appearing as Ljava.lang.String;@5792bb81 params added to both
		def mailingListScheduleInstance = new ScheduleBase(
			mailFrom:mailFrom, recipientToGroup: params.recipientToGroup, subject: subject, attachments: params.attachments,
			mailingListTemplate: mailingListTemplate, dateTime: dateTime, setDate: setDate, setTime: setTime,
			emailMessage: emailMessage, recipientToList: recipientToList,recipientCCList: recipientCCList,
			recipientBCCList: recipientBCCList,  addedby: addedby, sendType: sendtype, scheduleCancelled: false,
			scheduleComplete: false,scheduleName:'', deploymentComplete: false)
			if (!mailingListScheduleInstance.save(flush:true)) {
				log.info("Error saving ::: ")
				//mailingListScheduleInstance.errors.allErrors.each{println it}
				flash.message = message(code: 'Error saving schedule in DB table MailingListSchedule')
				if (recipientToGroup) {
					render(view: "contactclients", model: [mailingListScheduleInstance: mailingListScheduleInstance])
				}
				else{
					render(view: "index", model: [mailingListScheduleInstance: mailingListScheduleInstance])
				}
				return
			}

		params.id = mailingListScheduleInstance.id
		log.info("Schedule Email Parameters: $params")
		def d = new Date()
		if (!params.setDate) {
			params.setDate = d.format('dd MMM yyyy')
		}
		else {
			d = new SimpleDateFormat("dd/MM/yyyy").parse(params.setDate)
			params.setDate = d.format('dd MMM yyyy')
		}
		if (!params.setTime_hour) {
			params.setTime = d.format('HH:MM')
		}
		else {
			params.setTime = params.setTime_hour + ":" + params.setTime_minute
		}

		if (params.emailMessage.indexOf('[SETDATE]') > -1) {
			params.emailMessage = params.emailMessage.replace('[SETDATE]', params.setDate)
		}
		if (params.emailMessage.indexOf('[SETTIME]') >- 1) {
			params.emailMessage = params.emailMessage.replace('[SETTIME]', params.setTime)
		}
		def result = quartzEmailCheckerService.queueEmail(params)
		if (result) {
			ScheduleBase sb= ScheduleBase.findById(mailingListScheduleInstance.id, [lock: true])
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
		if (recipientToGroup) {
			render(view: "contactclients", model: [mailingListScheduleInstance: mailingListScheduleInstance])
		}
		else {
			render(view: "index", model: [mailingListScheduleInstance: mailingListScheduleInstance])
		}
	}
					  
	private List domainList(def ccontroller) {
		grailsApplication?.domainClasses?.find { it.clazz.simpleName == currentController(ccontroller) }?.clazz?.list()
	} 
	
	private String currentController(String s) {
		s.substring(0,1).toUpperCase() + s.substring(1)
	}
					  
}
