


<g:render template="/mailingList/addedby"  model="[caller: 'mailingListSendersInstance']"/>

<div class="fieldcontain ${hasErrors(bean: mailingListSendersInstance, field: 'emailAddress', 'error')} ">
	<label for="emailAddress">
		<g:message code="mailingListSenders.emailAddress.label" default="Email Address" />
		
	</label>
	<g:field type="email" name="emailAddress" value="${mailingListSendersInstance?.emailAddress}"/>
</div>

