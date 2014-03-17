
	<div class="fieldcontain ${hasErrors(bean: params, field: 'emailMessage', 'error')} ">
	<label for="manager">
		<g:message code="emailMessage.label" default="Message" />
	</label>

			
<ckeditor:resources/>
<div id=formmsg>
<ckeditor:editor 
name="emailMessage" height="300px" width="100%">
${content}
</ckeditor:editor>
</div>
	
</div>

