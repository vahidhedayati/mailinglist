package grails.plugin.mailinglist.core

class MailingListTagLib {

	static namespace = "mailinglist"
	def mailingListEmailService
	def grailsApplication
	

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
		out << g.render(contextPath: pluginContextPath,template: 'loadbootstrap' )
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

	def translateCronExpress={attrs ->
		String ce=attrs.cronExpression
		def c=ce.split(' ',-1)
		String seconds=c[0] //0-59
		String minutes=c[1] //0-59
		String hours=c[2] //0-23
		String dayOfMonth=c[3] //1-31
		String month=c[4] //1-2 or JAN - DEC, ?
		String dayOfWeek=c[5]  //1-7 or SUN-SAT, ?
		String year  //[optional]
		if (c.length>6) {
			year=c[6]
		}
		String always='*'
		String startTime='?'
		def weekDays=[:]
		int i=1
		while (i < 8) {
			weekDays."${i}"=g.message(code:"mailinglist.dow.${i}")
			i++
		}
		int j=1
		def months=[:]
		while (j < 13) {
			months."${j}"=g.message(code:"mailinglist.month.${i}")
			j++
		}
		
			
		StringBuilder sb = new StringBuilder()
		sb.append((hours==always?hours:g.message(code:'mailinglist.cron.hours',args:[hours])))
		sb.append(":"+(minutes==always?minutes:g.message(code:'mailinglist.cron.minutes',args:[minutes])))
		sb.append(":"+(seconds==always?always:g.message(code:'mailinglist.cron.seconds',args:[seconds]))+", ")
		if (dayOfMonth!=startTime&&dayOfMonth!=always) {		
			sb.append(g.message(code:'mailinglist.cron.dayOfMonth',args:[dayOfMonth])+", ")
		}
		if (month!=startTime&&month!=always) {
			sb.append(g.message(code:'mailinglist.cron.month',args:[months."${month}"])+", ")
		}
		if (dayOfWeek!=startTime&&dayOfWeek!=always) {
			sb.append(g.message(code:'mailinglist.cron.dayOfWeek',args:[weekDays."${dayOfWeek}"]))
		}	
		if (year) {
			sb.append(", "+(year==always?g.message(code:'mailinglist.cron.all.year'):g.message(code:'mailinglist.cron.year',args:[year])))
		}
		out << sb.toString()
	}

	private String defineDayOfMonth(String day) {
		defineDayMonth
	}
}
