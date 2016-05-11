import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingList/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'mailingList.label', default: 'MailingList'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.admin.menu.label"),'args':([entityName]),'default':("Welcome to ${entityName}")],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('render','g',9,['template':("/mainmenu")],-1)
printHtmlPart(3)
invokeTag('message','g',13,['code':("default.schedule.title.label"),'default':("Schedule Email")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',14,['code':("default.email.person.label"),'default':("Contact Person")],-1)
})
invokeTag('link','g',14,['controller':("mailingListEmail"),'class':("list"),'action':("index")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.email.group.label"),'default':("Contact Group")],-1)
})
invokeTag('link','g',15,['controller':("mailingListEmail"),'class':("list"),'action':("contactclients")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.schedule.label"),'default':("Schedule Logs"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['controller':("MailingListSchedule"),'class':("list"),'action':("br"),'params':([s:'oa',viewtype:'na'])],2)
printHtmlPart(6)
invokeTag('message','g',17,['code':("default.templates.title.label"),'default':("Templates")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',18,['code':("default.create.template.label"),'default':("Create Email Template")],-1)
})
invokeTag('link','g',18,['controller':("MailingListTemplates"),'class':("create"),'action':("create")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',19,['code':("default.create.from.existing.template.label"),'default':("Create From existing Template")],-1)
})
invokeTag('link','g',19,['controller':("MailingListTemplates"),'class':("create"),'action':("loadtemplate")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',20,['code':("default.list.template.label"),'default':("List Email Templates")],-1)
})
invokeTag('link','g',20,['controller':("MailingListTemplates"),'class':("list"),'action':("list")],2)
printHtmlPart(7)
invokeTag('message','g',22,['code':("default.attachments.title.label"),'default':("Email Attachments")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',23,['code':("default.add.attachments.label"),'default':("Add Attachments")],-1)
})
invokeTag('link','g',23,['controller':("MailingListAttachments"),'class':("create"),'action':("create")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',24,['code':("default.list.attachments.label"),'default':("List Attachments")],-1)
})
invokeTag('link','g',24,['controller':("MailingListAttachments"),'class':("list"),'action':("list")],2)
printHtmlPart(8)
invokeTag('message','g',30,['code':("default.categories.title.label"),'default':("Categories (Binds to Email Address)")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',31,['code':("default.create.category.label"),'default':("Create Category")],-1)
})
invokeTag('link','g',31,['controller':("MailingListCategories"),'class':("create"),'action':("create")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',32,['code':("default.list.category.label"),'default':("List Categories")],-1)
})
invokeTag('link','g',32,['controller':("MailingListCategories"),'class':("list"),'action':("list")],2)
printHtmlPart(9)
invokeTag('message','g',34,['code':("default.csv.uploader.title.label"),'default':("CSV Contacts Uploader")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',35,['code':("default.upload.csv.label"),'default':("Upload CSV")],-1)
})
invokeTag('link','g',35,['controller':("MailingListUploader"),'class':("list"),'action':("index")],2)
printHtmlPart(10)
invokeTag('message','g',37,['code':("default.configure.senders.title.label"),'default':("Configure Senders (From)")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',38,['code':("default.create.senders.label"),'default':("Create Email Sender")],-1)
})
invokeTag('link','g',38,['controller':("MailingListSenders"),'class':("create"),'action':("create")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',39,['code':("default.list.senders.label"),'default':("List Email Senders")],-1)
})
invokeTag('link','g',39,['controller':("MailingListSenders"),'class':("list"),'action':("list")],2)
printHtmlPart(11)
invokeTag('message','g',41,['code':("default.mailinglist.title.label"),'default':("MailingList (All Email Addresses)")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',42,['code':("default.create.email.label"),'default':("Create Email")],-1)
})
invokeTag('link','g',42,['controller':("MailingList"),'class':("create"),'action':("create")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',43,['code':("default.list.email.label"),'default':("List Emails")],-1)
})
invokeTag('link','g',43,['controller':("MailingList"),'class':("list"),'action':("list")],2)
printHtmlPart(12)
if(true && (scheduleStatus==grails.plugin.mailinglist.core.ScheduleBase.SCHEDULE_COMPLETE)) {
printHtmlPart(13)
invokeTag('render','g',50,['template':("/mailingList/scheduleCompleted"),'model':([sc:scheduleCompleted, total: total])],-1)
printHtmlPart(14)
}
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',54,[:],1)
printHtmlPart(16)
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
