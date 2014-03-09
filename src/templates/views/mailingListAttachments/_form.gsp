

<div class="fieldcontain ${hasErrors(bean: mailingListAttachmentsInstance, field: 'attachment', 'error')} required">
	<label for="attachment">
		<g:message code="mailingListAttachments.attachment.label" default="Attachment" />
		<span class="required-indicator">*</span>
	</label>
	<input type="file" id="attachment" name="attachment" />
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListAttachmentsInstance, field: 'addedby', 'error')} ">
<g:hiddenField name="addedby" value="${session.username}"/>
</div>


