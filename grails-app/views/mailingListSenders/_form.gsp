<%@ page import="kportal.MailingListSenders" %>



<div class="fieldcontain ${hasErrors(bean: mailingListSendersInstance, field: 'addedby', 'error')} ">
	<g:hiddenField name="addedby" value="${session.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListSendersInstance, field: 'emailAddress', 'error')} ">
	<label for="emailAddress">
		<g:message code="mailingListSenders.emailAddress.label" default="Email Address" />
		
	</label>
	<g:field type="email" name="emailAddress" value="${mailingListSendersInstance?.emailAddress}"/>
</div>

