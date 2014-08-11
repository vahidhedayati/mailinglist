<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mailingListAttachments.label', default: 'MailingListAttachments')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
	<div class="envtabs  navbar">
		<g:render template="/mainmenu"  />
		 <ul class="nav-pills pull-right">
				<li class="btn btn-default"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li class="btn btn-default"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
		</ul>
	</div>	
	
		<div id="create-mailingListAttachments" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${mailingListAttachmentsInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${mailingListAttachmentsInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<h3>
			<g:message code="default.files.uploaded.message.types.label" default="Files are uploaded directly to DB and presented in binary format, once uploaded the screen will redirect to list where the size will be shown."/>
			</h3>
			<g:form action="save"  enctype="multipart/form-data">
			<fieldset class="form">
				<g:render template="form"/>
			</fieldset>
			<fieldset class="buttons">
				<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
			</fieldset>
			</g:form>
			<h3><g:message code="default.suported.mime.types.label" default="Supported Mime Types: (All file formats)"/></h3>
		</div>
	</body>
</html>
