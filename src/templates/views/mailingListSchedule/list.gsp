
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mailingListSchedule.label', default: 'MailingListSchedule')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-mailingListSchedule" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default=""/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-mailingListSchedule" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="addedby" title="${message(code: 'mailingListSchedule.addedby.label', default: 'Addedby')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'mailingListSchedule.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="dateTime" title="${message(code: 'mailingListSchedule.dateTime.label', default: 'Date Time')}" />
					
						<g:sortableColumn property="deploymentComplete" title="${message(code: 'mailingListSchedule.deploymentComplete.label', default: 'Deployment Complete')}" />
					
						<g:sortableColumn property="emailMessage" title="${message(code: 'mailingListSchedule.emailMessage.label', default: 'Email Message')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'mailingListSchedule.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${mailingListScheduleInstanceList}" status="i" var="mailingListScheduleInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${mailingListScheduleInstance.id}">${fieldValue(bean: mailingListScheduleInstance, field: "addedby")}</g:link></td>
					
						<td><g:formatDate date="${mailingListScheduleInstance.dateCreated}" /></td>
					
						<td>${fieldValue(bean: mailingListScheduleInstance, field: "dateTime")}</td>
					
						<td><g:formatBoolean boolean="${mailingListScheduleInstance.deploymentComplete}" /></td>
					
						<td>${fieldValue(bean: mailingListScheduleInstance, field: "emailMessage")}</td>
					
						<td><g:formatDate date="${mailingListScheduleInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mailingListScheduleInstanceTotal}" />
			</div>
				<export:formats />
		</div>
	</body>
</html>
