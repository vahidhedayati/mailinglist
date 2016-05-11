import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_mailinglist_mailingListUploader_mailerUploaderForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailingListUploader/_mailerUploaderForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
invokeTag('modalForm','md',42,['id':("ModalDynamixIFRAMEUPLOADS"),'formId':("MyCSVForm"),'title':("Upload CSV"),'divId':("mailerUploader"),'returnController':("mailingListUploader"),'modalTemplatePage':("/mailingListUploader/formuploader"),'submitController':("mailingListUploader"),'submitAction':("save"),'submitValue':("Upload Attachment"),'modalTemplate':("/modaldynamix/modaliframe"),'domain':("grails.plugin.mailinglist.core.CategoryBase"),'height':("40em"),'width':("50em"),'bodyheight':("40em"),'bodywidth':("98%"),'overflow':("hidden"),'position':("fixed"),'top':("0"),'margintop':("10em"),'marginright':("auto"),'left':("auto"),'right':("auto"),'iframescrolling':("auto"),'iframetransparency':("true"),'iframezoom':("1"),'iframewidth':("100%"),'iframeheight':("100%"),'iframemargin':("0"),'iframepadding':("0")],-1)
printHtmlPart(0)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1463000575000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
