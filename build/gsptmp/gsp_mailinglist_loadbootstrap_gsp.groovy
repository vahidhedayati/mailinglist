import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_loadbootstrap_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/_loadbootstrap.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (enduser?.verifyAppVersion().equals('resources'))) {
printHtmlPart(1)
expressionOut.print(createLink(uri: '/css/bootstrap.min.css'))
printHtmlPart(2)
expressionOut.print(createLink(uri: '/css/mailingList.css'))
printHtmlPart(3)
expressionOut.print(createLink(uri: '/js/bootstrap.min.js'))
printHtmlPart(4)
}
else {
printHtmlPart(5)
invokeTag('javascript','asset',11,['src':("jquery-ui.min.js")],-1)
printHtmlPart(5)
invokeTag('javascript','asset',12,['src':("jquery-ui-timepicker-addon.js")],-1)
printHtmlPart(6)
invokeTag('javascript','asset',13,['src':("jquery-ui-timepicker-addon-i18n.min.js")],-1)
printHtmlPart(6)
invokeTag('stylesheet','asset',14,['href':("bootstrap.min.css")],-1)
printHtmlPart(6)
invokeTag('javascript','asset',15,['src':("bootstrap.min.js")],-1)
printHtmlPart(6)
invokeTag('stylesheet','asset',16,['href':("mailingList.css")],-1)
printHtmlPart(6)
invokeTag('stylesheet','asset',17,['href':("jquery-ui-timepicker-addon.css")],-1)
printHtmlPart(6)
invokeTag('stylesheet','asset',18,['href':("jquery-ui.css")],-1)
printHtmlPart(7)
}
printHtmlPart(8)
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
