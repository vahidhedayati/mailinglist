import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListTemplates_formSelfPost_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListTemplates/_formSelfPost.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('hiddenField','g',5,['name':("ajax"),'value':("yes")],-1)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: mailingListTemplatesInstance, field: 'name', 'error'))
printHtmlPart(3)
invokeTag('message','g',8,['code':("mailingListTemplates.name.label"),'default':("Name")],-1)
printHtmlPart(4)
invokeTag('textField','g',11,['name':("name"),'required':(""),'value':(mailingListTemplatesInstance?.name)],-1)
printHtmlPart(5)
invokeTag('render','g',13,['template':("/mailingList/addedby"),'model':([caller: 'mailingListTemplatesInstance'])],-1)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('editor','ckeditor',19,['name':("content"),'id':("myCKEditor"),'height':("25em"),'width':("100%")],2)
printHtmlPart(8)
invokeTag('submitButton','g',24,['name':("create"),'onclick':("CKupdate()"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(9)
})
invokeTag('form','g',26,['name':(attrs.formId),'id':("1"),'controller':("MailingListTemplates"),'action':("save"),'onload':("CKStart()")],1)
printHtmlPart(10)
createClosureForHtmlPart(11, 1)
invokeTag('javascript','g',40,[:],1)
printHtmlPart(12)
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
