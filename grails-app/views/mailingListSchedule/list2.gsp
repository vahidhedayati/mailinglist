<%@ page import="grails.plugin.mailinglist.core.CategoryBase" %>
<%@ page import="grails.plugin.mailinglist.core.SendersBase" %>
<%@ page import="grails.plugin.mailinglist.core.ScheduleBase" %>
<%@ page import="grails.plugin.mailinglist.core.TemplatesBase" %>
<%@ page import="grails.plugin.mailinglist.core.MailingListBase" %>

<html>
	<head>
		<g:if test="${!request.xhr }">
    		<meta name='layout' content="main"/>
    	</g:if>
		<g:else>
			<meta name='layout' content="mailingListMini"/>
		</g:else>
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mailingList.css')}" type="text/css">
		
    	<g:set var="entityName" value="${message(code: 'MailingListSchedule.label', default: 'MailingList Schedule')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body >
	<div id="siteContent">
		<g:render template="/mailingList/mainmenu" /> 
	        <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div id="clock" data-time="${now.time}">
                <h3>Current Time: ${now}</h3>
            </div>    
<div class="clearall"></div>
		<div class=header>
			<div class=heading1>
				<g:message code="default.list.label" args="[entityName]" />
			</div>
			                
		<div class="clearall"></div>
		
  			<ul class="tab_opt">
  				<li><g:select   class="top_form1"  name="sortby" from="${['lastUpdated', 'mailFrom','recipientToGroup','recipientToList','recipientBCCList','recipientCCList','subject','mailingListTemplate','dateTime','setDate','setTime','addedby']}"   value="${sortby}" onchange="${remoteFunction(action:'br', params:'\'id='+inputid+'\'+\'&envid='+envid+'\'+\'&sortby=\' + escape(this.value) +\'&s='+s+'\'+\'&pageSizes='+pageSizes+'\'+\'&max='+params.max+'\'+\'&offset='+offset+'\'+\'&order='+order+'\'+\'&viewtype=na\'',update : 'siteContent')}"/> </li>
				
				<li><g:select   class="top_form1" name="order" from="${['asc', 'desc']}"  value="${order}" onchange="${remoteFunction(action:'br', params:'\'id='+inputid+'\'+\'&order=\' + escape(this.value) +\'&s='+s+'\'+\'&pageSizes='+pageSizes+'\'+\'&max='+params.max+'\'+\'&envid='+envid+'\'+\'&offset='+offset+'\'+\'&sortby='+sortby+'\'+\'&viewtype=na\'',update : 'siteContent')}"/></li>
				<li><g:select   class="top_form1" name="s" from="${['oa':'Outstanding Schedule', 'od': 'Schedule Completed', 'oc': 'Schedule Cancelled']}"  optionKey="key" optionValue="value" value="${s}" onchange="${remoteFunction(action:'br', params:'\'id='+inputid+'\'+\'&s=\' + escape(this.value) +\'&order='+order+'\'+\'&pageSizes='+pageSizes+'\'+\'&max='+params.max+'\'+\'&envid='+envid+'\'+\'&offset='+offset+'\'+\'&sortby='+sortby+'\'+\'&viewtype=na\'',update : 'siteContent')}"/></li>
			</ul>
		</div>
		<div class=clearall></div>
		
		Current Action : ${s }<br/>
   			<g:render template="list1-top" model="[id:inputid, sortby:sortby, order:order, s:s, envid:envid, viewtype:viewtype, pageSizes:pageSizes, offset:offset, max:params.max, divupdate:divupdate,approvers:approvers]"></g:render>
			<div class="pagination">                           
 				<util:remotePaginate controller="MailingListSchedule" action="br" params="[max: max, id:inputid, s:s, order:order, pageSizes:pageSizes, sortby:sortby, offset:offset,  envid:envid, viewtype: 'na']" total="${deploymentInfoHistoryInstanceTotal}"
                                  update="siteContent"   max="${params.max}" pageSizes="[10:'10 Per Page', 20: '20 Per Page', 50:'50 Per Page',100:'100 Per Page',250:'250 Per Page',500:'500 Per Page',1000:'1000 Per Page']" /> 
	</div>
	<export:formats />
        	
    </div>
	</body>
</html>