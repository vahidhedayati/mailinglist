import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListAttachmentsshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListAttachments/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'mailingListAttachments.label', default: 'MailingListAttachments'))],-1)
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
invokeTag('message','g',18,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (mailingListAttachmentsInstance?.name)) {
printHtmlPart(11)
invokeTag('message','g',25,['code':("mailingListAttachments.name.label"),'default':("Name")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',26,['bean':(mailingListAttachmentsInstance),'field':("name")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListAttachmentsInstance?.attachment)) {
printHtmlPart(15)
invokeTag('message','g',31,['code':("mailingListAttachments.attachment.label"),'default':("Attachment size")],-1)
printHtmlPart(16)
expressionOut.print(mailingListAttachmentsInstance?.attachment.size())
printHtmlPart(17)
}
else {
printHtmlPart(18)
invokeTag('message','g',38,['code':("default.file.nocontent.label"),'default':("WARNING 0 BYTE OR NO ATTACHED FILE")],-1)
printHtmlPart(19)
}
printHtmlPart(14)
if(true && (mailingListAttachmentsInstance?.addedby)) {
printHtmlPart(20)
invokeTag('message','g',43,['code':("mailingListAttachments.addedby.label"),'default':("Addedby")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',44,['bean':(mailingListAttachmentsInstance),'field':("addedby")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListAttachmentsInstance?.dateCreated)) {
printHtmlPart(22)
invokeTag('message','g',49,['code':("mailingListAttachments.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(23)
invokeTag('formatDate','g',50,['date':(mailingListAttachmentsInstance?.dateCreated)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListAttachmentsInstance?.fullname)) {
printHtmlPart(24)
invokeTag('message','g',55,['code':("mailingListAttachments.fullname.label"),'default':("Fullname")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',56,['bean':(mailingListAttachmentsInstance),'field':("fullname")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListAttachmentsInstance?.contentType)) {
printHtmlPart(26)
invokeTag('message','g',61,['code':("mailingListAttachments.contentType.label"),'default':("contentType")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',62,['bean':(mailingListAttachmentsInstance),'field':("contentType")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListAttachmentsInstance?.lastUpdated)) {
printHtmlPart(28)
invokeTag('message','g',67,['code':("mailingListAttachments.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(29)
invokeTag('formatDate','g',68,['date':(mailingListAttachmentsInstance?.lastUpdated)],-1)
printHtmlPart(13)
}
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
invokeTag('hiddenField','g',74,['name':("id"),'value':(mailingListAttachmentsInstance?.id)],-1)
printHtmlPart(32)
invokeTag('actionSubmit','g',75,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(33)
})
invokeTag('form','g',77,[:],2)
printHtmlPart(34)
})
invokeTag('captureBody','sitemesh',79,[:],1)
printHtmlPart(35)
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
