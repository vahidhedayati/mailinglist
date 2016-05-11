import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_loadplugincss_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/_loadplugincss.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
if(true && (enduser?.verifyAppVersion().equals('resources'))) {
printHtmlPart(0)
expressionOut.print(createLink(uri: '/css/mailingList.css'))
printHtmlPart(1)
}
else {
printHtmlPart(2)
invokeTag('javascript','asset',5,['src':("jquery-ui.min.js")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',6,['src':("jquery-ui-timepicker-addon.js")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',7,['src':("jquery-ui-timepicker-addon-i18n.min.js")],-1)
printHtmlPart(3)
invokeTag('stylesheet','asset',8,['href':("mailingList.css")],-1)
printHtmlPart(3)
invokeTag('stylesheet','asset',9,['href':("jquery-ui-timepicker-addon.css")],-1)
printHtmlPart(3)
invokeTag('stylesheet','asset',10,['href':("jquery-ui.css")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
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
