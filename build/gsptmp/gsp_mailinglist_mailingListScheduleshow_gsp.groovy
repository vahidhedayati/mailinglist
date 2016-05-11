import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListScheduleshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListSchedule/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'mailingListSchedule.label', default: 'MailingListSchedule'))],-1)
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
if(true && (mailingListScheduleInstance?.addedby)) {
printHtmlPart(11)
invokeTag('message','g',24,['code':("mailingListSchedule.addedby.label"),'default':("Addedby")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',25,['bean':(mailingListScheduleInstance),'field':("addedby")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListScheduleInstance?.attachments)) {
printHtmlPart(15)
invokeTag('message','g',31,['code':("mailingListSchedule.attachments.label"),'default':("Attachments")],-1)
printHtmlPart(16)
for( a in (mailingListScheduleInstance.attachments) ) {
printHtmlPart(17)
createTagBody(4, {->
expressionOut.print(a?.encodeAsHTML())
})
invokeTag('link','g',33,['controller':("mailingListAttachments"),'action':("show"),'id':(a.id)],4)
printHtmlPart(16)
}
printHtmlPart(18)
}
printHtmlPart(14)
if(true && (mailingListScheduleInstance?.dateCreated)) {
printHtmlPart(19)
invokeTag('message','g',40,['code':("mailingListSchedule.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(20)
invokeTag('formatDate','g',41,['date':(mailingListScheduleInstance?.dateCreated)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListScheduleInstance?.dateTime)) {
printHtmlPart(21)
invokeTag('message','g',47,['code':("mailingListSchedule.dateTime.label"),'default':("Date Time")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',48,['bean':(mailingListScheduleInstance),'field':("dateTime")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListScheduleInstance?.emailMessage)) {
printHtmlPart(23)
invokeTag('message','g',54,['code':("mailingListSchedule.emailMessage.label"),'default':("Email Message")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',55,['bean':(mailingListScheduleInstance),'field':("emailMessage")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListScheduleInstance?.lastUpdated)) {
printHtmlPart(25)
invokeTag('message','g',61,['code':("mailingListSchedule.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(26)
invokeTag('formatDate','g',62,['date':(mailingListScheduleInstance?.lastUpdated)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListScheduleInstance?.mailFrom)) {
printHtmlPart(27)
invokeTag('message','g',68,['code':("mailingListSchedule.mailFrom.label"),'default':("Mail From")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',69,['bean':(mailingListScheduleInstance),'field':("mailFrom")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListScheduleInstance?.mailingListTemplate)) {
printHtmlPart(29)
invokeTag('message','g',75,['code':("mailingListSchedule.mailingListTemplate.label"),'default':("Mailing List Template")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',76,['bean':(mailingListScheduleInstance),'field':("mailingListTemplate")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListScheduleInstance?.recipientBCCList)) {
printHtmlPart(31)
invokeTag('message','g',82,['code':("mailingListSchedule.recipientBCCList.label"),'default':("Recipient BCCL ist")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',83,['bean':(mailingListScheduleInstance),'field':("recipientBCCList")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListScheduleInstance?.recipientCCList)) {
printHtmlPart(33)
invokeTag('message','g',89,['code':("mailingListSchedule.recipientCCList.label"),'default':("Recipient CCL ist")],-1)
printHtmlPart(34)
invokeTag('fieldValue','g',90,['bean':(mailingListScheduleInstance),'field':("recipientCCList")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListScheduleInstance?.recipientToGroup)) {
printHtmlPart(35)
invokeTag('message','g',96,['code':("mailingListSchedule.recipientToGroup.label"),'default':("Recipient To Group")],-1)
printHtmlPart(36)
invokeTag('fieldValue','g',97,['bean':(mailingListScheduleInstance),'field':("recipientToGroup")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListScheduleInstance?.recipientToList)) {
printHtmlPart(37)
invokeTag('message','g',103,['code':("mailingListSchedule.recipientToList.label"),'default':("Recipient To List")],-1)
printHtmlPart(38)
invokeTag('fieldValue','g',104,['bean':(mailingListScheduleInstance),'field':("recipientToList")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListScheduleInstance?.scheduleStatus)) {
printHtmlPart(39)
invokeTag('message','g',110,['code':("mailingListSchedule.scheduleStatus.label"),'default':("Schedule Cancelled")],-1)
printHtmlPart(40)
invokeTag('message','g',111,['code':("mailinglist.status.${l.scheduleStatus}")],-1)
printHtmlPart(41)
}
printHtmlPart(42)
if(true && (mailingListScheduleInstance?.sendType)) {
printHtmlPart(43)
invokeTag('message','g',116,['code':("mailingListSchedule.sendType.label"),'default':("Send Type")],-1)
printHtmlPart(44)
invokeTag('fieldValue','g',117,['bean':(mailingListScheduleInstance),'field':("sendType")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListScheduleInstance?.setDate)) {
printHtmlPart(45)
invokeTag('message','g',123,['code':("mailingListSchedule.setDate.label"),'default':("Set Date")],-1)
printHtmlPart(46)
invokeTag('fieldValue','g',124,['bean':(mailingListScheduleInstance),'field':("setDate")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListScheduleInstance?.setTime)) {
printHtmlPart(47)
invokeTag('message','g',130,['code':("mailingListSchedule.setTime.label"),'default':("Set Time")],-1)
printHtmlPart(48)
invokeTag('fieldValue','g',131,['bean':(mailingListScheduleInstance),'field':("setTime")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListScheduleInstance?.subject)) {
printHtmlPart(49)
invokeTag('message','g',137,['code':("mailingListSchedule.subject.label"),'default':("Subject")],-1)
printHtmlPart(50)
invokeTag('fieldValue','g',138,['bean':(mailingListScheduleInstance),'field':("subject")],-1)
printHtmlPart(13)
}
printHtmlPart(51)
createTagBody(2, {->
printHtmlPart(52)
invokeTag('hiddenField','g',144,['name':("id"),'value':(mailingListScheduleInstance?.id)],-1)
printHtmlPart(53)
createTagBody(3, {->
invokeTag('message','g',145,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',145,['class':("edit"),'action':("edit"),'id':(mailingListScheduleInstance?.id)],3)
printHtmlPart(53)
invokeTag('actionSubmit','g',146,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(54)
})
invokeTag('form','g',148,[:],2)
printHtmlPart(55)
})
invokeTag('captureBody','sitemesh',150,[:],1)
printHtmlPart(56)
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
