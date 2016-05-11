import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListTemplatesajaxupload_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListTemplates/ajaxupload.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
if(true && (enduser?.verifyAppVersion().equals('resources'))) {
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("mailingListMini")],-1)
printHtmlPart(3)
}
else {
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("mailingListMiniAssets")],-1)
printHtmlPart(3)
}
printHtmlPart(4)
invokeTag('set','g',11,['var':("entityName"),'value':(message(code: 'MailingListSchedule.label', default: 'MailingList Schedule'))],-1)
printHtmlPart(5)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',12,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
invokeTag('render','g',16,['template':("/mailingListModal/modalbasicSelfPost"),'model':([formId:'TemplatesForm', title:'Generate Template',controller: 'mailingListTemplates', callPage: 'formAjax' , divId: 'mailerTemplates', id: 'TEMPLATES'])],-1)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',18,[:],1)
printHtmlPart(9)
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
