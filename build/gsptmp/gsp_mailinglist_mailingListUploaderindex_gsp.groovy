import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListUploaderindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListUploader/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'mailingListTemplates.label', default: 'MailingListTemplates'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('render','g',11,['template':("/mainmenu")],-1)
printHtmlPart(5)
invokeTag('message','g',15,['code':("default.create.label"),'args':([entityName])],-1)
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('message','g',21,['code':("default.category.name.upload.label"),'default':("Define category name, browse and Upload A CSV file")],-1)
printHtmlPart(10)
invokeTag('message','g',23,['code':("default.upload.methods.label"),'default':("You can upload two types of CSV files which are your exported outlook contact lists.")],-1)
printHtmlPart(11)
invokeTag('message','g',24,['code':("default.two.field.csv.label"),'default':("1: 2 field CSV file")],-1)
printHtmlPart(12)
invokeTag('message','g',25,['code':("default.two.field.csv.fields.label"),'default':("E-mail Display Name,E-mail Address")],-1)
printHtmlPart(13)
invokeTag('message','g',26,['code':("default.two.field.csv.fields.details.label"),'default':("The fields must be in the above format and the first line must be a heading since it ignores the first line of the CSV file")],-1)
printHtmlPart(14)
invokeTag('message','g',29,['code':("default.seven.field.csv.label"),'default':("2: 7 field CSV file")],-1)
printHtmlPart(12)
invokeTag('message','g',30,['code':("default.seven.field.csv.fields.label"),'default':("'Title','First Name','Middle Name','Last Name','Categories','E-mail Address','E-mail Display Name'")],-1)
printHtmlPart(15)
invokeTag('message','g',32,['code':("default.seven.field.csv.fields.details.label"),'default':("The fields must be in the above format and the first line must be a heading since it ignores the first line of the csv file")],-1)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
expressionOut.print(hasErrors(bean: params, field: 'catname', 'error'))
printHtmlPart(18)
invokeTag('message','g',38,['code':("manager.label"),'default':("Mailing List Name")],-1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: params, field: 'file', 'error'))
printHtmlPart(20)
invokeTag('message','g',44,['code':("manager.label"),'default':("Choose File")],-1)
printHtmlPart(21)
invokeTag('submitButton','g',48,['name':("upload"),'value':("Upload")],-1)
printHtmlPart(22)
})
invokeTag('uploadForm','g',49,['action':("upload")],2)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',51,[:],1)
printHtmlPart(24)
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
