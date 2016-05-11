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

class gsp_mailinglist_mailingListSchedulelist2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListSchedule/list2.gsp" }
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
if(true && (!request.xhr)) {
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(5)
if(true && (enduser?.verifyAppVersion().equals('resources'))) {
printHtmlPart(6)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("mailingListMini")],-1)
printHtmlPart(5)
}
else {
printHtmlPart(6)
invokeTag('captureMeta','sitemesh',17,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("mailingListMiniAssets")],-1)
printHtmlPart(5)
}
printHtmlPart(2)
}
printHtmlPart(7)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',21,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',21,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',21,[:],2)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',22,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
invokeTag('render','g',27,['template':("/mainmenu")],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
expressionOut.print(now.time)
printHtmlPart(14)
expressionOut.print(now)
printHtmlPart(15)
invokeTag('message','g',39,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(16)
invokeTag('select','g',45,['class':("top_form1"),'name':("sortby"),'from':(['lastUpdated', 'mailFrom','recipientToGroup','recipientToList','recipientBCCList','recipientCCList','subject','mailingListTemplate','dateTime','setDate','setTime','addedby']),'value':(sortby),'onchange':(remoteFunction(action:'br', params:'\'id='+inputid+'\'+\'&envid='+envid+'\'+\'&sortby=\' + escape(this.value) +\'&s='+s+'\'+\'&pageSizes='+pageSizes+'\'+\'&max='+params.max+'\'+\'&offset='+offset+'\'+\'&order='+order+'\'+\'&viewtype=na\'',update : 'MailingListScheduleContent'))],-1)
printHtmlPart(17)
invokeTag('select','g',50,['class':("top_form1"),'name':("order"),'from':(['asc', 'desc']),'value':(order),'onchange':(remoteFunction(action:'br', params:'\'id='+inputid+'\'+\'&order=\' + escape(this.value) +\'&s='+s+'\'+\'&pageSizes='+pageSizes+'\'+\'&max='+params.max+'\'+\'&envid='+envid+'\'+\'&offset='+offset+'\'+\'&sortby='+sortby+'\'+\'&viewtype=na\'',update : 'MailingListScheduleContent'))],-1)
printHtmlPart(18)
invokeTag('select','g',54,['class':("top_form1"),'name':("s"),'from':(['all': 'All Schedules', 'oa':'Outstanding Schedule', 'od': 'Schedule Completed', 'oc': 'Schedule Cancelled']),'optionKey':("key"),'optionValue':("value"),'value':(s),'onchange':(remoteFunction(action:'br', params:'\'s=\' + escape(this.value) +\'&order='+order+'\'+\'&pageSizes='+pageSizes+'\'+\'&max='+params.max+'\'+\'&envid='+envid+'\'+\'&offset='+offset+'\'+\'&sortby='+sortby+'\'+\'&viewtype=na\'',update : 'MailingListScheduleContent'))],-1)
printHtmlPart(19)
expressionOut.print(s)
printHtmlPart(20)
invokeTag('render','g',60,['template':("list1-top")],-1)
printHtmlPart(21)
invokeTag('remotePaginate','util',67,['controller':("MailingListSchedule"),'action':("br"),'params':([max: max, id:inputid, s:s, order:order, pageSizes:pageSizes, sortby:sortby, offset:offset, viewtype: 'na']),'total':(total),'update':("MailingListScheduleContent"),'max':(params.max),'pageSizes':([10:'10 Per Page', 20: '20 Per Page', 50:'50 Per Page',100:'100 Per Page',250:'250 Per Page',500:'500 Per Page',1000:'1000 Per Page'])],-1)
printHtmlPart(22)
createTagBody(2, {->
invokeTag('message','g',73,['code':("default.csv.label"),'default':("CSV")],-1)
})
invokeTag('link','g',73,['class':("csv"),'controller':("MailingListSchedule"),'action':("list"),'params':([max: params?.max, s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'csv', extension:'csv' ])],2)
printHtmlPart(23)
createTagBody(2, {->
invokeTag('message','g',77,['code':("default.excel.label"),'default':("EXCEL")],-1)
})
invokeTag('link','g',77,['class':("excel"),'controller':("MailingListSchedule"),'action':("list"),'params':([max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'excel', extension:'excel' ])],2)
printHtmlPart(23)
createTagBody(2, {->
invokeTag('message','g',81,['code':("default.pdf.label"),'default':("PDF")],-1)
})
invokeTag('link','g',81,['class':("pdf"),'controller':("MailingListSchedule"),'action':("list"),'params':([max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'pdf', extension:'pdf' ])],2)
printHtmlPart(24)
createTagBody(2, {->
invokeTag('message','g',85,['code':("default.rtf.label"),'default':("RTF")],-1)
})
invokeTag('link','g',85,['class':("rtf"),'controller':("MailingListSchedule"),'action':("list"),'params':([max: params?.max, s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'rtf', extension:'rtf' ])],2)
printHtmlPart(23)
createTagBody(2, {->
invokeTag('message','g',89,['code':("default.xml.label"),'default':("XML")],-1)
})
invokeTag('link','g',89,['class':("xml"),'controller':("MailingListSchedule"),'action':("list"),'params':([max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'xml', extension:'xml' ])],2)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',95,[:],1)
printHtmlPart(26)
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
