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

class gsp_mailinglist_mailingListTemplatesloadtemplate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListTemplates/loadtemplate.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',10,['var':("entityName"),'value':(message(code: 'mailingListTemplates.label', default: 'MailingListTemplates'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',11,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(2)
invokeTag('resources','ckeditor',12,[:],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('render','g',16,['template':("/mainmenu")],-1)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',18,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',18,['class':("create"),'action':("create")],2)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',19,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',19,['class':("list"),'action':("list")],2)
printHtmlPart(7)
invokeTag('message','g',23,['code':("default.create.label"),'args':([entityName])],-1)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(14)
expressionOut.print(error.field)
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('message','g',30,['error':(error)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',31,['bean':(mailingListTemplatesInstance),'var':("error")],3)
printHtmlPart(18)
})
invokeTag('hasErrors','g',33,['bean':(mailingListTemplatesInstance)],2)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(19)
expressionOut.print(hasErrors(bean: mailingListTemplatesInstance, field: 'name', 'error'))
printHtmlPart(20)
invokeTag('message','g',37,['code':("mailingListTemplates.name.label"),'default':("Name")],-1)
printHtmlPart(21)
invokeTag('textField','g',40,['name':("name"),'required':(""),'value':(mailingListTemplatesInstance?.name)],-1)
printHtmlPart(22)
invokeTag('render','g',43,['template':("/mailingList/addedby"),'model':([caller: 'mailingListTemplatesInstance'])],-1)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: params, field: 'content', 'error'))
printHtmlPart(24)
invokeTag('message','g',47,['code':("mailingListTemplates.label"),'default':("Template")],-1)
printHtmlPart(21)
invokeTag('select','g',61,['id':("mailingListTemplates"),'name':("mailingListTemplate"),'from':(grails.plugin.mailinglist.core.TemplatesBase.list(sort: 'name', order: 'asc')),'optionKey':("id"),'required':(""),'value':(params.mailingListTemplates),'class':("many-to-one"),'noSelection':(['': 'Please choose Template']),'onchange':(remoteFunction (
			controller: 'MailingListTemplates',
			action: 'loadMessageBox',
			params: "'id=' + this.value",
			update: 'loadMessageBox'
			))],-1)
printHtmlPart(25)
invokeTag('submitButton','g',66,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(26)
})
invokeTag('form','g',68,['action':("save")],2)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',70,[:],1)
printHtmlPart(28)
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
