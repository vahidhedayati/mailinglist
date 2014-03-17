
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
			<link rel="stylesheet" href="${resource(dir: 'css', file: 'mailingList.css')}" type="text/css">
		<g:set var="entityName" value="${message(code: 'mailingListCat.label', default: 'MailingListCategories')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-mailingListCat" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default=""/></a>
		<g:render template="/mailingList/mainmenu" />
		<div id="nav3" class="nav3" role="navigation">
			<ul id="nav">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>

		<div id="list-mailingListCat" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'mailingListCat.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="addedby" title="${message(code: 'mailingListCat.addedby.label', default: 'Addedby')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'mailingListCat.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'mailingListCat.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${mailingListCatInstanceList}" status="i" var="mailingListCatInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${mailingListCatInstance.id}">${fieldValue(bean: mailingListCatInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: mailingListCatInstance, field: "addedby")}</td>
					
						<td><g:formatDate date="${mailingListCatInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${mailingListCatInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mailingListCatInstanceTotal}" />
			</div>
		</div>

	</body>
</html>
