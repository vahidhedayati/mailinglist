import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListEmail_goback_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListEmail/_goback.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
invokeTag('hiddenField','g',3,['name':("sendType"),'value':(params.sendType)],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',4,['name':("mailFrom"),'value':(params.mailFrom)],-1)
printHtmlPart(1)
if(true && (params.recipientToGroup.getClass().isArray())) {
printHtmlPart(1)
for( rg in (params.recipientToGroup) ) {
printHtmlPart(2)
invokeTag('hiddenField','g',7,['name':("recipientToGroup"),'value':(rg)],-1)
printHtmlPart(1)
}
printHtmlPart(3)
}
else {
printHtmlPart(2)
invokeTag('hiddenField','g',11,['name':("recipientToGroup"),'value':(params.recipientToGroup)],-1)
printHtmlPart(1)
}
printHtmlPart(1)
invokeTag('hiddenField','g',13,['name':("subject"),'value':(params.subject)],-1)
printHtmlPart(1)
if(true && (params.attachments.getClass().isArray())) {
printHtmlPart(1)
for( att in (params.attachments) ) {
printHtmlPart(4)
invokeTag('hiddenField','g',16,['name':("attachments"),'value':(att)],-1)
printHtmlPart(1)
}
printHtmlPart(3)
}
else {
printHtmlPart(5)
if(true && (params.attachments)) {
printHtmlPart(6)
invokeTag('hiddenField','g',21,['name':("attachments"),'value':(params.attachments)],-1)
printHtmlPart(4)
}
printHtmlPart(7)
}
printHtmlPart(1)
invokeTag('hiddenField','g',24,['name':("mailingListTemplate"),'value':(params.mailingListTemplate)],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',25,['name':("emailMessage1"),'value':(params.emailMessage)],-1)
printHtmlPart(8)
invokeTag('submitButton','g',28,['name':("EDIT MESSAGE"),'class':("btn btn-success btn-lg  nav-pills pull-left"),'value':(message(code: 'default.button.EDIT.label', default: 'EDIT EMAIL'))],-1)
printHtmlPart(9)
})
invokeTag('form','g',1,['action':("contactclients")],1)
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
