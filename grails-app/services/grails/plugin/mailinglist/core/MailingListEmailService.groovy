package grails.plugin.mailinglist.core

import grails.transaction.Transactional
import org.springframework.context.i18n.LocaleContextHolder as LCH
@Transactional
class MailingListEmailService {

	def grailsApplication
	def mailService
	def messageSource
	def quartzEmailCheckerService

	void SendHMail(toconfig, mycc, mysubject, mybody) {
		doSendMail toconfig, mycc, mysubject, mybody, true
	}

	void SendMail(toconfig, mycc, mysubject, mybody) {
		doSendMail toconfig, mycc, mysubject, mybody, false
	}

	def domainGetter(domain,rvalue) {
		StringBuilder sb=new StringBuilder()
		if (rvalue.isNumber()) {
			def criteria =  {  eq ( 'id', rvalue as Long ) }
			def results=grailsApplication?.domainClasses?.find { it.clazz.simpleName == currentController(domain) }?.clazz?.createCriteria().list(criteria)
			if (results) {
				results.each  {
					sb.append(it)
				}
			}
		}
		return sb.toString()
	}

	private void doSendMail(toconfig, mycc, mysubject, mybody, boolean html) {
		List<String> recipients = []
		String email = calculateAddresses(recipients, toconfig)
		List<String> ccrecipients = []
		String ccuser = calculateAddresses(recipients, mycc)
		try {
			mailService.sendMail {
				if (recipients) {
					to recipients
				}
				else {
					to email
				}

				if (ccrecipients) {
					cc ccrecipients
				}
				else {
					if (ccuser) {
						cc ccuser
					}
				}
				subject mysubject
				if (html) {
					if (mybody.indexOf('<html>') == -1) {
						mybody = "<html><body bgcolor=#CCC>" + mybody + "</body></html>"
					}
					if (mybody) {
						html mybody
					}
				}
				else if (mybody) {
					body mybody
				}
			}
		}
		catch (e) {
			log.error messageSource.getMessage('default.issue.sending.email.label', ["${e.message}"].toArray(), "Problem sending email ${e.message}", LCH.getLocale()),e
		}
	}

	def sendEmail(Map paramsMap) {
		def emailSubject = paramsMap.subject
		def recipientTo = paramsMap.recipientToList
		def recipientTo2 = paramsMap.recipientToList2
		def message = paramsMap.emailMessage
		def recipientCC = paramsMap.recipientCCList
		def recipientBCC = paramsMap.recipientBCCList
		def emailFrom = paramsMap.mailFrom
		def recipientToGroup = paramsMap.recipientToGroup
		def template = paramsMap.mailingListTemplate
		def templateModel = paramsMap.mailingListTemplateModel
		def scheduleid = paramsMap.id

		def recipientToList=recipientTo
		if (recipientTo){
			recipientToList=returnEmailArray(recipientTo)
		}
		
		def recipientToList2=recipientTo2
		if (recipientTo2){
			recipientToList2=returnEmailArray(recipientTo2)
		}
		
		def recipientCCList=recipientCC
		if (recipientCC){
			recipientCCList=returnEmailArray(recipientCC)
		}
		
		def recipientBCCList=recipientBCC
		if (recipientBCC){
			recipientBCCList=returnEmailArray(recipientBCC)
		}
		
		if (!scheduleid) {
			scheduleid = paramsMap.scheduleid
		}
		log.info messageSource.getMessage('default.sending.schedule.label', ["${scheduleid}"].toArray(), "sendEmail Schedule ID: ${scheduleid}", LCH.getLocale())
		String sendtype = paramsMap.sendType
		if (recipientToGroup) {
			if (!sendtype) { sendtype='bulk' }
		}
		def cidimg
		String aimage = ''
		String cproject = grailsApplication.metadata['app.name']
		String baseurl = grailsApplication.config.grails.baseURL
		//def uploadpath=grailsApplication.config.externalUploadPath
		String imgsearch = '<img alt="" src="/' + cproject
		String fulldomain = '<img alt="" src="' + baseurl
		def currentMap = [:]
		def currentMap1 = [:]

		message.eachLine { line ->
			if (line.indexOf(imgsearch) > -1) {
				String aimage1 = line.substring(line.indexOf('<img alt="" src="') + 17)
				aimage = aimage1.substring(0, aimage1.indexOf('"'))
				String rest = aimage1.substring(aimage1.indexOf('"'),aimage1.length())
				String imgtag = aimage.substring(aimage.lastIndexOf("/") + 1)
				if (imgtag.indexOf('.') > -1) {
					cidimg = imgtag.substring(0,imgtag.indexOf('.'))
				}
				message = message.replace(aimage, "cid:" + cidimg)
				currentMap[cidimg] = aimage
			}
			else if (line.indexOf(fulldomain) > -1) {
				String aimage1 = line.substring(line.indexOf('<img alt="" src="') + 17)
				aimage = aimage1.substring(baseurl.length(), aimage1.indexOf('"'))
				String rest = aimage1.substring(aimage1.indexOf('"'))
				String imgtag = aimage.substring(aimage.lastIndexOf("/") + 1)
				if (imgtag.indexOf('.') > -1) {
					cidimg = imgtag.substring(0, imgtag.indexOf('.'))
				}
				message = message.replace(baseurl + aimage, "cid:" + cidimg)
				currentMap1[cidimg] = aimage
			}
		}
		if (sendtype.equals('bulk')) {
			def primary = []
			if (recipientToGroup) {
				if (recipientToGroup.getClass().isArray()) {
					recipientToGroup.each { rg ->
						CategoryBase.get(rg)?.mailinglist?.each { currentemail ->
							if (currentemail) {
								primary << currentemail
							}
						}
					}
				}
				else {
					CategoryBase.get(recipientToGroup)?.mailinglist?.each { currentemail ->
						if (currentemail) {
							primary << currentemail
						}
					}
				}
			}
			if (primary) {
				recipientBCCList = primary
				log.info messageSource.getMessage('default.sending.schedule.to.group.label', ["${recipientToGroup}","${recipientBCCList}"].toArray(), "Scheduled Email: Email being sent to Group ${recipientToGroup} : ${recipientBCCList}", LCH.getLocale())
			}
			else {
				log.info messageSource.getMessage('default.sending.schedule.to.person.label', ["${recipientToList}"].toArray(), "Scheduled Email: Email being sent to Person: ${recipientToList}", LCH.getLocale())
			}
			try {
				boolean mp = false
				mailService.sendMail {
					if (paramsMap.attachments) {
						multipart true
						mp = true
					}
					if (!mp && message.indexOf('<img') > -1) {
						multipart true
						mp = true
					}
					if (!mp && scheduleid && ScheduleBase?.get(scheduleid)?.attachments) {
						multipart true
						mp = true
					}
					if (emailFrom) {from emailFrom }
					if (emailSubject) {subject emailSubject }
					if (recipientToList) {to recipientToList }
					if (!recipientToList && recipientToList2) { to recipientToList2 }
					if (recipientCCList) { cc recipientCCList}
					if (recipientBCCList) { bcc recipientBCCList}					
					if(template && templateModel){
						html grailsApplication.mainContext.groovyPageRenderer.render(template: template, model: templateModel)
					} else {
						html message
					}
					currentMap.each { k, v ->
						inline k, 'image/jpg', new File(System.properties['catalina.base'], "webapps/$v")
					}
					currentMap1.each { k, v ->
						inline k, 'image/jpg', new File(System.properties['catalina.base'], v)
					}
					if (scheduleid) {
						ScheduleBase?.get(scheduleid)?.attachments?.each { att ->
							attachBytes att.fullname, att.contentType, att.attachment
						}
					}
				}
			}
			catch (e) {
				log.error messageSource.getMessage('default.issue.sending.email.label', ["${e.message}"].toArray(), "Problem sending email ${e.message}", LCH.getLocale()),e
			}
		}
		else {
			if (recipientToGroup) {
				recipientToGroup.each { rg ->
					for (currentemail in CategoryBase?.get(rg)?.mailinglist) {
						if (!currentemail) {
							continue
						}
						recipientToList = currentemail?.emailAddress
						log.info messageSource.getMessage('default.sending.schedule.to.person.label', ["${recipientToList}"].toArray(), "Scheduled Email: Email being sent to Person: ${recipientToList}", LCH.getLocale())
						try {
							boolean mp = false
							mailService.sendMail {
								if (paramsMap.attachments) {
									multipart true
									mp = true
								}
								if (!mp && message.indexOf('<img') > -1) {
									multipart true
									mp=true
								}
								if (!mp && scheduleid && ScheduleBase?.get(scheduleid)?.attachments) {
									multipart true
									mp = true
								}
								if (emailFrom) {from emailFrom }
								if (emailSubject) {subject emailSubject }
								if (recipientToList) {to recipientToList }
								if (!recipientToList && recipientToList2) {to recipientToList2 }
								if (recipientCCList) { cc recipientCCList}
								if (recipientBCCList) { bcc recipientBCCList}								
								if(template && templateModel){
									html grailsApplication.mainContext.groovyPageRenderer.render(template: template, model: templateModel)
								} else {
									html message
								}
								currentMap.each { k, v ->
									inline k, 'image/jpg', new File(System.properties['catalina.base'], "webapps/$v")
								}
								currentMap1.each { k, v ->
									inline k, 'image/jpg', new File(System.properties['catalina.base'], v)
								}
								if (scheduleid) {
									ScheduleBase?.get(scheduleid)?.attachments?.each { att ->
										attachBytes att.fullname, att.contentType, att.attachment
									}
								}
							}
						}
						catch (e) {
							log.error messageSource.getMessage('default.issue.sending.email.label', ["${e.message}"].toArray(), "Problem sending email ${e.message}", LCH.getLocale()),e
						}
					}
				}
			}
			else {
				log.info messageSource.getMessage('default.sending.schedule.to.person.label', ["${recipientToList}"].toArray(), "Scheduled Email: Email being sent to Person: ${recipientToList}", LCH.getLocale())
				try {
					boolean mp = false
					mailService.sendMail {
						if (paramsMap.attachments) {
							multipart true
							mp = true
						}
						if (!mp && message.indexOf('<img') > -1) {
							multipart true
							mp = true
						}
						if (!mp && scheduleid && ScheduleBase?.get(scheduleid)?.attachments) {
							multipart true
							mp = true
						}
						if (emailFrom) {from emailFrom }
						if (emailSubject) {subject emailSubject }
						if (recipientToList) {to recipientToList }
						if (!recipientToList && recipientToList2) {to recipientToList2 }
						if (recipientCCList) { cc recipientCCList}
						if (recipientBCCList) { bcc recipientBCCList}						
						if(template && templateModel){
							html grailsApplication.mainContext.groovyPageRenderer.render(template: template, model: templateModel)
						} else {
							html message
						}
						currentMap.each { k, v ->
							inline k, 'image/jpg', new File(System.properties['catalina.base'], "webapps/$v")
						}
						currentMap1.each{ k, v ->
							inline k, 'image/jpg', new File(System.properties['catalina.base'], v)
						}
						if (scheduleid) {
							ScheduleBase?.get(scheduleid)?.attachments?.each { att ->
								attachBytes att.fullname, att.contentType, att.attachment
							}
						}
					}
				}
				catch (e) {
					log.error messageSource.getMessage('default.issue.sending.email.label', ["${e.message}"].toArray(), "Problem sending email ${e.message}", LCH.getLocale()),e
				}
			}
		}

		if (!scheduleid) {
			log.info messageSource.getMessage('default.error.saving.schedule.id.label', null, "Could not Updating status of MailingListSchedule: no ID was found for the schedule", LCH.getLocale())
			return
		}
		log.info messageSource.getMessage('default.saved.schedule.id.label', ["${scheduleid}"].toArray(), "Updating ScheduleID ${scheduleid} setting scheduleComplete as true", LCH.getLocale())
		ScheduleBase foundit = ScheduleBase.get(scheduleid)
		//ScheduleBase foundit= ScheduleBase.findById(scheduleid, [lock: true])
		if (foundit) {
			foundit.scheduleStatus = ScheduleBase.SCHEDULE_COMPLETE
			foundit.merge()
			foundit.save(flush:true)
		}
	}

	def rescheduleit(params) {
		log.info messageSource.getMessage('default.schedule.rescheduled.label', ["${params}"].toArray(), "Schedule [ rescheduleit ]  Email Parameters: ${params}", LCH.getLocale())
		def result = quartzEmailCheckerService.requeueEmail(params)
		ScheduleBase.get(params.id)?.each { gg->
			gg.scheduleName = result
			gg.save()
		}
		return result
	}

	private String calculateAddresses(List<String> recipients, config) {
		String address = ''
		if (config) {
			if (config.toString().indexOf('@') > -1) {
				address = config
			}
			else {
				address = grailsApplication.config.mailconfig[config] ?: ''
				if (address.toString().indexOf(',') > -1) {
					recipients.addAll(address.split(',').collect { it.trim() })
				}
			}
			if (config.toString().indexOf(',') > -1) {
				recipients.addAll(config.split(',').collect { it.trim() })
			}
		}
		return address
	}
	
	private String currentController(String s) {
		s.substring(0,1).toUpperCase() + s.substring(1)
	}
	
	def returnEmailArray(def email) {
		List<String> recipients
		if (email.toString().indexOf(',')>-1 && !(email instanceof List)) {
			recipients =email.split(',').collect { it.trim() }
			return recipients
		}
		return email
	}
}	