import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListSchedule_list1_top_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListSchedule/_list1-top.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('sortableColumn','g',4,['property':("id"),'title':(message(code: 'links.id.label', default: 'ID'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',5,['property':("mailFrom"),'title':(message(code: 'links.sender.label', default: 'Sender'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',6,['property':("mailFrom"),'title':(message(code: 'links.mailFrom.label', default: 'From'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',7,['property':("recipientToList"),'title':(message(code: 'links.recipientToList.label', default: 'To'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',8,['property':("subject"),'title':(message(code: 'links.subject.label', default: 'subject'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',9,['property':("emailMessage"),'title':(message(code: 'links.emailMessage.label', default: 'Message'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',10,['property':("scheduleName"),'title':(message(code: 'links.scheduleName.label', default: 'scheduleID'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',11,['property':("dateTime"),'title':(message(code: 'links.dateTime.label', default: 'date/Time'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',12,['property':("sendType"),'title':(message(code: 'links.sendType.label', default: 'send Type'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',13,['property':("scheduleStatus"),'title':(message(code: 'links.scheduleStatus.label', default: 'Status'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',14,['property':("dateCreated"),'title':(message(code: 'links.dateCreated.label', default: 'Created'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',15,['property':("execDate"),'title':(message(code: 'links.execDate.label', default: 'execDate'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',16,['property':("Actions"),'title':(message(code: 'Actions', default: 'Actions'))],-1)
printHtmlPart(2)
loop:{
int i = 0
for( instance in (mailingListScheduleInstance) ) {
printHtmlPart(3)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(4)
expressionOut.print(fieldValue(bean: instance, field: "id"))
printHtmlPart(5)
expressionOut.print(fieldValue(bean: instance, field: "addedby"))
printHtmlPart(5)
expressionOut.print(fieldValue(bean: instance, field: "mailFrom"))
printHtmlPart(6)
invokeTag('loadPopUp','mailinglist',32,['id':(instance?.recipientToGroup),'scriptCall':("recipientToGroup"),'controller':("CategoryBase"),'retController':("MailingListCategories"),'retValue':("name"),'action':("show")],-1)
printHtmlPart(1)
expressionOut.print(fieldValue(bean: instance, field: "recipientToList"))
printHtmlPart(7)
expressionOut.print(fieldValue(bean: instance, field: "recipientBCCList"))
printHtmlPart(1)
expressionOut.print(fieldValue(bean: instance, field: "recipientCCList"))
printHtmlPart(8)
expressionOut.print(fieldValue(bean: instance, field: "subject"))
printHtmlPart(9)
invokeTag('loadPopUp','mailinglist',45,['id':(instance?.mailingListTemplate),'scriptCall':("mailingListTemplate"),'controller':("TemplatesBase"),'retController':("MailingListTemplates"),'retValue':("name"),'action':("show")],-1)
printHtmlPart(10)
invokeTag('loadPopUp','mailinglist',54,['id':(instance?.id),'scriptCall':("MailingListSchedule"),'controller':("ScheduleBase"),'retController':("MailingListSchedule"),'retValue':("id"),'action':("showmsg")],-1)
printHtmlPart(11)
if(true && (instance.scheduleName)) {
printHtmlPart(12)
invokeTag('find','quartzutils',57,['jobName':(instance.scheduleName)],-1)
printHtmlPart(1)
}
printHtmlPart(8)
expressionOut.print(fieldValue(bean: instance, field: "dateTime"))
printHtmlPart(13)
if(true && (instance.setDate && nstance.setTime)) {
printHtmlPart(14)
expressionOut.print(fieldValue(bean: instance, field: "setDate"))
printHtmlPart(15)
expressionOut.print(fieldValue(bean: instance, field: "setTime"))
printHtmlPart(16)
}
printHtmlPart(16)
if(true && (instance.cronExpression)) {
printHtmlPart(17)
invokeTag('translateCronExpress','mailinglist',66,['cronExpression':(instance?.cronExpression)],-1)
printHtmlPart(18)
expressionOut.print(instance.cronExpression)
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(fieldValue(bean: instance, field: "sendType"))
printHtmlPart(5)
invokeTag('message','g',72,['code':("mailinglist.status.${instance.scheduleStatus}")],-1)
printHtmlPart(21)
invokeTag('display','prettytime',75,['date':(instance.dateCreated)],-1)
printHtmlPart(22)
if(true && (instance.scheduleName)) {
printHtmlPart(23)
invokeTag('jobRunningTime','quartzutils',80,['jobName':(instance.scheduleName)],-1)
printHtmlPart(24)
}
else {
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (instance.scheduleStatus==grails.plugin.mailinglist.core.ScheduleBase.SCHEDULE_RUNNING ||instance.scheduleStatus==grails.plugin.mailinglist.core.ScheduleBase.CRON)) {
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(1)
if(true && (enduser?.verifyAppVersion().equals('resources'))) {
printHtmlPart(27)
expressionOut.print(resource(dir: 'images', file: 'stop.png'))
printHtmlPart(28)
expressionOut.print(message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule'))
printHtmlPart(29)
expressionOut.print(message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule'))
printHtmlPart(30)
}
else {
printHtmlPart(12)
invokeTag('image','asset',93,['src':("stop.png"),'alt':(message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule')),'data-tooltip':(message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule'))],-1)
printHtmlPart(1)
}
printHtmlPart(13)
})
invokeTag('link','g',95,['controller':("MailingListSchedule"),'action':("modSchedule"),'id':(instance.id),'params':([calltype:'cancel', jobName:instance.scheduleName ])],3)
printHtmlPart(31)
expressionOut.print(createLink(uri: '/quartz/pause?jobName='+meta(name:'app.name')+'.'+instance.scheduleName+'&jobGroup=GRAILS_JOBS'))
printHtmlPart(32)
if(true && (enduser?.verifyAppVersion().equals('resources'))) {
printHtmlPart(27)
expressionOut.print(resource(dir: 'images', file: 'pause.png'))
printHtmlPart(28)
expressionOut.print(message(code: 'default.pause.job.label', default: 'Pause job'))
printHtmlPart(29)
expressionOut.print(message(code: 'default.pause.job.label', default: 'Pause job'))
printHtmlPart(30)
}
else {
printHtmlPart(12)
invokeTag('image','asset',101,['src':("pause.png"),'alt':(message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule')),'data-tooltip':(message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule'))],-1)
printHtmlPart(1)
}
printHtmlPart(33)
invokeTag('displayResume','quartzutils',105,['jobName':(instance.scheduleName)],-1)
printHtmlPart(31)
expressionOut.print(createLink(uri: '/quartz/runNow?jobName='+meta(name:'app.name')+'.'+instance.scheduleName+'&jobGroup=GRAILS_JOBS'))
printHtmlPart(32)
if(true && (enduser?.verifyAppVersion().equals('resources'))) {
printHtmlPart(27)
expressionOut.print(resource(dir: 'images', file: 'run.png'))
printHtmlPart(28)
expressionOut.print(message(code: 'default.run.job.label', default: 'Run job'))
printHtmlPart(34)
expressionOut.print(message(code: 'default.run.job.label', default: 'Run job'))
printHtmlPart(30)
}
else {
printHtmlPart(12)
invokeTag('image','asset',111,['src':("run.png"),'alt':(message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule')),'data-tooltip':(message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule'))],-1)
printHtmlPart(1)
}
printHtmlPart(35)
}
printHtmlPart(36)
i++
}
}
printHtmlPart(37)
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
