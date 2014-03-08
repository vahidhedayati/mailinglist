package $pack

import java.text.SimpleDateFormat

class EmailController  {
	
	def quartzEmailCheckerService
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def index() {
		def curr=new Date()
		def dFormat="dd/MM/yyyy HH.mm"
		SimpleDateFormat df = new SimpleDateFormat(dFormat);
		def current= df.format(curr)
		 [current:current, curr:curr] 
		
	}
	def testclients() { }
	def contactclients()  {
		def curr=new Date()
		def dFormat="dd/MM/yyyy HH.mm"
		SimpleDateFormat df = new SimpleDateFormat(dFormat);
		def current= df.format(curr)
		if (params.emailMessage1) { 
			params.emailMessage=params.emailMessage1
		}
		[params:params, current:current, curr:curr]
	}
	def loadMessageBox= {
		def mlt=MailingListTemplates?.get(params.id)
		def content=mlt?.content
		render(template: 'message', model: [ content: content ])
	}

	
	def confirmcontact () {
		
		if (!params.dateTime) { 
			flash.message='Please define dateTime for email schedule'
			render(view: 'contactclients', model: [ params:params ])
		}
		if (!params.recipientToGroup) {
			flash.message='No Recipient Groups defined - please choose recipient group!'
			render(view: 'contactclients', model: [ params:params ])
		}	

		if (!params.mailFrom) {
			flash.message='Please define who mail is from'
			render(view: 'contactclients', model: [ params:params ])
		}
		if (!params.subject) {
			flash.message='need a SUBJECT!'
			render(view: 'contactclients', model: [ params:params ])
		}
		if (!params.emailMessage) {
			flash.message='no message found!'
			render(view: 'contactclients', model: [ params:params ])
		}
		
		[params:params]
	}
   def scheduleEmail () {
	   
	   def from=params.mailFrom
	   def recipientToGroup=params.recipientToGroup
	   def subject=params.subject
	   def attachments=params.attachments
	   def mailingListTemplate=params.mailingListTemplate
	   def dateTime=params.dateTime
	   def setDate=params.setDate
	   def setTime=params.setTime
	   def sendtype=params.sendType
	   def addedby=params.addedby
	   def recipientTo=params.recipientToList
	   def emailMessage=params.emailMessage
	   def recipientCCList =params.recipientCCList
	   def recipientBCCList=params. recipientBCCList
	   
	   if(!recipientToGroup) {
		   if ((!recipientTo) && (!recipientCCList) && (!recipientBCCList) ){
			   flash.message = message(code: 'Forgot to define either To or BCC or CC field, no one to contact !')
			 render(view: "index", model: [mailingListScheduleInstance: params])
			   return
		   
		   }
	   }
	   if (!setTime) { setTime=''}
	   if (!setDate) { setDate=''}
	   if (!recipientToGroup) { recipientToGroup=''}
	   if (!mailingListTemplate) {mailingListTemplate=''}
	   if (!recipientTo) { recipientTo=''}
	   if (!recipientCCList) {recipientCCList='' }
	   if (!recipientBCCList) {recipientBCCList='' }
	   if (!emailMessage) { emailMessage='' }
	   def ttype='Email Announcement'
	   if(recipientToGroup) {
		   	if (!sendtype) { sendtype='bulk' }
			   //emailMessage=''
	   }else{
	   		if (!sendtype) { sendtype='individual' }
			  ttype='Email Person'
	   }
	   
	   
	   
	   if (!dateTime) {
		   flash.message = message(code: 'Forgot to define the Time and Date to be run !')
		   if (recipientToGroup) {
			   render(view: "contactclients", model: [mailingListScheduleInstance: params])
		   }else{
		   		render(view: "index", model: [mailingListScheduleInstance: params])
		   }
		   return
	   }
	   
		def mailingListScheduleInstance = new MailingListSchedule(mailFrom:from, recipientToGroup: recipientToGroup, 
		subject: subject, attachments: attachments, mailingListTemplate: mailingListTemplate, dateTime: dateTime,  
		setDate: setDate, setTime: setTime, emailMessage: emailMessage, 
		recipientToList: recipientTo,recipientCCList: recipientCCList,  
		recipientBCCList: recipientBCCList,  addedby: addedby, sendType: sendtype, scheduleCancelled: false, 
		scheduleComplete: false,scheduleName:'', deploymentComplete: false)
		
		if (!mailingListScheduleInstance.save(flush: true)) {
			log.info("Error saving ::: ")
			mailingListScheduleInstance.errors.allErrors.each{println it}
			if (recipientToGroup) {
				render(view: "contactclients", model: [mailingListScheduleInstance: mailingListScheduleInstance])
			}else{
				render(view: "index", model: [mailingListScheduleInstance: mailingListScheduleInstance])
			}
		   return
		}
		
		params.id=mailingListScheduleInstance.id	   
		log.info("Schedule Email Parameters: "+params)
		def d = new Date()
		if (!params.setDate) {
		   params.setDate=d.format('dd MMM yyyy')
		}else{
	   		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy")
			d = dateFormat.parse(params.setDate)
			params.setDate=d.format('dd MMM yyyy')
		}
		if (!params.setTime_hour) {
		   	params.setTime=d.format('HH:MM')
		}else{
	   		params.setTime=params.setTime_hour+":"+params.setTime_minute
		}
	   
		if(params.emailMessage.indexOf('[SETDATE]')>-1) { 
		   params.emailMessage=params.emailMessage.replace('[SETDATE]', params.setDate)
		}
		if(params.emailMessage.indexOf('[SETTIME]')>-1) {
		   params.emailMessage=params.emailMessage.replace('[SETTIME]', params.setTime)
		}
		def result=quartzEmailCheckerService.queueEmail(params)
		if (result) {
		   mailingListScheduleInstance.scheduleName=result
		   mailingListScheduleInstance.save(flush:true)
		   flash.message = message(code: "Scheduled job name: ["+result+"] scheduledEmail success.")
		   redirect(controller:'MailingListSchedule',action:'br', )
		}else{
	   		if (recipientToGroup) {
				render(view: "contactclients", model: [mailingListScheduleInstance: mailingListScheduleInstance])
		  	}else{
			  	render(view: "index", model: [mailingListScheduleInstance: mailingListScheduleInstance])
			}
		   return
		}
   }
   
   def rescheduleit (params) { 
	   log.info("Schedule [ rescheduleit ]  Email Parameters: "+params)
	   def result=quartzEmailCheckerService.requeueEmail(params)
	   def mailingListSchedule=MailingListSchedule?.get(params.id)
	   if (mailingListSchedule)  { 
		   mailingListSchedule.each { gg->
			   gg.scheduleName=result
			   gg.save(flush:true)
		   }
	   } 
	   return result
   }
  
}
