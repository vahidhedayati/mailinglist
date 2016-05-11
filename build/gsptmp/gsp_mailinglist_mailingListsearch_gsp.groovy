import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListsearch_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingList/search.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('sortableColumn','g',4,['property':("emailAddress"),'title':(message(code: 'mailingList.emailAddress.label', default: 'Email Address'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',5,['property':("emailDisplayName"),'title':(message(code: 'mailingList.emailDisplayName.label', default: 'Email Display Name'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',6,['property':("categories"),'title':(message(code: 'mailingList.categories.label', default: 'Category'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',7,['property':("firstName"),'title':(message(code: 'mailingList.firstName.label', default: 'First Name'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',8,['property':("lastName"),'title':(message(code: 'mailingList.lastName.label', default: 'Last Name'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',9,['property':("dateCreated"),'title':(message(code: 'mailingList.dateCreated.label', default: 'Date Created'))],-1)
printHtmlPart(2)
loop:{
int i = 0
for( mailingListInstance in (mailingListInstanceList) ) {
printHtmlPart(3)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(4)
createTagBody(2, {->
expressionOut.print(mailingListInstance?.emailAddress)
})
invokeTag('link','g',15,['action':("show"),'id':(mailingListInstance?.id)],2)
printHtmlPart(5)
expressionOut.print(mailingListInstance?.emailDisplayName)
printHtmlPart(5)
expressionOut.print(mailingListInstance?.categories?.name)
printHtmlPart(5)
expressionOut.print(mailingListInstance?.firstName)
printHtmlPart(5)
expressionOut.print(mailingListInstance?.lastName)
printHtmlPart(5)
invokeTag('display','prettytime',20,['date':(mailingListInstance?.dateCreated)],-1)
printHtmlPart(6)
i++
}
}
printHtmlPart(7)
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
