import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListUploaderajaxupload_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListUploader/ajaxupload.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
if(true && (enduser?.verifyAppVersion().equals('resources'))) {
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("mailingListMini")],-1)
printHtmlPart(3)
}
else {
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("mailingListMiniAssets")],-1)
printHtmlPart(3)
}
printHtmlPart(4)
invokeTag('set','g',13,['var':("entityName"),'value':(message(code: 'MailingListSchedule.label', default: 'MailingList Schedule'))],-1)
printHtmlPart(5)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',14,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',14,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',14,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',15,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('hiddenField','g',38,['name':("ajax"),'value':("yes")],-1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: params, field: 'catname', 'error'))
printHtmlPart(10)
invokeTag('message','g',41,['code':("manager.label"),'default':("Mailing List Name")],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: params, field: 'file', 'error'))
printHtmlPart(12)
invokeTag('message','g',48,['code':("manager.label"),'default':("Choose File")],-1)
printHtmlPart(13)
invokeTag('submitButton','g',52,['name':("upload"),'value':("Upload")],-1)
printHtmlPart(8)
})
invokeTag('uploadForm','g',53,['name':(params?.formId),'id':("1"),'controller':("MailingListUploader"),'action':("upload")],2)
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',57,[:],1)
printHtmlPart(15)
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
