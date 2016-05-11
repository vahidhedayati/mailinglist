import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListSchedulelist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListSchedule/list.gsp" }
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
invokeTag('message','g',6,['code':("default.list.label"),'args':([entityName])],-1)
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
invokeTag('message','g',17,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('sortableColumn','g',24,['property':("addedby"),'title':(message(code: 'mailingListSchedule.addedby.label', default: 'Addedby'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',25,['property':("dateCreated"),'title':(message(code: 'mailingListSchedule.dateCreated.label', default: 'Date Created'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',26,['property':("dateTime"),'title':(message(code: 'mailingListSchedule.dateTime.label', default: 'Date Time'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',27,['property':("emailMessage"),'title':(message(code: 'mailingListSchedule.emailMessage.label', default: 'Email Message'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',28,['property':("lastUpdated"),'title':(message(code: 'mailingListSchedule.lastUpdated.label', default: 'Last Updated'))],-1)
printHtmlPart(12)
loop:{
int i = 0
for( instance in (mailingListScheduleInstance) ) {
printHtmlPart(13)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: instance, field: "addedby"))
})
invokeTag('link','g',35,['action':("show"),'id':(instance.id)],3)
printHtmlPart(15)
invokeTag('formatDate','g',36,['date':(instance.dateCreated)],-1)
printHtmlPart(15)
expressionOut.print(fieldValue(bean: instance, field: "dateTime"))
printHtmlPart(15)
expressionOut.print(fieldValue(bean: instance, field: "emailMessage"))
printHtmlPart(15)
invokeTag('formatDate','g',39,['date':(instance.lastUpdated)],-1)
printHtmlPart(16)
i++
}
}
printHtmlPart(17)
invokeTag('paginate','g',45,['total':(total)],-1)
printHtmlPart(18)
createTagBody(2, {->
invokeTag('message','g',50,['code':("default.csv.label"),'default':("CSV")],-1)
})
invokeTag('link','g',50,['class':("csv"),'controller':("MailingListSchedule"),'action':("list"),'params':([max: params?.max, s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'csv', extension:'csv' ])],2)
printHtmlPart(19)
createTagBody(2, {->
invokeTag('message','g',53,['code':("default.excel.label"),'default':("EXCEL")],-1)
})
invokeTag('link','g',53,['class':("excel"),'controller':("MailingListSchedule"),'action':("list"),'params':([max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'excel', extension:'excel' ])],2)
printHtmlPart(19)
createTagBody(2, {->
invokeTag('message','g',56,['code':("default.pdf.label"),'default':("PDF")],-1)
})
invokeTag('link','g',56,['class':("pdf"),'controller':("MailingListSchedule"),'action':("list"),'params':([max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'pdf', extension:'pdf' ])],2)
printHtmlPart(20)
createTagBody(2, {->
invokeTag('message','g',59,['code':("default.rtf.label"),'default':("RTF")],-1)
})
invokeTag('link','g',59,['class':("rtf"),'controller':("MailingListSchedule"),'action':("list"),'params':([max: params?.max, s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'rtf', extension:'rtf' ])],2)
printHtmlPart(19)
createTagBody(2, {->
invokeTag('message','g',62,['code':("default.xml.label"),'default':("XML")],-1)
})
invokeTag('link','g',62,['class':("xml"),'controller':("MailingListSchedule"),'action':("list"),'params':([max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'xml', extension:'xml' ])],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',67,[:],1)
printHtmlPart(22)
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
