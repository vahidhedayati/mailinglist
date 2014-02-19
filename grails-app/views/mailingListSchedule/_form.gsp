<%@ page import="kportal.MailingListSchedule" %>



<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'addedby', 'error')} ">
	<label for="addedby">
		<g:message code="mailingListSchedule.addedby.label" default="Addedby" />
		
	</label>
	<g:textField name="addedby" value="${mailingListScheduleInstance?.addedby}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'attachments', 'error')} ">
	<label for="attachments">
		<g:message code="mailingListSchedule.attachments.label" default="Attachments" />
		
	</label>
	<g:select name="attachments" from="${kportal.MailingListAttachments.list()}" multiple="multiple" optionKey="id" size="5" value="${mailingListScheduleInstance?.attachments*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'dateTime', 'error')} ">
	<label for="dateTime">
		<g:message code="mailingListSchedule.dateTime.label" default="Date Time" />
		
	</label>
	<g:textField name="dateTime" value="${mailingListScheduleInstance?.dateTime}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'deploymentComplete', 'error')} ">
	<label for="deploymentComplete">
		<g:message code="mailingListSchedule.deploymentComplete.label" default="Deployment Complete" />
		
	</label>
	<g:checkBox name="deploymentComplete" value="${mailingListScheduleInstance?.deploymentComplete}" />
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'emailMessage', 'error')} ">
	<label for="emailMessage">
		<g:message code="mailingListSchedule.emailMessage.label" default="Email Message" />
		
	</label>
	<g:textField name="emailMessage" value="${mailingListScheduleInstance?.emailMessage}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'mailFrom', 'error')} ">
	<label for="mailFrom">
		<g:message code="mailingListSchedule.mailFrom.label" default="Mail From" />
		
	</label>
	<g:textField name="mailFrom" value="${mailingListScheduleInstance?.mailFrom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'mailingListTemplate', 'error')} ">
	<label for="mailingListTemplate">
		<g:message code="mailingListSchedule.mailingListTemplate.label" default="Mailing List Template" />
		
	</label>
	<g:textField name="mailingListTemplate" value="${mailingListScheduleInstance?.mailingListTemplate}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'recipientBCCList', 'error')} ">
	<label for="recipientBCCList">
		<g:message code="mailingListSchedule.recipientBCCList.label" default="Recipient BCCL ist" />
		
	</label>
	<g:textField name="recipientBCCList" value="${mailingListScheduleInstance?.recipientBCCList}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'recipientCCList', 'error')} ">
	<label for="recipientCCList">
		<g:message code="mailingListSchedule.recipientCCList.label" default="Recipient CCL ist" />
		
	</label>
	<g:textField name="recipientCCList" value="${mailingListScheduleInstance?.recipientCCList}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'recipientToGroup', 'error')} ">
	<label for="recipientToGroup">
		<g:message code="mailingListSchedule.recipientToGroup.label" default="Recipient To Group" />
		
	</label>
	<g:textField name="recipientToGroup" value="${mailingListScheduleInstance?.recipientToGroup}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'recipientToList', 'error')} ">
	<label for="recipientToList">
		<g:message code="mailingListSchedule.recipientToList.label" default="Recipient To List" />
		
	</label>
	<g:textField name="recipientToList" value="${mailingListScheduleInstance?.recipientToList}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'scheduleCancelled', 'error')} ">
	<label for="scheduleCancelled">
		<g:message code="mailingListSchedule.scheduleCancelled.label" default="Schedule Cancelled" />
		
	</label>
	<g:checkBox name="scheduleCancelled" value="${mailingListScheduleInstance?.scheduleCancelled}" />
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'scheduleComplete', 'error')} ">
	<label for="scheduleComplete">
		<g:message code="mailingListSchedule.scheduleComplete.label" default="Schedule Complete" />
		
	</label>
	<g:checkBox name="scheduleComplete" value="${mailingListScheduleInstance?.scheduleComplete}" />
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'sendType', 'error')} ">
	<label for="sendType">
		<g:message code="mailingListSchedule.sendType.label" default="Send Type" />
		
	</label>
	<g:textField name="sendType" value="${mailingListScheduleInstance?.sendType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'setDate', 'error')} ">
	<label for="setDate">
		<g:message code="mailingListSchedule.setDate.label" default="Set Date" />
		
	</label>
	<g:textField name="setDate" value="${mailingListScheduleInstance?.setDate}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'setTime', 'error')} ">
	<label for="setTime">
		<g:message code="mailingListSchedule.setTime.label" default="Set Time" />
		
	</label>
	<g:textField name="setTime" value="${mailingListScheduleInstance?.setTime}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'subject', 'error')} ">
	<label for="subject">
		<g:message code="mailingListSchedule.subject.label" default="Subject" />
		
	</label>
	<g:textField name="subject" value="${mailingListScheduleInstance?.subject}"/>
</div>

