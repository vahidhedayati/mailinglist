import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListCategoriesshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListCategories/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'mailingListCat.label', default: 'MailingListCategories'))],-1)
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
if(true && (mailingListCatInstance?.name)) {
printHtmlPart(11)
invokeTag('message','g',25,['code':("mailingListCat.name.label"),'default':("Name")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',26,['bean':(mailingListCatInstance),'field':("name")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListCatInstance?.addedby)) {
printHtmlPart(15)
invokeTag('message','g',31,['code':("mailingListCat.addedby.label"),'default':("Addedby")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',32,['bean':(mailingListCatInstance),'field':("addedby")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListCatInstance?.dateCreated)) {
printHtmlPart(17)
invokeTag('message','g',37,['code':("mailingListCat.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(18)
invokeTag('formatDate','g',38,['date':(mailingListCatInstance?.dateCreated)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListCatInstance?.lastUpdated)) {
printHtmlPart(19)
invokeTag('message','g',43,['code':("mailingListCat.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(20)
invokeTag('formatDate','g',44,['date':(mailingListCatInstance?.lastUpdated)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListCatInstance?.mailinglist)) {
printHtmlPart(21)
invokeTag('message','g',49,['code':("mailingListCat.mailinglist.label"),'default':("Mailinglist")],-1)
printHtmlPart(22)
for( m in (mailingListCatInstance.mailinglist) ) {
printHtmlPart(23)
createTagBody(4, {->
expressionOut.print(m?.encodeAsHTML())
})
invokeTag('link','g',51,['controller':("mailingList"),'action':("show"),'id':(m.id)],4)
printHtmlPart(22)
}
printHtmlPart(24)
}
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
invokeTag('hiddenField','g',58,['name':("id"),'value':(mailingListCatInstance?.id)],-1)
printHtmlPart(27)
createTagBody(3, {->
invokeTag('message','g',59,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',59,['class':("edit"),'action':("edit"),'id':(mailingListCatInstance?.id)],3)
printHtmlPart(27)
invokeTag('actionSubmit','g',60,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(28)
})
invokeTag('form','g',62,[:],2)
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',64,[:],1)
printHtmlPart(30)
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
