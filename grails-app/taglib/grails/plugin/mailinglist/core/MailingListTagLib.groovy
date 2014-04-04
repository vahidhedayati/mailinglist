package grails.plugin.mailinglist.core

class MailingListTagLib {
	
	static namespace = "mailinglist"
	def mailingListEmailService
	
	
	/*
	 * This loads in customised bootstrap.css and default bootstrap.js
	 * If your site already has these then no need to run, otherwise:
	 *
	 * <r:layoutResources />
	 * <mailinglist:loadbootstrap/>
	 * </head>
	 *
	 *(notice the extra tag loadbootstrap above)
	 *In your main file to run in overall site
	 *OR just call this on a specific gsp page if you have specific use
	 *
	 * <mailinglist:loadbootrap/>
	 */
	 
	def loadbootstrap= {
		out << g.render(contextPath: pluginContextPath,template: 'loadbootstrap')
	}
	
	
	/*
	 * This loads in customised css for this plugin
	 * If your site already has been bootstrapped then use this
	 *
	 * <r:layoutResources />
	 * <mailinglist:loadplugincss/>
	 * </head>
	 */
	def loadplugincss= {
		out << g.render(contextPath: pluginContextPath,template: 'loadplugincss')
	}
	
	
	def loadPopUp= {attrs, body ->
		def cid= attrs.remove('id')?.toString()
		def scriptCall= attrs.remove('scriptCall')?.toString()
		def controller= attrs.remove('controller')?.toString()
		def retValue= attrs.remove('retValue')?.toString()
		def action= attrs.remove('action')?.toString()
		if (!retValue) { retValue='' }
		if (cid&&scriptCall&&action) {
			if (cid.indexOf(',')>-1) {
				String[] tokens = cid.split(",")
				for(String t : tokens) {
					t=t.trim()
					def mcat=mailingListEmailService?.domainGetter(controller,t,'name',retValue)
					out << g.render(template:'/mailingList/htmlPopUp', model: [mcat:mcat, t:t, scriptCall:scriptCall, ccontrol: controller, cact: action ])
				}
			}else{
				String t=cid
				def mcat=mailingListEmailService?.domainGetter(controller,t,'name',retValue)
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
			out << "${gg}"
		}
	}	
}
