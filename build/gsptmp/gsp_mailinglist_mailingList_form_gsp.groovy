import grails.plugin.mailinglist.core.CategoryBase
import grails.plugin.mailinglist.core.SendersBase
import grails.plugin.mailinglist.core.ScheduleBase
import grails.plugin.mailinglist.core.TemplatesBase
import grails.plugin.mailinglist.core.MailingListBase
import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingList_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingList/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
invokeTag('render','g',6,['template':("/mailingList/addedby"),'model':([caller: 'mailingListInstance'])],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: mailingListInstance, field: 'title', 'error'))
printHtmlPart(2)
invokeTag('message','g',9,['code':("mailingList.title.label"),'default':("Title")],-1)
printHtmlPart(3)
invokeTag('textField','g',11,['name':("title"),'value':(mailingListInstance?.title)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mailingListInstance, field: 'firstName', 'error'))
printHtmlPart(5)
invokeTag('message','g',16,['code':("mailingList.firstName.label"),'default':("First Name")],-1)
printHtmlPart(3)
invokeTag('textField','g',18,['name':("firstName"),'value':(mailingListInstance?.firstName)],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: mailingListInstance, field: 'middleName', 'error'))
printHtmlPart(7)
invokeTag('message','g',24,['code':("mailingList.middleName.label"),'default':("Middle Name")],-1)
printHtmlPart(3)
invokeTag('textField','g',26,['name':("middleName"),'value':(mailingListInstance?.middleName)],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: mailingListInstance, field: 'lastName', 'error'))
printHtmlPart(8)
invokeTag('message','g',32,['code':("mailingList.lastName.label"),'default':("Last Name")],-1)
printHtmlPart(3)
invokeTag('textField','g',34,['name':("lastName"),'value':(mailingListInstance?.lastName)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: mailingListInstance, field: 'emailAddress', 'error'))
printHtmlPart(9)
invokeTag('message','g',39,['code':("mailingList.emailAddress.label"),'default':("Email Address")],-1)
printHtmlPart(3)
invokeTag('field','g',41,['type':("email"),'name':("emailAddress"),'value':(mailingListInstance?.emailAddress)],-1)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: mailingListInstance, field: 'emailDisplayName', 'error'))
printHtmlPart(10)
invokeTag('message','g',47,['code':("mailingList.emailDisplayName.label"),'default':("Email Display Name")],-1)
printHtmlPart(3)
invokeTag('textField','g',49,['name':("emailDisplayName"),'value':(mailingListInstance?.emailDisplayName)],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: mailingListInstance, field: 'categories', 'error'))
printHtmlPart(12)
invokeTag('message','g',56,['code':("mailingList.categories.label"),'default':("categories")],-1)
printHtmlPart(13)
invokeTag('select','g',59,['id':("categories"),'name':("categories.id"),'from':(CategoryBase?.list()),'optionKey':("id"),'required':(""),'value':(mailingListInstance?.categories?.id),'class':("many-to-one")],-1)
printHtmlPart(14)
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
