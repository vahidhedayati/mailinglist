
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mailingListTemplates.label', default: 'MailingListTemplates')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-mailingListTemplates" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default=""/></a>
		<div id="nav3" class="nav3" role="navigation">
			<ul id="nav">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				</ul>
		</div>

		<div id="list-mailingListTemplates" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'mailingListTemplates.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="addedby" title="${message(code: 'mailingListTemplates.addedby.label', default: 'Addedby')}" />
					
						<g:sortableColumn property="content" title="${message(code: 'mailingListTemplates.content.label', default: 'Content')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'mailingListTemplates.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'mailingListTemplates.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${mailingListTemplatesInstanceList}" status="i" var="mailingListTemplatesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${mailingListTemplatesInstance.id}">${fieldValue(bean: mailingListTemplatesInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: mailingListTemplatesInstance, field: "addedby")}</td>
					
						<td>${fieldValue(bean: mailingListTemplatesInstance, field: "content")}</td>
					
						<td><g:formatDate date="${mailingListTemplatesInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${mailingListTemplatesInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mailingListTemplatesInstanceTotal}" />
			</div>
				<export:formats />
		</div>

	</body>
</html>
