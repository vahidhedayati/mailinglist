import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListTemplateslist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListTemplates/list.gsp" }
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
invokeTag('message','g',6,['code':("default.list.label"),'args':([entityName])],-1)
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
invokeTag('message','g',17,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('sortableColumn','g',24,['property':("name"),'title':(message(code: 'mailingListTemplates.name.label', default: 'Name'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',25,['property':("addedby"),'title':(message(code: 'mailingListTemplates.addedby.label', default: 'Addedby'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',27,['property':("dateCreated"),'title':(message(code: 'mailingListTemplates.dateCreated.label', default: 'Date Created'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',28,['property':("lastUpdated"),'title':(message(code: 'mailingListTemplates.lastUpdated.label', default: 'Last Updated'))],-1)
printHtmlPart(13)

def currentsize=mailingListTemplatesInstanceList?.size()

printHtmlPart(14)

def mtl

printHtmlPart(14)
if(true && (currentsize>1)) {
printHtmlPart(14)

mtl =mailingListTemplatesInstanceList?.sort{a,b-> a.name.compareTo(b.name)}

printHtmlPart(14)
}
else {
printHtmlPart(15)

mtl=mailingListTemplatesInstanceList

printHtmlPart(14)
}
printHtmlPart(16)
loop:{
int i = 0
for( mailingListTemplatesInstance in (mtl) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: mailingListTemplatesInstance, field: "name"))
})
invokeTag('link','g',46,['action':("show"),'id':(mailingListTemplatesInstance.id)],3)
printHtmlPart(19)
expressionOut.print(fieldValue(bean: mailingListTemplatesInstance, field: "addedby"))
printHtmlPart(20)
invokeTag('formatDate','g',49,['date':(mailingListTemplatesInstance.dateCreated)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',50,['date':(mailingListTemplatesInstance.lastUpdated)],-1)
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',56,['total':(mailingListTemplatesInstanceTotal)],-1)
printHtmlPart(23)
createTagBody(2, {->
invokeTag('message','g',60,['code':("default.csv.label"),'default':("CSV")],-1)
})
invokeTag('link','g',60,['class':("csv"),'controller':("MailingListTemplates"),'action':("list"),'params':([max: params?.max, s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'csv', extension:'csv' ])],2)
printHtmlPart(24)
createTagBody(2, {->
invokeTag('message','g',63,['code':("default.excel.label"),'default':("EXCEL")],-1)
})
invokeTag('link','g',63,['class':("excel"),'controller':("MailingListTemplates"),'action':("list"),'params':([max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'excel', extension:'excel' ])],2)
printHtmlPart(24)
createTagBody(2, {->
invokeTag('message','g',66,['code':("default.pdf.label"),'default':("PDF")],-1)
})
invokeTag('link','g',66,['class':("pdf"),'controller':("MailingListTemplates"),'action':("list"),'params':([max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'pdf', extension:'pdf' ])],2)
printHtmlPart(25)
createTagBody(2, {->
invokeTag('message','g',69,['code':("default.rtf.label"),'default':("RTF")],-1)
})
invokeTag('link','g',69,['class':("rtf"),'controller':("MailingListTemplates"),'action':("list"),'params':([max: params?.max, s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'rtf', extension:'rtf' ])],2)
printHtmlPart(24)
createTagBody(2, {->
invokeTag('message','g',72,['code':("default.xml.label"),'default':("XML")],-1)
})
invokeTag('link','g',72,['class':("xml"),'controller':("MailingListTemplates"),'action':("list"),'params':([max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'xml', extension:'xml' ])],2)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',76,[:],1)
printHtmlPart(27)
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
