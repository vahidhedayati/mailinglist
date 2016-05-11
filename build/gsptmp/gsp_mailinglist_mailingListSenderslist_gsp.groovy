import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListSenderslist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListSenders/list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'mailingListSenders.label', default: 'MailingListSenders'))],-1)
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
invokeTag('sortableColumn','g',24,['property':("addedby"),'title':(message(code: 'mailingListSenders.addedby.label', default: 'Addedby'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',25,['property':("emailAddress"),'title':(message(code: 'mailingListSenders.emailAddress.label', default: 'Email Address'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',26,['property':("dateCreated"),'title':(message(code: 'mailingListSenders.dateCreated.label', default: 'Date Created'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',27,['property':("lastUpdated"),'title':(message(code: 'mailingListSenders.lastUpdated.label', default: 'Last Updated'))],-1)
printHtmlPart(12)
loop:{
int i = 0
for( mailingListSendersInstance in (mailingListSendersInstanceList) ) {
printHtmlPart(13)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(14)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: mailingListSendersInstance, field: "addedby"))
})
invokeTag('link','g',33,['action':("show"),'id':(mailingListSendersInstance.id)],3)
printHtmlPart(15)
expressionOut.print(fieldValue(bean: mailingListSendersInstance, field: "emailAddress"))
printHtmlPart(15)
invokeTag('formatDate','g',35,['date':(mailingListSendersInstance.dateCreated)],-1)
printHtmlPart(15)
invokeTag('formatDate','g',36,['date':(mailingListSendersInstance.lastUpdated)],-1)
printHtmlPart(16)
i++
}
}
printHtmlPart(17)
invokeTag('paginate','g',42,['total':(mailingListSendersInstanceTotal)],-1)
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',45,[:],1)
printHtmlPart(19)
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
