import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListSendersshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListSenders/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'mailingListSenders.label', default: 'MailingListSenders'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('render','g',10,['template':("/mainmenu")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',12,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',12,['class':("create"),'action':("create")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',13,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',13,['class':("list"),'action':("list")],2)
printHtmlPart(6)
invokeTag('message','g',17,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (mailingListSendersInstance?.addedby)) {
printHtmlPart(11)
invokeTag('message','g',25,['code':("mailingListSenders.addedby.label"),'default':("Addedby")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',26,['bean':(mailingListSendersInstance),'field':("addedby")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListSendersInstance?.emailAddress)) {
printHtmlPart(15)
invokeTag('message','g',32,['code':("mailingListSenders.emailAddress.label"),'default':("Email Address")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',33,['bean':(mailingListSendersInstance),'field':("emailAddress")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListSendersInstance?.dateCreated)) {
printHtmlPart(17)
invokeTag('message','g',39,['code':("mailingListSenders.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(18)
invokeTag('formatDate','g',40,['date':(mailingListSendersInstance?.dateCreated)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListSendersInstance?.lastUpdated)) {
printHtmlPart(19)
invokeTag('message','g',46,['code':("mailingListSenders.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(20)
invokeTag('formatDate','g',47,['date':(mailingListSendersInstance?.lastUpdated)],-1)
printHtmlPart(13)
}
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
invokeTag('hiddenField','g',53,['name':("id"),'value':(mailingListSendersInstance?.id)],-1)
printHtmlPart(23)
createTagBody(3, {->
invokeTag('message','g',54,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',54,['class':("edit"),'action':("edit"),'id':(mailingListSendersInstance?.id)],3)
printHtmlPart(23)
invokeTag('actionSubmit','g',55,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(24)
})
invokeTag('form','g',57,[:],2)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',59,[:],1)
printHtmlPart(26)
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
