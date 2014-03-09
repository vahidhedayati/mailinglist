package $pack

import java.text.SimpleDateFormat

class MailingListEmailController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	private static final String DATE_FORMAT = "dd/MM/yyyy HH.mm"

	def quartzEmailCheckerService

	def index() {
		def curr = new Date()
		[current: new SimpleDateFormat(DATE_FORMAT).format(curr), curr: curr]
	}

	def testclients() { }

	def contactclients() {
		if (params.emailMessage1) {
			params.emailMessage = params.emailMessage1
		}
		def curr = new Date()
		[params: params, current: new SimpleDateFormat(DATE_FORMAT).format(curr), curr: curr]
	}

	def loadMessageBox() {
		def mlt = MailingListTemplates.get(params.id)
		render(template: 'message', model: [ content: mlt?.content ])
	}

	def confirmcontact() {

		boolean ok = true

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

		[params:params]
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

		def mailingListScheduleInstance = new MailingListSchedule(
			mailFrom:mailFrom, recipientToGroup: recipientToGroup, subject: subject, attachments: attachments,
			mailingListTemplate: mailingListTemplate, dateTime: dateTime, setDate: setDate, setTime: setTime,
			emailMessage: emailMessage, recipientToList: recipientToList,recipientCCList: recipientCCList,
			recipientBCCList: recipientBCCList,  addedby: addedby, sendType: sendtype, scheduleCancelled: false,
			scheduleComplete: false,scheduleName:'', deploymentComplete: false)

		if (!mailingListScheduleInstance.save(flush: true)) {
			log.info("Error saving ::: ")
//			mailingListScheduleInstance.errors.allErrors.each{println it}
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
		log.info("Schedule Email Parameters: \$params")
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
			mailingListScheduleInstance.scheduleName = result
			mailingListScheduleInstance.save(flush:true)
			flash.message = message(code: "Scheduled job name: [\$result] scheduledEmail success.")
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
}
