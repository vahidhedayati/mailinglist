<%@ page import="kportal.MailingList" %>
<!DOCTYPE html>
<html>

	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mailingList.label', default: 'MailingList')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
	
		<a href="#list-mailingList" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default=""/></a>
		<div id="nav3" class="nav3" role="navigation">
			<ul id="nav">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><a class="home" href="${createLink(uri: '/admin/welcome#mailinglist')}">Schedule Announcement</a></li>		
			</ul>
		</div>
		
		<div id="list-mailingList" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<div class=heading1>
				 Search: <g:remoteField name="mq"  id="searchform"  update="emailSearch" paramName="mq" url="[controller:'MailingList', action:'search']"></g:remoteField>
			</div>
		
		<div class="clearall"></div>
		<div id="emailSearch" class="emailSearch">
		</div>
		<div id="searchResults"></div>
		<div id="returnPanel">
		</div>

				<g:render template="listing" model="[params:params, mailingListInstanceList: mailingListInstanceList]"></g:render>
	
		</div>

			
					<div class="pagination">                           
 <util:remotePaginate controller="MailingList" action="list" params="[max: max,  pageSizes:pageSizes, sortby:sortby, offset:offset,  envid:envid, viewtype: 'na']" total="${mailingListInstanceTotal}"
                                   update="siteContent"   max="${params.max}" pageSizes="[10:'10 Per Page', 20: '20 Per Page', 50:'50 Per Page',100:'100 Per Page',250:'250 Per Page',500:'500 Per Page',1000:'1000 Per Page']" /> 
</div>

		
			<export:formats />
		
		

	</body>
</html>
