import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mainmenu_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/_mainmenu.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
invokeTag('message','g',3,['code':("default.menu.label"),'default':("Menu")],-1)
})
invokeTag('link','g',3,['controller':("mailingList"),'action':("index")],1)
printHtmlPart(1)
createTagBody(1, {->
invokeTag('message','g',4,['code':("default.email.person.label"),'default':("Contact Person")],-1)
})
invokeTag('link','g',4,['controller':("mailingListEmail"),'action':("index")],1)
printHtmlPart(2)
createTagBody(1, {->
invokeTag('message','g',5,['code':("default.email.group.label"),'default':("Contact Group")],-1)
})
invokeTag('link','g',5,['controller':("mailingListEmail"),'action':("contactclients")],1)
printHtmlPart(3)
createTagBody(1, {->
invokeTag('message','g',6,['code':("default.schedule.label"),'default':("Schedule Logs")],-1)
})
invokeTag('link','g',6,['controller':("MailingListSchedule"),'action':("br"),'params':([s:'oa',viewtype:'na'])],1)
printHtmlPart(4)
expressionOut.print(createLink(uri: '/quartz/list'))
printHtmlPart(5)
invokeTag('message','g',7,['code':("default.quartz.label"),'default':("Quartz")],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1461328837000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
