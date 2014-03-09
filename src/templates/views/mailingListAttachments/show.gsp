<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mailingListAttachments.label', default: 'MailingListAttachments')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-mailingListAttachments" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default=""/></a>
			<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>

		<div id="show-mailingListAttachments" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list mailingListAttachments">
			
				<g:if test="${mailingListAttachmentsInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="mailingListAttachments.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${mailingListAttachmentsInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mailingListAttachmentsInstance?.attachment}">
				<li class="fieldcontain">
					<span id="attachment-label" class="property-label"><g:message code="mailingListAttachments.attachment.label" default="Attachment size" /></span>
					<span class="property-value" aria-labelledby="attachment-label">
					${mailingListAttachmentsInstance?.attachment.size()}
					</span>
				</li>
				</g:if>
				<g:else>
					<div class="red">WARNING 0 BYTE OR NO ATTACHED FILE</div>
				</g:else>
				<g:if test="${mailingListAttachmentsInstance?.addedby}">
				<li class="fieldcontain">
					<span id="addedby-label" class="property-label"><g:message code="mailingListAttachments.addedby.label" default="Addedby" /></span>
					
						<span class="property-value" aria-labelledby="addedby-label"><g:fieldValue bean="${mailingListAttachmentsInstance}" field="addedby"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${mailingListAttachmentsInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="mailingListAttachments.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${mailingListAttachmentsInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${mailingListAttachmentsInstance?.fullname}">
				<li class="fieldcontain">
					<span id="fullname-label" class="property-label"><g:message code="mailingListAttachments.fullname.label" default="Fullname" /></span>
					
						<span class="property-value" aria-labelledby="fullname-label"><g:fieldValue bean="${mailingListAttachmentsInstance}" field="fullname"/></span>
					
				</li>
				</g:if>
			
			
					<g:if test="${mailingListAttachmentsInstance?.contentType}">
				<li class="fieldcontain">
					<span id="contentType-label" class="property-label"><g:message code="mailingListAttachments.contentType.label" default="contentType" /></span>
					
						<span class="property-value" aria-labelledby="contentType-label"><g:fieldValue bean="${mailingListAttachmentsInstance}" field="contentType"/></span>
					
				</li>
				</g:if>
				<g:if test="${mailingListAttachmentsInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="mailingListAttachments.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${mailingListAttachmentsInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${mailingListAttachmentsInstance?.id}" />
						<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>

	</body>
</html>
