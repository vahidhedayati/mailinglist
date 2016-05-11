import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListTemplates_mailerTemplatesDisplay_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListTemplates/_mailerTemplatesDisplay.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
invokeTag('select','g',1,['id':("mailingListTemplates"),'name':("mailingListTemplate"),'from':(returnResult  ?: grails.plugin.mailinglist.core.TemplatesBase.list(sort: 'name', order: 'asc')),'optionKey':("id"),'required':(""),'value':(params.mailingListTemplates),'class':("many-to-one"),'noSelection':(['': 'Please choose Template']),'onchange':(remoteFunction (
		controller: 'MailingListEmail',
		action: 'loadMessageBox',
		params: "'id=' + this.value",
		update: 'loadMessageBox'
	))],-1)
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
