import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListCategories_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListCategories/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: mailingListCatInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',3,['code':("mailingListCat.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',6,['name':("name"),'required':(""),'value':(mailingListCatInstance?.name)],-1)
printHtmlPart(3)
invokeTag('render','g',8,['template':("/mailingList/addedby"),'model':([caller: 'mailingListCatInstance'])],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mailingListCatInstance, field: 'mailinglist', 'error'))
printHtmlPart(5)
invokeTag('message','g',11,['code':("mailingListCat.mailinglist.label"),'default':("Mailinglist")],-1)
printHtmlPart(6)
for( m in (mailingListCatInstance?.mailinglist) ) {
printHtmlPart(7)
createTagBody(2, {->
expressionOut.print(m?.encodeAsHTML())
})
invokeTag('link','g',15,['controller':("mailingList"),'action':("show"),'id':(m.id)],2)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'mailingList.label', default: 'MailingList')]))
})
invokeTag('link','g',18,['controller':("mailingList"),'action':("create"),'params':(['mailingListCat.id': mailingListCatInstance?.id])],1)
printHtmlPart(10)
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
