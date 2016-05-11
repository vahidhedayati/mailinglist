import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListTemplatesshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListTemplates/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'mailingListTemplates.label', default: 'MailingListTemplates'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('render','g',10,['template':("/mainmenu")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',12,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',12,['class':("create"),'action':("create")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',13,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',13,['class':("list"),'action':("list")],2)
printHtmlPart(6)
invokeTag('message','g',18,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (mailingListTemplatesInstance?.name)) {
printHtmlPart(11)
invokeTag('message','g',26,['code':("mailingListTemplates.name.label"),'default':("Name")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',27,['bean':(mailingListTemplatesInstance),'field':("name")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListTemplatesInstance?.addedby)) {
printHtmlPart(15)
invokeTag('message','g',33,['code':("mailingListTemplates.addedby.label"),'default':("Addedby")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',34,['bean':(mailingListTemplatesInstance),'field':("addedby")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListTemplatesInstance?.content)) {
printHtmlPart(17)
invokeTag('message','g',40,['code':("mailingListTemplates.content.label"),'default':("Content")],-1)
printHtmlPart(18)
expressionOut.print(mailingListTemplatesInstance?.content.encodeAsRaw())
printHtmlPart(19)
}
printHtmlPart(14)
if(true && (mailingListTemplatesInstance?.dateCreated)) {
printHtmlPart(20)
invokeTag('message','g',51,['code':("mailingListTemplates.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(21)
invokeTag('formatDate','g',52,['date':(mailingListTemplatesInstance?.dateCreated)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListTemplatesInstance?.lastUpdated)) {
printHtmlPart(22)
invokeTag('message','g',58,['code':("mailingListTemplates.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(23)
invokeTag('formatDate','g',59,['date':(mailingListTemplatesInstance?.lastUpdated)],-1)
printHtmlPart(13)
}
printHtmlPart(24)
createTagBody(2, {->
printHtmlPart(25)
invokeTag('hiddenField','g',65,['name':("id"),'value':(mailingListTemplatesInstance?.id)],-1)
printHtmlPart(26)
createTagBody(3, {->
invokeTag('message','g',66,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',66,['class':("edit"),'action':("edit"),'id':(mailingListTemplatesInstance?.id)],3)
printHtmlPart(26)
invokeTag('actionSubmit','g',67,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(27)
})
invokeTag('form','g',69,[:],2)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',71,[:],1)
printHtmlPart(29)
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
