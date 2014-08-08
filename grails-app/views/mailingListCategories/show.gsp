<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mailingList.css')}" type="text/css">
		<g:set var="entityName" value="${message(code: 'mailingListCat.label', default: 'MailingListCategories')}" />
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
	
		<div id="show-mailingListCat" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list mailingListCat">
				<g:if test="${mailingListCatInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="mailingListCat.name.label" default="Name" /></span>
					<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${mailingListCatInstance}" field="name"/></span>
				</li>
				</g:if>
				<g:if test="${mailingListCatInstance?.addedby}">
				<li class="fieldcontain">
					<span id="addedby-label" class="property-label"><g:message code="mailingListCat.addedby.label" default="Addedby" /></span>
					<span class="property-value" aria-labelledby="addedby-label"><g:fieldValue bean="${mailingListCatInstance}" field="addedby"/></span>
				</li>
				</g:if>
				<g:if test="${mailingListCatInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="mailingListCat.dateCreated.label" default="Date Created" /></span>
					<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${mailingListCatInstance?.dateCreated}" /></span>
				</li>
				</g:if>
				<g:if test="${mailingListCatInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="mailingListCat.lastUpdated.label" default="Last Updated" /></span>
					<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${mailingListCatInstance?.lastUpdated}" /></span>
				</li>
				</g:if>
				<g:if test="${mailingListCatInstance?.mailinglist}">
				<li class="fieldcontain">
					<span id="mailinglist-label" class="property-label"><g:message code="mailingListCat.mailinglist.label" default="Mailinglist" /></span>
						<g:each in="${mailingListCatInstance.mailinglist}" var="m">
							<span class="property-value" aria-labelledby="mailinglist-label"><g:link controller="mailingList" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
				</li>
				</g:if>
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${mailingListCatInstance?.id}" />
					<g:link class="edit" action="edit" id="${mailingListCatInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
