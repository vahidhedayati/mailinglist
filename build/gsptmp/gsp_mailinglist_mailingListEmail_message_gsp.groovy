import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListEmail_message_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListEmail/_message.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: params, field: 'emailMessage', 'error'))
printHtmlPart(1)
invokeTag('message','g',3,['code':("emailMessage.label"),'default':("Message")],-1)
printHtmlPart(2)
invokeTag('resources','ckeditor',6,[:],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(content)
printHtmlPart(5)
})
invokeTag('editor','ckeditor',10,['name':("emailMessage"),'height':("300px"),'width':("100%")],1)
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
