<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="mailingListMini">
		<g:set var="entityName" value="${message(code: 'mailingListSenders.label', default: 'MailingListSenders')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
			<div class="envtabs  navbar">
		<g:render template="/mainmenu"  />
		 <ul class="nav-pills pull-right">
				<li class="btn btn-default"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li class="btn btn-default"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
		</ul>
	</div>	
		<div id="list-mailingListSenders" class="content scaffold-list" role="mailingListMini">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="addedby" title="${message(code: 'mailingListSenders.addedby.label', default: 'Addedby')}" />
						<g:sortableColumn property="emailAddress" title="${message(code: 'mailingListSenders.emailAddress.label', default: 'Email Address')}" />
						<g:sortableColumn property="dateCreated" title="${message(code: 'mailingListSenders.dateCreated.label', default: 'Date Created')}" />
						<g:sortableColumn property="lastUpdated" title="${message(code: 'mailingListSenders.lastUpdated.label', default: 'Last Updated')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${mailingListSendersInstanceList}" status="i" var="mailingListSendersInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${mailingListSendersInstance.id}">${fieldValue(bean: mailingListSendersInstance, field: "addedby")}</g:link></td>
						<td>${fieldValue(bean: mailingListSendersInstance, field: "emailAddress")}</td>
						<td><g:formatDate date="${mailingListSendersInstance.dateCreated}" /></td>
						<td><g:formatDate date="${mailingListSendersInstance.lastUpdated}" /></td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mailingListSendersInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
