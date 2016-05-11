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

class gsp_mailinglist_mailingListSchedule_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListSchedule/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'addedby', 'error'))
printHtmlPart(2)
invokeTag('message','g',8,['code':("mailingListSchedule.addedby.label"),'default':("Addedby")],-1)
printHtmlPart(3)
invokeTag('textField','g',11,['name':("addedby"),'value':(mailingListScheduleInstance?.addedby)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'attachments', 'error'))
printHtmlPart(5)
invokeTag('message','g',16,['code':("mailingListSchedule.attachments.label"),'default':("Attachments")],-1)
printHtmlPart(3)
invokeTag('select','g',19,['name':("attachments"),'from':(MailingListAttachments?.list()),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':(mailingListScheduleInstance?.attachments*.id),'class':("many-to-many")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'dateTime', 'error'))
printHtmlPart(6)
invokeTag('message','g',24,['code':("mailingListSchedule.dateTime.label"),'default':("Date Time")],-1)
printHtmlPart(3)
invokeTag('textField','g',27,['name':("dateTime"),'value':(mailingListScheduleInstance?.dateTime)],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'emailMessage', 'error'))
printHtmlPart(8)
invokeTag('message','g',33,['code':("mailingListSchedule.emailMessage.label"),'default':("Email Message")],-1)
printHtmlPart(3)
invokeTag('textField','g',36,['name':("emailMessage"),'value':(mailingListScheduleInstance?.emailMessage)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'mailFrom', 'error'))
printHtmlPart(9)
invokeTag('message','g',41,['code':("mailingListSchedule.mailFrom.label"),'default':("Mail From")],-1)
printHtmlPart(3)
invokeTag('textField','g',44,['name':("mailFrom"),'value':(mailingListScheduleInstance?.mailFrom)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'mailingListTemplate', 'error'))
printHtmlPart(10)
invokeTag('message','g',49,['code':("mailingListSchedule.mailingListTemplate.label"),'default':("Mailing List Template")],-1)
printHtmlPart(3)
invokeTag('textField','g',52,['name':("mailingListTemplate"),'value':(mailingListScheduleInstance?.mailingListTemplate)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'recipientBCCList', 'error'))
printHtmlPart(11)
invokeTag('message','g',57,['code':("mailingListSchedule.recipientBCCList.label"),'default':("Recipient BCCL ist")],-1)
printHtmlPart(3)
invokeTag('textField','g',60,['name':("recipientBCCList"),'value':(mailingListScheduleInstance?.recipientBCCList)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'recipientCCList', 'error'))
printHtmlPart(12)
invokeTag('message','g',65,['code':("mailingListSchedule.recipientCCList.label"),'default':("Recipient CCL ist")],-1)
printHtmlPart(3)
invokeTag('textField','g',68,['name':("recipientCCList"),'value':(mailingListScheduleInstance?.recipientCCList)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'recipientToGroup', 'error'))
printHtmlPart(13)
invokeTag('message','g',73,['code':("mailingListSchedule.recipientToGroup.label"),'default':("Recipient To Group")],-1)
printHtmlPart(3)
invokeTag('textField','g',76,['name':("recipientToGroup"),'value':(mailingListScheduleInstance?.recipientToGroup)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'recipientToList', 'error'))
printHtmlPart(14)
invokeTag('message','g',81,['code':("mailingListSchedule.recipientToList.label"),'default':("Recipient To List")],-1)
printHtmlPart(3)
invokeTag('textField','g',84,['name':("recipientToList"),'value':(mailingListScheduleInstance?.recipientToList)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'scheduleStatus', 'error'))
printHtmlPart(15)
invokeTag('message','g',89,['code':("mailingListSchedule.scheduleStatus.label"),'default':("Schedule Status")],-1)
printHtmlPart(16)
invokeTag('textField','g',91,['name':("scheduleStatus"),'value':(mailingListScheduleInstance?.scheduleStatus)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'sendType', 'error'))
printHtmlPart(17)
invokeTag('message','g',96,['code':("mailingListSchedule.sendType.label"),'default':("Send Type")],-1)
printHtmlPart(3)
invokeTag('textField','g',99,['name':("sendType"),'value':(mailingListScheduleInstance?.sendType)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'setDate', 'error'))
printHtmlPart(18)
invokeTag('message','g',104,['code':("mailingListSchedule.setDate.label"),'default':("Set Date")],-1)
printHtmlPart(3)
invokeTag('textField','g',107,['name':("setDate"),'value':(mailingListScheduleInstance?.setDate)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'setTime', 'error'))
printHtmlPart(19)
invokeTag('message','g',112,['code':("mailingListSchedule.setTime.label"),'default':("Set Time")],-1)
printHtmlPart(3)
invokeTag('textField','g',115,['name':("setTime"),'value':(mailingListScheduleInstance?.setTime)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'subject', 'error'))
printHtmlPart(20)
invokeTag('message','g',120,['code':("mailingListSchedule.subject.label"),'default':("Subject")],-1)
printHtmlPart(3)
invokeTag('textField','g',123,['name':("subject"),'value':(mailingListScheduleInstance?.subject)],-1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1462825834000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
