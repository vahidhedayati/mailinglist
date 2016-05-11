import grails.plugin.mailinglist.core.CategoryBase
import grails.plugin.mailinglist.core.SendersBase
import grails.plugin.mailinglist.core.ScheduleBase
import grails.plugin.mailinglist.core.TemplatesBase
import grails.plugin.mailinglist.core.MailingListBase
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListEmailindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListEmail/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',10,['var':("entityName"),'value':(message(code: 'emailaperson.label', default: 'Contact A Person'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',11,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(2)
invokeTag('resources','ckeditor',12,[:],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('render','g',16,['template':("/mainmenu")],-1)
printHtmlPart(5)
invokeTag('message','g',20,['code':("default.contactperson.label"),'args':([entityName]),'default':("Define Schedule to Email a Person")],-1)
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(12)
expressionOut.print(error.field)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('message','g',27,['error':(error)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',28,['bean':(mailingListScheduleInstance),'var':("error")],3)
printHtmlPart(16)
})
invokeTag('hasErrors','g',30,['bean':(mailingListScheduleInstance)],2)
printHtmlPart(17)
createTagBody(2, {->
printHtmlPart(18)
invokeTag('render','g',35,['template':("/mailingList/addedby"),'model':([caller: 'mailingListScheduleInstance'])],-1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'mailFrom', 'error'))
printHtmlPart(20)
invokeTag('message','g',38,['code':("manager.label"),'default':("mailFrom")],-1)
printHtmlPart(21)
invokeTag('textField','g',40,['name':("mailFrom"),'value':(params?.mailFrom)],-1)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'recipientToList', 'error'))
printHtmlPart(23)
invokeTag('message','g',46,['code':("recipientToList.label"),'default':("To:")],-1)
printHtmlPart(21)
invokeTag('textField','g',48,['name':("recipientToList"),'value':(params?.recipientToList)],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'recipientCCList', 'error'))
printHtmlPart(23)
invokeTag('message','g',53,['code':("recipientCCList.label"),'default':("CC:")],-1)
printHtmlPart(21)
invokeTag('textField','g',55,['name':("recipientCCList"),'value':(params?.recipientCCList)],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'recipientBCCList', 'error'))
printHtmlPart(25)
invokeTag('message','g',60,['code':("recipientBCCList.label"),'default':("BCC:")],-1)
printHtmlPart(21)
invokeTag('textField','g',62,['name':("recipientBCCList"),'value':(params?.recipientBCCList)],-1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'subject', 'error'))
printHtmlPart(20)
invokeTag('message','g',67,['code':("manager.label"),'default':("subject")],-1)
printHtmlPart(21)
invokeTag('textField','g',69,['name':("subject"),'value':(params?.subject),'size':("50")],-1)
printHtmlPart(27)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'attachments', 'error'))
printHtmlPart(28)
invokeTag('message','g',75,['code':("mailingListSchedule.attachments.label"),'default':("Attachments")],-1)
printHtmlPart(29)
invokeTag('render','g',79,['template':("/mailingListAttachments/mailerAttachmentsDisplay")],-1)
printHtmlPart(30)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'emailMessage', 'error'))
printHtmlPart(31)
invokeTag('message','g',86,['code':("emailMessage.label"),'default':("emailMessage")],-1)
printHtmlPart(32)
createTagBody(3, {->
printHtmlPart(3)
expressionOut.print(params?.emailMessage)
printHtmlPart(3)
})
invokeTag('editor','ckeditor',91,['name':("emailMessage"),'height':("300px"),'width':("100%")],3)
printHtmlPart(33)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'dateTime', 'error'))
printHtmlPart(34)
invokeTag('message','g',100,['code':("dateTime.label"),'default':("dateTime")],-1)
printHtmlPart(35)
if(true && (enduser?.verifyAppVersion().equals('resources'))) {
printHtmlPart(9)
invokeTag('time','jqueryPicker',103,['name':("dateTime"),'value':(curr)],-1)
printHtmlPart(2)
}
else {
printHtmlPart(36)
expressionOut.print(current)
printHtmlPart(37)
}
printHtmlPart(38)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'cronExpression', 'error'))
printHtmlPart(39)
invokeTag('message','g',111,['code':("cronExpression.label"),'default':("cronExpression")],-1)
printHtmlPart(35)
invokeTag('textField','g',113,['name':("cronExpression"),'value':(mailingListScheduleInstance?.cronExpression)],-1)
printHtmlPart(40)
expressionOut.print(hasErrors(bean: params, field: 'send', 'error'))
printHtmlPart(41)
invokeTag('message','g',118,['code':("dateTime.label"),'default':("Trigger")],-1)
printHtmlPart(35)
invokeTag('submitButton','g',120,['name':("Send Email"),'id':("loginbtn"),'class':("loginbtn"),'value':(message(code: 'default.button.SendEmail.label', default: 'Send'))],-1)
printHtmlPart(42)
})
invokeTag('form','g',124,['action':("scheduleEmail")],2)
printHtmlPart(43)
})
invokeTag('captureBody','sitemesh',127,[:],1)
printHtmlPart(44)
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
