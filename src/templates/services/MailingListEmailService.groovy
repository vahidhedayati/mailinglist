package $pack

class MailingListEmailService {
	def mailService
	def grailsApplication
	
	
	def sendEmail(Map paramsMap){
		def emailSubject = paramsMap.subject
		def recipientTo = paramsMap.recipientToList
		def recipientTo2 = paramsMap.recipientToList2
		def message = paramsMap.emailMessage
		def recipientCC = paramsMap.recipientCCList
		def recipientBCC = paramsMap.recipientBCCList
		def emailFrom  = paramsMap.mailFrom
		def recipientToGroup = paramsMap.recipientToGroup
		def template=paramsMap.mailingListTemplate
		def scheduleid=paramsMap.id
		if (!scheduleid) { 
			scheduleid=paramsMap.scheduleid
		}
		
		def recipientToList=recipientTo
		if (recipientTo){
			recipientToList=returnEmailArrary(recipientTo)
		}
		
		def recipientToList2=recipientTo2
		if (recipientTo2){
			recipientToList2=returnEmailArrary(recipientTo2)
		}
		
		def recipientCCList=recipientCC
		if (recipientCC){
			recipientCCList=returnEmailArrary(recipientCC)
		}
		
		def recipientBCCList=recipientBCC
		if (recipientBCC){
			recipientBCCList=returnEmailArrary(recipientBCC)
		}
		
		println "sendEmail Schedule ID: "+scheduleid+" "
		def sendtype=paramsMap.sendType
		if (recipientToGroup) {
			if (!sendtype) { sendtype='bulk' }
		}
		def cidimg,aimage=''
		def cproject=grailsApplication.metadata['app.name']
		def baseurl=grailsApplication.config.grails.baseURL
		//def uploadpath=grailsApplication.config.externalUploadPath	
		def imgsearch='<img alt="" src="/'+cproject
		def fulldomain='<img alt="" src="'+baseurl
		def currentMap = [:]
		def currentMap1 = [:]
			message.eachLine { line ->
				if(line.indexOf(imgsearch)>-1) {
					def aimage1=line.substring(line.indexOf('<img alt="" src="')+17,line.length())
					aimage=aimage1.substring(0,aimage1.indexOf('"'))
					def rest=aimage1.substring(aimage1.indexOf('"'),aimage1.length())
					def imgtag=aimage.substring(aimage.lastIndexOf("/")+1, aimage.length())
					if (imgtag.indexOf('.')>-1){
						cidimg=imgtag.substring(0,imgtag.indexOf('.'))
					}
					def replaceval="cid:"+cidimg
					message=message.replace(aimage, replaceval )
					currentMap.put(cidimg,aimage)
				}else if(line.indexOf(fulldomain)>-1) {
					def aimage1=line.substring(line.indexOf('<img alt="" src="')+17,line.length())
					aimage=aimage1.substring(baseurl.length(),aimage1.indexOf('"'))
					def rest=aimage1.substring(aimage1.indexOf('"'),aimage1.length())
					def imgtag=aimage.substring(aimage.lastIndexOf("/")+1, aimage.length())
					if (imgtag.indexOf('.')>-1){
						cidimg=imgtag.substring(0,imgtag.indexOf('.'))
					}
					def replaceval="cid:"+cidimg
					message=message.replace(""+baseurl+""+aimage, replaceval )
					currentMap1.put(cidimg,aimage)
				}
			}
			if 	(sendtype.equals('bulk')) {
				def primary=[]
				if (recipientToGroup) {
					if (recipientToGroup.class.isArray()) {
					recipientToGroup.each  { rg ->
						def rtg=MailingListCat?.findById(rg)
						rtg?.mailinglist.each { currentemail ->
							if (currentemail) {
								primary.add(currentemail)
							}
						}	
					}
					}else{
						def rtg=MailingListCat?.findById(recipientToGroup)
						rtg?.mailinglist.each { currentemail ->
							if (currentemail) {
								primary.add(currentemail)
							}
						}
					}
				}
				if (primary )  { 
					recipientBCCList = primary
					log.info ("Scheduled Email: Email being sent to Group "+recipientToGroup+" : "+recipientBCCList)
				}else{
					log.info ("Scheduled Email: Email being sent to Person: "+recipientToList)
				}
				try{
					Boolean mp=false
					mailService.sendMail {
						if (paramsMap.attachments) {
								multipart true
								mp=true
						}
						if (mp==false){
							if(message.indexOf('<img')>-1) {
								multipart true
								mp=true
							}
						}
						if (mp==false) {
							if (scheduleid) {
								def mlresult=MailingListSchedule.findById(scheduleid)
								if (mlresult.attachments) {
									multipart true
									mp=true
								}
							}
						}	
						if(emailFrom) {from emailFrom }
						if(emailSubject) {subject emailSubject }
						if(recipientToList) {to recipientToList }
						if (!recipientToList) {
							if(recipientToList2) {to recipientToList2 }
						}
						if (recipientCCList) { cc recipientCCList}
						if (recipientBCCList) { bcc recipientBCCList}
						html message
						if (currentMap) {
						currentMap.each{ k, v ->
							inline k, 'image/jpg', new File(System.properties['catalina.base']+"/webapps/"+v)
						}	
						}
						if (currentMap1) {
						currentMap1.each{ k, v ->
							inline k, 'image/jpg', new File(System.properties['catalina.base']+""+v)
						}
						}
						if (scheduleid) {
							def mlresult=MailingListSchedule.findById(scheduleid)
							mlresult.attachments.each  { att ->
								def attl=att.fullname.toLowerCase()
								def doctype=att.contentType
								attachBytes att.fullname, doctype, att.attachment
							}
						}	
					}
				}catch (Exception mailSenderException){
					log.error("Exception in sending mail: "+mailSenderException.getMessage())
				}
			}else{	
				if (recipientToGroup) {
					recipientToGroup.each  { rg ->
						def rtg=MailingListCat.findById(rg)
						rtg?.mailinglist.each { currentemail ->
							if (currentemail) {
								recipientToList=currentemail?.emailAddress
								log.info ("Scheduled Email: Email being sent to: "+recipientToList)
								try{
									Boolean mp=false
									mailService.sendMail {
										if (paramsMap.attachments) {
											multipart true
											mp=true
										}
										if (mp==false){
											if(message.indexOf('<img')>-1) {
												multipart true
												mp=true
											}
										}
										if (mp==false) {
											if (scheduleid) {
												def mlresult=MailingListSchedule.findById(scheduleid)
												if (mlresult.attachments) {
													multipart true
													mp=true
												}
											}
										}	
										if(emailFrom) {from emailFrom }
										if(emailSubject) {subject emailSubject }
										if(recipientToList) {to recipientToList }
										if (!recipientToList) {
											if(recipientToList2) {to recipientToList2 }
										}
										if (recipientCCList) { cc recipientCCList}
										if (recipientBCCList) { bcc recipientBCCList}
										html message
										if (currentMap) {
											currentMap.each{ k, v ->
												inline k, 'image/jpg', new File(System.properties['catalina.base']+"/webapps/"+v)

											}
										}
										if (currentMap1) {
											currentMap1.each{ k, v ->
												inline k, 'image/jpg', new File(System.properties['catalina.base']+"['catalina.base']"+v)
											}
										}
										if (scheduleid) {
											def mlresult=MailingListSchedule.findById(scheduleid)
											mlresult.attachments.each  { att ->
												def attl=att.fullname.toLowerCase()
												def doctype=att.contentType
												attachBytes att.fullname, doctype, att.attachment
											}	
										}
									}
								}catch (Exception mailSenderException){
									log.error("Exception in sending mail: "+mailSenderException.getMessage())
								}
							}
						}	
					}	
				}else{
					log.info ("Scheduled Email: Email being sent to: "+recipientToList)
					try{
						Boolean mp=false
						mailService.sendMail {
							if (paramsMap.attachments) {
									multipart true
									mp=true
							}
							if (mp==false){
								if(message.indexOf('<img')>-1) {
									multipart true
									mp=true
								}
							}
							if (mp==false) {
								if (scheduleid) {
									def mlresult=MailingListSchedule.findById(scheduleid)
									if (mlresult.attachments) {
										multipart true
										mp=true
									}
								}
							}	
							if(emailFrom) {from emailFrom }
							if(emailSubject) {subject emailSubject }
							if(recipientToList) {to recipientToList }
							if (!recipientToList) {
								if(recipientToList2) {to recipientToList2 }
							}
							if (recipientCCList) { cc recipientCCList}
							if (recipientBCCList) { bcc recipientBCCList}
							html message
							if (currentMap) {
								currentMap.each{ k, v ->
									inline k, 'image/jpg', new File(System.properties['catalina.base']+"/webapps"+v)
								}
							}
							if (currentMap1) {
								currentMap1.each{ k, v ->
									inline k, 'image/jpg', new File(System.properties['catalina.base']+"['catalina.base']}"+v)
								}
							}
							if (scheduleid) {
								def mlresult=MailingListSchedule.findById(scheduleid)
								mlresult.attachments.each  { att ->
									def attl=att.fullname.toLowerCase()
									def doctype=att.contentType
									attachBytes att.fullname, doctype, att.attachment
								}
							}
						}
					}catch (Exception mailSenderException){
						log.error("Exception in sending mail: "+mailSenderException.getMessage())
					}
				}	
			}
			if (scheduleid) {
				log.info("Updating ScheduleID "+scheduleid+" setting scheduleComplete as true")
				def foundit=MailingListSchedule.findById(scheduleid)
				if (foundit) {
					foundit.scheduleComplete=true
					foundit.deploymentComplete=true
					foundit.save(flush:false)
				}
			} else{
				log.info("Could not Updating status of MailingListSchedule: no ID was found for the schedule")
			}
	}
	
	def returnEmailArrary(String email) {
		List<String> recipients
		if (email.toString().indexOf(',')>-1) {
			recipients =email.split(',').collect { it.trim() }
			return recipients
		}
		return email
	}
}	