<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mailingListSchedule.label', default: 'MailingListSchedule')}" />
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
		<div id="show-mailingListSchedule" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list mailingListSchedule">
				<g:if test="${mailingListScheduleInstance?.addedby}">
				<li class="fieldcontain">
					<span id="addedby-label" class="property-label"><g:message code="mailingListSchedule.addedby.label" default="Addedby" /></span>
					<span class="property-value" aria-labelledby="addedby-label"><g:fieldValue bean="${mailingListScheduleInstance}" field="addedby"/></span>
				</li>
				</g:if>
			
				<g:if test="${mailingListScheduleInstance?.attachments}">
				<li class="fieldcontain">
					<span id="attachments-label" class="property-label"><g:message code="mailingListSchedule.attachments.label" default="Attachments" /></span>
						<g:each in="${mailingListScheduleInstance.attachments}" var="a">
						<span class="property-value" aria-labelledby="attachments-label"><g:link controller="mailingListAttachments" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
				</li>
				</g:if>
			
				<g:if test="${mailingListScheduleInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="mailingListSchedule.dateCreated.label" default="Date Created" /></span>
					<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${mailingListScheduleInstance?.dateCreated}" /></span>
				</li>
				</g:if>
			
				<g:if test="${mailingListScheduleInstance?.dateTime}">
				<li class="fieldcontain">
					<span id="dateTime-label" class="property-label"><g:message code="mailingListSchedule.dateTime.label" default="Date Time" /></span>
					<span class="property-value" aria-labelledby="dateTime-label"><g:fieldValue bean="${mailingListScheduleInstance}" field="dateTime"/></span>
				</li>
				</g:if>
			
				<g:if test="${mailingListScheduleInstance?.emailMessage}">
				<li class="fieldcontain">
					<span id="emailMessage-label" class="property-label"><g:message code="mailingListSchedule.emailMessage.label" default="Email Message" /></span>
					<span class="property-value" aria-labelledby="emailMessage-label"><g:fieldValue bean="${mailingListScheduleInstance}" field="emailMessage"/></span>
				</li>
				</g:if>
			
				<g:if test="${mailingListScheduleInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="mailingListSchedule.lastUpdated.label" default="Last Updated" /></span>
					<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${mailingListScheduleInstance?.lastUpdated}" /></span>
				</li>
				</g:if>
			
				<g:if test="${mailingListScheduleInstance?.mailFrom}">
				<li class="fieldcontain">
					<span id="mailFrom-label" class="property-label"><g:message code="mailingListSchedule.mailFrom.label" default="Mail From" /></span>
					<span class="property-value" aria-labelledby="mailFrom-label"><g:fieldValue bean="${mailingListScheduleInstance}" field="mailFrom"/></span>
				</li>
				</g:if>
			
				<g:if test="${mailingListScheduleInstance?.mailingListTemplate}">
				<li class="fieldcontain">
					<span id="mailingListTemplate-label" class="property-label"><g:message code="mailingListSchedule.mailingListTemplate.label" default="Mailing List Template" /></span>
					<span class="property-value" aria-labelledby="mailingListTemplate-label"><g:fieldValue bean="${mailingListScheduleInstance}" field="mailingListTemplate"/></span>
				</li>
				</g:if>
			
				<g:if test="${mailingListScheduleInstance?.recipientBCCList}">
				<li class="fieldcontain">
					<span id="recipientBCCList-label" class="property-label"><g:message code="mailingListSchedule.recipientBCCList.label" default="Recipient BCCL ist" /></span>
					<span class="property-value" aria-labelledby="recipientBCCList-label"><g:fieldValue bean="${mailingListScheduleInstance}" field="recipientBCCList"/></span>
				</li>
				</g:if>
			
				<g:if test="${mailingListScheduleInstance?.recipientCCList}">
				<li class="fieldcontain">
					<span id="recipientCCList-label" class="property-label"><g:message code="mailingListSchedule.recipientCCList.label" default="Recipient CCL ist" /></span>
					<span class="property-value" aria-labelledby="recipientCCList-label"><g:fieldValue bean="${mailingListScheduleInstance}" field="recipientCCList"/></span>
				</li>
				</g:if>
			
				<g:if test="${mailingListScheduleInstance?.recipientToGroup}">
				<li class="fieldcontain">
					<span id="recipientToGroup-label" class="property-label"><g:message code="mailingListSchedule.recipientToGroup.label" default="Recipient To Group" /></span>
					<span class="property-value" aria-labelledby="recipientToGroup-label"><g:fieldValue bean="${mailingListScheduleInstance}" field="recipientToGroup"/></span>
				</li>
				</g:if>
			
				<g:if test="${mailingListScheduleInstance?.recipientToList}">
				<li class="fieldcontain">
					<span id="recipientToList-label" class="property-label"><g:message code="mailingListSchedule.recipientToList.label" default="Recipient To List" /></span>
					<span class="property-value" aria-labelledby="recipientToList-label"><g:fieldValue bean="${mailingListScheduleInstance}" field="recipientToList"/></span>
				</li>
				</g:if>
			
				<g:if test="${mailingListScheduleInstance?.scheduleStatus}">
				<li class="fieldcontain">
					<span id="scheduleStatus" class="property-label"><g:message code="mailingListSchedule.scheduleStatus.label" default="Schedule Cancelled" /></span>
					<span class="property-value" aria-labelledby="scheduleStatus"><g:message code="mailinglist.status.${l.scheduleStatus}"/> </span>
				</li>
				</g:if>
				<g:if test="${mailingListScheduleInstance?.sendType}">
				<li class="fieldcontain">
					<span id="sendType-label" class="property-label"><g:message code="mailingListSchedule.sendType.label" default="Send Type" /></span>
					<span class="property-value" aria-labelledby="sendType-label"><g:fieldValue bean="${mailingListScheduleInstance}" field="sendType"/></span>
				</li>
				</g:if>
			
				<g:if test="${mailingListScheduleInstance?.setDate}">
				<li class="fieldcontain">
					<span id="setDate-label" class="property-label"><g:message code="mailingListSchedule.setDate.label" default="Set Date" /></span>
					<span class="property-value" aria-labelledby="setDate-label"><g:fieldValue bean="${mailingListScheduleInstance}" field="setDate"/></span>
				</li>
				</g:if>
			
				<g:if test="${mailingListScheduleInstance?.setTime}">
				<li class="fieldcontain">
					<span id="setTime-label" class="property-label"><g:message code="mailingListSchedule.setTime.label" default="Set Time" /></span>
						<span class="property-value" aria-labelledby="setTime-label"><g:fieldValue bean="${mailingListScheduleInstance}" field="setTime"/></span>
				</li>
				</g:if>
			
				<g:if test="${mailingListScheduleInstance?.subject}">
				<li class="fieldcontain">
					<span id="subject-label" class="property-label"><g:message code="mailingListSchedule.subject.label" default="Subject" /></span>
					<span class="property-value" aria-labelledby="subject-label"><g:fieldValue bean="${mailingListScheduleInstance}" field="subject"/></span>
				</li>
				</g:if>
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${mailingListScheduleInstance?.id}" />
					<g:link class="edit" action="edit" id="${mailingListScheduleInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
