import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListUploader_mailerUploaderDisplay_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListUploader/_mailerUploaderDisplay.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( cat in (returnValue ?: grails.plugin.mailinglist.core.CategoryBase.list()) ) {
printHtmlPart(1)
if(true && (params.recipientToGroup.getClass().isArray())) {
printHtmlPart(2)
if(true && (params.recipientToGroup.contains(cat.id.toString()))) {
printHtmlPart(3)
invokeTag('checkBox','g',8,['name':("recipientToGroup"),'value':(cat.id),'checked':("true")],-1)
printHtmlPart(4)
expressionOut.print(cat.name)
printHtmlPart(5)
}
else {
printHtmlPart(6)
invokeTag('checkBox','g',11,['name':("recipientToGroup"),'value':(cat.id),'checked':("false")],-1)
printHtmlPart(4)
expressionOut.print(cat.name)
printHtmlPart(7)
}
printHtmlPart(8)
}
else {
printHtmlPart(9)
if(true && (params.recipientToGroup)) {
printHtmlPart(10)
if(true && (params.recipientToGroup.toString().equals(cat.id.toString()))) {
printHtmlPart(11)
invokeTag('checkBox','g',19,['name':("recipientToGroup"),'value':(cat.id),'checked':("true")],-1)
printHtmlPart(4)
expressionOut.print(cat.name)
printHtmlPart(5)
}
else {
printHtmlPart(11)
invokeTag('checkBox','g',22,['name':("recipientToGroup"),'value':(cat.id),'checked':("false")],-1)
printHtmlPart(4)
expressionOut.print(cat.name)
printHtmlPart(12)
}
printHtmlPart(13)
}
else {
printHtmlPart(14)
invokeTag('checkBox','g',26,['name':("recipientToGroup"),'value':(cat.id),'checked':("false")],-1)
printHtmlPart(4)
expressionOut.print(cat.name)
printHtmlPart(15)
}
printHtmlPart(16)
}
printHtmlPart(17)
}
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
