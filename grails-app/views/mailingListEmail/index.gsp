<%@ page import="grails.plugin.mailinglist.core.CategoryBase" %>
<%@ page import="grails.plugin.mailinglist.core.SendersBase" %>
<%@ page import="grails.plugin.mailinglist.core.ScheduleBase" %>
<%@ page import="grails.plugin.mailinglist.core.TemplatesBase" %>
<%@ page import="grails.plugin.mailinglist.core.MailingListBase" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mailingList.css')}" type="text/css">
		<g:set var="entityName" value="${message(code: 'emailaperson.label', default: 'Contact A Person')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<ckeditor:resources/>
	</head>
	<body>
		<g:render template="/mailingList/mainmenu"/>
		<div id="create-mailingList" class="content scaffold-create" role="main">
			<h1><g:message code="default.contactperson.label" args="[entityName]" default='Define Schedule to Email a Person' /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${mailingListScheduleInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${mailingListScheduleInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>

		<g:form action="scheduleEmail" >
		<div id="contact-area">

			<g:render template="/mailingList/addedby"  model="[caller: 'mailingListScheduleInstance']"/>
			<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'mailFrom', 'error')} required">
			<label for="manager">
				<g:message code="manager.label" default="mailFrom" />
			</label>
			<g:textField name="mailFrom"   value="${params?.mailFrom }"/>
			</div>
	
	
			<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'recipientToList', 'error')} ">
			<label for="manager">
				<g:message code="recipientToList.label" default="To:" />
			</label>
			<g:textField name="recipientToList" value="${params?.recipientToList}"/>
			</div>
	
			<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'recipientCCList', 'error')} ">
			<label for="manager">
				<g:message code="recipientCCList.label" default="CC:" />
			</label>
			<g:textField name="recipientCCList" value="${params?.recipientCCList}"/>
			</div>
	
			<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'recipientBCCList', 'error')}  ">
			<label for="manager">
				<g:message code="recipientBCCList.label" default="BCC:" />
			</label>
			<g:textField name="recipientBCCList" value="${params?.recipientBCCList}"/>	
			</div>	
		
			<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'subject', 'error')} required">
			<label for="manager">
				<g:message code="manager.label" default="subject" />
			</label>
			<g:textField name="subject" value="${params?.subject}" size="50"/>
			</div>
		</div>
	
	<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'attachments', 'error')} ">
	<label for="attachments">
		<g:message code="mailingListSchedule.attachments.label" default="Attachments" />
		<br/>
		</label>
		<div id="mailerAttachments" style="display:inline-block;*display:inline;*zoom:1;">
		<g:render template="/mailingListAttachments/mailerAttachmentsDisplay" />
	</div>
	</div>
	
	<div id="contact-area">
	<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'emailMessage', 'error')} required">
	<label for="manager">
		<g:message code="emailMessage.label" default="emailMessage" />
	</label>
	<div id=formmsg>
	<ckeditor:editor name="emailMessage" height="300px" width="100%">
	${params?.emailMessage}
	</ckeditor:editor>
	</div>
	</div>
	
	
	
	
	<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'dateTime', 'error')} required">
	<label for="manager">
		<g:message code="dateTime.label" default="dateTime" />
	</label>
	<jqueryPicker:time name="dateTime" value="${curr }" />
	</div>
	<div class="fieldcontain ${hasErrors(bean: params, field: 'send', 'error')} ">
		<label for="Trigger">
			<g:message code="dateTime.label" default="Trigger" />
		</label>
		<g:submitButton name="Send Email" id="loginbtn" class="loginbtn" value="${message(code: 'default.button.SendEmail.label', default: 'Send')}" />
	</div>
				
	</div>		
	</g:form>
</div>
</body></html>
