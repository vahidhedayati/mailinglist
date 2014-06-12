<div class="fieldcontain ${hasErrors(bean: mailingListAttachmentsInstance, field: 'attachment', 'error')} required">
	<label for="attachment">
		<g:message code="mailingListAttachments.attachment.label" default="Attachment" />
		<span class="required-indicator">*</span>
	</label>
	<input type="file" id="attachment" name="attachment" />
</div>
<g:render template="/mailingList/addedby"  model="[caller: 'mailingListAttachmentsInstance']"/>

