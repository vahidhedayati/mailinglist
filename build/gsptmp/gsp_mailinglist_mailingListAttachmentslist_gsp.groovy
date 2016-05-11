import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListAttachmentslist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListAttachments/list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'mailingListAttachments.label', default: 'MailingListAttachments'))],-1)
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
invokeTag('message','g',18,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('message','g',22,['code':("default.files.uploaded.message.download.label"),'default':("Files are uploaded directly to DB and presented in binary format, in order to simplify the show option will attempt to directly download uploaded file.")],-1)
printHtmlPart(11)
invokeTag('message','g',24,['code':("default.files.uploaded.issues.label"),'default':("Once uploaded, if there are issues DELETE and RE-CREATE")],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',28,['property':("fullname"),'title':(message(code: 'mailingListAttachments.fullname.label', default: 'Fullname'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',29,['property':("size"),'title':(message(code: 'mailingListAttachments.size.label', default: 'size'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',30,['property':("name"),'title':(message(code: 'mailingListAttachments.name.label', default: 'Name'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',31,['property':("contentType"),'title':(message(code: 'mailingListAttachments.contentType.label', default: 'contentType'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',32,['property':("addedby"),'title':(message(code: 'mailingListAttachments.addedby.label', default: 'Addedby'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',33,['property':("dateCreated"),'title':(message(code: 'mailingListAttachments.dateCreated.label', default: 'Date Created'))],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',34,['property':("lastUpdated"),'title':(message(code: 'mailingListAttachments.lastUpdated.label', default: 'Last Updated'))],-1)
printHtmlPart(14)
loop:{
int i = 0
for( mailingListAttachmentsInstance in (mailingListAttachmentsInstanceList) ) {
printHtmlPart(15)

def cc=""

printHtmlPart(15)
if(true && (mailingListAttachmentsInstance.attachment.size()>0)) {
printHtmlPart(15)

cc="${(i % 2) == 0 ? 'even' : 'odd'}"

printHtmlPart(15)
}
else {
printHtmlPart(15)

cc="red"

printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(cc)
printHtmlPart(17)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: mailingListAttachmentsInstance, field: "fullname"))
printHtmlPart(13)
})
invokeTag('link','g',48,['action':("show"),'id':(mailingListAttachmentsInstance.id)],3)
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',48,['action':("del"),'id':(mailingListAttachmentsInstance.id)],3)
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',49,['action':("download"),'id':(mailingListAttachmentsInstance.id)],3)
printHtmlPart(22)
expressionOut.print(mailingListAttachmentsInstance.attachment.size())
printHtmlPart(23)
expressionOut.print(fieldValue(bean: mailingListAttachmentsInstance, field: "name"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: mailingListAttachmentsInstance, field: "contentType"))
printHtmlPart(23)
expressionOut.print(fieldValue(bean: mailingListAttachmentsInstance, field: "addedby"))
printHtmlPart(23)
invokeTag('display','prettytime',55,['date':(mailingListAttachmentsInstance.dateCreated)],-1)
printHtmlPart(23)
invokeTag('display','prettytime',56,['date':(mailingListAttachmentsInstance.lastUpdated)],-1)
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',63,['total':(mailingListAttachmentsInstanceTotal)],-1)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',68,[:],1)
printHtmlPart(27)
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
