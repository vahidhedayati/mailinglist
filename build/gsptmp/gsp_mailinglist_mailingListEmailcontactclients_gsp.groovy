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

class gsp_mailinglist_mailingListEmailcontactclients_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListEmail/contactclients.gsp" }
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
createTagBody(2, {->
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(7)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(8)
expressionOut.print(error.field)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('message','g',22,['error':(error)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',23,['bean':(mailingListScheduleInstance),'var':("error")],3)
printHtmlPart(12)
})
invokeTag('hasErrors','g',25,['bean':(mailingListScheduleInstance)],2)
printHtmlPart(13)
invokeTag('message','g',26,['code':("default.contactgroup.label"),'args':([entityName]),'default':("Define Schedule to Contact Mailing Group")],-1)
printHtmlPart(14)
if(true && (flash.message)) {
printHtmlPart(15)
expressionOut.print(flash.message)
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('genModalButton','md',38,['id':("ModalDynamixSELFPOST"),'divId':("mailerTemplates1"),'title':("Create New Template"),'value':("New Template"),'style':("btn btn-primary")],-1)
printHtmlPart(18)
invokeTag('genModalButton','md',47,['id':("ModalDynamixIFRAMEUPLOADS"),'divId':("mailerUploader1"),'title':("Upload CSV Mail To Group?"),'value':("Upload CSV"),'style':("btn btn-danger")],-1)
printHtmlPart(19)
invokeTag('genModalButton','md',54,['id':("ModalDynamixIFRAMEATTACH"),'divId':("mailerAttachments1"),'title':("New Attachment?"),'value':("New Attachment"),'style':("btn btn-warning")],-1)
printHtmlPart(20)
invokeTag('genModalButton','md',62,['id':("ModalDynamixRemoteFORM"),'divId':("mailerSenders1"),'title':("New Email From field"),'value':("New Sender"),'style':("btn btn-success")],-1)
printHtmlPart(21)
invokeTag('render','g',68,['template':("/mailingListTemplates/mailerTemplatesForm")],-1)
printHtmlPart(22)
invokeTag('render','g',71,['template':("/mailingListUploader/mailerUploaderForm")],-1)
printHtmlPart(23)
invokeTag('render','g',75,['template':("/mailingListAttachments/mailerAttachmentsForm")],-1)
printHtmlPart(24)
invokeTag('render','g',78,['template':("/mailingListSenders/mailerSendersForm")],-1)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
invokeTag('render','g',87,['template':("/mailingList/addedby"),'model':([caller: 'params'])],-1)
printHtmlPart(27)
expressionOut.print(hasErrors(bean: params, field: 'sendType', 'error'))
printHtmlPart(28)
invokeTag('message','g',90,['code':("manager.label"),'default':("sendType")],-1)
printHtmlPart(29)
invokeTag('select','g',98,['id':("sendType"),'name':("sendType"),'value':(params.sendType),'from':(['bulk':'bulk', 'individual':'individual']),'optionKey':("key"),'optionValue':("value"),'noSelection':(['bulk': 'bulk']),'required':("required")],-1)
printHtmlPart(30)
invokeTag('message','g',99,['code':("default.bulk.message.label"),'default':("Bulk = one email with all users in one line and put it in BCC field ")],-1)
printHtmlPart(31)
invokeTag('message','g',100,['code':("default.individual.message.label"),'default':("Individual = will create 1 email per user and send To each user")],-1)
printHtmlPart(32)
expressionOut.print(hasErrors(bean: params, field: 'mailFrom', 'error'))
printHtmlPart(33)
invokeTag('message','g',105,['code':("manager.label"),'default':("mailFrom")],-1)
printHtmlPart(34)
invokeTag('render','g',109,['template':("/mailingListSenders/mailerSendersDisplay")],-1)
printHtmlPart(35)
expressionOut.print(hasErrors(bean: params, field: 'recipientToGroup', 'error'))
printHtmlPart(36)
invokeTag('message','g',114,['code':("recipientToGroup.label"),'default':("To:")],-1)
printHtmlPart(37)
invokeTag('render','g',118,['template':("/mailingListUploader/mailerUploaderDisplay")],-1)
printHtmlPart(38)
expressionOut.print(hasErrors(bean: params, field: 'subject', 'error'))
printHtmlPart(39)
invokeTag('message','g',126,['code':("manager.label"),'default':("subject")],-1)
printHtmlPart(40)
invokeTag('textField','g',129,['name':("subject"),'value':(params?.subject),'size':("60")],-1)
printHtmlPart(41)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'attachments', 'error'))
printHtmlPart(42)
invokeTag('message','g',136,['code':("mailingListSchedule.attachments.label"),'default':("Attachments")],-1)
printHtmlPart(43)
invokeTag('render','g',139,['template':("/mailingListAttachments/mailerAttachmentsDisplay")],-1)
printHtmlPart(44)
if(true && (params.emailMessage)) {
printHtmlPart(2)
if(true && (params.mailingListTemplate)) {
printHtmlPart(45)
invokeTag('hiddenField','g',145,['name':("mailingListTemplate"),'value':(params.mailingListTemplate)],-1)
printHtmlPart(2)
}
printHtmlPart(27)
expressionOut.print(hasErrors(bean: params, field: 'emailMessage', 'error'))
printHtmlPart(46)
invokeTag('message','g',149,['code':("emailMessage.label"),'default':("Message")],-1)
printHtmlPart(47)
invokeTag('resources','ckeditor',151,[:],-1)
printHtmlPart(48)
createTagBody(4, {->
printHtmlPart(49)
expressionOut.print(params.emailMessage)
printHtmlPart(45)
})
invokeTag('editor','ckeditor',155,['name':("emailMessage"),'height':("300px"),'width':("140%")],4)
printHtmlPart(50)
}
else {
printHtmlPart(27)
expressionOut.print(hasErrors(bean: params, field: 'mailingListScheduleInstance', 'error'))
printHtmlPart(51)
invokeTag('message','g',162,['code':("mailingListTemplates.label"),'default':("Template")],-1)
printHtmlPart(52)
invokeTag('render','g',166,['template':("/mailingListTemplates/mailerTemplatesDisplay")],-1)
printHtmlPart(53)
}
printHtmlPart(54)
expressionOut.print(hasErrors(bean: mailingListScheduleInstance, field: 'dateTime', 'error'))
printHtmlPart(55)
invokeTag('message','g',174,['code':("dateTime.label"),'default':("dateTime")],-1)
printHtmlPart(47)
if(true && (enduser?.verifyAppVersion().equals('resources'))) {
printHtmlPart(45)
invokeTag('time','jqueryPicker',177,['name':("dateTime"),'value':(curr)],-1)
printHtmlPart(2)
}
else {
printHtmlPart(56)
expressionOut.print(current)
printHtmlPart(57)
}
printHtmlPart(58)
expressionOut.print(hasErrors(bean: params, field: 'cronExpression', 'error'))
printHtmlPart(59)
invokeTag('message','g',186,['code':("cronExpression.label"),'default':("cronExpression")],-1)
printHtmlPart(47)
invokeTag('textField','g',188,['name':("cronExpression"),'value':(params?.cronExpression)],-1)
printHtmlPart(60)
expressionOut.print(hasErrors(bean: params, field: 'setDate', 'error'))
printHtmlPart(61)
invokeTag('message','g',193,['code':("setDate.label"),'default':("Issue/Resolve Date:")],-1)
printHtmlPart(62)
if(true && (enduser?.verifyAppVersion().equals('resources'))) {
printHtmlPart(63)
invokeTag('date','jqueryPicker',197,['name':("setDate"),'value':(params.setDate)],-1)
printHtmlPart(64)
}
else {
printHtmlPart(65)
expressionOut.print(params.setDate)
printHtmlPart(57)
}
printHtmlPart(66)
expressionOut.print(hasErrors(bean: params, field: 'setTime', 'error'))
printHtmlPart(67)
invokeTag('message','g',206,['code':("setTime.label"),'default':("Issue/Resolve Time:")],-1)
printHtmlPart(62)
invokeTag('timePicker','joda',209,['name':("setTime"),'value':("")],-1)
printHtmlPart(58)
expressionOut.print(hasErrors(bean: params, field: 'send', 'error'))
printHtmlPart(68)
invokeTag('message','g',214,['code':("dateTime.label"),'default':("Trigger")],-1)
printHtmlPart(47)
invokeTag('submitButton','g',216,['name':("Send Email"),'id':("loginbtn"),'class':("loginbtn"),'value':(message(code: 'default.button.preview.label', default: 'Preview'))],-1)
printHtmlPart(69)
})
invokeTag('form','g',221,['action':("confirmcontact")],2)
printHtmlPart(70)
createTagBody(2, {->
printHtmlPart(71)
if(true && (enduser?.verifyAppVersion().equals('resources'))) {
printHtmlPart(72)
}
printHtmlPart(73)
})
invokeTag('javascript','g',242,[:],2)
printHtmlPart(0)
})
invokeTag('captureBody','sitemesh',243,[:],1)
printHtmlPart(74)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1462999369000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
