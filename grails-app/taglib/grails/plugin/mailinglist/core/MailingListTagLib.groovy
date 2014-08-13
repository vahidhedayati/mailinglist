package grails.plugin.mailinglist.core

class MailingListTagLib {

	static namespace = "mailinglist"
	def mailingListEmailService
	def grailsApplication

	
	def verifyAppVersion={attrs, body ->
		def gfolder=returnAppVersion()
		out << gfolder
	}
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
		/*def gver=grailsApplication.metadata['app.grails.version']
		double verify=getGrailsVersion(gver)
		def gfolder="resources"
		if (verify >= 2.4 ) {
			gfolder="assets"
		}*/
		def gfolder=returnAppVersion()
		out << g.render(contextPath: pluginContextPath,template: 'loadbootstrap' , model:[gfolder:gfolder])
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
		/*def gver=grailsApplication.metadata['app.grails.version']
		double verify=getGrailsVersion(gver)
		def gfolder="resources"
		if (verify >= 2.4 ) {
			gfolder="assets"
		}*/
		def gfolder=returnAppVersion()
		out << g.render(contextPath: pluginContextPath,template: 'loadplugincss', model:[gfolder:gfolder])
	}


	def loadPopUp= {attrs, body ->
		def cid= attrs.remove('id')?.toString()
		def scriptCall= attrs.remove('scriptCall')?.toString()
		def controller= attrs.remove('controller')?.toString()
		def retController= attrs.remove('retController')?.toString()
		def retValue= attrs.remove('retValue')?.toString()
		def action= attrs.remove('action')?.toString()
		if (!retValue) { retValue='' }
		if (cid&&scriptCall&&action) {
			if (cid.indexOf(',')>-1) {
				String[] tokens = cid.split(",")
				for(String t : tokens) {
					t=t.trim()
					def mcat=mailingListEmailService?.domainGetter(controller,t)
					out << g.render(template:'/mailingList/htmlPopUp', model: [mcat:mcat, t:t, scriptCall:scriptCall, ccontrol: retController, cact: action ])
				}
			}else{
				String t=cid
				def mcat=mailingListEmailService?.domainGetter(controller,t)
				out << g.render(template:'/mailingList/htmlPopUp', model: [mcat:mcat, t:t, scriptCall:scriptCall, ccontrol: retController, cact: action ])
			}
		}
	}

	def localDomainGetter = { attrs, body ->
		def domain= attrs.remove('domain')?.toString()
		def value= attrs.remove('value')?.toString()
		def retValue= attrs.remove('retValue')?.toString()
		def retValue2= attrs.remove('retValue2')?.toString()
		if (domain&&value) {
			def gg=mailingListEmailService?.domainGetter(domain,value)
			out << "${gg}"
		}
	}

	private String returnAppVersion() {
		def gver=grailsApplication.metadata['app.grails.version']
		double verify=getGrailsVersion(gver)
		def gfolder="resources"
		if (verify >= 2.4 ) {
			gfolder="assets"
		}
		return gfolder
	}
	// Returns users grails version
	private getGrailsVersion(String appVersion) {
		if (appVersion && appVersion.indexOf('.')>-1) {
			int lastPos=appVersion.indexOf(".", appVersion.indexOf(".") + 1)
			double verify=appVersion.substring(0,lastPos) as double
		}
	}

}
