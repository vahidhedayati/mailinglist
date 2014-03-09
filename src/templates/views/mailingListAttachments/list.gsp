<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
			<link rel="stylesheet" href="${resource(dir: 'css', file: 'mailingList.css')}" type="text/css">
		<g:set var="entityName" value="${message(code: 'mailingListAttachments.label', default: 'MailingListAttachments')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-mailingListAttachments" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default=""/></a>
		<g:render template="/mailingList/mainmenu" />
		<div id="nav3" class="nav3" role="navigation">
			<ul id="nav">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>

		<div id="list-mailingListAttachments" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<h3>Files are uploaded directly to DB and presented in binary format, in order to simplify the show option will attempt to directly download uploaded file.</h3>
			<h2><b>Once uploaded, if there are issues DELETE and RE-CREATE</b></h2>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="fullname" title="${message(code: 'mailingListAttachments.fullname.label', default: 'Fullname')}" />
						<g:sortableColumn property="size" title="${message(code: 'mailingListAttachments.size.label', default: 'size')}" />
						
						<g:sortableColumn property="name" title="${message(code: 'mailingListAttachments.name.label', default: 'Name')}" />

						<g:sortableColumn property="contentType" title="${message(code: 'mailingListAttachments.contentType.label', default: 'contentType')}" />
						
						<g:sortableColumn property="addedby" title="${message(code: 'mailingListAttachments.addedby.label', default: 'Addedby')}" />
					
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'mailingListAttachments.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'mailingListAttachments.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${mailingListAttachmentsInstanceList}" status="i" var="mailingListAttachmentsInstance">
				<% def cc="" %>
				<g:if test="${mailingListAttachmentsInstance.attachment.size()>0 }" >
				<% cc="${(i % 2) == 0 ? 'even' : 'odd'}" %>
					
				</g:if>	
				<g:else>
				<% cc="red" %>
				</g:else>
				<tr class="${cc}">
						<td><g:link action="show" id="${mailingListAttachmentsInstance.id}">${fieldValue(bean: mailingListAttachmentsInstance, field: "fullname")}
						</g:link> | <g:link action="del" id="${mailingListAttachmentsInstance.id}">Delete</g:link>
						| <g:link action="download" id="${mailingListAttachmentsInstance.id}">Download</g:link>
						</td>
						<td>${mailingListAttachmentsInstance.attachment.size() }</td>
						
						<td>${fieldValue(bean: mailingListAttachmentsInstance, field: "name")}</td>
							<td>${fieldValue(bean: mailingListAttachmentsInstance, field: "contentType")}</td>
						
						<td>${fieldValue(bean: mailingListAttachmentsInstance, field: "addedby")}</td>
					
					
						<td><prettytime:display date="${mailingListAttachmentsInstance.dateCreated}" /></td>
					
						<td><prettytime:display date="${mailingListAttachmentsInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mailingListAttachmentsInstanceTotal}" />
			</div>
			
			</div>

	</body>
</html>
