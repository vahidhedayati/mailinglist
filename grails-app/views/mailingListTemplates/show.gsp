<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mailingListTemplates.label', default: 'MailingListTemplates')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
			<div class="envtabs  navbar">
		<g:render template="/mainmenu"  />
		 <ul class="nav-pills pull-right">
				<li class="btn btn-default"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li class="btn btn-default"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
		</ul>
	</div>	

		<div id="show-mailingListTemplates" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list mailingListTemplates">
			
				<g:if test="${mailingListTemplatesInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="mailingListTemplates.name.label" default="Name" /></span>
					<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${mailingListTemplatesInstance}" field="name"/></span>
				</li>
				</g:if>
			
				<g:if test="${mailingListTemplatesInstance?.addedby}">
				<li class="fieldcontain">
					<span id="addedby-label" class="property-label"><g:message code="mailingListTemplates.addedby.label" default="Addedby" /></span>
					<span class="property-value" aria-labelledby="addedby-label"><g:fieldValue bean="${mailingListTemplatesInstance}" field="addedby"/></span>
				</li>
				</g:if>
			
				<g:if test="${mailingListTemplatesInstance?.content}">
				<li class="fieldcontain">
					<span id="content-label" class="property-label"><g:message code="mailingListTemplates.content.label" default="Content" /></span>
					<span class="property-value" aria-labelledby="content-label">
					
					${mailingListTemplatesInstance?.content.encodeAsRaw() }
					
					</span>
				</li>
				</g:if>
			
				<g:if test="${mailingListTemplatesInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="mailingListTemplates.dateCreated.label" default="Date Created" /></span>
					<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${mailingListTemplatesInstance?.dateCreated}" /></span>
				</li>
				</g:if>
			
				<g:if test="${mailingListTemplatesInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="mailingListTemplates.lastUpdated.label" default="Last Updated" /></span>
					<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${mailingListTemplatesInstance?.lastUpdated}" /></span>
				</li>
				</g:if>
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${mailingListTemplatesInstance?.id}" />
					<g:link class="edit" action="edit" id="${mailingListTemplatesInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
