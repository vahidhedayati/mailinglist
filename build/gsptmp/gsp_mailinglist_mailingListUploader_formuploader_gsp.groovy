import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListUploader_formuploader_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListUploader/_formuploader.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("mailingListMiniAssets")],-1)
printHtmlPart(2)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'MailingListSchedule.label', default: 'MailingList Schedule'))],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('hiddenField','g',25,['name':("ajax"),'value':("yes")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: params, field: 'catname', 'error'))
printHtmlPart(8)
invokeTag('message','g',28,['code':("manager.label"),'default':("Mailing List Name")],-1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: params, field: 'file', 'error'))
printHtmlPart(10)
invokeTag('message','g',35,['code':("manager.label"),'default':("Choose File")],-1)
printHtmlPart(11)
invokeTag('submitButton','g',39,['name':("upload"),'value':("Upload")],-1)
printHtmlPart(6)
})
invokeTag('uploadForm','g',40,['name':(params?.formId),'id':("1"),'controller':("MailingListUploader"),'action':("upload")],2)
printHtmlPart(12)
})
invokeTag('captureBody','sitemesh',44,[:],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1463000702000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
