import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingList_scheduleCompleted_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingList/_scheduleCompleted.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('message','g',6,['code':("default.total.sent.label"),'default':("Total Sent: ${total}"),'args':([total])],-1)
})
invokeTag('link','g',6,['controller':("MailingListSchedule"),'class':("list"),'action':("br"),'params':([s:'od',viewtype:'na'])],1)
printHtmlPart(2)
for( l in (sc) ) {
printHtmlPart(3)
expressionOut.print(l.mailFrom)
printHtmlPart(4)
if(true && (l.recipientToGroup)) {
printHtmlPart(5)
invokeTag('loadPopUp','mailinglist',19,['id':(l?.recipientToGroup),'scriptCall':("recipientToGroup"),'controller':("CategoryBase"),'retController':("MailingListCategories"),'retValue':("name"),'action':("show")],-1)
printHtmlPart(1)
}
printHtmlPart(6)
if(true && (l.recipientToList)) {
printHtmlPart(7)
invokeTag('message','g',22,['code':("default.to.label"),'default':("To")],-1)
printHtmlPart(8)
expressionOut.print(l?.recipientToList)
printHtmlPart(9)
}
printHtmlPart(6)
if(true && (l.recipientBCCList)) {
printHtmlPart(10)
invokeTag('message','g',25,['code':("default.bcc.label"),'default':("BCC")],-1)
printHtmlPart(8)
expressionOut.print(l?.recipientBCCList)
printHtmlPart(9)
}
printHtmlPart(6)
if(true && (l.recipientCCList)) {
printHtmlPart(10)
invokeTag('message','g',28,['code':("default.cc.label"),'default':("CC")],-1)
printHtmlPart(8)
expressionOut.print(l?.recipientCCList)
printHtmlPart(9)
}
printHtmlPart(11)
invokeTag('message','g',33,['code':("default.sent.label"),'default':("Sent")],-1)
printHtmlPart(12)
invokeTag('display','prettytime',34,['date':(l.dateCreated)],-1)
printHtmlPart(13)
invokeTag('message','g',37,['code':("default.subject.label"),'default':("Subject")],-1)
printHtmlPart(8)
expressionOut.print(l.subject)
printHtmlPart(14)
invokeTag('message','g',38,['code':("default.message.label"),'default':("Msg")],-1)
printHtmlPart(15)
invokeTag('loadPopUp','mailinglist',44,['id':(l?.id),'scriptCall':("MailingListSchedule"),'controller':("ScheduleBase"),'retController':("MailingListSchedule"),'retValue':("id"),'action':("showmsg")],-1)
printHtmlPart(16)
invokeTag('message','g',47,['code':("mailinglist.status.${l.scheduleStatus}")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
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
