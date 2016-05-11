import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingList_listing_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingList/_listing.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('sortableColumn','g',6,['property':("emailAddress"),'title':(message(code: 'mailingList.emailAddress.label', default: 'Email Address'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',7,['property':("emailDisplayName"),'title':(message(code: 'mailingList.emailDisplayName.label', default: 'Email Display Name'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',8,['property':("categories"),'title':(message(code: 'mailingList.categories.label', default: 'Category'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',9,['property':("firstName"),'title':(message(code: 'mailingList.firstName.label', default: 'First Name'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',10,['property':("lastName"),'title':(message(code: 'mailingList.lastName.label', default: 'Last Name'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',11,['property':("dateCreated"),'title':(message(code: 'mailingList.dateCreated.label', default: 'Date Created'))],-1)
printHtmlPart(2)
loop:{
int i = 0
for( mailingListInstance in (mailingListInstanceList) ) {
printHtmlPart(3)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(4)
createTagBody(2, {->
expressionOut.print(fieldValue(bean: mailingListInstance, field: "emailAddress"))
})
invokeTag('link','g',17,['action':("show"),'id':(mailingListInstance.id)],2)
printHtmlPart(5)
expressionOut.print(fieldValue(bean: mailingListInstance, field: "emailDisplayName"))
printHtmlPart(6)
invokeTag('remoteFunction','g',19,['action':("list"),'params':([id:mailingListInstance?.categories?.id, sortby:sortby, order:order, s:'c', envid:envid, viewtype:viewtype, offset:offset, max:params.max,pageSizes:pageSizes,divupdate:divupdate,total:mailingListInstanceTotal ]),'update':(divupdate)],-1)
printHtmlPart(7)
expressionOut.print(mailingListInstance?.categories?.name)
printHtmlPart(8)
expressionOut.print(fieldValue(bean: mailingListInstance, field: "firstName"))
printHtmlPart(5)
expressionOut.print(fieldValue(bean: mailingListInstance, field: "lastName"))
printHtmlPart(5)
invokeTag('display','prettytime',23,['date':(mailingListInstance.dateCreated)],-1)
printHtmlPart(9)
i++
}
}
printHtmlPart(10)
createTagBody(1, {->
invokeTag('message','g',32,['code':("default.csv.label"),'default':("CSV")],-1)
})
invokeTag('link','g',32,['class':("csv"),'controller':("MailingList"),'action':("list"),'params':([max: params?.max, s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'csv', extension:'csv' ])],1)
printHtmlPart(11)
createTagBody(1, {->
invokeTag('message','g',35,['code':("default.excel.label"),'default':("EXCEL")],-1)
})
invokeTag('link','g',35,['class':("excel"),'controller':("MailingList"),'action':("list"),'params':([max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'excel', extension:'excel' ])],1)
printHtmlPart(11)
createTagBody(1, {->
invokeTag('message','g',38,['code':("default.pdf.label"),'default':("PDF")],-1)
})
invokeTag('link','g',38,['class':("pdf"),'controller':("MailingList"),'action':("list"),'params':([max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'pdf', extension:'pdf' ])],1)
printHtmlPart(12)
createTagBody(1, {->
invokeTag('message','g',41,['code':("default.rtf.label"),'default':("RTF")],-1)
})
invokeTag('link','g',41,['class':("rtf"),'controller':("MailingList"),'action':("list"),'params':([max: params?.max, s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'rtf', extension:'rtf' ])],1)
printHtmlPart(11)
createTagBody(1, {->
invokeTag('message','g',44,['code':("default.xml.label"),'default':("XML")],-1)
})
invokeTag('link','g',44,['class':("xml"),'controller':("MailingList"),'action':("list"),'params':([max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'xml', extension:'xml' ])],1)
printHtmlPart(13)
invokeTag('remotePaginate','util',49,['controller':("MailingList"),'action':("list"),'params':([max: params?.max,  pageSizes:pageSizes, sortby:sortby, offset:offset]),'total':(mailingListInstanceTotal),'update':(divupdate),'max':(params?.max),'pageSizes':([10:'10 Per Page', 20: '20 Per Page', 50:'50 Per Page',100:'100 Per Page',250:'250 Per Page',500:'500 Per Page',1000:'1000 Per Page', 5000:'5000 Per Page', 10000:'10000 Per Page', 100000:'100000 Per Page'])],-1)
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
