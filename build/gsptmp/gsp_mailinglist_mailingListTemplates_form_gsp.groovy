import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListTemplates_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListTemplates/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
invokeTag('resources','ckeditor',2,[:],-1)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',3,[:],1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: mailingListTemplatesInstance, field: 'name', 'error'))
printHtmlPart(2)
invokeTag('message','g',7,['code':("mailingListTemplates.name.label"),'default':("Name")],-1)
printHtmlPart(3)
invokeTag('textField','g',10,['name':("name"),'required':(""),'value':(mailingListTemplatesInstance?.name)],-1)
printHtmlPart(4)
invokeTag('render','g',13,['template':("/mailingList/addedby"),'model':([caller: 'mailingListTemplatesInstance'])],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: mailingListTemplatesInstance, field: 'content', 'error'))
printHtmlPart(5)
invokeTag('message','g',17,['code':("mailingListTemplates.content.label"),'default':("Content")],-1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
expressionOut.print(mailingListTemplatesInstance?.content)
printHtmlPart(8)
})
invokeTag('editor','ckeditor',22,['name':("content"),'height':("300px"),'width':("100%")],1)
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
