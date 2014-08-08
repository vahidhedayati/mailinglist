<%@ page import="grails.plugin.mailinglist.core.CategoryBase" %>
<%@ page import="grails.plugin.mailinglist.core.SendersBase" %>
<%@ page import="grails.plugin.mailinglist.core.ScheduleBase" %>
<%@ page import="grails.plugin.mailinglist.core.TemplatesBase" %>
<%@ page import="grails.plugin.mailinglist.core.MailingListBase" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mailingListTemplates.label', default: 'MailingListTemplates')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
		<ckeditor:resources/>
	</head>
	<body>
			<div class="envtabs  navbar">
		<g:render template="/mainmenu"  />
		 <ul class="nav-pills pull-right">
				<li class="btn btn-default"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li class="btn btn-default"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
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

			<g:render template="/mailingList/addedby"  model="[caller: 'mailingListTemplatesInstance']"/>

			<div class="fieldcontain ${hasErrors(bean: params, field: 'content', 'error')} required">
			<label for="content">
				<g:message code="mailingListTemplates.label" default="Template" />
				<span class="required-indicator">*</span>
			</label>
			<g:select id="mailingListTemplates" name="mailingListTemplate" 
			from="${grails.plugin.mailinglist.core.TemplatesBase.list(sort: 'name', order: 'asc')}" 
			optionKey="id" required="" value="${params.mailingListTemplates}" class="many-to-one"
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
