
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="mailingListMini">
		<g:set var="entityName" value="${message(code: 'mailingList.label', default: 'MailingList')}" />
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
	
		<div id="show-mailingList" class="content scaffold-show" role="mailingListMini">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list mailingList">
				<g:if test="${mailingListInstance?.addedby}">
				<li class="fieldcontain">
					<span id="addedby-label" class="property-label"><g:message code="mailingList.addedby.label" default="Addedby" /></span>
					<span class="property-value" aria-labelledby="addedby-label"><g:fieldValue bean="${mailingListInstance}" field="addedby"/></span>
				</li>
				</g:if>
				<g:if test="${mailingListInstance?.emailAddress}">
				<li class="fieldcontain">
					<span id="emailAddress-label" class="property-label"><g:message code="mailingList.emailAddress.label" default="Email Address" /></span>
					<span class="property-value" aria-labelledby="emailAddress-label"><g:fieldValue bean="${mailingListInstance}" field="emailAddress"/></span>
				</li>
				</g:if>
				<g:if test="${mailingListInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="mailingList.dateCreated.label" default="Date Created" /></span>
					<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${mailingListInstance?.dateCreated}" /></span>
				</li>
				</g:if>
				<g:if test="${mailingListInstance?.emailDisplayName}">
				<li class="fieldcontain">
					<span id="emailDisplayName-label" class="property-label"><g:message code="mailingList.emailDisplayName.label" default="Email Display Name" /></span>
					<span class="property-value" aria-labelledby="emailDisplayName-label"><g:fieldValue bean="${mailingListInstance}" field="emailDisplayName"/></span>
				</li>
				</g:if>
				<g:if test="${mailingListInstance?.firstName}">
				<li class="fieldcontain">
					<span id="firstName-label" class="property-label"><g:message code="mailingList.firstName.label" default="First Name" /></span>
					<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${mailingListInstance}" field="firstName"/></span>
				</li>
				</g:if>
				<g:if test="${mailingListInstance?.lastName}">
				<li class="fieldcontain">
					<span id="lastName-label" class="property-label"><g:message code="mailingList.lastName.label" default="Last Name" /></span>
					<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${mailingListInstance}" field="lastName"/></span>
				</li>
				</g:if>
				<g:if test="${mailingListInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="mailingList.lastUpdated.label" default="Last Updated" /></span>
					<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${mailingListInstance?.lastUpdated}" /></span>
				</li>
				</g:if>
				<g:if test="${mailingListInstance?.middleName}">
				<li class="fieldcontain">
					<span id="middleName-label" class="property-label"><g:message code="mailingList.middleName.label" default="Middle Name" /></span>
					<span class="property-value" aria-labelledby="middleName-label"><g:fieldValue bean="${mailingListInstance}" field="middleName"/></span>
				</li>
				</g:if>
				<g:if test="${mailingListInstance?.categories}">
				<li class="fieldcontain">
					<span id="categories-label" class="property-label"><g:message code="mailingList.categories.label" default="categories" /></span>
					<span class="property-value" aria-labelledby="categories-label"><g:link controller="mailingListCategories" action="show" id="${mailingListInstance?.categories?.id}">${mailingListInstance?.categories?.encodeAsHTML()}</g:link></span>
				</li>
				</g:if>
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${mailingListInstance?.id}" />
					<g:link class="edit" action="edit" id="${mailingListInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>

	</body>
</html>
