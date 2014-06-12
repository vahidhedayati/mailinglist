
<g:form action="save"  name="${params.formId }" id="1"  controller="mailingListAttachments" enctype="multipart/form-data">
<g:hiddenField name="ajax" value="yes"/>
	<fieldset class="form">
		<g:render template="/mailingListAttachments/form"/>
	</fieldset>
	<fieldset class="buttons">
		<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}"  />
	</fieldset>
</g:form>
			
<h3><g:message code="default.suported.mime.types.label" default="Supported Mime Types: (All file formats)"/></h3>