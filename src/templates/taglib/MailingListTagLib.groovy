package $pack

class MailingListTagLib {
	static namespace = "mailinglist"
	def getGroup =  { attrs, body ->
		def recipientToGroup= attrs.remove('recipientToGroup')?.toString()
		if (recipientToGroup) { 
			String[] tokens = recipientToGroup.split(",")
			for(String t : tokens) {
				t=t.trim()
				def mcat=MailingListCategories?.get(t)
				out << g.render(template:'/mailingList/htmlPopUp', model: [mcat:mcat, t:t, scriptCall:'recipientToGroup', ccontrol: 'MailingListCategories', cact: 'show' ])	
			}
		}
    }	
	
	def getTemplate=  { attrs, body ->
		def mailingListTemplate= attrs.remove('mailingListTemplate')?.toString()
		if (mailingListTemplate) { 
			String[] tokens = mailingListTemplate.split(",")
			for(String t : tokens) {	
				t=t.trim()
				def mcat=MailingListTemplates?.get(t)
				out << g.render(template:'/mailingList/htmlPopUp', model: [mcat:mcat, t:t, scriptCall:'mailingListTemplate', ccontrol: 'MailingListTemplates', cact: 'show' ])
			}
		}
    }	
    
}
