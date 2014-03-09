package $pack

class MailingListTagLib {
	static namespace = "mailinglist"

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
					def mcat=retMcat(controller,t)
					out << g.render(template:'/mailingList/htmlPopUp', model: [mcat:mcat, t:t, scriptCall:scriptCall, ccontrol: controller, cact: action ])
				}
			}else{
				String t=cid
				def mcat=retMcat(controller,t)
				out << g.render(template:'/mailingList/htmlPopUp', model: [mcat:mcat, t:t, scriptCall:scriptCall, ccontrol: controller, cact: action ])
			}	
		}
	} 
	
	private String retMcat(def controller,def t){
		def mcat=''
		if (controller) {
			def domainClass = grailsApplication?.getDomainClass(controller)?.clazz
			if (domainClass) {
				mcat=domainClass?.get(t)
			}
		}
		return mcat
	}	   
}
