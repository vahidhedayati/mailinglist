import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListlist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingList/list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',3,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',4,['var':("entityName"),'value':(message(code: 'mailingList.label', default: 'MailingList'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',5,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('render','g',9,['template':("/mainmenu")],-1)
printHtmlPart(4)
createTagBody(2, {->
invokeTag('message','g',11,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',11,['class':("create"),'action':("create")],2)
printHtmlPart(5)
createTagBody(2, {->
invokeTag('message','g',12,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',12,['class':("list"),'action':("list")],2)
printHtmlPart(6)
invokeTag('message','g',17,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('message','g',23,['code':("default.search.label"),'default':("Search")],-1)
printHtmlPart(11)
invokeTag('remoteField','g',24,['name':("mq"),'id':("searchform"),'update':("emailSearch"),'paramName':("mq"),'url':([controller:'MailingList', action:'search'])],-1)
printHtmlPart(12)
invokeTag('select','g',28,['class':("top_form1"),'name':("sortby"),'from':(['lastUpdated', 'firstName','lastName','dateCreated','categories','emailDisplayName','emailAddress','addedby']),'value':(sortby),'onchange':(remoteFunction(action:'list', params:'\'id='+inputid+'\'+\'&envid='+envid+'\'+\'&sortby=\' + escape(this.value) +\'&s='+s+'\'+\'&pageSizes='+pageSizes+'\'+\'&max='+params?.max+'\'+\'&offset='+offset+'\'+\'&order='+order+'\'+\'&viewtype=na\'',update : divupdate))],-1)
printHtmlPart(13)
invokeTag('select','g',29,['class':("top_form1"),'name':("order"),'from':(['asc', 'desc']),'value':(order),'onchange':(remoteFunction(action:'list', params:'\'id='+inputid+'\'+\'&order=\' + escape(this.value) +\'&s='+s+'\'+\'&pageSizes='+pageSizes+'\'+\'&max='+params?.max+'\'+\'&envid='+envid+'\'+\'&offset='+offset+'\'+\'&sortby='+sortby+'\'+\'&viewtype=na\'',update : divupdate))],-1)
printHtmlPart(14)
invokeTag('select','g',30,['class':("top_form1"),'name':("s"),'from':(allcat),'optionKey':("id"),'optionValue':("name"),'value':(s),'onchange':(remoteFunction(action:'list', params:'\'id=\' + escape(this.value) +\'&s=c&order='+order+'\'+\'&pageSizes='+pageSizes+'\'+\'&max='+params?.max+'\'+\'&envid='+envid+'\'+\'&offset='+offset+'\'+\'&sortby='+sortby+'\'+\'&viewtype=na\'',update : divupdate))],-1)
printHtmlPart(15)
invokeTag('render','g',38,['template':("listing"),'model':([params:params, mailingListInstanceList: mailingListInstanceList])],-1)
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',41,[:],1)
printHtmlPart(17)
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
