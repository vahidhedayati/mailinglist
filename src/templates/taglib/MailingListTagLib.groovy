package $pack

class MailingListTagLib {
	
	static namespace = "mailinglist"
	def mailingListEmailService
	
	def loadPopUp= {attrs, body ->
		def cid= attrs.remove('id')?.toString()
		def scriptCall= attrs.remove('scriptCall')?.toString()
		def controller= attrs.remove('controller')?.toString()
		def action= attrs.remove('action')?.toString()
		if (cid&&scriptCall&&action) {
			if (cid.indexOf(',')>-1) {
				String[] tokens = cid.split(",")
				for(String t : tokens) {
					t=t.trim()
					def mcat=mailingListEmailService?.domainGetter(controller,t,'name','')
					out << g.render(template:'/mailingList/htmlPopUp', model: [mcat:mcat, t:t, scriptCall:scriptCall, ccontrol: controller, cact: action ])
				}
			}else{
				String t=cid
				def mcat=mailingListEmailService?.domainGetter(controller,t,'name','')
				out << g.render(template:'/mailingList/htmlPopUp', model: [mcat:mcat, t:t, scriptCall:scriptCall, ccontrol: controller, cact: action ])
			}	
		}
	} 
	
	def localDomainGetter = { attrs, body ->
		def domain= attrs.remove('domain')?.toString()
		def rvalue= attrs.remove('rvalue')?.toString()
		def retValue= attrs.remove('retValue')?.toString()
		def retValue2= attrs.remove('retValue2')?.toString()
		if (domain&&rvalue&&retValue) {
			def gg=mailingListEmailService?.domainGetter(domain,rvalue,retValue,retValue2)
			out << "\${gg}"
		}
	}	
}
