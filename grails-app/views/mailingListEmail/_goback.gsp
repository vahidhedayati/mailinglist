<g:form action="contactclients" >
	<div id="contact-area">
	<g:hiddenField name="sendType" value="${params.sendType }"/>
	<g:hiddenField name="mailFrom" value="${params.mailFrom }"/>
	<g:if test="${params.recipientToGroup.getClass().isArray()}">
	<g:each in="${params.recipientToGroup }" var="rg">
	 	<g:hiddenField name="recipientToGroup" value="${rg }"/>
	</g:each>	
	</g:if>
	<g:else>
	 	<g:hiddenField name="recipientToGroup" value="${params.recipientToGroup}"/>
	</g:else>
	<g:hiddenField name="subject" value="${params.subject }"/>
	<g:if test="${params.attachments.getClass().isArray()}">
	<g:each in="${params.attachments }" var="att">
		 <g:hiddenField name="attachments" value="${att}"/>
	</g:each>	
	</g:if>
	<g:else>
		<g:if test="${params.attachments}">
		 	<g:hiddenField name="attachments" value="${params.attachments}"/>
		 </g:if> 
	</g:else>
	<g:hiddenField name="mailingListTemplate" value="${params.mailingListTemplate }"/>
	<g:hiddenField name="emailMessage1" value="${params.emailMessage}"/>
	

	<g:submitButton name="EDIT MESSAGE" id="loginbtn" class="edit" value="${message(code: 'default.button.EDIT.label', default: 'EDIT EMAIL')}" />
	</div>
</g:form>