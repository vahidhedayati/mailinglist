<g:render template="/mailingList/mailingListImport"/>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mailingListTemplates.label', default: 'MailingListTemplates')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
		<ckeditor:resources/>
	</head>
	<body>
		<a href="#create-mailingListTemplates" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default=""/></a>
		<div id="nav3" class="nav3" role="navigation">
			<ul id="nav">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>

		<div id="create-mailingListTemplates" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${mailingListTemplatesInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${mailingListTemplatesInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="save" >
			<div class="fieldcontain ${hasErrors(bean: mailingListTemplatesInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="mailingListTemplates.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${mailingListTemplatesInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListTemplatesInstance, field: 'addedby', 'error')} ">
	<g:hiddenField name="addedby" value="${session.username}"/>
</div>
			

<div class="fieldcontain ${hasErrors(bean: params, field: 'content', 'error')} required">
	<label for="content">
		<g:message code="mailingListTemplates.label" default="Template" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="mailingListTemplates" name="mailingListTemplate" from="${MailingListTemplates?.list()}" optionKey="id" required="" value="${params.mailingListTemplates}" class="many-to-one"
		noSelection="['': 'Please choose Template']"
		required=""
		onchange="${remoteFunction (
		controller: 'MailingListTemplates',
		action: 'loadMessageBox',
		params: "'id=' + this.value",
		update: 'loadMessageBox'
	)}"
	/>
</div>

<div id="loadMessageBox"></div>

				
				
					
					
					

				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>

	</body>
</html>
