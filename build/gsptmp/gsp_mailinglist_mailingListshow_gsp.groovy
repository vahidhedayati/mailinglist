import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingList/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'mailingList.label', default: 'MailingList'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('render','g',11,['template':("/mainmenu")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',13,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',13,['class':("create"),'action':("create")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',14,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',14,['class':("list"),'action':("list")],2)
printHtmlPart(6)
invokeTag('message','g',19,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (mailingListInstance?.addedby)) {
printHtmlPart(11)
invokeTag('message','g',26,['code':("mailingList.addedby.label"),'default':("Addedby")],-1)
printHtmlPart(12)
invokeTag('fieldValue','g',27,['bean':(mailingListInstance),'field':("addedby")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListInstance?.emailAddress)) {
printHtmlPart(15)
invokeTag('message','g',32,['code':("mailingList.emailAddress.label"),'default':("Email Address")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',33,['bean':(mailingListInstance),'field':("emailAddress")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListInstance?.dateCreated)) {
printHtmlPart(17)
invokeTag('message','g',38,['code':("mailingList.dateCreated.label"),'default':("Date Created")],-1)
printHtmlPart(18)
invokeTag('formatDate','g',39,['date':(mailingListInstance?.dateCreated)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListInstance?.emailDisplayName)) {
printHtmlPart(19)
invokeTag('message','g',44,['code':("mailingList.emailDisplayName.label"),'default':("Email Display Name")],-1)
printHtmlPart(20)
invokeTag('fieldValue','g',45,['bean':(mailingListInstance),'field':("emailDisplayName")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListInstance?.firstName)) {
printHtmlPart(21)
invokeTag('message','g',50,['code':("mailingList.firstName.label"),'default':("First Name")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',51,['bean':(mailingListInstance),'field':("firstName")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListInstance?.lastName)) {
printHtmlPart(23)
invokeTag('message','g',56,['code':("mailingList.lastName.label"),'default':("Last Name")],-1)
printHtmlPart(24)
invokeTag('fieldValue','g',57,['bean':(mailingListInstance),'field':("lastName")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListInstance?.lastUpdated)) {
printHtmlPart(25)
invokeTag('message','g',62,['code':("mailingList.lastUpdated.label"),'default':("Last Updated")],-1)
printHtmlPart(26)
invokeTag('formatDate','g',63,['date':(mailingListInstance?.lastUpdated)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListInstance?.middleName)) {
printHtmlPart(27)
invokeTag('message','g',68,['code':("mailingList.middleName.label"),'default':("Middle Name")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',69,['bean':(mailingListInstance),'field':("middleName")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (mailingListInstance?.categories)) {
printHtmlPart(29)
invokeTag('message','g',74,['code':("mailingList.categories.label"),'default':("categories")],-1)
printHtmlPart(30)
createTagBody(3, {->
expressionOut.print(mailingListInstance?.categories?.encodeAsHTML())
})
invokeTag('link','g',75,['controller':("mailingListCategories"),'action':("show"),'id':(mailingListInstance?.categories?.id)],3)
printHtmlPart(13)
}
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
invokeTag('hiddenField','g',81,['name':("id"),'value':(mailingListInstance?.id)],-1)
printHtmlPart(33)
createTagBody(3, {->
invokeTag('message','g',82,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',82,['class':("edit"),'action':("edit"),'id':(mailingListInstance?.id)],3)
printHtmlPart(33)
invokeTag('actionSubmit','g',83,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(34)
})
invokeTag('form','g',85,[:],2)
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',88,[:],1)
printHtmlPart(36)
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
