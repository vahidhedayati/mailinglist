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

class gsp_mailinglist_mailingListEmailconfirmcontact_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListEmail/confirmcontact.gsp" }
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
invokeTag('set','g',10,['var':("entityName"),'value':(message(code: 'ContactClients.label', default: 'Contact Clients'))],-1)
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
if(true && (warnResend)) {
printHtmlPart(6)
expressionOut.print(warnResend)
printHtmlPart(7)
}
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(10)
expressionOut.print(error.field)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('message','g',25,['error':(error)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',26,['bean':(mailingListScheduleInstance),'var':("error")],3)
printHtmlPart(14)
})
invokeTag('hasErrors','g',28,['bean':(mailingListScheduleInstance)],2)
printHtmlPart(15)
invokeTag('message','g',30,['code':("default.confirmcontact.label"),'args':([entityName]),'default':("Confirm email before sending")],-1)
printHtmlPart(16)
if(true && (flash.message)) {
printHtmlPart(17)
expressionOut.print(flash.message)
printHtmlPart(18)
}
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
expressionOut.print(hasErrors(bean: params, field: 'sendType', 'error'))
printHtmlPart(21)
invokeTag('message','g',39,['code':("manager.label"),'default':("sendType")],-1)
printHtmlPart(22)
invokeTag('hiddenField','g',41,['name':("sendType"),'value':(params.sendType)],-1)
expressionOut.print(params.sendType)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: params, field: 'mailFrom', 'error'))
printHtmlPart(24)
invokeTag('message','g',46,['code':("manager.label"),'default':("mailFrom")],-1)
printHtmlPart(25)
invokeTag('hiddenField','g',48,['name':("mailFrom"),'value':(params.mailFrom)],-1)
expressionOut.print(params.mailFrom)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: params, field: 'recipientToGroup', 'error'))
printHtmlPart(26)
invokeTag('message','g',53,['code':("recipientToGroup.label"),'default':("To:")],-1)
printHtmlPart(27)
if(true && (params.recipientToGroup.getClass().isArray())) {
printHtmlPart(28)
for( rg in (params.recipientToGroup) ) {
printHtmlPart(28)
invokeTag('localDomainGetter','mailinglist',57,['domain':("categoryBase"),'value':(rg),'retValue':("name")],-1)
printHtmlPart(29)
invokeTag('hiddenField','g',58,['name':("recipientToGroup"),'value':(rg)],-1)
printHtmlPart(28)
}
printHtmlPart(30)
}
else {
printHtmlPart(28)
invokeTag('localDomainGetter','mailinglist',62,['domain':("categoryBase"),'value':(params.recipientToGroup),'retValue':("name")],-1)
printHtmlPart(29)
invokeTag('hiddenField','g',63,['name':("recipientToGroup"),'value':(params.recipientToGroup)],-1)
printHtmlPart(31)
}
printHtmlPart(32)
invokeTag('hiddenField','g',68,['name':("addedby"),'value':(params.addedby)],-1)
printHtmlPart(33)
expressionOut.print(hasErrors(bean: params, field: 'subject', 'error'))
printHtmlPart(34)
invokeTag('message','g',71,['code':("manager.label"),'default':("subject")],-1)
printHtmlPart(35)
invokeTag('hiddenField','g',73,['name':("subject"),'value':(params.subject)],-1)
expressionOut.print(params.subject)
printHtmlPart(36)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'attachments', 'error'))
printHtmlPart(37)
invokeTag('message','g',79,['code':("mailingListSchedule.attachments.label"),'default':("Attachments")],-1)
printHtmlPart(35)
if(true && (params.attachments.getClass().isArray())) {
printHtmlPart(38)
for( att in (params.attachments) ) {
printHtmlPart(39)
invokeTag('hiddenField','g',83,['name':("attachments"),'value':(att)],-1)
printHtmlPart(28)
invokeTag('localDomainGetter','mailinglist',84,['domain':("attachmentsBase"),'value':(att),'retValue':("fullname")],-1)
printHtmlPart(38)
}
printHtmlPart(40)
}
else {
printHtmlPart(38)
if(true && (params.attachments)) {
printHtmlPart(41)
invokeTag('hiddenField','g',89,['name':("attachments"),'value':(params.attachments)],-1)
printHtmlPart(29)
invokeTag('localDomainGetter','mailinglist',90,['domain':("attachmentsBase"),'value':(params.attachments),'retValue':("fullname")],-1)
printHtmlPart(38)
}
printHtmlPart(42)
}
printHtmlPart(43)
if(true && (params.mailingListTemplate)) {
printHtmlPart(38)
invokeTag('hiddenField','g',96,['name':("mailingListTemplate"),'value':(params.mailingListTemplate)],-1)
printHtmlPart(2)
}
printHtmlPart(44)
expressionOut.print(hasErrors(bean: params, field: 'mailingListScheduleInstance', 'error'))
printHtmlPart(45)
invokeTag('message','g',101,['code':("mailingListTemplates.label"),'default':("emailMessage")],-1)
printHtmlPart(46)
createTagBody(3, {->
printHtmlPart(47)
expressionOut.print(params.emailMessage)
printHtmlPart(47)
})
invokeTag('editor','ckeditor',105,['name':("emailMessage"),'height':("300px"),'width':("100%")],3)
printHtmlPart(48)
expressionOut.print(hasErrors(bean: params, field: 'dateTime', 'error'))
printHtmlPart(49)
invokeTag('message','g',110,['code':("dateTime.label"),'default':("Schedule Email: Date & Time")],-1)
printHtmlPart(35)
invokeTag('hiddenField','g',112,['name':("dateTime"),'value':(params.dateTime)],-1)
printHtmlPart(47)
expressionOut.print(params.dateTime)
printHtmlPart(50)
expressionOut.print(hasErrors(bean: params, field: 'cronExpression', 'error'))
printHtmlPart(51)
invokeTag('message','g',119,['code':("cronExpression.label"),'default':("cronExpression")],-1)
printHtmlPart(52)
invokeTag('hiddenField','g',121,['name':("cronExpression"),'value':(params?.cronExpression)],-1)
printHtmlPart(2)
expressionOut.print(params?.cronExpression)
printHtmlPart(53)
expressionOut.print(hasErrors(bean: params, field: 'setDate', 'error'))
printHtmlPart(54)
invokeTag('message','g',127,['code':("setDate.label"),'default':("Issue/Resolve Date:")],-1)
printHtmlPart(35)
invokeTag('hiddenField','g',129,['name':("setDate"),'value':(params.setDate)],-1)
printHtmlPart(47)
expressionOut.print(params.setDate)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: params, field: 'setTime', 'error'))
printHtmlPart(55)
invokeTag('message','g',135,['code':("setTime.label"),'default':("Issue/Resolve Time:")],-1)
printHtmlPart(56)
invokeTag('hiddenField','g',138,['name':("setTime"),'value':("${params.setTime_hour}:${params.setTime_minute}")],-1)
printHtmlPart(47)
expressionOut.print(params.setTime_hour)
printHtmlPart(57)
expressionOut.print(params.setTime_minute)
printHtmlPart(58)
invokeTag('submitButton','g',143,['name':("Confirmed Send it now"),'class':("btn btn-danger btn-lg  nav-pills pull-right"),'value':(message(code: 'default.button.SendEmail.label', default: 'Send Email'))],-1)
printHtmlPart(59)
})
invokeTag('form','g',147,['action':("scheduleEmail")],2)
printHtmlPart(60)
invokeTag('render','g',150,['template':("goback")],-1)
printHtmlPart(61)
})
invokeTag('captureBody','sitemesh',152,[:],1)
printHtmlPart(62)
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
