import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListSenders_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListSenders/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
invokeTag('render','g',1,['template':("/mailingList/addedby"),'model':([caller: 'mailingListSendersInstance'])],-1)
printHtmlPart(0)
expressionOut.print(hasErrors(bean: mailingListSendersInstance, field: 'emailAddress', 'error'))
printHtmlPart(1)
invokeTag('message','g',4,['code':("mailingListSenders.emailAddress.label"),'default':("Email Address")],-1)
printHtmlPart(2)
invokeTag('field','g',6,['type':("email"),'name':("emailAddress"),'value':(mailingListSendersInstance?.emailAddress)],-1)
printHtmlPart(3)
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
