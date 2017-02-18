<%@ page import="grails.plugin.mailinglist.core.CategoryBase" %>
<%@ page import="grails.plugin.mailinglist.core.SendersBase" %>
<%@ page import="grails.plugin.mailinglist.core.ScheduleBase" %>
<%@ page import="grails.plugin.mailinglist.core.TemplatesBase" %>
<%@ page import="grails.plugin.mailinglist.core.MailingListBase" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="mailingListMini">
		<g:set var="entityName" value="${message(code: 'ContactClients.label', default: 'Contact Clients')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<ckeditor:resources/>
	</head>
	<body>
	<div class="container">
	<div class="envtabs  navbar">
		<g:render template="/mainmenu"  />
		 
	</div>	
	<g:if test="${warnResend }">
	<div class="errors"><h3>${warnResend }</h3></div>
	</g:if>
	<g:hasErrors bean="${mailingListScheduleInstance}">
		<ul class="errors" role="alert">
			<g:eachError bean="${mailingListScheduleInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
			</g:eachError>
		</ul>
	</g:hasErrors>
	
		<h1><g:message code="default.confirmcontact.label" args="[entityName]" default='Confirm email before sending' /></h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
		</g:if>	

		<g:form action="scheduleEmail" >
		<div id="contact-area">
		<div class="fieldcontain ${hasErrors(bean: params, field: 'sendType', 'error')} ">
				<label for="sendType">
					<g:message code="sendType.label" default="sendType" />
				</label>
				<g:hiddenField name="sendType" value="${params.sendType }"/>${params.sendType }
		</div>
			
		<div class="fieldcontain ${hasErrors(bean: params, field: 'mailFrom', 'error')} ">
				<label for="mailFrom">
					<g:message code="mailFrom.label" default="mailFrom" />
				</label>
				<g:hiddenField name="mailFrom" value="${params.mailFrom }"/>${params.mailFrom }
		</div>
			
		<div class="fieldcontain ${hasErrors(bean: params, field: 'recipientToGroup', 'error')} ">
				<label for="recipientToGroup">
					<g:message code="recipientToGroup.label" default="To:" />
				</label>	
				<g:if test="${params.recipientToGroup.getClass().isArray()}">
					<g:each in="${params.recipientToGroup }" var="rg">
					<mailinglist:localDomainGetter domain="categoryBase" value="${rg}"	retValue="name"/>
						<g:hiddenField name="recipientToGroup" value="${rg }"/>
					</g:each>	
				</g:if>
				<g:else>
					<mailinglist:localDomainGetter domain="categoryBase" value="${params.recipientToGroup }" retValue="name"/>
						<g:hiddenField name="recipientToGroup" value="${params.recipientToGroup}"/>
					
				</g:else>
			
		</div>
		<g:hiddenField name="addedby" value="${params.addedby }"/>
		<div class="fieldcontain ${hasErrors(bean: params, field: 'subject', 'error')} ">
			<label for="subject">
				<g:message code="subject.label" default="subject" />
			</label>
			<g:hiddenField name="subject" value="${params.subject }"/>${params.subject }</div>
		</div>
		
		
		<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'attachments', 'error')} ">
			<label for="attachments">
				<g:message code="mailingListSchedule.attachments.label" default="Attachments" />
			</label>
			<g:if test="${params.attachments.getClass().isArray()}">
				<g:each in="${params.attachments }" var="att">
		 			<g:hiddenField name="attachments" value="${att}"/>
					<mailinglist:localDomainGetter domain="attachmentsBase" value="${att}"	retValue="fullname"  />
				</g:each>	
			</g:if>
			<g:else>
				<g:if test="${params.attachments}">
			 		<g:hiddenField name="attachments" value="${params.attachments}"/>
						<mailinglist:localDomainGetter domain="attachmentsBase" value="${params.attachments}"	retValue="fullname" />
				</g:if> 
			</g:else>
		</div>
	
		<g:if test="${params.mailingListTemplate}">
				<g:hiddenField name="mailingListTemplate" value="${params.mailingListTemplate }"/>
		</g:if>

		<div class="fieldcontain ${hasErrors(bean: params, field: 'mailingListScheduleInstance', 'error')} required">
			<label for="mailingListTemplates">
				<g:message code="mailingListTemplates.label" default="emailMessage" /> 
			</label>
			<ckeditor:editor  name="emailMessage" height="300px" width="100%">
			${params.emailMessage}
			</ckeditor:editor>
		</div>

		<div class="fieldcontain ${hasErrors(bean: params, field: 'dateTime', 'error')} ">
			<label for="dateTime">
				<g:message code="dateTime.label" default="Schedule Email: Date & Time" />
			</label>
			<g:hiddenField name="dateTime" value="${params.dateTime }"/>
			${params.dateTime}
		</div>
		
		
	<div class="fieldcontain ${hasErrors(bean: params, field: 'cronExpression', 'error')}">
		<label for="cronExpression">
			<g:message code="cronExpression.label" default="cronExpression" />
		</label>
		<g:hiddenField  name="cronExpression" value="${params?.cronExpression}"/>
		${params?.cronExpression}
	</div>
	
		<div class="fieldcontain ${hasErrors(bean: params, field: 'setDate', 'error')} ">
			<label for="setDate">
				<g:message code="setDate.label" default="Issue/Resolve Date:" />
			</label>
			<g:hiddenField name="setDate" value="${params.setDate }"/>
			${params.setDate}
		</div>
			
		<div class="fieldcontain ${hasErrors(bean: params, field: 'setTime', 'error')} ">
			<label for="setTime">
				<g:message code="setTime.label" default="Issue/Resolve Time:" />
				<span class="required-indicator">*</span>
			</label>
			<g:hiddenField name="setTime" value="${params.setTime_hour}:${ params.setTime_minute}"/>
			${params.setTime_hour}:${ params.setTime_minute}
		</div>
		
	<div class="whitefont">
			<g:submitButton name="Confirmed Send it now"  class="btn btn-danger nav-pills pull-right" value="${message(code: 'default.button.SendEmail.label', default: 'Send Email')}" />
	</div>


	</g:form>
	
	<div class="btn btn-primary" >
<g:render template="goback"/>
	</div>
	</div>
	</body></html>
